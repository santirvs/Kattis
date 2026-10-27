package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class InterplanetaryTunnels {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. Leer N (número de planetas) y M (número de hypertúneles)
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2. Leer los planetas de inicio de Alicia (startA) y Bob (startB)
        line = br.readLine();
        st = new StringTokenizer(line);
        int startA = Integer.parseInt(st.nextToken());
        int startB = Integer.parseInt(st.nextToken());

        // 3. Construir la lista de adyacencia para representar el grafo no dirigido.
        // Nota: Se usa una sintaxis compatible con Java 1.7 (sin operador diamante).
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u); // El túnel es bidireccional
        }

        // 4. Ejecutar BFS (Búsqueda en Anchura) desde el origen de Alicia (startA)
        // para encontrar la distancia mínima en aristas (túneles) hasta cualquier otro planeta.
        int[] dist = new int[n];
        Arrays.fill(dist, -1); // -1 indica que el nodo no ha sido visitado

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startA);
        dist[startA] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            // Optimización: si ya alcanzamos el planeta de Bob, podemos detener la búsqueda
            if (u == startB) {
                break;
            }

            // Explorar los vecinos (planetas conectados mediante hypertúneles)
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (dist[v] == -1) { // Si no ha sido visitado
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                }
            }
        }

        // 5. La distancia total mínima entre Alicia y Bob es la distancia registrada en startB
        int totalDist = dist[startB];

        // 6. Calcular el número máximo de túneles que tendrá que tomar el que más viaje.
        // Corresponde a dividir la distancia total entre 2 redondeando hacia arriba: ceil(D / 2).
        // En división entera, esto equivale a: (totalDist + 1) / 2
        int answer = (totalDist + 1) / 2;

        // 7. Imprimir el resultado final
        System.out.println(answer);
    }
}
