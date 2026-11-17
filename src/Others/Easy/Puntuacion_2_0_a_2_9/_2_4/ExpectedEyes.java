package Others.Easy.Puntuacion_2_0_a_2_9._2_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class ExpectedEyes {
    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader + StringTokenizer en lugar de Scanner.
        // En programación competitiva, esto evita cuellos de botella de lectura
        // (Time Limit Exceeded) si el número de dados (n) es muy grande.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Leemos la primera línea que contiene n (cantidad total de dados)
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }
        int n = Integer.parseInt(line.trim());

        // Usamos 'long' (entero de 64 bits) para acumular la suma de las caras.
        // Si n = 10^5 y cada dado tiene 10^9 caras, la suma superaría el límite
        // de un 'int' (~2.14 * 10^9), causando desbordamiento (overflow).
        long sumaCaras = 0;

        // Usamos StringTokenizer para ir extrayendo cada número de caras de forma eficiente
        StringTokenizer st = new StringTokenizer("");

        for (int i = 0; i < n; i++) {
            // Si el tokenizer actual se queda sin elementos (por ejemplo, si los datos
            // vienen repartidos en varias líneas), leemos la siguiente línea.
            while (!st.hasMoreTokens()) {
                String nextLine = br.readLine();
                if (nextLine == null) {
                    break;
                }
                st = new StringTokenizer(nextLine);
            }

            // Leemos el número de caras (a_i) del dado actual y lo acumulamos
            long carasDado = Long.parseLong(st.nextToken());
            sumaCaras += carasDado;
        }

        /*
         * PLANTEAMIENTO MATEMÁTICO:
         * 1. El valor esperado de un dado justo de k caras es: (k + 1) / 2.
         * 2. Por la linealidad de la esperanza, el valor esperado de lanzar todos los dados
         *    es la suma de sus esperanzas individuales:
         *
         *    E_total = (a_1 + 1)/2 + (a_2 + 1)/2 + ... + (a_n + 1)/2
         *
         * 3. Factorizando el denominador común (2) y agrupando los '1's (hay n unos):
         *
         *    E_total = (sumaCaras + n) / 2.0
         *
         * Hacer una única división en punto flotante al final es más rápido y evita
         * acumular errores de redondeo en cada iteración.
         */
        double valorEsperado = (sumaCaras + n) / 2.0;

        // Imprimimos el resultado forzando Locale.US para asegurar que el separador
        // decimal sea siempre un punto ('.') y no una coma (','), sin importar la
        // configuración regional del servidor donde se evalúe el código.
        System.out.printf(Locale.US, "%.6f%n", valorEsperado);
    }
}