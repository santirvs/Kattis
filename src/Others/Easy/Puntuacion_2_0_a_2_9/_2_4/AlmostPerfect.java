package Others.Easy.Puntuacion_2_0_a_2_9._2_4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class AlmostPerfect {
    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader para una lectura rápida y eficiente de la entrada estándar (EOF)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // Leemos línea por línea hasta llegar al final del archivo (EOF)
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            // StringTokenizer permite procesar múltiples números en una misma línea si los hubiera
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                long n = Long.parseLong(st.nextToken());

                // Calculamos la suma de los divisores propios de n
                long sum = getProperDivisorsSum(n);

                // Evaluamos las condiciones del problema
                if (sum == n) {
                    System.out.println(n + " perfect");
                } else if (Math.abs(sum - n) <= 2) {
                    // "almost perfect" si la diferencia es de a lo sumo 2, pero no es perfecto
                    System.out.println(n + " almost perfect");
                } else {
                    System.out.println(n + " not perfect");
                }
            }
        }
    }

    /**
     * Método para calcular la suma de los divisores propios de un número en O(sqrt(N)).
     * Un divisor propio es aquel menor que n que lo divide exactamente.
     */
    private static long getProperDivisorsSum(long n) {
        if (n <= 1) return 0; // El número 1 no tiene divisores propios

        long sum = 1; // 1 siempre es un divisor propio para cualquier n > 1
        long limit = (long) Math.sqrt(n);

        for (long i = 2; i <= limit; i++) {
            if (n % i == 0) {
                sum += i;
                long other = n / i;
                // Evitamos sumar el mismo número dos veces si n es un cuadrado perfecto (ej. i == other)
                if (other != i) {
                    sum += other;
                }
            }
        }
        return sum;
    }
}