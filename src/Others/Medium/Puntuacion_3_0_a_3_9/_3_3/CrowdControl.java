package Others.Medium.Puntuacion_3_0_a_3_9._3_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Ver CrowdControl.md

public class CrowdControl {

    // Clase para representar una calle (arista)
    static class Edge {
        int id;
        int to;
        int capacity;

        public Edge(int id, int to, int capacity) {
            this.id = id;
            this.to = to;
            this.capacity = capacity;
        }
    }

    // Clase para los estados de la Cola de Prioridad (Dijkstra)
    static class State {
        int node;
        int maxCapacity;

        public State(int node, int maxCapacity) {
            this.node = node;
            this.maxCapacity = maxCapacity;
        }
    }

    public static void main(String[] args) throws IOException {
        // Fast I/O compatible con Java 1.7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Inicializar la lista de adyacencia
        List<List<Edge>> graph = new ArrayList<List<Edge>>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<Edge>());
        }

        // Guardamos los extremos de cada calle para la Fase 2
        int[] edgeU = new int[M];
        int[] edgeV = new int[M];

        for (int i = 0; i < M; i++) {
            line = br.readLine();
            if (line != null) {
                st = new StringTokenizer(line);
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph.get(u).add(new Edge(i, v, c));
                graph.get(v).add(new Edge(i, u, c));

                edgeU[i] = u;
                edgeV[i] = v;
            }
        }

        // --- FASE 1: Dijkstra Modificado (Max-Heap) ---
        int[] maxCap = new int[N];
        int[] parentNode = new int[N];
        int[] parentEdge = new int[N];

        for (int i = 0; i < N; i++) {
            maxCap[i] = -1; // -1 simula que no ha sido alcanzado
            parentNode[i] = -1;
            parentEdge[i] = -1;
        }

        maxCap[0] = Integer.MAX_VALUE; // El nodo inicial tiene capacidad infinita

        // Comparador para ordenar de MAYOR a MENOR capacidad (Max-Heap)
        PriorityQueue<State> pq = new PriorityQueue<State>(11, new Comparator<State>() {
            @Override
            public int compare(State s1, State s2) {
                return Integer.compare(s2.maxCapacity, s1.maxCapacity);
            }
        });

        pq.add(new State(0, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            State current = pq.poll();
            int u = current.node;
            int currentCap = current.maxCapacity;

            // Si encontramos un camino peor guardado en la cola anterior, lo ignoramos
            if (currentCap < maxCap[u]) continue;
            if (u == N - 1) break; // Ya encontramos el camino óptimo al destino

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int weight = edge.capacity;

                // La capacidad para llegar a 'v' es el cuello de botella (el mínimo)
                int nextCap = Math.min(maxCap[u], weight);

                if (nextCap > maxCap[v]) {
                    maxCap[v] = nextCap;
                    parentNode[v] = u;
                    parentEdge[v] = edge.id;
                    pq.add(new State(v, nextCap));
                }
            }
        }

        // --- FASE 2: Marcar nodos y calles del camino óptimo ---
        boolean[] enCamino = new boolean[N];
        boolean[] calleEnCamino = new boolean[M];

        int curr = N - 1;
        enCamino[curr] = true;
        while (curr != 0) {
            int edgeId = parentEdge[curr];
            if (edgeId == -1) break; // Por si acaso el grafo no estuviera conectado
            calleEnCamino[edgeId] = true;

            curr = parentNode[curr];
            enCamino[curr] = true;
        }

        // --- FASE 3: Encontrar qué calles bloquear ---
        List<Integer> aBloquear = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            // Si la calle NO está en el camino, pero toca al menos a un nodo que SÍ está en el camino
            if (!calleEnCamino[i] && (enCamino[edgeU[i]] || enCamino[edgeV[i]])) {
                aBloquear.add(i);
            }
        }

        // --- FASE 4: Imprimir salida ---
        if (aBloquear.isEmpty()) {
            System.out.println("none");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < aBloquear.size(); i++) {
                if (i > 0) sb.append(" ");
                sb.append(aBloquear.get(i));
            }
            System.out.println(sb.toString());
        }
    }
}