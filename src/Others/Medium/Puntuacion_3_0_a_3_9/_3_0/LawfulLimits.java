package Others.Medium.Puntuacion_3_0_a_3_9._3_0;


/*
    Aplicar un Dijsktra modificado según la velocidad variable a partir del instante t
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LawfulLimits {

    static class Edge {
        int to;
        double length;
        double vAntes;
        double vDespues;

        public Edge(int to, double length, double vAntes, double vDespues) {
            this.to = to;
            this.length = length;
            this.vAntes = vAntes;
            this.vDespues = vDespues;
        }
    }

    static class State {
        int node;
        double time;

        public State(int node, double time) {
            this.node = node;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        double T = Double.parseDouble(st.nextToken());

        List<List<Edge>> graph = new ArrayList<List<Edge>>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine();
            if (line != null) {
                st = new StringTokenizer(line);
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                double len = Double.parseDouble(st.nextToken());
                double v1 = Double.parseDouble(st.nextToken());
                double v2 = Double.parseDouble(st.nextToken());

                graph.get(u).add(new Edge(v, len, v1, v2));
                graph.get(v).add(new Edge(u, len, v1, v2));
            }
        }

        double[] minTime = new double[N + 1];
        Arrays.fill(minTime, Double.MAX_VALUE);
        minTime[1] = 0.0;

        PriorityQueue<State> pq = new PriorityQueue<State>(11, new Comparator<State>() {
            @Override
            public int compare(State s1, State s2) {
                return Double.compare(s1.time, s2.time);
            }
        });

        pq.add(new State(1, 0.0));

        // Margen de tolerancia para errores de punto flotante (Epsilon)
        double EPS = 1e-11;

        while (!pq.isEmpty()) {
            State current = pq.poll();
            int u = current.node;
            double tInicio = current.time;

            if (tInicio > minTime[u] + EPS) continue;
            if (u == N) break;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                double travelDuration = 0.0;

                // ESCENARIO A: Ya es tarde (usamos EPS para evitar errores de aproximación)
                if (tInicio >= T - EPS) {
                    travelDuration = edge.length / edge.vDespues;
                } else {
                    double tFinEstimado = tInicio + (edge.length / edge.vAntes);

                    // ESCENARIO B: Termina antes o justo en T
                    if (tFinEstimado <= T + EPS) {
                        travelDuration = edge.length / edge.vAntes;
                    }
                    // ESCENARIO C: El límite cambia en mitad del camino
                    else {
                        double dt1 = T - tInicio;
                        // Fórmula directa optimizada para mantener la precisión matemática
                        travelDuration = dt1 + (edge.length - dt1 * edge.vAntes) / edge.vDespues;
                    }
                }

                double tPotencial = tInicio + travelDuration;

                // Evitamos actualizar si la mejora es infinitesimalmente despreciable
                if (tPotencial < minTime[v] - EPS) {
                    minTime[v] = tPotencial;
                    pq.add(new State(v, tPotencial));
                }
            }
        }

        System.out.printf(java.util.Locale.UK, "%.7f\n", minTime[N]);
    }
}