package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Recorrido total en anchura desde cada S
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AutonomyReach {

    // Clase auxiliar para almacenar las coordenadas (fila, columna) en la matriz
    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        // Fast I/O usando BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] grid = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        Queue<Point> queue = new LinkedList<Point>();

        // 1. LECTURA Y CONSTRUCCIÓN DEL MAPA
        // Identificamos las posiciones iniciales de todos los depósitos ('S')
        for (int r = 0; r < R; r++) {
            String rowStr = br.readLine();
            for (int c = 0; c < C; c++) {
                grid[r][c] = rowStr.charAt(c);

                // Si encontramos un depósito 'S', se encola como punto de partida
                // y se marca inmediatamente como visitado para evitar procesarlo doble.
                if (grid[r][c] == 'S') {
                    visited[r][c] = true;
                    queue.add(new Point(r, c));
                }
            }
        }

        // Desplazamientos en 4 direcciones ortogonales: Arriba, Abajo, Izquierda, Derecha
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int reachablePickups = 0;

        // 2. BÚSQUEDA EN ANCHURA (BFS) MULTI-ORIGEN
        // Exploramos todas las celdas alcanzables partiendo desde cualquiera de los depósitos 'S'
        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            // Evaluar los 4 vecinos posibles
            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                // Verificación de límites de la matriz
                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {

                    // Si no ha sido visitada y no es un obstáculo ('#' o 'W')
                    if (!visited[nr][nc] && isDrivable(grid[nr][nc])) {
                        visited[nr][nc] = true;

                        // Si la celda transitables resulta ser un punto de recogida ('P'),
                        // incrementamos el contador de pasajeros alcanzables
                        if (grid[nr][nc] == 'P') {
                            reachablePickups++;
                        }

                        // Agregar a la cola para continuar la exploración
                        queue.add(new Point(nr, nc));
                    }
                }
            }
        }

        // 3. SALIDA
        // Imprimir el total de puntos 'P' alcanzables
        System.out.println(reachablePickups);
    }

    /**
     * Determina si una celda es transitable por el taxi autónomo.
     * Celdas transitables: '.' (calle), 'C' (cargador), 'P' (pasajero), 'S' (depósito).
     * Celdas bloqueadas: '#' (edificio), 'W' (agua).
     */
    private static boolean isDrivable(char cell) {
        return cell == '.' || cell == 'C' || cell == 'P' || cell == 'S';
    }
}