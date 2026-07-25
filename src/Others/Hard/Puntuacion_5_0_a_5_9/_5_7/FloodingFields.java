package Others.Hard.Puntuacion_5_0_a_5_9._5_7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * PROBLEMA: Flooding Fields
 *
 * PLANTEAMIENTO GENERAL Y ESTRATEGIA:
 * ----------------------------------
 * 1. Modelado como Red de Flujo Máximo (Max Flow):
 *    Como las vacas se mueven simultáneamente en el tiempo y no pueden compartir
 *    la misma casilla a la vez, modelamos el problema como un flujo máximo
 *    en una red temporizada (Time-Expanded Network).
 *
 * 2. Capas del Grafo (Tiempo x Posición):
 *    Duplicamos el tablero N x N para cada hora t en [0, H].
 *    Un estado individual está definido por la tupla (fila, columna, hora).
 *
 * 3. Garantizar "1 vaca por celda":
 *    Para evitar que dos vacas ocupen la misma casilla al mismo tiempo,
 *    dividimos cada casilla (r, c) en la hora 'h' en dos nodos:
 *    - u_in : Nodo de entrada de la casilla.
 *    - u_out: Nodo de salida de la casilla.
 *
 *    Añadimos una arista de capacidad 1: u_in -> u_out.
 *
 * 4. Transiciones de Movimiento (de hora h a h+1):
 *    Si una casilla (r, c) está seca a la hora 'h', la vaca puede permanecer
 *    allí o moverse a una casilla adyacente (nr, nc) a la hora 'h+1', siempre
 *    que la casilla destino esté seca a la hora 'h+1':
 *
 *    u_out (hora h) -> v_in (hora h+1) [capacidad 1]
 *
 * 5. Conexiones con la Fuente (S) y Sumidero (T):
 *    - Fuente (S) -> (r_vaca, c_vaca, hora 0)_in con capacidad 1.
 *    - Cuentan como sobrevivientes las vacas que llegan a la hora H:
 *      (r, c, hora H)_out -> Sumidero (T) con capacidad 1 (si está seca).
 *
 * 6. Algoritmo de Flujo:
 *    Se utiliza el Algoritmo de Dinic debido a su gran eficiencia en grafos
 *    con capacidades unitarias.
 */
public class FloodingFields {

    // Representación de una arista en la red de flujo residual
    static class Edge {
        int to;      // Nodo destino
        int rev;     // Índice de la arista reversa en la lista de adyacencia del nodo 'to'
        int cap;     // Capacidad de la arista
        int flow;    // Flujo actual consumido

        Edge(int to, int rev, int cap) {
            this.to = to;
            this.rev = rev;
            this.cap = cap;
            this.flow = 0;
        }
    }

    // Estructura del Grafo
    static List<Edge>[] graph;
    static int[] level; // Nivel de cada nodo en el árbol BFS de Dinic
    static int[] ptr;   // Puntero para la búsqueda DFS en Dinic (optimización de aristas muertas)

    @SuppressWarnings("unchecked")
    static void initGraph(int nodes) {
        graph = new List[nodes];
        for (int i = 0; i < nodes; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        level = new int[nodes];
        ptr = new int[nodes];
    }

    // Método para agregar aristas dirigidas (con su respectiva arista residual de capacidad 0)
    static void addEdge(int from, int to, int cap) {
        Edge a = new Edge(to, graph[to].size(), cap);
        Edge b = new Edge(from, graph[from].size(), 0); // Arista residual
        graph[from].add(a);
        graph[to].add(b);
    }

    // Paso 1 de Dinic: BFS para construir el grafo por niveles (Level Graph)
    static boolean bfs(int s, int t) {
        Arrays.fill(level, -1);
        level[s] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);

        while (!q.isEmpty()) {
            int v = q.poll();
            for (Edge e : graph[v]) {
                // Si la arista tiene capacidad residual y el nodo no ha sido visitado
                if (e.cap - e.flow > 0 && level[e.to] < 0) {
                    level[e.to] = level[v] + 1;
                    q.add(e.to);
                }
            }
        }
        return level[t] >= 0; // Retorna true si el sumidero T es alcanzable
    }

