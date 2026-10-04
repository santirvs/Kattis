package Others.Easy.Puntuacion_1_1_a_1_9._1_5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ShebasAmoebas {

    // Direcciones para explorar los 8 vecinos de un píxel (4 ortogonales + 4 diagonales)
    // Esto coincide con la definición de adyacencia del problema: "sharing an edge or corner"
    private static final int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

    /**
     * Realiza un recorrido iterativo (tipo BFS usando un arreglo como cola estática,
     * o equivalente a una búsqueda por inundación - Flood Fill) para marcar toda
     * la componente conexa (la ameba actual) como visitada.
     */
    private static void floodFill(char[][] grid, boolean[][] visited, int startRow, int startCol, int m, int n) {
        // Usaremos una cola basada en arreglos para evitar sobrecarga de memoria o recursión profunda (StackOverflowError)
        int maxElements = m * n;
        int[] queueR = new int[maxElements];
        int[] queueC = new int[maxElements];
        int head = 0, tail = 0;

        queueR[tail] = startRow;
        queueC[tail] = startCol;
        tail++;
        visited[startRow][startCol] = true;

        while (head < tail) {
            int r = queueR[head];
            int c = queueC[head];
            head++;

            // Explorar los 8 vecinos de la celda actual
            for (int i = 0; i < 8; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];

                // Verificar si el vecino está dentro de los límites de la cuadrícula,
                // si es un píxel negro ('#') y si aún no ha sido visitado.
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (grid[nr][nc] == '#' && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queueR[tail] = nr;
                        queueC[tail] = nc;
                        tail++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) {
            return;
        }

        st = new StringTokenizer(line);
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            String rowLine = br.readLine();
            while (rowLine == null) {
                rowLine = br.readLine();
            }
            // Asegurarse de leer correctamente la línea de la cuadrícula
            grid[i] = rowLine.trim().toCharArray();
        }

        boolean[][] visited = new boolean[m][n];
        int amoebaCount = 0;

        // Recorrer cada celda de la cuadrícula buscando amebas (píxeles '#') no descubiertas
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Si encontramos un píxel negro que no ha sido visitado,
                // pertenece a una nueva ameba (bucle cerrado).
                if (grid[i][j] == '#' && !visited[i][j]) {
                    amoebaCount++;
                    // Marcamos todos los píxeles conectados a esta ameba mediante 8-vecindad
                    floodFill(grid, visited, i, j, m, n);
                }
            }
        }

        // Mostrar el número total de amebas encontradas
        System.out.println(amoebaCount);
    }
}