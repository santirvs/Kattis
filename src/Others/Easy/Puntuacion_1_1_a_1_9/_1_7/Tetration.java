package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * No hace falta calcular la serie infinita, sino que
 * basta con calcular su equivalente:  N = a^N
 * y de aquí, deducir que a = N ^ (1/N)
 */

import java.util.Scanner;

public class Tetration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextDouble()) {
            double N = scanner.nextDouble();

            // Calculamos a = N^(1/N)
            double a = Math.pow(N, 1.0 / N);

            // Imprimimos el resultado con la precisión adecuada
            System.out.printf("%.6f\n", a);
        }

        scanner.close();
    }
}