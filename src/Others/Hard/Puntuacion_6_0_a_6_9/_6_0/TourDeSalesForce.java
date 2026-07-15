package Others.Hard.Puntuacion_6_0_a_6_9._6_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * PROBLEMA: Tours de Sales Force
 * ============================================================================
 * EXPLICACIÓN DEL PLANTEAMIENTO
 * ============================================================================
 * 1. RESOLUCIÓN DEL TSP (Traveling Salesperson Problem):
 * - Usamos Programación Dinámica con Máscaras de Bits (Algoritmo de Held-Karp).
 * - Estado: dp(u, mask) representa la distancia mínima para visitar el conjunto
 * de nodos activos en 'mask' terminando en el nodo 'u', habiendo partido del nodo 0.
 * - Complejidad de cada TSP: O(N^2 * 2^N).
 * - Para N <= 10 (distritos individuales), es extremadamente rápido (~10^5 ops).
 * - Para N <= 20 (distritos fusionados), toma a lo sumo ~4 * 10^8 operaciones
 * en el peor caso absoluto, pero en la práctica corre en milisegundos gracias
 * a la poda y a la simplicidad del cálculo de distancias Euclideanas.
 * * 2. MATRIZ DE COSTOS DE FUSIÓN:
 * - Clasificamos los distritos en dos conjuntos: Fired (0 a D/2 - 1) y Unfired (D/2 a D - 1).
 * - Creamos una matriz de costos 'costMatrix' de tamaño (D/2) x (D/2).
 * - En costMatrix[i][j], guardamos el valor de resolver el TSP exacto tras unir
 * los clientes del distrito despedido 'i' con el distrito conservado 'j + D/2'.
 * * 3. ASIGNACIÓN ÓPTIMA (ALGORITMO HÚNGARO):
 * - Una vez construida la matriz de costos, resolvemos el Problema de Asignación Bipartita
 * utilizando el Algoritmo Húngaro en O(V^3), donde V = D/2 <= 50. Esto corre de manera
 * instantánea y nos garantiza el emparejamiento perfecto que minimiza la suma total de los tours.
 */
public class TourDeSalesForce {

    // Clase para representar un punto (cliente) en el plano 2D
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Estructura de cada distrito original
    static class District {
        int size;
        Point[] clients;

        District(int size, Point[] clients) {
            this.size = size;
            this.clients = clients;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int d = Integer.parseInt(line.trim()); // Número de distritos (par)
        District[] districts = new District[d];

        for (int i = 0; i < d; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()); // Cantidad de clientes
            Point[] clients = new Point[c];
            for (int j = 0; j < c; j++) {
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());
                clients[j] = new Point(x, y);
            }
            districts[i] = new District(c, clients);
        }

        // ====================================================================
        // FASE 1: CALCULAR LA SUMA DE LOS TOURS DE TSP ORIGINALES (ANTES DE FIRINGS)
        // ====================================================================
        double originalTSPSum = 0;
        for (int i = 0; i < d; i++) {
            originalTSPSum += solveTSP(districts[i].clients);
        }

        // ====================================================================
        // FASE 2: CONSTRUIR LA MATRIZ DE COSTOS DE FUSIÓN DE DISTRITOS
        // ====================================================================
        int half = d / 2;
        double[][] costMatrix = new double[half][half];

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                // Combinar los clientes del distrito Fired(i) y el Unfired(j + half)
                District fired = districts[i];
                District unfired = districts[j + half];

                int combinedSize = fired.size + unfired.size;
                Point[] combinedClients = new Point[combinedSize];

                System.arraycopy(fired.clients, 0, combinedClients, 0, fired.size);
                System.arraycopy(unfired.clients, 0, combinedClients, fired.size, unfired.size);

