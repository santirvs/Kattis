package Others.Easy.Puntuacion_2_0_a_2_9._2_5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class a10KindsOfPeople {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numFilas = Integer.parseInt(st.nextToken());
        int numColumnas = Integer.parseInt(st.nextToken());

        char[][] mapa = new char[numFilas][numColumnas];
        for (int i = 0; i < numFilas; i++) {
            mapa[i] = br.readLine().toCharArray();
        }

        // Matriz para almacenar el ID de la componente conexa de cada celda
        int[][] component = new int[numFilas][numColumnas];
        int currentComponent = 1;

        // Direcciones para movernos (Norte, Sur, Oeste, Este)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Preprocesamiento: etiquetar todas las componentes conexas una sola vez O(R * C)
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                if (component[i][j] == 0) {
                    char type = mapa[i][j];
                    Queue<Integer> queue = new ArrayDeque<>();
                    queue.add(i);
                    queue.add(j);
                    component[i][j] = currentComponent;

                    while (!queue.isEmpty()) {
                        int r = queue.poll();
                        int c = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr >= 0 && nr < numFilas && nc >= 0 && nc < numColumnas) {
                                if (component[nr][nc] == 0 && mapa[nr][nc] == type) {
                                    component[nr][nc] = currentComponent;
                                    queue.add(nr);
                                    queue.add(nc);
                                }
                            }
                        }
                    }
                    currentComponent++;
                }
            }
        }

        // Procesar consultas en O(1) cada una
        int numConsultas = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numConsultas; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            // Si son de tipos distintos (0 y 1), es imposible
            if (mapa[r1][c1] != mapa[r2][c2]) {
                sb.append("neither\n");
            }
            // Si están en la misma componente conexa
            else if (component[r1][c1] == component[r2][c2]) {
                if (mapa[r1][c1] == '1') {
                    sb.append("decimal\n");
                } else {
                    sb.append("binary\n");
                }
            } else {
                sb.append("neither\n");
            }
        }

        System.out.print(sb);
    }
}