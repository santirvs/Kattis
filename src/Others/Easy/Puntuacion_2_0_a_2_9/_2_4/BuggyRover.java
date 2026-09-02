package Others.Easy.Puntuacion_2_0_a_2_9._2_4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BuggyRover {

    // Representación de las 4 direcciones principales
    private static final char[] DIRS = {'N', 'E', 'S', 'W'};
    // Desplazamientos en filas (dr) y columnas (dc) correspondientes a N, E, S, W
    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // Uso de BufferedReader y StringTokenizer para lectura eficiente (necesario en Java 1.7)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null || line.trim().length() == 0) return;

        StringTokenizer st = new StringTokenizer(line);
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] grid = new char[R][C];
        int startR = -1, startC = -1;

        for (int r = 0; r < R; r++) {
            String gridLine = reader.readLine();
            for (int c = 0; c < C; c++) {
                grid[r][c] = gridLine.charAt(c);
                if (grid[r][c] == 'S') {
                    startR = r;
                    startC = c;
                }
            }
        }

        String moves = reader.readLine();
        if (moves == null) moves = "";

        // =========================================================================
        // FASE 1: PREPROCESAMIENTO DE LA TRAYECTORIA
        // =========================================================================
        // Puesto que el problema afirma que todos los movimientos conducen a celdas
        // transitables y la secuencia dada 'moves' describe los pasos tomados,
        // la trayectoria exacta del rover está determinadamente fijada.
        // Calculamos las coordenadas (posR[i], posC[i]) antes de ejecutar el paso i.

        int nMoves = moves.length();
        int[] posR = new int[nMoves + 1];
        int[] posC = new int[nMoves + 1];
        posR[0] = startR;
        posC[0] = startC;

        for (int i = 0; i < nMoves; i++) {
            char m = moves.charAt(i);
            int dirIdx = getDirIndex(m);
            posR[i + 1] = posR[i] + DR[dirIdx];
            posC[i + 1] = posC[i] + DC[dirIdx];
        }

        // =========================================================================
        // FASE 2: GENERACIÓN DE TODAS LAS PERMUTACIONES (4! = 24)
        // =========================================================================
        // Una permutación define el orden interno de prioridad de direcciones del rover.
        // Guardamos cada permutación como una regla int[4] con índices de 0 a 3 (N, E, S, W).

        List<int[]> permutationsList = new ArrayList<int[]>();
        boolean[] used = new boolean[4];
        int[] currentPerm = new int[4];
        generatePermutations(0, used, currentPerm, permutationsList);

        int numPerms = permutationsList.size(); // Siempre será 24

        // =========================================================================
        // FASE 3: VALIDACIÓN DE PERMUTACIONES SEGÚN EL COMPORTAMIENTO DEL ROVER
        // =========================================================================
        // Precalculamos para cada paso 'i' y para cada permutación 'p' si es POSIBLE
        // que el rover elija el movimiento moves.charAt(i).
        //
        // Regla de decisión del algoritmo interno del rover:
        // El rover intenta cada dirección en el orden dado por la permutación P.
        // Ejecutará la PRIMERA dirección que sea válida (dentro del mapa y no sea '#').
        // Por lo tanto, para que el rover elija la dirección observada D:
        // 1. La dirección D debe estar habilitada (es transitable).
        // 2. TODAS las direcciones que preceden a D en la permutación P DEBEN estar bloqueadas.

        boolean[][] isValidPermForStep = new boolean[nMoves][numPerms];

        for (int i = 0; i < nMoves; i++) {
            int curR = posR[i];
            int curC = posC[i];
            char targetDir = moves.charAt(i);

            for (int p = 0; p < numPerms; p++) {
                int[] perm = permutationsList.get(p);
                isValidPermForStep[i][p] = canProduceMove(grid, R, C, curR, curC, perm, targetDir);
            }
        }

        // =========================================================================
        // FASE 4: PROGRAMACIÓN DINÁMICA (DP) / BÚSQUEDA DEL CAMINO MÍNIMO
        // =========================================================================
        // DP[p] = Mínimo número de rayos cósmicos necesarios para estar en el estado
        // actual utilizando la permutación 'p'.
        //
        // Inicialmente (antes de realizar ningún paso, i=0), la elección de la
        // primera permutación es libre y no implica ningún impacto por rayo cósmico.
        // Por tanto, DP[p] = 0 para todas las permutaciones válidas para el paso 0.

        int[] dp = new int[numPerms];

        // Inicialización para el paso 0
        for (int p = 0; p < numPerms; p++) {
            if (isValidPermForStep[0][p]) {
                dp[p] = 0;
            } else {
                dp[p] = 1000000; // Valor infinito (imposible)
            }
        }

        // Transición de estados a través de la secuencia de pasos
        for (int i = 0; i < nMoves - 1; i++) {
            int[] nextDp = new int[numPerms];
            Arrays.fill(nextDp, 1000000);

            // Obtenemos el costo mínimo del paso anterior si se decide CAMBIAR de permutación
            int minPrev = 1000000;
            for (int p = 0; p < numPerms; p++) {
                if (dp[p] < minPrev) {
                    minPrev = dp[p];
                }
            }

            for (int nextP = 0; nextP < numPerms; nextP++) {
                // Solo consideramos permutaciones que legalmente puedan realizar el movimiento i+1
                if (isValidPermForStep[i + 1][nextP]) {
                    // Opción A: Mantener la misma permutación (Costo +0)
                    int costSame = dp[nextP];
                    // Opción B: Recibir un rayo cósmico y cambiar desde la mejor del paso i (Costo +1)
                    int costChange = minPrev + 1;

                    nextDp[nextP] = Math.min(costSame, costChange);
                }
            }

            dp = nextDp;
        }

        // El resultado es el costo mínimo para completar el último paso
        int minCosmicRays = 1000000;
        for (int p = 0; p < numPerms; p++) {
            if (dp[p] < minCosmicRays) {
                minCosmicRays = dp[p];
            }
        }

        System.out.println(minCosmicRays);
    }

    /**
     * Mapea el carácter de dirección ('N', 'E', 'S', 'W') a un índice numérico [0..3].
     */
    private static int getDirIndex(char c) {
        switch (c) {
            case 'N': return 0;
            case 'E': return 1;
            case 'S': return 2;
            case 'W': return 3;
        }
        return -1;
    }

    /**
     * Genera recursivamente todas las 24 permutaciones de {0, 1, 2, 3}.
     */
    private static void generatePermutations(int depth, boolean[] used, int[] currentPerm, List<int[]> list) {
        if (depth == 4) {
            list.add(currentPerm.clone());
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (!used[i]) {
                used[i] = true;
                currentPerm[depth] = i;
                generatePermutations(depth + 1, used, currentPerm, list);
                used[i] = false;
            }
        }
    }

    /**
     * Verifica si una celda dada en el mapa es libre/transitable.
     */
    private static boolean isFree(char[][] grid, int R, int C, int r, int c) {
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return false; // Fuera de los límites del planeta
        }
        return grid[r][c] != '#'; // No debe ser una roca
    }

    /**
     * Evalúa si una permutación particular de orden de direcciones producirá
     * la dirección 'targetDir' dada la posición actual en el tablero.
     */
    private static boolean canProduceMove(char[][] grid, int R, int C, int r, int c, int[] perm, char targetDir) {
        int targetIdx = getDirIndex(targetDir);

        for (int d : perm) {
            int nextR = r + DR[d];
            int nextC = c + DC[d];

            boolean free = isFree(grid, R, C, nextR, nextC);

            if (d == targetIdx) {
                // Se alcanzó la dirección deseada. Para que sea elegida por el rover,
                // la casilla correspondiente debe estar vacía.
                return free;
            } else {
                // Si esta dirección está antes de la deseada, DEBE ESTAR BLOQUEADA.
                // Si estuviera libre, el rover la habría elegido e ignorado 'targetDir'.
                if (free) {
                    return false;
                }
            }
        }
        return false;
    }
}