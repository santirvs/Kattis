package Others.Easy.Puntuacion_2_0_a_2_9._2_6;

import java.util.Scanner;

public class HammingEllipses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int q = sc.nextInt();
        int n = sc.nextInt();
        int d = sc.nextInt();

        String f1 = sc.next();
        String f2 = sc.next();

        // dp[j] guardará la cantidad de formas de obtener una suma de distancias igual a j
        long[] dp = new long[d + 1];

        // Estado base: 1 forma de tener distancia 0 con 0 caracteres
        dp[0] = 1;

        // Iteramos por cada posición de las cadenas
        for (int i = 0; i < n; i++) {
            long[] nextDp = new long[d + 1];
            char c1 = f1.charAt(i);
            char c2 = f2.charAt(i);

            if (c1 == c2) {
                // Escenario A: Los focos tienen el mismo carácter en esta posición
                for (int j = 0; j <= d; j++) {
                    if (dp[j] > 0) {
                        // Opción 1: Mismo carácter (+0 a la distancia total). 1 opción.
                        if (j + 0 <= d) {
                            nextDp[j + 0] += dp[j] * 1;
                        }
                        // Opción 2: Cualquier otro carácter del alfabeto (+2 a la distancia total). Q - 1 opciones.
                        if (j + 2 <= d) {
                            nextDp[j + 2] += dp[j] * (q - 1);
                        }
                    }
                }
            } else {
                // Escenario B: Los focos tienen caracteres diferentes
                for (int j = 0; j <= d; j++) {
                    if (dp[j] > 0) {
                        // Opción 1 y 2: El carácter coincide con F1 o con F2 (+1 a la distancia total). 2 opciones.
                        if (j + 1 <= d) {
                            nextDp[j + 1] += dp[j] * 2;
                        }
                        // Opción 3: Cualquier otro carácter diferente a F1 y F2 (+2 a la distancia total). Q - 2 opciones.
                        if (j + 2 <= d) {
                            nextDp[j + 2] += dp[j] * (q - 2);
                        }
                    }
                }
            }
            // Avanzamos al siguiente estado
            dp = nextDp;
        }

        // La respuesta es el número de combinaciones válidas que suman exactamente D
        System.out.println(dp[d]);

        sc.close();
    }
}
