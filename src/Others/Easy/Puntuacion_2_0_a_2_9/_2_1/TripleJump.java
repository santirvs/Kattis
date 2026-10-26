package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TripleJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        int[] observations = new int[n];

        for (int i = 0; i < n; i++) {
            observations[i] = scanner.nextInt();
        }
        scanner.close();

        /*
         * PASO 1: Deducir los valores extremos (a y c)
         * El primer elemento sigue siendo 3*a y el último 3*c,
         * sin importar si faltan algunas observaciones intermedias.
         */
        int a = observations[0] / 3;
        int c = observations[n - 1] / 3;

        /*
         * PASO 2: Búsqueda del valor intermedio (b)
         */
        for (int b = a + 1; b < c; b++) {

            // Usamos un Set para almacenar las sumas únicas generadas con la terna {a, b, c}
            Set<Integer> generatedSums = new HashSet<Integer>();

            generatedSums.add(3 * a);         // a + a + a
            generatedSums.add(2 * a + b);     // a + a + b
            generatedSums.add(2 * a + c);     // a + a + c
            generatedSums.add(a + 2 * b);     // a + b + b
            generatedSums.add(a + b + c);     // a + b + c
            generatedSums.add(a + 2 * c);     // a + c + c
            generatedSums.add(3 * b);         // b + b + b
            generatedSums.add(2 * b + c);     // b + b + c
            generatedSums.add(b + 2 * c);     // b + c + c
            generatedSums.add(3 * c);         // c + c + c

            // PASO 3: Validar si todas las observaciones de entrada están cubiertas
            boolean match = true;
            for (int i = 0; i < n; i++) {
                if (!generatedSums.contains(observations[i])) {
                    match = false;
                    break;
                }
            }

            // Si el conjunto generado contiene a todas las observaciones leídas, hemos encontrado la terna
            if (match) {
                System.out.println(a + " " + b + " " + c);
                return;
            }
        }
    }
}