    // Paso 2 de Dinic: DFS para enviar el flujo máximo por el grafo por niveles
    static int dfs(int v, int t, int pushed) {
        if (pushed == 0) return 0;
        if (v == t) return pushed;

        for (; ptr[v] < graph[v].size(); ptr[v]++) {
            Edge e = graph[v].get(ptr[v]);
            int tr = e.to;

            // Solo avanzamos a nodos del siguiente nivel en el BFS
            if (level[v] + 1 != level[tr] || e.cap - e.flow == 0) continue;

            int trPushed = dfs(tr, t, Math.min(pushed, e.cap - e.flow));
            if (trPushed == 0) continue;

            // Actualizamos el flujo y el flujo residual
            e.flow += trPushed;
            graph[tr].get(e.rev).flow -= trPushed;
            return trPushed;
        }
        return 0;
    }

    // Función principal para calcular el Flujo Máximo usando Dinic
    static int dinic(int s, int t) {
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

    /**
     * Mapea una posición del tablero (r, c) a una hora 'h' y su estado (IN/OUT)
     * a un identificador entero único de nodo en el grafo.
     *
     * inOut = 0 -> Nodo IN  (Entrada a la casilla)
     * inOut = 1 -> Nodo OUT (Salida de la casilla)
     */
    static int getNodeIndex(int r, int c, int h, int inOut, int N) {
        return (h * (N * N) + (r * N + c)) * 2 + inOut;
    }

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        String tN = scanner.next();
        if (tN == null) return;

        int N = Integer.parseInt(tN); // Tamaño de la grilla (N x N)
        int K = scanner.nextInt();    // Cantidad de vacas
        int H = scanner.nextInt();    // Cantidad de horas a evaluar

        // Lectura de las alturas del terreno
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // Lectura de las posiciones iniciales de las vacas
        int[][] cows = new int[K][2];
        for (int i = 0; i < K; i++) {
            cows[i][0] = scanner.nextInt();
            cows[i][1] = scanner.nextInt();
        }

        // Lectura del nivel del agua para cada hora h (1 <= h <= H)
        int[] floodLevel = new int[H + 1];
        for (int h = 1; h <= H; h++) {
            floodLevel[h] = scanner.nextInt();
        }
        // Nota: A la hora 0 el agua no ha subido (nivel por defecto: -1)

        // Definición de nodos especiales en el grafo
        int totalGridNodes = (H + 1) * N * N * 2;
        int S = totalGridNodes;     // Fuente
        int T = S + 1;              // Sumidero

        initGraph(T + 1);

        // Vectores de dirección: Arriba, Abajo, Izquierda, Derecha y Quedarse Quieto
        int[] dr = {0, 0, 1, -1, 0};
        int[] dc = {1, -1, 0, 0, 0};

        // CONSTRUCCIÓN DE LA RED DE FLUJO
        // ----------------------------------
        for (int h = 0; h <= H; h++) {
            int currentFlood = (h == 0) ? -1 : floodLevel[h];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    // Si el terreno está sumergido a la hora h, las vacas no pueden estar aquí
                    if (grid[r][c] <= currentFlood) continue;

                    int uIn = getNodeIndex(r, c, h, 0, N);
                    int uOut = getNodeIndex(r, c, h, 1, N);

                    // Capacidad 1 dentro de la casilla: Garantiza que máximo 1 vaca la ocupe a la vez
                    addEdge(uIn, uOut, 1);

                    // Si no es la última hora, creamos las transiciones de movimiento hacia la hora h + 1
                    if (h < H) {
                        int nextFlood = floodLevel[h + 1];

                        // Probar las 5 opciones de movimiento (4 adyacentes + 1 mantenerse)
                        for (int d = 0; d < 5; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                // Solamente agregamos arista si la casilla de destino estará seca a la hora h + 1
                                if (grid[nr][nc] > nextFlood) {
                                    int vNextIn = getNodeIndex(nr, nc, h + 1, 0, N);
                                    addEdge(uOut, vNextIn, 1);
                                }
                            }
                        }
                    } else {
                        // Si alcanzamos la última hora (H) en terreno seco, la vaca sobrevive -> Conectar al Sumidero T
                        addEdge(uOut, T, 1);
                    }
                }
            }
        }

        // Conectar la Fuente S a las casillas donde inician las vacas a la hora 0
        for (int i = 0; i < K; i++) {
            int cr = cows[i][0];
            int cc = cows[i][1];
            // Se valida que la casilla inicial no esté bajo agua
            if (grid[cr][cc] > -1) {
                int cowStartNode = getNodeIndex(cr, cc, 0, 0, N);
                addEdge(S, cowStartNode, 1);
            }
        }

        // El flujo máximo representa el número máximo de vacas que logran sobrevivir
        System.out.println(dinic(S, T));
    }

    // Clase auxiliar para la lectura eficiente de grandes volúmenes de datos en Java 1.7
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}