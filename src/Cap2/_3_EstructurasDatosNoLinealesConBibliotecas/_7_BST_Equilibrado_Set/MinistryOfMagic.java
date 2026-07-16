package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Leer los candidatos y sus preferencias
// Cada partido se guarda en un HashMao
// Las preferencias de cada partido se guardan en una lista
// Se realiza una votación por cada candidato, votando el primer partido de su lista de preferencias
// El partido menos votado se elimina (se elimina de la lista de preferencias de todos los candidatos)

// Caso de prueba #3: RTE - Ojo que pueden haber más candidatos que candidatos!!!
// Caso de prueba #4: TLE - Cambio a fast input/output. Sigue con TLE
//       C -> numCandidatos :  hasta 10.000
//       P -> numPartidos : hasta 100
//       V -> votos : hasta 10^6
//       Total de votos: hasta 10^6 * 100 = 10^8
//   Como agilizar el proceso???
//     - El candidato a votar es el primero de la lista (acceso directo)
//     - Se votarán un máximo de 100 candidatos, no de 10.000  (OPTIMIZACIÓN!!!)
//     - Se puede eliminar el candidato menos votado accediendo a un HashMap en lugar de una lista (OPTIMIZACIÓN!!!)

import java.util.StringTokenizer;

public class MinistryOfMagic {

    // Representación ultra-eficiente de cada partido
    static class Partido {
        int votos;
        int[] preferencias;
        int indicePreferido; // Puntero perezoso que avanza en lugar de eliminar elementos

        public Partido(int votos, int numCandidatos) {
            this.votos = votos;
            this.preferencias = new int[numCandidatos];
            this.indicePreferido = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int numCandidatos = Integer.parseInt(st.nextToken());
        int numPartidos = Integer.parseInt(st.nextToken());

        Partido[] partidos = new Partido[numPartidos];
        long totalVotosSuma = 0; // Guardamos la suma total de votos en el parlamento

        for (int i = 0; i < numPartidos; i++) {
            st = new StringTokenizer(in.readLine());
            int votosPartido = Integer.parseInt(st.nextToken());
            totalVotosSuma += votosPartido;

            Partido partido = new Partido(votosPartido, numCandidatos);
            for (int j = 0; j < numCandidatos; j++) {
                partido.preferencias[j] = Integer.parseInt(st.nextToken());
            }
            partidos[i] = partido;
        }

        // Estructura rápida para saber si un candidato ha sido eliminado
        boolean[] eliminado = new boolean[numCandidatos + 1];
        int candidatosRestantes = numCandidatos;

        // Bucle principal de rondas
        while (candidatosRestantes > 0) {
            int[] votosCandidatos = new int[numCandidatos + 1];

            // 1. Ronda de votación
            for (int i = 0; i < numPartidos; i++) {
                Partido p = partidos[i];

                // Avanzar el puntero perezoso si el candidato preferido actual ya fue eliminado
                while (p.indicePreferido < numCandidatos && eliminado[p.preferencias[p.indicePreferido]]) {
                    p.indicePreferido++;
                }

                // Si el partido todavía tiene candidatos válidos, vota por el actual
                if (p.indicePreferido < numCandidatos) {
                    int candidatoVotado = p.preferencias[p.indicePreferido];
                    votosCandidatos[candidatoVotado] += p.votos;
                }
            }

            // 2. Comprobar si hay mayoría absoluta (> totalVotosSuma / 2)
            int candidatoGanador = -1;
            for (int c = 1; c <= numCandidatos; c++) {
                if (!eliminado[c] && votosCandidatos[c] > totalVotosSuma / 2) {
                    candidatoGanador = c;
                    break;
                }
            }

            if (candidatoGanador != -1) {
                System.out.println(candidatoGanador);
                return;
            }

            // 3. Eliminar al candidato menos popular.
            // Si hay empate en menor popularidad, se elimina el de menor identificador (menor número).
            int minVotos = Integer.MAX_VALUE;
            int candidatoAEliminar = -1;

            for (int c = 1; c <= numCandidatos; c++) {
                if (!eliminado[c]) {
                    if (votosCandidatos[c] < minVotos) {
                        minVotos = votosCandidatos[c];
                        candidatoAEliminar = c;
                    }
                }
            }

            // Marcarlo como eliminado y reducir el conteo global
            eliminado[candidatoAEliminar] = true;
            candidatosRestantes--;
        }
    }
}