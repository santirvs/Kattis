package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// v1: Construir el grafo y aplicar el dijkstra
//

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SingleSourceShortestPathNonNegativeWeights {

    static class FR_Int {
        private InputStream in = System.in;
        private byte[] buffer = new byte[1 << 16];
        private int head = 0;
        private int tail = 0;

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;   // Fin de archivo
            }
            return buffer[head++];
        }

        public int nextInt() throws IOException {
            int c = read();
            // Ignorar espacios en blanco o saltos de línea (ASCII <= 32)
            while (c != -1 && c <= 32) {
                c = read();
            }

            if (c == -1) return -1; // EOF
            boolean negativo = false;
            if (c == '-') {
                negativo = true;
                c = read();
            }
            int res = 0;
            // Construir el número mientras el carácter sea visible (> 32)
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res;
        }
    }

    static class Edge {
        String destino;
        int coste;
        String nomEdge;

        public Edge(String destino, int coste, String nomEdge) {
            this.destino = destino;
            this.coste = coste;
            this.nomEdge = nomEdge;
        }
    }

    static class Node implements Comparable<Node> {
        String nodeName;
        int dist;

        public Node(String nodeName, int dist) {
            this.nodeName = nodeName;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return this.dist - other.dist;
        }
    }

    static class Dijkstra {
        // MAX_VALUE /2 para no causar overflow al sumar el coste
        static final int INF = Integer.MAX_VALUE / 2;

        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, String> edgeToParent = new HashMap<>();
        HashMap<String, List<Edge>> grafo = new HashMap<>();
        HashSet<String> prohibidas = new HashSet<>();

        // Calcula el coste de llegar a cualquier nodo desde el inicio
        // evitando la lista de aristas prohibidas
        public void dijkstra(String inicio) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(inicio, 0));
            distance.put(inicio, 0);

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                int distancia = INF;
                if (distance.containsKey(cur.nodeName)) {
                    distancia = distance.get(cur.nodeName);
                }

                if (cur.dist > distancia) continue;

                for (Edge e : grafo.get(cur.nodeName)) {

                    if (prohibidas.contains(e.nomEdge)) continue;

                    int nd = cur.dist + e.coste;

                    int distanciaDestino = INF;
                    if (distance.containsKey(e.destino)) {
                        distanciaDestino = distance.get(e.destino);
                    }

                    if (nd < distanciaDestino) {
                        distance.put(e.destino, nd);
                        pq.add(new Node(e.destino, nd));
                        parent.put(e.destino, cur.nodeName);
                        edgeToParent.put(e.destino, e.nomEdge);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FR_Int sc = new FR_Int();

        int numNodes = sc.nextInt();
        int numEdges = sc.nextInt();
        int numQueries = sc.nextInt();
        int startingNode = sc.nextInt();
        boolean primero = true;

        while (numNodes != 0 || numEdges != 0 || numQueries != 0 || startingNode != 0) {

            //Salto de línea entre casos
            if (!primero) System.out.println();
            else primero = false;

            Dijkstra d = new Dijkstra();
            //Inicializar el grafo con los nodos
            for (int i=0; i<numNodes; i++) {
                d.grafo.put(""+i, new ArrayList<>());
            }

            //Leer las aristas
            for (int i=0; i<numEdges; i++) {
                int inicio = sc.nextInt();
                int fin = sc.nextInt();
                int distancia = sc.nextInt();

                Edge e = new Edge(""+fin, distancia, inicio + "-" + fin);
                d.grafo.get(""+inicio).add(e);
            }

            //Calcular el dijkstra
            d.dijkstra(""+startingNode);

            //Mirar las consultas e imprimir la distancia al nodo de destino
            for (int i=0; i<numQueries; i++) {
                int destino = sc.nextInt();
                Integer distancia = d.distance.get(""+destino);
                if (distancia == null) System.out.println("Impossible");
                else System.out.println(distancia);
            }

            //Siguiente caso
            numNodes = sc.nextInt();
            numEdges = sc.nextInt();
            numQueries = sc.nextInt();
            startingNode = sc.nextInt();
        }

    }
}
