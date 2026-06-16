package Others.Medium.Puntuacion_3_0_a_3_9._3_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PROBLEMA: Zadaca
 * * PLANTEAMIENTO EN COMENTARIOS:
 * 1. El problema consiste en hallar el MCD entre dos números gigantescos, A y B.
 * No se nos dan A y B directamente, sino sus factores descompuestos en dos listas.
 * Calcular A y B explícitamente multiplicando sus elementos causará un desbordamiento de memoria (overflow).
 * * 2. Error Común (Aritmética Modular Incorrecta):
 * No podemos aplicar el operador módulo (%) libremente en cada multiplicación de factores para mantener el número pequeño,
 * ya que matemáticamente: MCD(A, B) % M  !=  MCD(A % M, B % M).
 * El módulo distorsiona los factores comunes reales.
 * * 3. Solución (Cancelación Cruzada):
 * En lugar de multiplicar las listas, comparamos cada elemento individual 'a_i' de la lista A
 * con cada elemento 'b_j' de la lista B.
 * - Calculamos el MCD de la pareja: g = MCD(a_i, b_j) usando el algoritmo de Euclides.
 * - Si g > 1, significa que 'g' es un factor común real que aporta al MCD global de A y B.
 * - Acumulamos este factor en nuestro resultado final: totalGcd = totalGcd * g.
 * - Para evitar contar este factor repetidas veces, "reducimos" los números originales dividiéndolos:
 * a_i = a_i / g  y  b_j = b_j / g.
 * * 4. Control de Desbordamiento y Formateo:
 * El problema exige que si el MCD real supera los 9 dígitos (> 999,999,999), solo imprimamos los últimos 9 dígitos
 * rellenando con ceros a la izquierda si el residuo es menor (ej. 000012028).
 * - Usamos una bandera booleana 'hasOverflow' para detectar si en algún producto el valor superó 10^9.
 * - Al multiplicar por 'g', si el resultado pasa de 999,999,999, activamos la bandera y aplicamos módulo 10^9.
 * - Al final, si 'hasOverflow' es verdadero, usamos String.format("%09d", totalGcd) para forzar los ceros a la izquierda.
 */
public class Zadaca {

    // Constante para el módulo de los últimos 9 dígitos
    private static final long MOD = 1000000000L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // --- LECTURA DE LA LISTA A ---
        String lineN = br.readLine();
        if (lineN == null) return;
        int n = Integer.parseInt(lineN.trim());

        long[] a = new long[n];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(stA.nextToken());
        }

        // --- LECTURA DE LA LISTA B ---
        int m = Integer.parseInt(br.readLine().trim());
        long[] b = new long[m];
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Long.parseLong(stB.nextToken());
        }

        long totalGcd = 1;
        boolean hasOverflow = false;

        // --- PROCESAMIENTO DE CANCELACIÓN CRUZADA ---
        // Comparamos todos los elementos de A contra todos los de B
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Si alguno de los elementos ya se redujo a 1, no tiene caso calcular su MCD
                if (a[i] == 1) break;
                if (b[j] == 1) continue;

                // Calculamos el MCD de la pareja actual
                long g = gcd(a[i], b[j]);

                if (g > 1) {
                    // Multiplicamos el factor común encontrado al MCD global acumulado
                    totalGcd = totalGcd * g;

                    // Controlamos si la multiplicación real superó los 9 dígitos
                    if (totalGcd >= MOD) {
                        hasOverflow = true;
                        totalGcd %= MOD; // Truncamos manteniendo solo los últimos 9 dígitos
                    }

                    // Reducimos ambos elementos eliminando el factor común ya procesado
                    a[i] /= g;
                    b[j] /= g;
                }
            }
        }

        // --- FORMATEO DE SALIDA ---
        if (hasOverflow) {
            // Si hubo overflow, forzamos a que imprima exactamente 9 dígitos rellenando con ceros
            System.out.printf("%09d\n", totalGcd);
        } else {
            // Si el MCD nunca pasó de 9 dígitos, se imprime de forma natural
            System.out.println(totalGcd);
        }
    }

    /**
     * Algoritmo de Euclides para encontrar el Máximo Común Divisor (MCD)
     * de forma iterativa y eficiente en O(log(min(x, y))).
     */
    private static long gcd(long x, long y) {
        while (y > 0) {
            long temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}