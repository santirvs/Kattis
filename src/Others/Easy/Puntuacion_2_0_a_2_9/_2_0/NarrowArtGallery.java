package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class NarrowArtGallery {

    static int N, K;
    static int[][] values;
    static int[][][] memo; // Usamos long o int dependiendo del rango de valores, int suele bastar
    static final int INF = 1000000000; // Valor infinito para representar estados inválidos

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // Condición de parada del problema
            if (N == 0 && K == 0) {
                break;
            }

            int totalSum = 0;
            values = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                values[i][0] = Integer.parseInt(st.nextToken());
                values[i][1] = Integer.parseInt(st.nextToken());
                totalSum += values[i][0] + values[i][1];
            }

            // Inicializar la tabla de memorización con -1
            // Dimensiones: N filas, K habitaciones por cerrar + 1, 3 estados posibles (0: ninguno, 1: izq cerrada, 2: der cerrada)
            memo = new int[N][K + 1][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= K; j++) {
                    Arrays.fill(memo[i][j], -1);
                }
            }

            // Calculamos el costo MÍNIMO de las habitaciones que se cierran
            int minCostToClose = solve(0, K, 0);

            // El resultado es la suma total de valores menos el costo mínimo cerrado
            int maxRemainingValue = totalSum - minCostToClose;
            System.out.println(maxRemainingValue);
        }
    }

    /**
     * Función recursiva de Programación Dinámica (Top-Down con Memoización)
     *
     * @param idx   Índice de la fila actual que estamos evaluando (0 a N-1).
     * @param k     Número de habitaciones que todavía necesitamos cerrar.
     * @param state Restricción heredada de la fila anterior:
     *              0 -> Sin restricciones (ningún lado bloqueó la fila actual).
     *              1 -> La habitación IZQUIERDA de la fila anterior fue cerrada
     *                   (prohíbe cerrar la derecha en la fila actual por contacto diagonal).
     *              2 -> La habitación DERECHA de la fila anterior fue cerrada
     *                   (prohíbe cerrar la izquierda en la fila actual por contacto diagonal).
     * @return El costo mínimo (suma de valores de habitaciones cerradas) desde la fila 'idx' hasta el final.
     */
    private static int solve(int idx, int k, int state) {
        // Caso base 1: Ya cerramos exactamente las k habitaciones requeridas
        if (k == 0) {
            return 0;
        }

        // Caso base 2: Se nos acabaron las filas pero aún faltan habitaciones por cerrar (estado inválido)
        if (idx == N) {
            return INF;
        }

        // Si ya calculamos este estado, lo devolvemos directamente
        if (memo[idx][k][state] != -1) {
            return memo[idx][k][state];
        }

        int minCost = INF;

        // Opcón 1: No cerrar ninguna habitación en esta fila
        // Pasa al siguiente índice, 'k' se mantiene igual, y el estado se reinicia a 0 (ningún bloqueo cruzado)
        minCost = Math.min(minCost, solve(idx + 1, k, 0));

        // Opción 2: Cerrar la habitación IZQUIERDA de esta fila
        // Solo es válido si la restricción anterior no bloqueaba la izquierda (es decir, state != 2) y si k > 0
        if (state != 2) {
            int costIfCloseLeft = values[idx][0] + solve(idx + 1, k - 1, 1);
            minCost = Math.min(minCost, costIfCloseLeft);
        }

        // Opción 3: Cerrar la habitación DERECHA de esta fila
        // Solo es válido si la restricción anterior no bloqueaba la derecha (es decir, state != 1) y si k > 0
        if (state != 1) {
            int costIfCloseRight = values[idx][1] + solve(idx + 1, k - 1, 2);
            minCost = Math.min(minCost, costIfCloseRight);
        }

        // Guardamos el resultado en la tabla de memoización y lo retornamos
        return memo[idx][k][state] = minCost;
    }
}