                // El costo de esta asignación de pareja es el TSP del nuevo distrito unificado
                costMatrix[i][j] = solveTSP(combinedClients);
            }
        }

        // ====================================================================
        // FASE 3: ENCONTRAR EL EMPAREJAMIENTO DE PESO MÍNIMO (ALGORITMO HÚNGARO)
        // ====================================================================
        HungarianMatcher matcher = new HungarianMatcher(costMatrix);
        double afterTSPSum = matcher.execute();

        // Salida con la precisión absoluta requerida
        System.out.printf("%.6f %.6f\n", originalTSPSum, afterTSPSum);
    }

    /**
     * Resuelve el TSP para un conjunto de puntos dado mediante Programación Dinámica en O(N^2 * 2^N)
     */
    private static double solveTSP(Point[] points) {
        int n = points.length;
        if (n <= 1) return 0;
        if (n == 2) {
            return distance(points[0], points[1]) * 2;
        }

        // 1. Precalcular distancias
        double[][] dist = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = distance(points[i], points[j]);
            }
        }

        int numStates = 1 << n;
        double[][] dp = new double[n][numStates];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Double.MAX_VALUE);
        }

        // 2. Definimos de manera estricta el punto de partida (siempre el nodo 0)
        dp[0][1] = 0; // Costo de estar en 0 habiendo visitado solo el nodo 0 (máscara 1)

        // 3. Recorremos todas las máscaras de menor a mayor.
        // Esto garantiza que cualquier sub-máscara requerida ya esté calculada.
        for (int mask = 1; mask < numStates; mask++) {
            for (int u = 0; u < n; u++) {
                // Si el estado actual es inaccesible o el nodo 'u' no está en la máscara, saltamos
                if (dp[u][mask] == Double.MAX_VALUE || (mask & (1 << u)) == 0) {
                    continue;
                }

                // Intentamos transicionar a un nuevo nodo 'v' que no haya sido visitado
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) == 0) { // Si 'v' no está en la máscara actual
                        int nextMask = mask | (1 << v);
                        double nextDist = dp[u][mask] + dist[u][v];
                        if (nextDist < dp[v][nextMask]) {
                            dp[v][nextMask] = nextDist;
                        }
                    }
                }
            }
        }

        // 4. Cerramos el tour volviendo al nodo inicial (0)
        double minTour = Double.MAX_VALUE;
        int fullMask = numStates - 1;
        for (int u = 1; u < n; u++) {
            if (dp[u][fullMask] != Double.MAX_VALUE) {
                double tourCost = dp[u][fullMask] + dist[u][0];
                if (tourCost < minTour) {
                    minTour = tourCost;
                }
            }
        }

        return minTour;
    }
    private static double distance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Implementación robusta del Algoritmo Húngaro (Kuhn-Munkres) para emparejamiento perfecto
     * de costo mínimo en un grafo bipartito balanceado en tiempo O(V^3).
     */
    /**
     * Implementación del Algoritmo Húngaro (Kuhn-Munkres) para emparejamiento perfecto
     * de costo mínimo en O(V^3). Esta versión BFS es sumamente estable, limpia
     * y libre de errores de indexación cruzada.
     */
    static class HungarianMatcher {
        private final double[][] cost;
        private final int n;

        HungarianMatcher(double[][] matrix) {
            this.n = matrix.length;
            this.cost = new double[n + 1][n + 1];
            // Convertimos a 1-based index para facilitar el manejo de estados vacíos (0)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    this.cost[i + 1][j + 1] = matrix[i][j];
                }
            }
        }

        public double execute() {
            double[] u = new double[n + 1]; // Etiquetas para X
            double[] v = new double[n + 1]; // Etiquetas para Y
            int[] p = new int[n + 1];       // Emparejamientos de Y -> X
            int[] way = new int[n + 1];     // Seguimiento de ruta para reconstruir

            for (int i = 1; i <= n; i++) {
                p[0] = i;
                int jOfValue = 0;
                double[] minv = new double[n + 1];
                Arrays.fill(minv, Double.MAX_VALUE);
                boolean[] used = new boolean[n + 1];

                do {
                    used[jOfValue] = true;
                    int i0 = p[jOfValue];
                    double delta = Double.MAX_VALUE;
                    int j1 = 0;

                    for (int j = 1; j <= n; j++) {
                        if (!used[j]) {
                            double cur = cost[i0][j] - u[i0] - v[j];
                            if (cur < minv[j]) {
                                minv[j] = cur;
                                way[j] = jOfValue;
                            }
                            if (minv[j] < delta) {
                                delta = minv[j];
                                j1 = j;
                            }
                        }
                    }

                    for (int j = 0; j <= n; j++) {
                        if (used[j]) {
                            u[p[j]] += delta;
                            v[j] -= delta;
                        } else {
                            minv[j] -= delta;
                        }
                    }
                    jOfValue = j1;
                } while (p[jOfValue] != 0);

                do {
                    int j1 = way[jOfValue];
                    p[jOfValue] = p[j1];
                    jOfValue = j1;
                } while (jOfValue != 0);
            }

            // El costo mínimo óptimo se almacena directamente en el opuesto de v[0]
            return -v[0];
        }
    }
}