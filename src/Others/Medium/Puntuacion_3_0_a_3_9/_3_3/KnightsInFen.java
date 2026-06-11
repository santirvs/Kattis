package Others.Medium.Puntuacion_3_0_a_3_9._3_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KnightsInFen {
    // Tablero objetivo oficial del problema
    private static final char[][] TARGET = {
            {'1', '1', '1', '1', '1'},
            {'0', '1', '1', '1', '1'},
            {'0', '0', ' ', '1', '1'},
            {'0', '0', '0', '0', '1'},
            {'0', '0', '0', '0', '0'}
    };

    // Movimientos posibles del caballo (enfoque: mover el espacio vacío)
    private static final int[] DR = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] DC = {-1, 1, -2, 2, -2, 2, -1, 1};

    private static boolean solucionado;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int numTestCases = Integer.parseInt(line.trim());

        while (numTestCases-- > 0) {
            char[][] board = new char[5][5];
            int emptyRow = -1;
            int emptyCol = -1;

            // Lectura estricta de las 5 líneas del tablero
            for (int i = 0; i < 5; i++) {
                String rowStr = br.readLine();
                // Si la línea es más corta, rellenamos con espacios (caso de espacio al final)
                while (rowStr.length() < 5) {
                    rowStr += " ";
                }
                for (int j = 0; j < 5; j++) {
                    board[i][j] = rowStr.charAt(j);
                    if (board[i][j] == ' ') {
                        emptyRow = i;
                        emptyCol = j;
                    }
                }
            }

            solucionado = false;
            int resultado = -1;

            // IDA* / IDDFS: Buscamos incrementando el límite de movimientos de 0 a 10
            for (int limite = 0; limite <= 10; limite++) {
                if (dfs(0, limite, emptyRow, emptyCol, board)) {
                    resultado = limite;
                    break;
                }
            }

            if (resultado != -1) {
                System.out.println("Solvable in " + resultado + " move(s).");
            } else {
                System.out.println("Unsolvable in less than 11 move(s).");
            }
        }
    }

    /**
     * Cuenta cuántas piezas NO están en su lugar correcto respecto al objetivo.
     */
    private static int calcularHeuristica(char[][] board) {
        int incorrectos = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != TARGET[i][j]) {
                    incorrectos++;
                }
            }
        }
        return incorrectos;
    }

    /**
     * Búsqueda en Profundidad Acotada con Poda Heurística (IDA*)
     */
    private static boolean dfs(int g, int limite, int r, int c, char[][] board) {
        int h = calcularHeuristica(board);

        // Estado meta alcanzado
        if (h == 0) {
            return true;
        }

        // PODA CRUCIAL:
        // Si el coste actual (g) más la estimación mínima (h - 1) supera el límite permitido,
        // es matemáticamente imposible resolverlo en los movimientos restantes.
        if (g + h - 1 > limite) {
            return false;
        }

        // Explorar los 8 movimientos del caballo
        for (int i = 0; i < 8; i++) {
            int nr = r + DR[i];
            int nc = c + DC[i];

            // Validar límites del tablero de 5x5
            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
                // Hacer el movimiento (swap)
                char temp = board[r][c];
                board[r][c] = board[nr][nc];
                board[nr][nc] = temp;

                // Llamada recursiva avanzando un paso en profundidad
                if (dfs(g + 1, limite, nr, nc, board)) {
                    return true;
                }

                // Deshacer el movimiento (Backtracking obligatorio)
                temp = board[r][c];
                board[r][c] = board[nr][nc];
                board[nr][nc] = temp;
            }
        }
        return false;
    }
}