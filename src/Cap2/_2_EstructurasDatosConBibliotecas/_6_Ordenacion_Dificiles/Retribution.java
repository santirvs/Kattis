package Cap2._2_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.StringTokenizer;

public class Retribution {

    static class Posicion {
        int x, y;
        public Posicion(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Distancia implements Comparable<Distancia> {
        int juez;
        int target; // Representa el depósito o almacén
        double distancia;

        public Distancia(int juez, int target, double distancia) {
            this.juez = juez;
            this.target = target;
            this.distancia = distancia;
        }

        @Override
        public int compareTo(Distancia o) {
            // 1. Comparar distancias usando Double.compare de forma segura
            int cmpDist = Double.compare(this.distancia, o.distancia);
            if (cmpDist != 0) return cmpDist;

            // 2. En caso de empate, menor índice de juez primero
            if (this.juez != o.juez) {
                return Integer.compare(this.juez, o.juez);
            }

            // 3. En caso de seguir empatados, menor índice de depósito/almacén primero
            return Integer.compare(this.target, o.target);
        }
    }

    public static double calcularDistancia(Posicion a, Posicion b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        if (line == null) return;
        st = new StringTokenizer(line);
        int numJueces = Integer.parseInt(st.nextToken());
        int numDepositos = Integer.parseInt(st.nextToken());
        int numAlmacenes = Integer.parseInt(st.nextToken());

        Posicion[] jueces = new Posicion[numJueces];
        for (int i = 0; i < numJueces; i++) {
            st = new StringTokenizer(br.readLine());
            jueces[i] = new Posicion(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Posicion[] depositos = new Posicion[numDepositos];
        for (int i = 0; i < numDepositos; i++) {
            st = new StringTokenizer(br.readLine());
            depositos[i] = new Posicion(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Posicion[] almacenes = new Posicion[numAlmacenes];
        for (int i = 0; i < numAlmacenes; i++) {
            st = new StringTokenizer(br.readLine());
            almacenes[i] = new Posicion(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        double ansDistanciaTotal = 0.0;

        // --- ASIGNACIÓN DE ALQUITRÁN (TAR) ---
        ArrayList<Distancia> distanciasTar = new ArrayList<>(numJueces * numDepositos);
        for (int i = 0; i < numJueces; i++) {
            for (int j = 0; j < numDepositos; j++) {
                distanciasTar.add(new Distancia(i, j, calcularDistancia(jueces[i], depositos[j])));
            }
        }
        Collections.sort(distanciasTar);

        boolean[] juezAsignado = new boolean[numJueces];
        boolean[] depositoAsignado = new boolean[numDepositos];

        for (Distancia d : distanciasTar) {
            if (!juezAsignado[d.juez] && !depositoAsignado[d.target]) {
                ansDistanciaTotal += d.distancia;
                juezAsignado[d.juez] = true;
                depositoAsignado[d.target] = true;
            }
        }

        // --- ASIGNACIÓN DE PLUMAS (FEATHERS) ---
        // Reiniciamos los jueces asignados (cada juez necesita obligatoriamente 1 de cada elemento)
        juezAsignado = new boolean[numJueces];
        boolean[] almacenAsignado = new boolean[numAlmacenes];

        ArrayList<Distancia> distanciasFeather = new ArrayList<>(numJueces * numAlmacenes);
        for (int i = 0; i < numJueces; i++) {
            for (int j = 0; j < numAlmacenes; j++) {
                distanciasFeather.add(new Distancia(i, j, calcularDistancia(jueces[i], almacenes[j])));
            }
        }
        Collections.sort(distanciasFeather);

        for (Distancia d : distanciasFeather) {
            if (!juezAsignado[d.juez] && !almacenAsignado[d.target]) {
                ansDistanciaTotal += d.distancia;
                juezAsignado[d.juez] = true;
                almacenAsignado[d.target] = true;
            }
        }

        // Imprimir con la precisión requerida
        System.out.printf(Locale.ENGLISH, "%.8f\n", ansDistanciaTotal);
    }
}