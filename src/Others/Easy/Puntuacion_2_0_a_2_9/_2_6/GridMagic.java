package Others.Easy.Puntuacion_2_0_a_2_9._2_6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Planteamiento de "Grid Magic":
 *
 * Queremos contar cuántas cuadrículas de tamaño N x M con dígitos del 0 al 9
 * cumplen que TODOS los prefijos no vacíos de cada fila (leídos de izquierda a derecha)
 * y TODOS los prefijos no vacíos de cada columna (leídos de arriba abajo) sean números primos.
 *
 * Idea principal:
 * - Al recorrer la cuadrícula fila por fila (de izquierda a derecha, y de arriba abajo),
 *   cuando estamos en la celda (r, c):
 *     * La fila 'r' ya tiene formado el prefijo hasta la columna 'c - 1' (guardado en rowPrefix[r]).
 *     * La columna 'c' ya tiene formado el prefijo hasta la fila 'r - 1' (guardado en colPrefix[c]).
 * - Si colocamos un dígito 'd' (0..9) en (r, c):
 *     * El nuevo prefijo de la fila 'r' pasa a ser: rowPrefix[r] * 10 + d.
 *     * El nuevo prefijo de la columna 'c' pasa a ser: colPrefix[c] * 10 + d.
 * - Como todo prefijo debe ser primo, si alguno de estos dos nuevos números NO es primo,
 *   podemos podar (descartar) toda la rama inmediatamente sin seguir llenando casillas.
 * - Solo cuando logramos completar todas las filas (r == n), significa que todas las filas
 *   y columnas tienen todos sus prefijos primos, así que sumamos 1 a la respuesta.
 */
public class GridMagic {

    private static int n;          // Número de filas de la cuadrícula
    private static int m;          // Número de columnas de la cuadrícula
    private static long[] rowPrefix; // Prefijo numérico acumulado en cada fila (0..n-1)
    private static long[] colPrefix; // Prefijo numérico acumulado en cada columna (0..m-1)
    private static long ans;       // Contador total de cuadrículas superprimas válidas

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = readNextNonEmptyLine(br);
        if (line == null) {
            return;
        }

        // Lectura de las dimensiones N y M desde la entrada estándar
        StringTokenizer st = new StringTokenizer(line);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // Inicialmente, ningún prefijo tiene dígitos (valor 0)
        rowPrefix = new long[n];
        colPrefix = new long[m];
        ans = 0L;

        // Iniciamos la búsqueda con vuelta atrás (backtracking) en la esquina superior izquierda (0, 0)
        dfs(0, 0);

        // Imprimimos el número total de cuadrículas válidas
        System.out.println(ans);
    }

    /**
     * Lee la siguiente línea no vacía de la entrada para evitar problemas
     * con líneas en blanco o espacios extra en los casos de prueba.
     */
    private static String readNextNonEmptyLine(BufferedReader br) throws IOException {
        String s;
        while ((s = br.readLine()) != null) {
            if (s.trim().length() > 0) {
                return s;
            }
        }
        return null;
    }

    /**
     * Búsqueda exhaustiva con poda (backtracking) sobre la cuadrícula N x M.
     *
     * @param r fila actual (0 <= r <= n)
     * @param c columna actual (0 <= c < m)
     */
    private static void dfs(int r, int c) {
        // Caso base: si r == n, hemos completado todas las filas (0..n-1)
        // y cada columna (0..m-1) también ha pasado la prueba de primalidad en cada paso.
        if (r == n) {
            ans++;
            return;
        }

        // Calculamos la siguiente celda en orden de lectura (fila por fila, izquierda a derecha)
        int nextR = (c + 1 == m) ? r + 1 : r;
        int nextC = (c + 1 == m) ? 0 : c + 1;

        // Guardamos los prefijos anteriores para restaurarlos al retroceder (backtrack)
        long prevRow = rowPrefix[r];
        long prevCol = colPrefix[c];

        // Probamos todos los dígitos posibles (0 al 9) en la celda (r, c)
        for (int d = 0; d <= 9; d++) {
            // Concatenamos el dígito 'd' al final del prefijo actual de la fila y de la columna.
            // Usamos 'long' para reducir el riesgo de desbordamiento en cuadrículas más grandes.
            long newRowVal = prevRow * 10L + d;
            long newColVal = prevCol * 10L + d;

            // Poda: ambos prefijos resultantes deben ser números primos.
            // Por ejemplo, al inicio (prev = 0), solo d in {2, 3, 5, 7} pasarán esta condición.
            if (isPrime(newRowVal) && isPrime(newColVal)) {
                rowPrefix[r] = newRowVal;
                colPrefix[c] = newColVal;

                // Avanzamos a la siguiente celda
                dfs(nextR, nextC);

                // Restauramos el estado previo antes de probar el siguiente dígito 'd'
                rowPrefix[r] = prevRow;
                colPrefix[c] = prevCol;
            }
        }
    }

    /**
     * Comprueba si un número entero no negativo es primo mediante división por trial division
     * optimizada (descartando múltiplos de 2 y 3, y probando divisores de la forma 6k ± 1
     * hasta la raíz cuadrada de 'num').
     *
     * @param num número a evaluar
     * @return true si 'num' es primo, false en caso contrario
     */
    private static boolean isPrime(long num) {
        if (num < 2L) {
            return false;
        }
        if (num == 2L || num == 3L) {
            return true;
        }
        if (num % 2L == 0L || num % 3L == 0L) {
            return false;
        }

        // Todos los primos mayores que 3 son de la forma 6k - 1 o 6k + 1
        for (long i = 5L; i * i <= num; i += 6L) {
            if (num % i == 0L || num % (i + 2L) == 0L) {
                return false;
            }
        }
        return true;
    }
}