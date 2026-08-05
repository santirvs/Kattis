package Others.Easy.Puntuacion_2_0_a_2_9._2_4;



// En cada ronda eliminamos la mitad de los pétalos si es par o la mitad -1 si es impar
// La primera ronda empieza con Sí.
// La siguiente ronda empieza con Sí (si la anterior es par) o con No (si la anterior es impar)
// Con el volumen de petalos (10^18) no podemos implementar una solución basada en una estructura de datos
// tipo Array o Set
// Es una variante del problema de Josefo con eliminación de los miembros


import java.io.IOException;
import java.util.Scanner;

public class EgElksaHann {

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);

        // Lectura de n (número inicial de pétalos)
        long n = sc.nextLong();

        // Cálculo del pétalo superviviente
        long resultado = resolverJosefo(n);

        // Impresión de la respuesta
        System.out.println(resultado);

    }

    /**
     * Resuelve el problema de Josefo para k = 2.
     *
     * PLANTEAMIENTO Y FUNDAMENTO MATEMÁTICO:
     * -------------------------------------------------------------------------
     * 1. El ciclo elimina pétalos alternados (el 2º, 4º, 6º, etc.).
     *
     * 2. Si el número de pétalos 'n' fuera exactamente una potencia de 2 (n = 2^a),
     *    tras la primera vuelta completa de eliminaciones el problema se reduce
     *    a la mitad de elementos exactos, manteniendo siempre al pétalo 1 como el
     *    iniciador de cada sub-ronda. Por tanto, si n es potencia de 2, el pétalo
     *    ganador siempre es el 1.
     *
     * 3. Para cualquier 'n' general, podemos expresar n como:
     *        n = 2^a + l
     *    donde:
     *    - 2^a es la mayor potencia de 2 menor o igual a n.
     *    - l es el residuo (l = n - 2^a), representando cuántos pétalos "sobran"
     *      respecto a la potencia de 2 anterior.
     *
     * 4. Al eliminar los primeros 'l' pétalos (lo que elimina l pétalos pares),
     *    el círculo se reduce a exactamente 2^a pétalos. En ese preciso instante,
     *    el pétalo que le toca jugar actúa como el "nuevo pétalo 1".
     *
     * 5. Dado que cada eliminación avanza 2 posiciones en la numeración original,
     *    la posición original del elemento que toma el turno tras 'l' eliminaciones es:
     *        J(n) = 2*l + 1
     *
     * @param n Número inicial de pétalos.
     * @return El número de pétalo que queda al final.
     */
    public static long resolverJosefo(long n) {
        // Caso base
        if (n <= 1) {
            return 1;
        }

        /*
         * PASO 1: Obtener la mayor potencia de 2 menor o igual a n (2^a).
         *
         * En Java 1.7, Long.highestOneBit(n) devuelve un valor de tipo long
         * que tiene únicamente el bit más significativo activo de 'n'.
         * Ejemplo: para n = 10 (binario 1010), highestOneBit devuelve 8 (binario 1000).
         */
        long mayorPotenciaDeDos = Long.highestOneBit(n);

        /*
         * PASO 2: Calcular el remanente 'l'.
         *
         * 'l' indica cuántas eliminaciones deben ocurrir antes de que el
         * tamaño restante del círculo sea una potencia de 2 limpia.
         * Ejemplo: para n = 10 -> l = 10 - 8 = 2.
         */
        long l = n - mayorPotenciaDeDos;

        /*
         * PASO 3: Aplicar la fórmula del superviviente J(n) = 2*l + 1.
         *
         * Ejemplo: para n = 10 -> 2*(2) + 1 = 5.
         */
        return 2 * l + 1;
    }
}