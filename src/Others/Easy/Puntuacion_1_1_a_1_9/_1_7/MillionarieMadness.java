package Others.Easy.Puntuacion_1_1_a_1_9._1_7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MillionarieMadness {

    // Clase auxiliar para representar una celda en la cola de prioridad
    static class Node implements Comparable<Node> {
        int row, col, maxClimb;

        public Node(int row, int col, int maxClimb) {
            this.row = row;
            this.col = col;
            this.maxClimb = maxClimb;
        }

        @Override
        public int compareTo(Node other) {
            // Queremos extraer primero el nodo con el menor maxClimb
            return Integer.compare(this.maxClimb, other.maxClimb);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Matriz para almacenar el menor esfuerzo máximo conocido para llegar a cada celda
        int[][] dist = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        // Empezamos en la esquina superior izquierda (0, 0)
        dist[0][0] = 0;
        pq.offer(new Node(0, 0, 0));

        // Direcciones de movimiento: Arriba, Abajo, Izquierda, Derecha
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int ans = -1;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // Si llegamos a la esquina inferior derecha, terminamos
            if (curr.row == M - 1 && curr.col == N - 1) {
                ans = curr.maxClimb;
                break;
            }

            // Si encontramos un camino ya optimizado a esta celda, lo ignoramos
            if (curr.maxClimb > dist[curr.row][curr.col]) {
                continue;
            }

            // Exploramos los 4 vecinos
            for (int i = 0; i < 4; i++) {
                int nr = curr.row + dr[i];
                int nc = curr.col + dc[i];

                if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
                    // El salto requerido es la diferencia de altura si es positiva, o 0 si bajamos
                    int climb = grid[nr][nc] - grid[curr.row][curr.col];
                    if (climb < 0) {
                        climb = 0;
                    }

                    // El costo máximo del camino hasta el vecino
                    int nextMaxClimb = Math.max(curr.maxClimb, climb);

                    // Si encontramos un camino con menor esfuerzo máximo, actualizamos
                    if (nextMaxClimb < dist[nr][nc]) {
                        dist[nr][nc] = nextMaxClimb;
                        pq.offer(new Node(nr, nc, nextMaxClimb));
                    }
                }
            }
        }

        System.out.println(ans);
    }
}