package Cap3._2_BusquedaCompleta.CalculoPrevio;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

// Aquí la clave está en que el tablero puede ser como máximo de 4x4.
// Esto nos permite generar todas las combinaciones posibles de piezas de chocolate
// y comprobar si forman un polígono. Además, es posible pre-calcular todas las combinaciones
// y guardarlas en una matriz de respuestas para poder consultarlas rápidamente.

// Para comprobar si un conjunto de piezas de chocolate forma un polígono,
// debemos asegurarnos de que:
// 1. Todas las piezas de chocolate son conexas (es decir, se pueden alcanzar unas a otras).
// 2. Todas las celdas vacías son conexas a la frontera del tablero (es decir, no hay agujeros en el polígono).
// Para ello basta con realizar una búsqueda con 4 direcciones para las piezas de chocolate
// y una búsqueda con 8 direcciones para las celdas vacías, asegurándonos de que todas las piezas
// de chocolate están conectadas entre sí y que todas las celdas vacías están conectadas a la frontera del tablero.

public class Chocolates {

    // Idea feliz!! Como máximo hay 16 celdas, por lo que en un int de 16 bits podemos representar todas las
    // combinaciones posibles de piezas de chocolate. Así que podemos usar un int para representar el tablero.
    public static boolean checkPolygon(int h, int w, int p) {
        if (p == 0) return false; // No és polígon si no hi ha res

        int[][] board = new int[h][w];
        int[] source = {-1, -1};

        // Convertim el número p a una matriu de 0s i 1s
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                int bitIndex = r * w + c;
                board[r][c] = ((1 << bitIndex) & p) != 0 ? 1 : 0;
                if (source[0] == -1 && board[r][c] == 1) {
                    source[0] = r;
                    source[1] = c;
                }
            }
        }

        // 1. Comprovem que totes les peces de xocolata són connexes
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[h][w];
        //definim les direccions per a la cerca (dreta, amunt, esquerra, dalt)
        int[] dr4 = {0, 1, 0, -1};
        int[] dc4 = {1, 0, -1, 0};

        q.add(new int[]{source[0], source[1]});
        visited[source[0]][source[1]] = true;

        while (!q.isEmpty()) {
            int[] pos = q.pollLast();
            int r = pos[0], c = pos[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr4[i];
                int nc = c + dc4[i];
                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (visited[nr][nc]) continue;
                if (board[nr][nc] == 1) {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (!visited[r][c] && board[r][c] == 1) return false;
            }
        }

        // 2. Comprovem que totes les cel·les buides són connexes a la vora
        q.clear();
        visited = new boolean[h][w];
        int[] dr8 = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dc8 = {1, 0, -1, 0, 1, -1, 1, -1};

        for (int r = 0; r < h; r++) {
            if (board[r][0] == 0) q.add(new int[]{r, 0});
            if (board[r][w - 1] == 0) q.add(new int[]{r, w - 1});
        }
        for (int c = 1; c < w - 1; c++) {
            if (board[0][c] == 0) q.add(new int[]{0, c});
            if (board[h - 1][c] == 0) q.add(new int[]{h - 1, c});
        }

        for (int[] pos : q) {
            visited[pos[0]][pos[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] pos = q.pollLast();
            int r = pos[0], c = pos[1];
            for (int i = 0; i < 8; i++) {
                int nr = r + dr8[i];
                int nc = c + dc8[i];
                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (visited[nr][nc]) continue;
                if (board[nr][nc] == 1) continue;
                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (!visited[r][c] && board[r][c] == 0) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //generate();
        solve();
    }
    public static void generate() {
        int[][] answerMatrix = new int[4][4];

        for (int h = 0; h < 4; h++) {
            for (int w = 0; w < 4; w++) {
                int total = 1 << ((h + 1) * (w + 1));
                for (int p = 0; p < total; p++) {
                    if (checkPolygon(h + 1, w + 1, p)) {
                        answerMatrix[h][w]++;
                    }
                }
            }
        }

        // Imprimim la matriu de respostes
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(answerMatrix[i]));
        }
    }

    public static void solve() {
        // Matriu de respostes pre-calculada
        int[][] answerMatrix = {
            {1, 3, 6, 10}, // 1x1
            {3, 13, 40, 108}, // 2x2
            {6, 40, 217, 1109}, // 3x3
            {10, 108, 1109, 10977}  // 4x4
        };

        // Llegeix entrada per consultar una resposta específica
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        System.out.println(answerMatrix[h - 1][w - 1]);
    }
}
