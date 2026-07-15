package Others.Medium.Puntuacion_3_0_a_3_9._3_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * PROBLEMA: Sentry Robots
 * ============================================================================
 * EXPLICACIÓN DEL PLANTEAMIENTO
 * ============================================================================
 * 1. LA DIVISIÓN EN SEGMENTOS INDEPENDIENTES:
 * Los obstáculos '#' impiden que los robots vigilen más allá de ellos.
 * Por lo tanto, una sola fila o columna queda fragmentada en múltiples "segmentos"
 * independientes de vigilancia:
 * - Un "segmento horizontal" es una secuencia continua de celdas en una misma fila
 * delimitada por los bordes del tablero o por obstáculos.
 * - Un "segmento vertical" es lo mismo pero a lo largo de una columna.
 * * 2. MODELADO COMO COBERTURA MÍNIMA DE VÉRTICES (MINIMUM VERTEX COVER):
 * Cada punto de interés '*' se encuentra exactamente en la intersección de un
 * segmento horizontal 'H' y un segmento vertical 'V'.
 * - Para vigilar este punto '*', debemos colocar obligatoriamente un robot en 'H'
 * (mirando horizontalmente) o un robot en 'V' (mirando verticalmente).
 * - Queremos seleccionar la menor cantidad de segmentos de manera que TODOS los
 * puntos de interés estén cubiertos. Esto es la definición exacta de la
 * Cobertura Mínima de Vértices en un grafo.
 * * 3. EL TEOREMA DE KŐNIG:
 * Dado que un nodo representa un segmento horizontal (L) y otro un segmento vertical (R),
 * el grafo resultante es estrictamente BIPARTITO.
 * El Teorema de Kőnig nos dice que en un grafo bipartito:
 * Tamaño de Cobertura Mínima = Tamaño de Emparejamiento Máximo (Max Matching)
 * * 4. RESOLUCIÓN MEDIANTE FLUJO MÁXIMO (ALGORITMO DE DINIC):
 * Para hallar el matching máximo construimos una red de flujo:
 * - Añadimos una fuente súper origen (S) conectada a todos los segmentos horizontales (L) con capacidad 1.
 * - Añadimos un sumidero súper destino (T) conectado a todos los segmentos verticales (R) con capacidad 1.
 * - Por cada punto de interés '*', añadimos una arista dirigida con capacidad 1 desde
 * su segmento horizontal 'H_i' hacia su segmento vertical 'V_j'.
 * - El Flujo Máximo de S a T será igual al mínimo número de robots requeridos.
 */
public class SentryRobots {

    // Estructuras de datos para el Algoritmo de Dinic (Flujo Máximo)
    static class Edge {
        int to;
        int rev; // Índice de la arista inversa en la lista del destino
        int cap;
        int flow;

        Edge(int to, int rev, int cap) {
            this.to = to;
            this.rev = rev;
            this.cap = cap;
            this.flow = 0;
        }
    }

    private static List<Edge>[] adj;
    private static int[] level;
    private static int[] ptr;

    // Agrega una arista dirigida con su correspondiente arista inversa de capacidad cero
    private static void addEdge(int from, int to, int cap) {
        adj[from].add(new Edge(to, adj[to].size(), cap));
        adj[to].add(new Edge(from, adj[from].size() - 1, 0));
    }

    // BFS para construir el grafo de niveles en Dinic
    private static boolean bfs(int s, int t) {
        Arrays.fill(level, -1);
        level[s] = 0;
        int[] queue = new int[adj.length];
        int head = 0, tail = 0;
        queue[tail++] = s;

        while (head < tail) {
            int v = queue[head++];
            for (int i = 0; i < adj[v].size(); i++) {
                Edge e = adj[v].get(i);
                if (e.cap - e.flow > 0 && level[e.to] == -1) {
                    level[e.to] = level[v] + 1;
                    queue[tail++] = e.to;
                }
            }
        }
        return level[t] != -1;
    }

    // DFS para enviar flujo a través del grafo de niveles en Dinic
    private static int dfs(int v, int t, int pushed) {
        if (pushed == 0) return 0;
        if (v == t) return pushed;

        for (int cid = ptr[v]; ptr[v] < adj[v].size(); ptr[v]++) {
            Edge e = adj[v].get(ptr[v]);
            int tr = e.to;
            if (level[v] + 1 != level[tr] || e.cap - e.flow == 0) continue;

            int push = dfs(tr, t, Math.min(pushed, e.cap - e.flow));
            if (push == 0) continue;

            e.flow += push;
            adj[tr].get(e.rev).flow -= push;
            return push;
        }
        return 0;
    }

