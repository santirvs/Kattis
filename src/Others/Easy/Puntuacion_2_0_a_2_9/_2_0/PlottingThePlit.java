package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PlottingThePlit {
    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader y StringTokenizer para una lectura rápida y eficiente,
        // vital en problemas de programación competitiva con matrices grandes.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        // Matriz para almacenar los niveles L(r, c) de cada celda.
        // L(r, c) se define como la división entera de la profundidad entre K.
        long[][] L = new long[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                long depth = Long.parseLong(st.nextToken());
                // En Java, la división entera '/' trunca hacia abajo automáticamente,
                // cumpliendo con la definición de L(r, c).
                L[r][c] = depth / K;
            }
        }

        // Direcciones de los vecinos ortogonales: Arriba, Abajo, Izquierda, Derecha.
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // StringBuilder para acumular la salida de forma eficiente antes de imprimir.
        StringBuilder output = new StringBuilder();

        // ==========================================
        // PROCESAMIENTO DE CADA CELDA DE LA GRILLA
        // ==========================================
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {

                // PASO 1: Encontrar el valor mínimo M(r, c) entre los vecinos válidos que comparten borde.
                long minNeighbor = Long.MAX_VALUE;

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    // Verificamos que el vecino esté dentro de los límites de la matriz.
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        if (L[nr][nc] < minNeighbor) {
                            minNeighbor = L[nr][nc];
                        }
                    }
                }

                // PASO 2: Calcular la diferencia delta entre el nivel actual y el mínimo vecino.
                // Nota: Si una celda no tiene vecinos válidos (matrices de 1x1),
                // minNeighbor se mantendría en MAX_VALUE, pero el problema garantiza dimensiones
                // y vecinos ortogonales según la especificación.
                long delta = L[r][c] - minNeighbor;

                // PASO 3: Determinar el carácter según las reglas del problema.
                char symbol;
                if (delta <= 0) {
                    symbol = ' ';
                } else if (delta == 1) {
                    symbol = '+';
                } else if (delta == 2) {
                    symbol = 'X';
                } else { // delta >= 3
                    symbol = '#';
                }

                output.append(symbol);
            }
            // Al terminar cada fila, agregamos un salto de línea.
            output.append('\n');
        }

        // Imprimir el resultado final del mapa topográfico.
        System.out.print(output.toString());
    }
}