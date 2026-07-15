package Others.Hard.Puntuacion_7_0_a_7_9._7_3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Numbers {

    private static final int MOD = 1000;

    // Multiplica dos matrices de 2x2 bajo módulo 1000
    private static int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long sum = 0;
                for (int k = 0; k < 2; k++) {
                    sum += (long) A[i][k] * B[k][j];
                }
                // (sum % MOD + MOD) % MOD asegura que no tengamos residuos negativos
                C[i][j] = (int) ((sum % MOD + MOD) % MOD);
            }
        }
        return C;
    }

    // Eleva una matriz a la potencia p usando exponenciación binaria O(log p)
    private static int[][] power(int[][] A, int p) {
        int[][] res = {{1, 0}, {0, 1}}; // Matriz Identidad
        int[][] base = A;
        while (p > 0) {
            if ((p & 1) == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            p >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (T == -1) return;

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();

            int ans;
            if (n == 1) {
                // S_1 = 6. Parte entera de (3 + sqrt(5))^1 es S_1 - 1 = 5.
                ans = 5;
            } else {
                // Matriz de transición: T = [[6, -4], [1, 0]]
                // Ajustamos el -4 a módulo 1000 -> -4 + 1000 = 996
                int[][] T_mat = {
                        {6, 996},
                        {1, 0}
                };

                // Elevamos la matriz a la potencia (n - 1)
                int[][] T_pow = power(T_mat, n - 1);

                // Multiplicamos T_pow * [S_1, S_0]^T -> T_pow * [6, 2]^T
                // S_n = T_pow[0][0]*S_1 + T_pow[0][1]*S_0
                int S_n = (T_pow[0][0] * 6 + T_pow[0][1] * 2) % MOD;

                // El resultado es (S_n - 1) % MOD.
                // Sumamos MOD para evitar negativos si S_n llegara a ser 0.
                ans = (S_n - 1 + MOD) % MOD;
            }

            // Formatear la salida siempre con 3 dígitos rellenos de ceros a la izquierda
            //sb.append("Case #").append(t).append(": ").append(String.format("%03d", ans)).append("\n");
            System.out.printf("Case #%d: %03d\n",t,ans);
        }
    }
}