package Others.Medium.Puntuacion_5_0_a_5_9._5_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class WordClock {

    // Constante para representar estados imposibles o no alcanzados (infinito lógico)
    static final int INF = 30000;
    // Factor de desplazamiento (shift) para empaquetar filas y columnas en un solo entero.
    // Esto permite almacenar simultáneamente: (filasUtilizadas * 32 + columnasOcupadasEnUltimaFila).
    static final int SHIFT = 32;

    static int h, w, n;
    static String[] words;
    static int[] len;
    static int[][] add; // add[i][j] almacena los caracteres netos que aporta colocar j tras i

    static int states;
    static short[] dp;
    static byte[] parent;

    /**
     * Mapea un estado único de la DP (combinando la máscara de palabras y la última palabra usada)
     * a un índice lineal dentro del arreglo unidimensional de estados.
     */
    static int index(int mask, int last) {
        return mask * n + last;
    }

    /**
     * Calcula el solapamiento máximo entre el sufijo de la palabra 'a' y el prefijo de la palabra 'b'.
     * Permite aprovechar cuando dos palabras pueden compartir letras consecutivas.
     */
    static int overlap(String a, String b) {
        int max = Math.min(a.length(), b.length());

        for (int k = max; k > 0; k--) {
            boolean ok = true;

            for (int j = 0; j < k; j++) {
                if (a.charAt(a.length() - k + j) != b.charAt(j)) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                return k;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String line = br.readLine();
        if (line == null) {
            return;
        }

        StringTokenizer st = new StringTokenizer(line);

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        List<String> input = new ArrayList<String>();

        while (input.size() < n) {
            line = br.readLine();
            if (line == null) {
                break;
            }

            st = new StringTokenizer(line);

            while (st.hasMoreTokens()) {
                input.add(st.nextToken());
            }
        }

        // Validación inicial: Si alguna palabra individual supera la anchura de la cuadrícula, es imposible.
        for (int i = 0; i < n; i++) {
            if (input.get(i).length() > w) {
                System.out.println("impossible");
                return;
            }
        }

        // Preprocesamiento: Eliminar palabras que están completamente contenidas dentro de otras.
        List<String> useful = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            String a = input.get(i);
            boolean contained = false;

            for (int j = 0; j < n; j++) {
                if (i != j && input.get(j).contains(a)) {
                    contained = true;
                    break;
                }
            }

            if (!contained) {
                useful.add(a);
            }
        }

        words = useful.toArray(new String[useful.size()]);
        n = words.length;

        len = new int[n];

        for (int i = 0; i < n; i++) {
            len[i] = words[i].length();
        }

        // Precalcular la matriz de transiciones:
        // add[i][j] = número de letras nuevas que hay que añadir al colocar j después de i (considerando solapamiento).
        add = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                add[i][j] = len[j] - overlap(words[i], words[j]);
            }
        }

        // El número total de máscaras de bits es 2^n (subconjuntos de palabras colocadas)
        states = 1 << n;

        // dp[index] almacena el valor codificado (filas y columnas) para alcanzar un estado óptimo
        dp = new short[states * n];
        parent = new byte[states * n]; // Permite reconstruir el camino óptimo hacia atrás

        for (int i = 0; i < dp.length; i++) {
            dp[i] = (short) INF;
            parent[i] = -1;
        }

        // Casos base: Iniciar la DP colocando cada palabra individualmente como punto de partida.
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            // Estado inicial: 0 filas completas ocupadas, y una longitud inicial igual a len[i] en la columna actual
            dp[index(mask, i)] = (short) len[i];
        }

        // Programación Dinámica Iterativa sobre Subconjuntos (Bitmask DP)
        for (int mask = 1; mask < states; mask++) {

            for (int last = 0; last < n; last++) {

                // Si la última palabra no forma parte de la máscara actual, ignorar
                if ((mask & (1 << last)) == 0) {
                    continue;
                }

                int stateIndex = index(mask, last);
                int value = dp[stateIndex];

                if (value == INF) {
                    continue;
                }

                // Desempaquetar el estado actual usando el factor SHIFT
                int rows = value / SHIFT;
                int col = value % SHIFT;

                // Intentar añadir una nueva palabra 'next' que aún no esté en la máscara
                for (int next = 0; next < n; next++) {

                    if ((mask & (1 << next)) != 0) {
                        continue;
                    }

                    int extra = add[last][next];
                    int newRows = rows;
                    int newCol;

                    // Verificar si la palabra cabe en el espacio restante de la fila actual o si debe saltar a la siguiente.
                    if (col + extra > w) {
                        newRows++;
                        newCol = len[next];
                    } else {
                        newCol = col + extra;
                    }

                    // Poda: Si el número de filas requeridas supera o iguala la altura h, se descarta.
                    if (newRows >= h) {
                        continue;
                    }

                    // Empaquetar el nuevo valor de filas y columnas
                    int newValue = newRows * SHIFT + newCol;
                    int newMask = mask | (1 << next);
                    int newIndex = index(newMask, next);

                    // Si encontramos una forma más eficiente (con menos filas/columnas gastadas), actualizamos la DP
                    if (newValue < dp[newIndex]) {
                        dp[newIndex] = (short) newValue;
                        parent[newIndex] = (byte) last;
                    }
                }
            }
        }

        // Buscar el estado final donde todas las palabras han sido colocadas (fullMask)
        int fullMask = (states - 1);
        int last = -1;

        for (int i = 0; i < n; i++) {
            if (dp[index(fullMask, i)] != INF) {
                last = i;
                break;
            }
        }

        if (last == -1) {
            System.out.println("impossible");
            return;
        }

        // Reconstrucción del orden óptimo de las palabras usando los punteros 'parent'
        int[] order = new int[n];
        int mask = fullMask;

        for (int p = n - 1; p >= 0; p--) {
            order[p] = last;

            int previous = parent[index(mask, last)];
            mask ^= (1 << last);

            if (p > 0) {
                last = previous;
            }
        }

        // Construcción física de la cuadrícula de caracteres
        char[][] grid = new char[h][w];

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                grid[r][c] = 'A'; // Rellenar celdas sobrantes con 'A' por defecto
            }
        }

        int row = 0;
        int col = 0;

        String first = words[order[0]];

        for (int j = 0; j < first.length(); j++) {
            grid[row][j] = first.charAt(j);
        }

        col = first.length();

        // Pintar el resto de las palabras en la matriz respetando saltos de línea y solapamientos
        for (int p = 1; p < n; p++) {

            int previous = order[p - 1];
            int current = order[p];

            String word = words[current];
            int extra = add[previous][current];

            if (col + extra > w) {
                // Salto de línea: La palabra comienza en la fila siguiente desde la columna 0.
                row++;
                col = 0;

                for (int j = 0; j < word.length(); j++) {
                    grid[row][j] = word.charAt(j);
                }

                col = word.length();

            } else {
                // Solapamiento horizontal: Escribir solamente la parte nueva que no se solapa.
                int ov = len[current] - extra;

                for (int j = ov; j < len[current]; j++) {
                    grid[row][col + j - ov] = word.charAt(j);
                }

                col += extra;
            }
        }

        // Generar la salida estándar en formato de texto
        StringBuilder out = new StringBuilder();

        for (int r = 0; r < h; r++) {
            out.append(grid[r]).append('\n');
        }

        System.out.print(out.toString());
    }
}