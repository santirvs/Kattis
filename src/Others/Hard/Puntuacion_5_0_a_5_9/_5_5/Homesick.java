package Others.Hard.Puntuacion_5_0_a_5_9._5_5;
import java.io.InputStream;
import java.io.IOException;

public class Homesick {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int head = 0;
        private int tail = 0;

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public int nextInt() throws IOException {
            int c = read();
            while (c <= ' ') {
                if (c == -1) return -1;
                c = read();
            }
            int res = 0;
            while (c >= '0' && c <= '9') {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        if (n == -1) return;
        int m = fs.nextInt();

        int totalEdges = 2 * m;
        int[] head = new int[n + 1];
        for (int i = 1; i <= n; i++) head[i] = -1;

        int[] to = new int[totalEdges];
        int[] from = new int[totalEdges];
        int[] next = new int[totalEdges];
        int edgeCount = 0;

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();

            // Arista u -> v
            from[edgeCount] = u;
            to[edgeCount] = v;
            next[edgeCount] = head[u];
            head[u] = edgeCount++;

            // Arista v -> u
            from[edgeCount] = v;
            to[edgeCount] = u;
            next[edgeCount] = head[v];
            head[v] = edgeCount++;
        }

        int[] parentEdge = new int[totalEdges];
        for (int i = 0; i < totalEdges; i++) parentEdge[i] = -1;

        boolean[] visitedEdge = new boolean[totalEdges];

        // PODA CLAVE PARA ELIMINAR TLE:
        // Guardamos hasta los primeros 2 nodos de origen que entran a cada nodo 'v'.
        int[] firstInFrom = new int[n + 1];
        int[] secondInFrom = new int[n + 1];

        int[] queue = new int[totalEdges];
        int qHead = 0;
        int qTail = 0;

        // Inicialización BFS desde el nodo 1
        for (int e = head[1]; e != -1; e = next[e]) {
            visitedEdge[e] = true;
            queue[qTail++] = e;

            int v = to[e];
            if (firstInFrom[v] == 0) {
                firstInFrom[v] = 1;
            } else if (secondInFrom[v] == 0 && firstInFrom[v] != 1) {
                secondInFrom[v] = 1;
            }
        }

        int targetEdge = -1;

        while (qHead < qTail) {
            int curr = queue[qHead++];
            int currTo = to[curr];
            int currFrom = from[curr];

            if (currTo == 1) {
                targetEdge = curr;
                break;
            }

            // PODA POR GRADO/NODO:
            // Si el nodo destino 'currTo' ya fue alcanzado por al menos 2 orígenes distintos
            // y 'currFrom' NO es uno de esos dos orígenes principales, OMITIR expandir.
            if (firstInFrom[currTo] != 0 && secondInFrom[currTo] != 0) {
                if (currFrom != firstInFrom[currTo] && currFrom != secondInFrom[currTo]) {
                    continue;
                }
            }

            for (int e = head[currTo]; e != -1; e = next[e]) {
                // Poda de no-backtracking
                if (to[e] == currFrom) {
                    continue;
                }

                if (!visitedEdge[e]) {
                    int nextNode = to[e];

                    // Registrar orígenes de llegada a nextNode
                    if (firstInFrom[nextNode] == 0) {
                        firstInFrom[nextNode] = currTo;
                    } else if (secondInFrom[nextNode] == 0 && firstInFrom[nextNode] != currTo) {
                        secondInFrom[nextNode] = currTo;
                    }

                    visitedEdge[e] = true;
                    parentEdge[e] = curr;
                    queue[qTail++] = e;
                }
            }
        }

        if (targetEdge == -1) {
            System.out.println("impossible");
        } else {
            int length = 0;
            int curr = targetEdge;
            while (curr != -1) {
                length++;
                curr = parentEdge[curr];
            }

            int[] path = new int[length + 1];
            path[0] = 1;
            curr = targetEdge;
            for (int i = length; i >= 1; i--) {
                path[i] = to[curr];
                curr = parentEdge[curr];
            }

            StringBuilder sb = new StringBuilder();
            sb.append(path.length).append("\n");
            for (int i = 0; i < path.length; i++) {
                sb.append(path[i]);
                if (i < path.length - 1) sb.append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}