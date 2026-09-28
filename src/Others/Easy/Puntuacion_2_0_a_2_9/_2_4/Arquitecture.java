package Others.Easy.Puntuacion_2_0_a_2_9._2_4;
import java.util.Scanner;

/**
 * Solución para el problema "Architecture".
 *
 * PLANTEAMIENTO DETALLADO:
 * 1. El problema busca determinar si es posible construir una rejilla de edificios
 *    tal que los máximos por fila (skyline este) y los máximos por columna (skyline norte)
 *    coincidan con los datos de entrada.
 *
 * 2. Condición lógica clave:
 *    - El edificio más alto de toda la ciudad debe encontrarse tanto en el skyline este
 *      (como el máximo de alguna fila) como en el skyline norte (como el máximo de alguna columna).
 *    - Por lo tanto, el valor máximo absoluto del array este debe ser exactamente
 *      igual al valor máximo absoluto del array norte.
 *
 * 3. Suficiencia:
 *    - Si max(Este) == max(Norte), siempre es posible construir una solución válida
 *      asignando a cada celda (i, j) la altura: min(Este[i], Norte[j]).
 *    - Si los máximos globales difieren, es matemáticamente imposible que las intersecciones
 *      alcancen la altura requerida en ambas direcciones, por lo que la respuesta es "impossible".
 *
 * 4. Complejidad:
 *    - Tiempo: O(R + C), ya que solo recorremos los arrays de entrada una vez para hallar los máximos.
 *    - Espacio: O(1) adicional, procesando los valores al vuelo sin necesidad de almacenar matrices.
 */
public class Arquitecture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Validar si existe entrada disponible
        if (!scanner.hasNextInt()) {
            return;
        }

        int r = scanner.nextInt(); // Número de filas (dimensión del skyline este)
        int c = scanner.nextInt(); // Número de columnas (dimensión del skyline norte)

        // Leer el skyline del este y encontrar su valor máximo
        int maxE = 0;
        for (int i = 0; i < r; i++) {
            int height = scanner.nextInt();
            if (height > maxE) {
                maxE = height;
            }
        }

        // Leer el skyline del norte y encontrar su valor máximo
        int maxN = 0;
        for (int j = 0; j < c; j++) {
            int height = scanner.nextInt();
            if (height > maxN) {
                maxN = height;
            }
        }

        // Comprobar la condición necesaria y suficiente
        if (maxE == maxN) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }

        scanner.close();
    }
}