    // Función principal para resolver el Flujo Máximo de Dinic
    private static int dinic(int s, int t) {
        int flow = 0;
        while (bfs(s, t)) {
            Arrays.fill(ptr, 0);
            while (true) {
                int pushed = dfs(s, t, Integer.MAX_VALUE);
                if (pushed == 0) break;
                flow += pushed;
            }
        }
        return flow;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int testCases = Integer.parseInt(line.trim());

        for (int tc = 0; tc < testCases; tc++) {
            br.readLine(); // Leer línea vacía antes de cada caso de prueba

            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()); // Alto del grid (filas)
            int w = Integer.parseInt(st.nextToken()); // Ancho del grid (columnas)

            // Representación del tablero: 0 = Vacío, 1 = Punto de interés (*), 2 = Obstáculo (#)
            int[][] grid = new int[h + 1][w + 1];

            // Lectura de puntos de interés
            int p = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                grid[r][c] = 1;
            }

            // Lectura de obstáculos
            int o = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < o; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                grid[r][c] = 2;
            }

            // ====================================================================
            // PASO 1: ASIGNACIÓN DE SEGMENTOS HORIZONTALES
            // ====================================================================
            int[][] horizontalSegments = new int[h + 1][w + 1];
            int hSegCount = 0;
            for (int r = 1; r <= h; r++) {
                boolean activeSegment = false;
                for (int c = 1; c <= w; c++) {
                    if (grid[r][c] == 2) {
                        activeSegment = false; // Se interrumpe el segmento por el obstáculo
                    } else if (grid[r][c] == 1) {
                        if (!activeSegment) {
                            hSegCount++;
                            activeSegment = true;
                        }
                        horizontalSegments[r][c] = hSegCount;
                    } else {
                        // Celda vacía: si ya venimos con un segmento activo, la celda puede ser parte de él.
                        if (activeSegment) {
                            horizontalSegments[r][c] = hSegCount;
                        }
                    }
                }
            }

            // ====================================================================
            // PASO 2: ASIGNACIÓN DE SEGMENTOS VERTICALES
            // ====================================================================
            int[][] verticalSegments = new int[h + 1][w + 1];
            int vSegCount = 0;
            for (int c = 1; c <= w; c++) {
                boolean activeSegment = false;
                for (int r = 1; r <= h; r++) {
                    if (grid[r][c] == 2) {
                        activeSegment = false; // Se interrumpe el segmento por el obstáculo
                    } else if (grid[r][c] == 1) {
                        if (!activeSegment) {
                            vSegCount++;
                            activeSegment = true;
                        }
                        verticalSegments[r][c] = vSegCount;
                    } else {
                        if (activeSegment) {
                            verticalSegments[r][c] = vSegCount;
                        }
                    }
                }
            }

            // ====================================================================
            // PASO 3: CONSTRUCCIÓN DEL GRAFO DE FLUJO
            // ====================================================================
            // Nodos:
            // Súper Origen S = 0
            // Segmentos Horizontales = [1, hSegCount]
            // Segmentos Verticales = [hSegCount + 1, hSegCount + vSegCount]
            // Súper Destino T = hSegCount + vSegCount + 1
            int s = 0;
            int t = hSegCount + vSegCount + 1;
            int numNodes = t + 1;

            adj = new ArrayList[numNodes];
            for (int i = 0; i < numNodes; i++) {
                adj[i] = new ArrayList<Edge>();
            }
            level = new int[numNodes];
            ptr = new int[numNodes];

            // Aristas de Súper Origen (S) a cada Segmento Horizontal con capacidad 1
            for (int i = 1; i <= hSegCount; i++) {
                addEdge(s, i, 1);
            }

            // Aristas de cada Segmento Vertical a Súper Destino (T) con capacidad 1
            for (int i = 1; i <= vSegCount; i++) {
                addEdge(hSegCount + i, t, 1);
            }

            // Unir segmentos por cada punto de interés '*' con capacidad 1
            for (int r = 1; r <= h; r++) {
                for (int c = 1; c <= w; c++) {
                    if (grid[r][c] == 1) {
                        int hId = horizontalSegments[r][c];
                        int vId = verticalSegments[r][c];
                        addEdge(hId, hSegCount + vId, 1);
                    }
                }
            }

            // ====================================================================
            // PASO 4: OBTENER EL MATCHING MÁXIMO E IMPRIMIR EL RESULTADO
            // ====================================================================
            int minRobotsNeeded = dinic(s, t);
            System.out.println(minRobotsNeeded);
        }
    }
}