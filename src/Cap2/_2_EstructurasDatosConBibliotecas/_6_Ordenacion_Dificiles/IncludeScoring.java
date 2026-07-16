package Cap2._2_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IncludeScoring {

    static int[] puntos = {
            100, 75, 60, 50, 45, 40, 36, 32, 29, 26,
            24, 22, 20, 18, 16, 15, 14, 13, 12, 11,
            10, 9, 8, 7, 6, 5, 4, 3, 2, 1
    };

    public static int calcularPuntos(int posicion) {
        if (posicion < 30) {
            return puntos[posicion];
        } else {
            return 0;
        }
    }

    public static class Participante implements Comparable<Participante> {
        int numACs;
        int tiempoTotal;
        int ultimoAC;
        int posicionOriginal;
        int puntos;

        public Participante(int problemasAC, int tiempoTotal, int ultimoAC, int online, int posicion) {
            this.numACs = problemasAC;
            this.tiempoTotal = tiempoTotal;
            this.ultimoAC = ultimoAC;
            this.posicionOriginal = posicion;
            this.puntos = online;
        }

        @Override
        public int compareTo(Participante o) {
            // Primer criterio: mayor numACs
            if (this.numACs != o.numACs) {
                return Integer.compare(o.numACs, this.numACs);
            }
            // Segundo criterio: menor tiempoTotal
            if (this.tiempoTotal != o.tiempoTotal) {
                return Integer.compare(this.tiempoTotal, o.tiempoTotal);
            }
            // Tercer criterio: ultimoAC más temprano
            return Integer.compare(this.ultimoAC, o.ultimoAC);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Participante) {
                Participante p = (Participante) obj;
                return this.numACs == p.numACs && this.tiempoTotal == p.tiempoTotal && this.ultimoAC == p.ultimoAC;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int numParticipantes = Integer.parseInt(line.trim());
        Participante[] listaParticipantes = new Participante[numParticipantes];

        for (int i = 0; i < numParticipantes; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numACs = Integer.parseInt(st.nextToken());
            int tiempoTotal = Integer.parseInt(st.nextToken());
            int ultimoAC = Integer.parseInt(st.nextToken());
            int online = Integer.parseInt(st.nextToken());

            listaParticipantes[i] = new Participante(numACs, tiempoTotal, ultimoAC, online, i);
        }

        // Ordenar los participantes por su desempeño
        Arrays.sort(listaParticipantes);

        // Calcular los puntos asignados
        int i = 0;
        while (i < numParticipantes) {
            int j = i;
            int puntosEmpates = 0;

            // Agrupar todos los empatados en el mismo puesto
            while (j < numParticipantes && listaParticipantes[i].equals(listaParticipantes[j])) {
                puntosEmpates += calcularPuntos(j);
                j++;
            }

            int numEmpatados = j - i;
            // Promedio redondeado hacia arriba de manera segura
            int puntosIndividuales = (puntosEmpates + numEmpatados - 1) / numEmpatados;

            // Asignar los puntos individuales a cada uno de los empatados
            for (int k = i; k < j; k++) {
                listaParticipantes[k].puntos += puntosIndividuales;
            }

            i = j; // Avanzar el puntero al siguiente grupo no empatado
        }

        // Reordenar los participantes según su posición original
        Arrays.sort(listaParticipantes, (a, b) -> Integer.compare(a.posicionOriginal, b.posicionOriginal));

        // Mostrar el resultado final
        StringBuilder sb = new StringBuilder();
        for (Participante p : listaParticipantes) {
            sb.append(p.puntos).append("\n");
        }
        System.out.print(sb);
    }
}