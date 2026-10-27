package Others.Easy.Puntuacion_2_0_a_2_9._2_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class CoastLenght {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. Leer dimensiones N (filas) y M (columnas)
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2. Leer el mapa original de caracteres ('1' para tierra, '0' para agua)
        char[][] originalMap = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine().trim();
            for (int j = 0; j < m; j++) {
                originalMap[i][j] = row.charAt(j);
            }
        }

        // 3. Crear una cuadrícula ampliada (padding) de (N + 2) x (M + 2)
        // Esto añade un borde exterior de agua ('0') alrededor de todo el mapa original,
        // lo que facilita la identificación del mar abierto.
        int rows = n + 2;
        int cols = m + 2;
        char[][] padded = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                padded[i][j] = '0'; // Inicializar todo con agua
            }
        }

        // Copiar el mapa original en el centro de la cuadrícula ampliada
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                padded[i + 1][j + 1] = originalMap[i][j];
            }
        }

        // 4. Identificar el mar abierto utilizando BFS (Búsqueda en Anchura)
        // Partimos desde la esquina superior izquierda (0, 0) del mapa con padding,
        // la cual está garantizada de ser mar abierto.
        boolean[][] isSea = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<int[]>(); // Sintaxis compatible con Java 1.7

        queue.add(new int[]{0, 0});
        isSea[0][0] = true;

        // Direcciones de movimiento: arriba, abajo, izquierda, derecha
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // Si la celda vecina está dentro de los límites, es agua ('0') y aún no ha sido marcada como mar
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    if (padded[nr][nc] == '0' && !isSea[nr][nc]) {
                        isSea[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        // 5. Calcular la longitud de la costa marítima
        // Recorremos cada celda de tierra ('1') en el mapa original y revisamos sus 4 vecinos.
        int coastLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originalMap[i][j] == '1') {
                    // Mapear a las coordenadas de la cuadrícula ampliada
                    int pr = i + 1;
                    int pc = j + 1;

                    // Comprobar los 4 vecinos de la celda de tierra
                    for (int k = 0; k < 4; k++) {
                        int nr = pr + dr[k];
                        int nc = pc + dc[k];

                        // Si el vecino es mar abierto (isSea == true), representa un segmento de costa
                        if (isSea[nr][nc]) {
                            coastLength++;
                        }
                    }
                }
            }
        }

        // 6. Imprimir el resultado final
        System.out.println(coastLength);
    }
}