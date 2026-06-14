package Others.Medium.Puntuacion_3_0_a_3_9._3_3;


// Ver NeutralGround.md
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NeutralGround {

    // Representa una arista dirigida en la red de flujo
    static class Edge {
        int v;        // Nodo destino
        int cap;      // Capacidad de la arista
        int flow;     // Flujo actual de la arista
        Edge rev;     // Referencia a la arista residual inversa

        public Edge(int v, int cap) {
            this.v = v;
            this.cap = cap;
            this.flow = 0;
        }
    }

    private static ArrayList<ArrayList<Edge>> graph;
    private static int INF = 1000000000; // Un valor lo suficientemente grande como infinito

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int width = sc.nextInt();
        int height = sc.nextInt();

        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            map[i] = sc.next().toCharArray();
        }

        // --- MODELADO DEL GRAFO ---
        // Cada casilla (r, c) tendrá dos nodos:
        // Entrada: (r * width + c) * 2
        // Salida:  (r * width + c) * 2 + 1
        int totalCasillas = height * width;
        int source = totalCasillas * 2;
        int sink = source + 1;
        int totalNodes = sink + 1;

        // Inicializamos la lista de adyacencia
        graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i < totalNodes; i++) {
            graph.add(new ArrayList<Edge>());
        }

        // Direcciones para moverse (Arriba, Abajo, Izquierda, Derecha)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                char current = map[r][c];
                if (current == '0') continue; // Tierra impasable, se ignora

                int idBase = r * width + c;
                int inNode = idBase * 2;
                int outNode = idBase * 2 + 1;

                // 1. Conexión Interna de la Casilla (De Entrada a Salida)
                if (current == 'A') {
                    // El Rey A es el origen. Conectamos Super-Origen al nodo de entrada.
                    addEdge(source, inNode, INF);
                    // Como es su base, el coste de cruzarla internamente es infinito
                    addEdge(inNode, outNode, INF);
                } else if (current == 'B') {
                    // El Rey B es el destino. Conectamos el nodo de salida al Super-Destino.
                    addEdge(outNode, sink, INF);
                    addEdge(inNode, outNode, INF);
                } else {
                    // Es un dígito '1'-'9'. Capacidad interna = valor numérico.
                    int cost = current - '0';
                    addEdge(inNode, outNode, cost);
                }

                // 2. Conexiones con los Vecinos (De Salida de este a Entrada del vecino)
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    // Validar límites y que no sea una pared '0'
                    if (nr >= 0 && nr < height && nc >= 0 && nc < width && map[nr][nc] != '0') {
                        int neighborIdBase = nr * width + nc;
                        int neighborInNode = neighborIdBase * 2;

                        // Conectamos nuestra salida con la entrada del vecino (Costo Infinito)
                        addEdge(outNode, neighborInNode, INF);
                    }
                }
            }
        }

        // --- CÁLCULO DEL FLUJO MÁXIMO / CORTE MÍNIMO ---
        int maxFlow = edmondsKarp(source, sink, totalNodes);
        System.out.println(maxFlow);
    }

    // Método auxiliar para añadir aristas dirigidas y sus respectivas reversas residuales
    private static void addEdge(int u, int v, int cap) {
        Edge a = new Edge(v, cap);
        Edge b = new Edge(u, 0); // La inversa inicialmente tiene capacidad 0
        a.rev = b;
        b.rev = a;
        graph.get(u).add(a);
        graph.get(v).add(b);
    }

    // Algoritmo de Edmonds-Karp
    private static int edmondsKarp(int source, int sink, int totalNodes) {
        int flow = 0;
        Edge[] parent = new Edge[totalNodes];

        while (true) {
            // Inicializar el arreglo de padres para rastrear el camino del BFS
            Arrays.fill(parent, null);
            Queue<Integer> queue = new LinkedList<Integer>();

            queue.offer(source);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                if (curr == sink) break;

                for (Edge edge : graph.get(curr)) {
                    // Si el destino no ha sido visitado y la arista tiene capacidad residual
                    if (parent[edge.v] == null && edge.v != source && edge.cap - edge.flow > 0) {
                        parent[edge.v] = edge;
                        queue.offer(edge.v);
                    }
                }
            }

            // Si no se encontró ningún camino de aumento hasta el sumidero (sink), terminamos
            if (parent[sink] == null) break;

            // Encontrar la capacidad del "cuello de botella" en el camino hallado
            int push = INF;
            for (Edge edge = parent[sink]; edge != null; edge = parent[edge.rev.v]) {
                push = Math.min(push, edge.cap - edge.flow);
            }

            // Aplicar el flujo a lo largo del camino
            for (Edge edge = parent[sink]; edge != null; edge = parent[edge.rev.v]) {
                edge.flow += push;
                edge.rev.flow -= push; // Flujo negativo en la arista residual inversa
            }

            flow += push;
        }

        return flow;
    }
}