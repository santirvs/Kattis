package Others.Easy.Puntuacion_1_1_a_1_9._1_7;
import java.util.Scanner;

public class FractionalSequence {

    // Algoritmo de Euclides para simplificar la fracción
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) {
            return;
        }

        long n = sc.nextLong();

        // 1. Encontrar k usando la fórmula cuadrática: ceil((-1 + sqrt(1 + 8N)) / 2)
        // Usamos Math.sqrt en double, lo cual es totalmente seguro para N <= 4e10 (fits within double precision)
        double discriminant = 1.0 + 8.0 * n;
        long k = (long) Math.ceil((-1.0 + Math.sqrt(discriminant)) / 2.0);

        // 2. Elementos acumulados hasta el bloque (k - 1)
        long prevElements = (k - 1) * k / 2;

        // 3. Posición i dentro del bloque k (1-indexed)
        long i = n - prevElements;

        // 4. Determinar la fracción y dar formato
        long numerator = i - 1;
        long denominator = k;

        if (numerator == 0) {
            // Es un número entero exacto
            System.out.println(k);
        } else {
            // Simplificar la fracción
            long g = gcd(numerator, denominator);
            numerator /= g;
            denominator /= g;

            System.out.println(k + " " + numerator + "/" + denominator);
        }

        sc.close();
    }
}