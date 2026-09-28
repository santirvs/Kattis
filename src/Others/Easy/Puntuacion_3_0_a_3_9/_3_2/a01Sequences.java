package Others.Easy.Puntuacion_3_0_a_3_9._3_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Solución para el problema "0-1 Sequences".
 *
 * PLANTEAMIENTO DETALLADO:
 * 1. El problema pide calcular la suma del número de inversiones de todas las
 *    2^C secuencias posibles (donde C es el número total de caracteres '?').
 *
 * 2. Enfoque por pares (Linealidad de la esperanza/suma):
 *    - Una inversión ocurre cada vez que un '1' aparece antes que un '0' (es decir,
 *      un par de índices i < j tales que S[i] = '1' y S[j] = '0').
 *    - En lugar de generar todas las cadenas (exponencial), podemos recorrer la cadena
 *      una sola vez y calcular, para cada posición j que actúa como '0', cuántos '1'
 *      (o '?' que se conviertan en '1') tiene a su izquierda.
 *
 * 3. Manejo de Comodines ('?'):
 *    - Si tenemos totalQ comodines en total en la cadena:
 *      * Si un '1' fijo precede a un '0', hay 2^(totalQ) formas de rellenar el resto.
 *      * Si un '?' precede a un '0', ese '?' debe elegirse como '1' (1 opción) y
 *        quedan totalQ - 1 comodines libres -> 2^(totalQ - 1) formas.
 *      * Si el propio elemento actual es un '?', este actúa como '0' y gasta 1 comodín,
 *        por lo que las potencias de 2 disminuyen en 1 grado adicional.
 *
 * 4. Complejidad:
 *    - Tiempo: O(N), ya que precalculamos las potencias de 2 y recorremos la cadena una sola vez.
 *    - Espacio: O(N) para el almacenamiento de potencias de 2.
 */
public class a01Sequences {
    private static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (s == null) {
            return;
        }

        int n = s.length();

        // 1. Contar el número total de comodines '?' en toda la cadena
        long totalQ = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                totalQ++;
            }
        }

        // 2. Precalcular las potencias de 2 módulo 10^9 + 7 para acceso en O(1)
        long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        long totalInversions = 0;
        long count1 = 0; // Acumulador de '1's fijos vistos a la izquierda
        long countQ = 0; // Acumulador de '?' vistos a la izquierda

        // 3. Recorrer la cadena acumulando contribuciones
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '0') {
                // El carácter actual es '0' y actúa como el extremo derecho de las inversiones.
                // Contribución de los '1' previos: count1 * 2^(totalQ)
                // Contribución de los '?' previos: countQ * 2^(totalQ - 1)
                long ways1 = (totalQ >= 0) ? pow2[(int)totalQ] : 0;
                long waysQ = (totalQ >= 1) ? pow2[(int)totalQ - 1] : 0;

                long currentInv = (count1 * ways1 + countQ * waysQ) % MOD;
                totalInversions = (totalInversions + currentInv) % MOD;

            } else if (c == '1') {
                // Registramos el '1' para que pueda formar inversiones con futuros '0' o '?'
                count1++;

            } else if (c == '?') {
                // El carácter actual es '?' y puede actuar como '0' (derecha).
                // Al fijar este '?' como '0', gastamos 1 comodín en esta posición.
                long ways1 = (totalQ >= 1) ? pow2[(int)totalQ - 1] : 0;
                long waysQ = (totalQ >= 2) ? pow2[(int)totalQ - 2] : 0;

                long currentInv = (count1 * ways1 + countQ * waysQ) % MOD;
                totalInversions = (totalInversions + currentInv) % MOD;

                // Después de evaluarlo como derecho, este '?' pasa a formar parte
                // del historial izquierdo para los elementos posteriores.
                countQ++;
            }
        }

        // Imprimir el resultado final módulo 10^9 + 7
        System.out.println(totalInversions);
    }
}