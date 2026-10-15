package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Locale;
import java.util.Arrays;

public class GetShorty {

    // Clase auxiliar para representar una arista (corredor) en el grafo
    static class Edge {
        int to;
        double factor;

        public Edge(int to, double factor) {
            this.to = to;
            this.factor = factor;
        }
    }

    // Clase auxiliar para el PriorityQueue (Cola de prioridad)
    // Almacena el nodo actual y el factor acumulado hasta el momento.
    static class State implements Comparable<State> {
        int node;
        double prob; // Representa la fracción de tamaño restante de Mikael

        public State(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }

        @Override
        public int compareTo(State other) {
            // Queremos un Max-Heap (la mayor probabilidad debe estar arriba).
            // Por defecto PriorityQueue es un Min-Heap, por lo que invertimos la comparación:
            // Comparamos 'other.prob' con 'this.prob'.
            return Double.compare(other.prob, this.prob);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) continue;

            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // Condición de parada del problema: n = 0 y m = 0
            if (n == 0 && m == 0) {
                break;
            }

            // 1. Construcción del Grafo usando listas de adyacencia
            List<Edge>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<Edge>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                double factor = Double.parseDouble(st.nextToken());

                // Como los pasillos son bidireccionales, añadimos la arista en ambas direcciones
                graph[u].add(new Edge(v, factor));
                graph[v].add(new Edge(u, factor));
            }

            // 2. Planteamiento del Algoritmo de Dijkstra Modificado:
            // - En lugar de sumar distancias mínimas, queremos MAXIMIZAR EL PRODUCTO de los factores.
            // - El nodo inicial es 0 y el tamaño inicial es 1.0 (100% de su tamaño).
            double[] maxFactor = new double[n];
            Arrays.fill(maxFactor, 0.0);
            maxFactor[0] = 1.0;

            PriorityQueue<State> pq = new PriorityQueue<State>();
            pq.add(new State(0, 1.0));

            while (!pq.isEmpty()) {
                State current = pq.poll();
                int u = current.node;
                double currentProb = current.prob;

                // Si encontramos un camino mejor previamente procesado para este nodo, lo ignoramos
                if (currentProb < maxFactor[u]) {
                    continue;
                }

                // Si ya llegamos al destino (n - 1), podríamos optimizar,
                // pero dejamos que Dijkstra continúe para asegurar el máximo global si fuera necesario,
                // aunque en este problema específico podemos relajar los vecinos.
                for (int i = 0; i < graph[u].size(); i++) {
                    Edge edge = graph[u].get(i);
                    int v = edge.to;
                    double nextFactor = currentProb * edge.factor;

                    // Relajación de la arista: si multiplicando el factor actual logramos
                    // un tamaño mayor al registrado previamente en el nodo 'v', lo actualizamos.
                    if (nextFactor > maxFactor[v]) {
                        maxFactor[v] = nextFactor;
                        pq.add(new State(v, nextFactor));
                    }
                }
            }

            // 3. Imprimir el resultado con exactamente cuatro decimales.
            // Usamos Locale.US para asegurar que el separador decimal sea un punto (.) y no una coma (,).
            System.out.printf(Locale.US, "%.4f\n", maxFactor[n - 1]);
        }
    }
}