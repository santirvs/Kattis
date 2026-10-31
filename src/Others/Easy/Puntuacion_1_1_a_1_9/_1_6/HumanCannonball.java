package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

public class HumanCannonball {

    static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distanceTo(Point other) {
            double dx = this.x - other.x;
            double dy = this.y - other.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    static class NodeTime {
        int nodeIndex;
        double time;

        public NodeTime(int nodeIndex, double time) {
            this.nodeIndex = nodeIndex;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = null;

        try {
            String line = reader.readLine();
            if (line == null || line.trim().isEmpty()) return;

            // 1. Coordenadas de inicio
            tokenizer = new StringTokenizer(line);
            double startX = Double.parseDouble(tokenizer.nextToken());
            double startY = Double.parseDouble(tokenizer.nextToken());
            Point start = new Point(startX, startY);

            // 2. Coordenadas del destino
            tokenizer = new StringTokenizer(reader.readLine());
            double endX = Double.parseDouble(tokenizer.nextToken());
            double endY = Double.parseDouble(tokenizer.nextToken());
            Point end = new Point(endX, endY);

            // 3. Número de cañones
            tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());

            int totalNodes = n + 2;
            Point[] points = new Point[totalNodes];
            points[0] = start;
            for (int i = 1; i <= n; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                double cx = Double.parseDouble(tokenizer.nextToken());
                double cy = Double.parseDouble(tokenizer.nextToken());
                points[i] = new Point(cx, cy);
            }
            points[n + 1] = end;

            double[][] graph = new double[totalNodes][totalNodes];

            // Construcción del grafo de tiempos
            for (int i = 0; i < totalNodes; i++) {
                for (int j = 0; j < totalNodes; j++) {
                    if (i == j) {
                        graph[i][j] = 0.0;
                        continue;
                    }

                    double dist = points[i].distanceTo(points[j]);

                    if (i == 0) {
                        graph[i][j] = dist / 5.0;
                    } else {
                        if (dist <= 50.0) {
                            double runTime = dist / 5.0;
                            double cannonTime = 2.0 + (50.0 - dist) / 5.0;
                            graph[i][j] = Math.min(runTime, cannonTime);
                        } else {
                            graph[i][j] = 2.0 + (dist - 50.0) / 5.0;
                        }
                    }
                }
            }

            // Algoritmo de Dijkstra
            double[] minTime = new double[totalNodes];
            Arrays.fill(minTime, Double.MAX_VALUE);
            minTime[0] = 0.0;

            PriorityQueue<NodeTime> pq = new PriorityQueue<NodeTime>(totalNodes, new Comparator<NodeTime>() {
                @Override
                public int compare(NodeTime a, NodeTime b) {
                    return Double.compare(a.time, b.time);
                }
            });

            pq.add(new NodeTime(0, 0.0));
            boolean[] visited = new boolean[totalNodes];

            while (!pq.isEmpty()) {
                NodeTime current = pq.poll();
                int u = current.nodeIndex;

                if (visited[u]) continue;
                visited[u] = true;

                if (u == n + 1) {
                    break;
                }

                for (int v = 0; v < totalNodes; v++) {
                    if (u == v) continue;
                    double weight = graph[u][v];
                    if (minTime[u] + weight < minTime[v]) {
                        minTime[v] = minTime[u] + weight;
                        pq.add(new NodeTime(v, minTime[v]));
                    }
                }
            }

            // Imprimir resultado esperado
            System.out.printf("%.6f\n", minTime[n + 1]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}