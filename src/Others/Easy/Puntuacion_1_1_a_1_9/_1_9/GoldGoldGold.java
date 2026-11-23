package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoldGoldGold {

    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader + StringTokenizer para lectura rápida en Java 7
        // (importante si hay muchos casos de prueba).
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int t = Integer.parseInt(line.trim());
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // Leemos como long para evitar desbordamientos en restas/multiplicaciones
            // si los denominadores b o d son grandes (por ejemplo, hasta 10^9).
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());

            /*
             * PLANTEAMIENTO MATEMÁTICO:
             * 1. Probabilidad de obtener dorado en 1 caja: p = a / b.
             *    Probabilidad de NO obtener dorado en 1 caja: q = 1 - (a / b) = (b - a) / b.
             *
             * 2. Al abrir n cajas independientes, la probabilidad de NO obtener ningún dorado
             *    en ninguna de las n cajas es:
             *        P(0 dorados en n cajas) = ((b - a) / b)^n
             *
             * 3. Por suceso complementario, la probabilidad de obtener AL MENOS 1 dorado es:
             *        P(>= 1 dorado en n cajas) = 1 - ((b - a) / b)^n
             *
             * 4. Queremos que esta probabilidad sea al menos c / d:
             *        1 - ((b - a) / b)^n >= c / d
             *        ((b - a) / b)^n <= 1 - (c / d)
             *        ((b - a) / b)^n <= (d - c) / d
             *
             * 5. Aplicamos logaritmo natural (ln) a ambos lados:
             *        n * ln((b - a) / b) <= ln((d - c) / d)
             *
             *    Como 0 < (b - a) / b < 1, su logaritmo es NEGATIVO.
             *    Al dividir por un número negativo, se invierte la desigualdad:
             *        n >= ln((d - c) / d) / ln((b - a) / b)
             *
             *    El menor entero que cumple esto es la función techo (Math.ceil).
             */

            // Calculamos ln((d - c) / d) y ln((b - a) / b) usando propiedades de logaritmos
            // o directamente sobre el cociente en double.
            double probFalloCaja = (double) (b - a) / (double) b;
            double probFalloObjetivo = (double) (d - c) / (double) d;

            double nReal = Math.log(probFalloObjetivo) / Math.log(probFalloCaja);

            /*
             * CONTROL DE PRECISIÓN EN COMA FLOTANTE:
             * Si el resultado exacto de nReal es un entero (ej. 1.0 en "1 2 1 2"),
             * una mínima imprecisión en los logaritmos podría dar 1.0000000000000002,
             * y Math.ceil() devolvería 2 en lugar de 1.
             *
             * Restamos un epsilon muy pequeño (1e-12) antes de aplicar Math.ceil,
             * y después verificamos directamente con Math.pow que se cumple la desigualdad
             * original ((b - a)/b)^n <= (d - c)/d para garantizar exactitud total.
             */
            long n = (long) Math.ceil(nReal - 1e-12);
            if (n < 1) {
                n = 1;
            }

            // Ajuste fino de seguridad:
            // Si por restar epsilon nos quedamos cortos, incrementamos n.
            while (Math.pow(probFalloCaja, n) > probFalloObjetivo) {
                n++;
            }
            // Si n - 1 ya cumplía la desigualdad, decrementamos n.
            while (n > 1 && Math.pow(probFalloCaja, n - 1) <= probFalloObjetivo) {
                n--;
            }

            out.append(n).append('\n');
        }

        // Imprimimos todas las respuestas de una sola vez
        System.out.print(out.toString());
    }
}