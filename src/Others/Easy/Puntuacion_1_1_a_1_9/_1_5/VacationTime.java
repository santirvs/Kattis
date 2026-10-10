package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class VacationTime {

    // Estructura para representar un vuelo (arista dirigida)
    static class Edge {
        int to;
        long cost;
        boolean isA380;

        public Edge(int to, long cost, boolean isA380) {
            this.to = to;
            this.cost = cost;
            this.isA380 = isA380;
        }
    }

    // Estructura para representar el estado actual en la cola de prioridad de Dijkstra
    // Implementa Comparable para ordenar los estados por costo acumulado ascendente.
    static class State implements Comparable<State> {
        int u;
        int state; // 0: Sin A380, 1: Con al menos un A380
        long cost;

        public State(int u, int state, long cost) {
            this.u = u;
            this.state = state;
            this.cost = cost;
        }

        @Override
        public int compareTo(State o) {
            if (this.cost < o.cost) return -1;
            if (this.cost > o.cost) return 1;
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line = br.readLine();
        if (line == null) return;
        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Construcción del grafo usando listas de adyacencia
        // (Nota: Sintaxis totalmente compatible con Java 1.7, sin operadores diamante vacío <>)
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            String model = st.nextToken();

            boolean isA380 = model.equals("A380");
            graph.get(u).add(new Edge(v, cost, isA380));
        }

        // Matriz de distancias para el Dijkstra de estados: dist[nodo][estado_a380]
        // dist[u][0]: Costo mínimo para llegar a u SIN haber volado en A380
        // dist[u][1]: Costo mínimo para llegar a u CON al menos un vuelo en A380
        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<State>();

        // Estado inicial:
        // - Estamos en el aeropuerto 0.
        // - Todavía no hemos tomado ningún A380 (estado = 0).
        // - Costo acumulado = 0.
        dist[0][0] = 0;
        pq.add(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            int u = curr.u;
            int state = curr.state;
            long cost = curr.cost;

            // Poda: si ya encontramos un camino más barato para este mismo estado, ignoramos
            if (cost > dist[u][state]) {
                continue;
            }

            // Explorar todos los vuelos disponibles desde el aeropuerto actual u
            ArrayList<Edge> neighbors = graph.get(u);
            for (int i = 0; i < neighbors.size(); i++) {
                Edge edge = neighbors.get(i);
                int v = edge.to;
                long newCost = cost + edge.cost;

                // Actualizamos el estado del viaje:
                // Si el vuelo actual es A380, el siguiente estado se vuelve 1 de forma obligatoria.
                // Si no es A380, conservamos el estado que ya traíamos.
                int nextState = state;
                if (edge.isA380) {
                    nextState = 1;
                }

                // Relajación de la arista si encontramos un costo menor
                if (newCost < dist[v][nextState]) {
                    dist[v][nextState] = newCost;
                    pq.add(new State(v, nextState, newCost));
                }
            }
        }

        // El destino final es el aeropuerto n-1.
        // Nos interesa exclusivamente el costo mínimo habiendo volado al menos una vez en A380 (estado 1).
        long ans = dist[n - 1][1];

        // Si el valor sigue siendo infinito, significa que no fue posible cumplir la condición
        if (ans == Long.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(ans);
        }
    }
}