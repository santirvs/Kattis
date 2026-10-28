package Others.Easy.Puntuacion_2_0_a_2_9._2_8;

import java.util.Scanner;

public class DeildGodsagnanna {
    // Módulo habitual en problemas de programación competitiva (10^9 + 7)
    private static final long MOD = 1000000007L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLong()) {
            return;
        }
        long n = scanner.nextLong();
        scanner.close();

        // Secuencia de cantidad de campeones involucrados en cada uno de los 17 pasos del draft:
        // Pasos 1 a 6: 1 baneo cada uno (1, 1, 1, 1, 1, 1)
        // Paso 7: Blue pick 1
        // Paso 8: Red pick 2
        // Paso 9: Blue pick 2
        // Paso 10: Red pick 1
        // Pasos 11 a 14: 1 baneo cada uno (1, 1, 1, 1)
        // Paso 15: Red pick 1
        // Paso 16: Blue pick 2
        // Paso 17: Red pick 1
        int[] steps = {1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2, 1};

        long ans = 1L;
        long disponibles = n;

        for (int i = 0; i < steps.length; i++) {
            int k = steps[i];

            // Si no hay suficientes campeones disponibles
            if (disponibles < k) {
                ans = 0;
                break;
            }

            // Calculamos C(disponibles, k) % MOD
            long combinations = nCr(disponibles, k);

            // Multiplicamos al resultado acumulado usando aritmética modular
            ans = (ans * combinations) % MOD;

            // Actualizamos la cantidad de campeones restantes
            disponibles -= k;
        }

        System.out.println(ans);
    }

    /**
     * Calcula la combinación C(n, k) % MOD para k = 1 o k = 2.
     */
    private static long nCr(long n, int k) {
        if (k == 1) {
            return n % MOD;
        } else if (k == 2) {
            // C(n, 2) = n * (n - 1) / 2
            // Simplificamos la división entre 2 antes de aplicar el módulo para evitar divisiones con módulo
            long term1 = n;
            long term2 = n - 1;

            if (term1 % 2 == 0) {
                term1 /= 2;
            } else {
                term2 /= 2;
            }

            term1 %= MOD;
            term2 %= MOD;

            return (term1 * term2) % MOD;
        }
        return 1L;
    }
}