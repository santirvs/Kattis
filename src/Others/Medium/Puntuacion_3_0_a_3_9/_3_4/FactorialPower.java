package Others.Medium.Puntuacion_3_0_a_3_9._3_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PROBLEMA: Factorial Power
 * * PLANTEAMIENTO MATEMÁTICO Y ALGORÍTMICO:
 * * 1. Descomposición en Factores Primos:
 * Cualquier número entero A (> 1) puede expresarse como el producto de sus
 * factores primos: A = (p1^k1) * (p2^k2) * ... * (pm^km).
 * Para que (A^N) divida a B!, cada factor primo 'p' de A debe aparecer en la
 * descomposición de B! con un exponente al menos igual a (k * N).
 * * 2. Teorema de Legendre:
 * No podemos calcular B! directamente porque crece de forma exponencial. El teorema
 * de Legendre nos permite calcular cuántas veces un número primo 'p' divide a B!
 * (denotado como Ep(B!)) mediante la fórmula:
 * Ep(B!) = floor(B/p) + floor(B/p^2) + floor(B/p^3) + ...
 * Esta suma se detiene cuando p^i > B.
 * * 3. El Cuello de Botella (Restricción de N):
 * Para cada factor primo 'p' con exponente 'k' en A, la máxima potencia N que
 * este primo permite individualmente se calcula como: N_p = floor(Ep(B!) / k).
 * Dado que A^N requiere que TODOS sus factores primos estén cubiertos por B!,
 * el valor global de N estará limitado por el primo más restrictivo (el mínimo).
 * N = min( N_p1, N_p2, ..., N_pm )
 * * 4. Optimización de Tiempo:
 * Buscamos los factores primos de A iterando desde 2 hasta sqrt(A). Si después de
 * esta iteración el valor remanente de A es mayor a 1, significa que dicho valor
 * restante es un número primo grande (mayor a sqrt(A)) con exponente k = 1.
 */
public class FactorialPower {
    public static void main(String[] args) throws Exception {
        // Usamos BufferedReader y StringTokenizer para una lectura rápida y eficiente de datos (estándar en Jueces Línea)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // Inicializamos maxN con el valor máximo posible, ya que buscaremos el factor más restrictivo (mínimo)
        long maxN = Long.MAX_VALUE;
        long tempA = a;

        // PASO 1: Factorizar 'a' buscando sus divisores primos hasta sqrt(a).
        // Esto optimiza el tiempo de ejecución a O(sqrt(A)), ideal para valores de hasta 10^18.
        for (long i = 2; i * i <= tempA; i++) {
            if (tempA % i == 0) {
                long k = 0; // Exponente 'k' del primo 'i' en la descomposición de 'a'

                // Reducimos 'tempA' de manera sucesiva para contar cuántas veces contiene al primo 'i'
                while (tempA % i == 0) {
                    k++;
                    tempA /= i;
                }

                // PASO 2: Aplicamos el Teorema de Legendre.
                // Calculamos cuántas veces en total el número primo 'i' está presente en B!
                long ep = getLegendre(b, i);

                // PASO 3: Calculamos cuántas veces podemos satisfacer la demanda de este primo en A^N.
                // Es decir, dividimos la disponibilidad en B! (ep) entre lo requerido por cada unidad de A (k).
                long currentN = ep / k;

                // El N final está limitado por el primo que produzca el menor valor (el cuello de botella)
                maxN = Math.min(maxN, currentN);
            }
        }

        // CASO ESPECIAL: Si al finalizar el bucle tempA es mayor a 1, significa que el valor restante
        // es un número primo grande que originalmente era mayor que la raíz cuadrada de A.
        // Su exponente 'k' en este caso es igual a 1.
        if (tempA > 1) {
            long ep = getLegendre(b, tempA);
            long currentN = ep / 1; // k = 1
            maxN = Math.min(maxN, currentN);
        }

        // Imprimimos el entero N que representa la mayor potencia para la cual A^N divide a B!
        System.out.println(maxN);
    }

    /**
     * Implementación del Teorema de Legendre.
     * Calcula la máxima potencia del primo 'p' que divide a 'b!' de forma eficiente en O(log_p B).
     * Va dividiendo sucesivamente 'b' entre 'p' y acumulando los cocientes enteros.
     */
    private static long getLegendre(long b, long p) {
        long count = 0;
        long tempB = b;

        while (tempB > 0) {
            count += tempB / p; // Suma floor(B / p^i)
            tempB /= p;         // Prepara la base para la siguiente potencia p^(i+1)
        }

        return count;
    }
}