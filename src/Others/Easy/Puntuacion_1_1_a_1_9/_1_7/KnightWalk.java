package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Hacer una búsqueda en profundidad
 */

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class KnightWalk {

    // Movimientos del caballo ordenados alfabéticamente por la representación del tablero
    // (columnas a-h primero, luego filas 1-8).
    private static final int[] DX = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] DY = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;

        String startStr = sc.next();
        String targetStr = sc.next();

        int startX = startStr.charAt(0) - 'a';
        int startY = startStr.charAt(1) - '1';
        int targetX = targetStr.charAt(0) - 'a';
        int targetY = targetStr.charAt(1) - '1';

        // Matriz de distancias cortas desde la posición inicial
        int[][] dist = new int[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(dist[i], -1);
        }

        // BFS para calcular distancias mínimas
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{startX, startY});
        dist[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            if (cx == targetX && cy == targetY) {
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (isValid(nx, ny) && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cx][cy] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        // DFS / Backtracking para reconstruir todos los caminos más cortos
        List<String> path = new ArrayList<String>();
        path.add(toAlgebraic(startX, startY));
        findPaths(startX, startY, targetX, targetY, dist, path);

        sc.close();
    }

    private static void findPaths(int x, int y, int targetX, int targetY, int[][] dist, List<String> path) {
        if (x == targetX && y == targetY) {
            // Imprimir el camino en el formato requerido
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) {
                    sb.append(" -> ");
                }
                sb.append(path.get(i));
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (isValid(nx, ny) && dist[nx][ny] == dist[x][y] + 1) {
                path.add(toAlgebraic(nx, ny));
                findPaths(nx, ny, targetX, targetY, dist, path);
                path.remove(path.size() - 1); // Backtrack
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    private static String toAlgebraic(int x, int y) {
        return "" + (char) ('a' + x) + (char) ('1' + y);
    }
}