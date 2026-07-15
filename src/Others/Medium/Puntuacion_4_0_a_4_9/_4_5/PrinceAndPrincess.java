package Others.Medium.Puntuacion_4_0_a_4_9._4_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.IOException;

/**
 * PROBLEMA: Prince and Princess
 * ============================================================================
 * EXPLICACIÓN DEL PLANTEAMIENTO (LCS a LIS)
 * ============================================================================
 * 1. EL RETO DE LA COMPLEJIDAD:
 * Queremos encontrar la Máxima Subsecuencia Común (LCS) entre la ruta del
 * Príncipe (de tamaño p + 1) y la de la Princesa (de tamaño q + 1).
 * Dado que p, q <= n^2 (donde n <= 250, por lo que n^2 <= 62,500), el algoritmo
 * estándar de programación dinámica para LCS de O(p * q) tomaría alrededor de
 * 3.9 * 10^9 operaciones, causando un Time Limit Exceeded (TLE).
 * * 2. LA PROPIEDAD CLAVE:
 * El enunciado garantiza que todos los elementos dentro de la secuencia del
 * Príncipe son únicos (distintos), y lo mismo para la Princesa.
 * Cuando los elementos de al menos una de las secuencias son únicos, podemos
 * transformar el problema de LCS a LIS (Longest Increasing Subsequence /
 * Máxima Subsecuencia Creciente), el cual se puede resolver en O(M log M).
 * * 3. LA TRANSFORMACIÓN:
 * - Creamos un arreglo de mapeo de posiciones de tamaño (N^2 + 1).
 * Para cada número 'x' de la secuencia del Príncipe, guardamos en qué índice
 * aparece: pos[x] = indice_del_príncipe.
 * - Iteramos por la secuencia de la Princesa. Para cada número 'y':
 * Si existe en el mapa de posiciones (es decir, el Príncipe también lo visitó),
 * reemplazamos 'y' por su índice pos[y] en la secuencia del Príncipe.
 * Si el Príncipe no lo visitó, simplemente lo ignoramos.
 * - Esto nos genera una nueva secuencia de índices B'.
 * * 4. ¿POR QUÉ FUNCIONA?
 * Cualquier elemento común que mantenga el orden original del Príncipe deberá
 * aparecer con índices estrictamente crecientes en la transformación. Por lo tanto,
 * la LCS entre el Príncipe y la Princesa es exactamente igual a la LIS de B'.
 */
public class PrinceAndPrincess {

    // Lector rápido para procesar eficientemente la entrada de datos pesada
    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        String tStr = sc.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr); // Cantidad de casos de prueba

        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            // Las secuencias reales tienen tamaño p + 1 y q + 1 respectivamente
            int princeSize = p + 1;
            int princessSize = q + 1;

            // Arreglo de mapeo: guardará en qué índice (1-basado) del Príncipe aparece cada número.
            // Dado que los números en el tablero van de 1 a N^2, el tamaño máximo es N^2 + 1.
            int[] pos = new int[n * n + 1];

            // Leemos la secuencia del Príncipe y mapeamos cada elemento a su posición
            for (int i = 1; i <= princeSize; i++) {
                int val = sc.nextInt();
                pos[val] = i; // Guardamos el índice (i) asociado al valor (val)
            }

            // Leemos la secuencia de la Princesa y la transformamos directamente.
            // Solo nos quedamos con los elementos que el Príncipe también haya visitado (pos[val] > 0).
            int[] transformed = new int[princessSize];
            int m = 0; // Tamaño de la nueva secuencia transformada
            for (int i = 0; i < princessSize; i++) {
                int val = sc.nextInt();
                if (pos[val] > 0) {
                    transformed[m++] = pos[val];
                }
            }

            // Calculamos la longitud de la LIS (Longest Increasing Subsequence) de la secuencia 'transformed'
            int ans = getLISLength(transformed, m);

            System.out.println("Case " + tc + ": " + ans);
        }
    }

    /**
     * Calcula la longitud de la Máxima Subsecuencia Creciente (LIS) en tiempo O(M log M)
     * utilizando búsqueda binaria sobre un arreglo de "colas" (tails).
     */
    private static int getLISLength(int[] arr, int size) {
        if (size == 0) return 0;

        // tails[i] almacenará el menor valor final de todas las subsecuencias crecientes activas de longitud i + 1
        int[] tails = new int[size];
        int len = 0; // Longitud de la LIS activa

        for (int i = 0; i < size; i++) {
            int x = arr[i];

            // Realizamos una búsqueda binaria para encontrar la posición del primer elemento >= x en 'tails'
            int low = 0;
            int high = len - 1;
            int targetIdx = len; // Por defecto, asumimos que va al final

            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (tails[mid] >= x) {
                    targetIdx = mid;
                    high = mid - 1; // Intentamos buscar uno más pequeño a la izquierda
                } else {
                    low = mid + 1;
                }
            }

            // Reemplazamos o extendemos
            tails[targetIdx] = x;
            if (targetIdx == len) {
                len++; // Incrementamos la longitud de la LIS encontrada si añadimos un nuevo elemento al final
            }
        }

        return len;
    }
}