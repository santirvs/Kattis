package Others.Medium.Puntuacion_4_0_a_4_9._4_1;




import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TreasureMap {

        // Lector ultra rápido de enteros para evitar la sobrecarga de StringTokenizer
        static class FastReader {
            private InputStream stream;
            private byte[] buf = new byte[1024 * 64];
            private int head = 0, tail = 0;

            public FastReader(InputStream stream) {
                this.stream = stream;
            }

            private int read() throws IOException {
                if (head >= tail) {
                    head = 0;
                    tail = stream.read(buf, 0, buf.length);
                    if (tail <= 0) return -1;
                }
                return buf[head++];
            }

            public int nextInt() throws IOException {
                int c = read();
                while (c <= 32) {
                    if (c == -1) return -1;
                    c = read();
                }
                int res = 0;
                while (c > 32) {
                    if (c < '0' || c > '9') throw new RuntimeException();
                    res = res * 10 + c - '0';
                    c = read();
                }
                return res;
            }
        }

        static class Node {
            int id;
            boolean isX;
            long val = Long.MAX_VALUE;
            int compId = -1;
            List<Edge> edges = new ArrayList<Edge>();

            Node(int id, boolean isX) {
                this.id = id;
                this.isX = isX;
            }
        }

        static class Edge {
            Node target;
            long depth;

            Edge(Node target, long depth) {
                this.target = target;
                this.depth = depth;
            }
        }

        public static void main(String[] args) {
            try {
                FastReader fr = new FastReader(System.in);
                int R = fr.nextInt();
                if (R == -1) return;
                int C = fr.nextInt();
                int N = fr.nextInt();
                int Xt = fr.nextInt();
                int Yt = fr.nextInt();

                Node[] xNodes = new Node[R + 1];
                for (int i = 0; i <= R; i++) xNodes[i] = new Node(i, true);

                Node[] yNodes = new Node[C + 1];
                for (int i = 0; i <= C; i++) yNodes[i] = new Node(i, false);

                for (int i = 0; i < N; i++) {
                    int x = fr.nextInt();
                    int y = fr.nextInt();
                    long d = fr.nextInt();

                    xNodes[x].edges.add(new Edge(yNodes[y], d));
                    yNodes[y].edges.add(new Edge(xNodes[x], d));
                }

                // --- Paso 1: BFS para componentes ---
                List<List<Node>> components = new ArrayList<List<Node>>();
                int currentCompId = 0;

                List<Node> allNodes = new ArrayList<Node>((R + 1) + (C + 1));
                for (Node n : xNodes) allNodes.add(n);
                for (Node n : yNodes) allNodes.add(n);

                // Cola reutilizable para evitar instanciar memoria en el bucle
                Node[] queue = new Node[allNodes.size()];

                for (Node root : allNodes) {
                    if (root.compId == -1) {
                        List<Node> comp = new ArrayList<Node>();
                        root.val = 0;
                        root.compId = currentCompId;

                        int head = 0;
                        int tail = 0;
                        queue[tail++] = root;

                        while (head < tail) {
                            Node curr = queue[head++];
                            comp.add(curr);

                            for (int i = 0; i < curr.edges.size(); i++) {
                                Edge edge = curr.edges.get(i);
                                Node nxt = edge.target;
                                long expectedVal = edge.depth - curr.val;

                                if (nxt.compId == -1) {
                                    nxt.compId = currentCompId;
                                    nxt.val = expectedVal;
                                    queue[tail++] = nxt;
                                } else {
                                    if (nxt.val != expectedVal) {
                                        System.out.println("impossible");
                                        return;
                                    }
                                }
                            }
                        }
                        components.add(comp);
                        currentCompId++;
                    }
                }

                // --- Paso 2: Extraer mínimos de manera eficiente ---
                int numComps = components.size();
                long[] minF = new long[numComps];
                long[] minG = new long[numComps];
                for (int i = 0; i < numComps; i++) {
                    minF[i] = Long.MAX_VALUE;
                    minG[i] = Long.MAX_VALUE;
                }

                for (int i = 0; i < numComps; i++) {
                    List<Node> comp = components.get(i);
                    for (int j = 0; j < comp.size(); j++) {
                        Node node = comp.get(j);
                        if (node.isX) {
                            if (node.val < minF[i]) minF[i] = node.val;
                        } else {
                            if (node.val < minG[i]) minG[i] = node.val;
                        }
                    }
                }

                long[] minDelta = new long[numComps];
                long[] maxDelta = new long[numComps];

                // Variables para el chequeo global O(K) en lugar de O(K^2)
                long globalMinFWithDelta = Long.MAX_VALUE;
                long globalMinGMinusDelta = Long.MAX_VALUE;

                for (int i = 0; i < numComps; i++) {
                    minDelta[i] = Long.MIN_VALUE;
                    maxDelta[i] = Long.MAX_VALUE;

                    if (minF[i] != Long.MAX_VALUE) {
                        minDelta[i] = Math.max(minDelta[i], -minF[i]);
                    }
                    if (minG[i] != Long.MAX_VALUE) {
                        maxDelta[i] = Math.min(maxDelta[i], minG[i]);
                    }

                    if (minDelta[i] > maxDelta[i]) {
                        System.out.println("impossible");
                        return;
                    }

                    // Guardamos los extremos más críticos globales
                    if (minF[i] != Long.MAX_VALUE) {
                        long fLimit = minF[i] + minDelta[i];
                        if (fLimit < globalMinFWithDelta) globalMinFWithDelta = fLimit;
                    }
                    if (minG[i] != Long.MAX_VALUE) {
                        long gLimit = minG[i] - maxDelta[i];
                        if (gLimit < globalMinGMinusDelta) globalMinGMinusDelta = gLimit;
                    }
                }

                // Verificación global ultrarrápida: ¿El peor escenario posible de F + G es menor a 0?
                if (globalMinFWithDelta != Long.MAX_VALUE && globalMinGMinusDelta != Long.MAX_VALUE) {
                    if (globalMinFWithDelta + globalMinGMinusDelta < 0) {
                        System.out.println("impossible");
                        return;
                    }
                }

                // --- Paso 3: Minimizar la posición del tesoro ---
                Node nodeXt = xNodes[Xt];
                Node nodeYt = yNodes[Yt];

                int compXt = nodeXt.compId;
                int compYt = nodeYt.compId;

                long ans = 0;

                if (compXt == compYt) {
                    ans = nodeXt.val + nodeYt.val;
                } else {
                    long bestDeltaXt = minDelta[compXt];
                    long bestDeltaYt = maxDelta[compYt];

                    if (minF[compXt] != Long.MAX_VALUE && minG[compYt] != Long.MAX_VALUE) {
                        long limit = minF[compXt] + minG[compYt];
                        if (bestDeltaYt - bestDeltaXt > limit) {
                            bestDeltaYt = bestDeltaXt + limit;
                        }
                    }
                    ans = nodeXt.val + bestDeltaXt + nodeYt.val - bestDeltaYt;
                }

                if (ans < 0) {
                    System.out.println("impossible");
                } else {
                    System.out.println(ans);
                }

            } catch (Exception e) {
                System.out.println("impossible");
            }
        }
    }