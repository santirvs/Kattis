package Others.Medium.Puntuacion_2_0_a_2_9._2_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PianoLessons {

    private static ArrayList<ArrayList<Integer>> adj;
    private static int[] match;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Envolver en un bucle while permite procesar múltiples casos de prueba
        while (sc.hasNextInt()) {
            int numStudents = sc.nextInt();
            int numSlots = sc.nextInt();

            // Inicializamos la lista de adyacencia para este caso de prueba
            adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < numStudents; i++) {
                adj.add(new ArrayList<Integer>());
            }

            // Lectura correcta de las preferencias de cada estudiante
            for (int i = 0; i < numStudents; i++) {
                int numPrefs = sc.nextInt();
                for (int j = 0; j < numPrefs; j++) {
                    int slot = sc.nextInt();
                    // Restamos 1 para manejar índices de 0 a M-1
                    adj.get(i).add(slot - 1);
                }
            }

            // Inicializamos los arreglos para el algoritmo
            match = new int[numSlots];
            Arrays.fill(match, -1);
            visited = new boolean[numSlots];

            int maxMatches = 0;

            // Ejecutamos el algoritmo de emparejamiento para cada estudiante
            for (int i = 0; i < numStudents; i++) {
                Arrays.fill(visited, false);
                if (dfs(i)) {
                    maxMatches++;
                }
            }

            // Imprimimos la respuesta del caso de prueba actual
            System.out.println(maxMatches);
        }

        sc.close();
    }

    // Función DFS estándar para Maximum Bipartite Matching
    private static boolean dfs(int u) {
        for (int slot : adj.get(u)) {
            if (visited[slot]) continue;
            visited[slot] = true;

            // Si el horario está libre o el estudiante asignado puede reubicarse
            if (match[slot] < 0 || dfs(match[slot])) {
                match[slot] = u;
                return true;
            }
        }
        return false;
    }
}