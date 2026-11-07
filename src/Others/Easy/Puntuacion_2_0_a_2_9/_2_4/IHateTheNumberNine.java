package Others.Easy.Puntuacion_2_0_a_2_9._2_4;


import java.util.Scanner;

public class IHateTheNumberNine {

    private static final long MOD = 1000000007L;

    // Función para calcular (base^exp) % MOD en O(log exp)
    private static long power(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            // Si exp es impar, multiplicamos base con el resultado
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            // exp debe ser par ahora, elevamos al cuadrado la base
            base = (base * base) % MOD;
            exp >>= 1; // Equivale a exp /= 2
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();

        while (numCasos-- > 0) {
            long d = scan.nextLong();

            // Fórmula: 8 * (9^(d - 1)) % MOD
            long ans = (8 * power(9, d - 1)) % MOD;

            System.out.println(ans);
        }

        scan.close();
    }
}