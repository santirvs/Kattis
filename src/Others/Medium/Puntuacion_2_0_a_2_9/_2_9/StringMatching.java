package Others.Medium.Puntuacion_2_0_a_2_9._2_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
import java.util.StringTokenizer;

public class StringMatching {

    /**
     * Clase auxiliar para lectura rápida de datos (Fast I/O).
     * En programación competitiva, BufferedReader y StringTokenizer evitan
     * el cuello de botella de Scanner al leer entradas grandes de la consola.
     */
    static class FR {
        BufferedReader br;
        StringTokenizer st;

        public FR() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            try {
                if (st != null && st.hasMoreElements()) {
                    return st.nextToken("\n");
                }
                return br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * PLANTEAMIENTO DEL PRE-CÁLCULO (Tabla LPS - Longest Prefix Suffix):
     * -----------------------------------------------------------------
     * El corazón de KMP es evitar retroceder innecesariamente en el texto principal
     * cuando ocurre un desajuste (mismatch). Para lograrlo, precalculamos una tabla
     * llamada LPS (o función de falla).
     *
     * ¿Qué almacena lps[i]?
     * Almacena la longitud del prefijo propio más largo del patrón que es también
     * sufijo del subpatrón que termina en el índice i.
     *
     * ¿Para qué sirve?
     * Cuando hay un error de coincidencia en el patrón, en lugar de reiniciar la
     * búsqueda desde cero en el texto, la tabla nos dice exactamente cuántos caracteres
     * podemos "saltarnos" o reutilizar porque ya sabemos que coinciden.
     * Complejidad temporal de este pre-cálculo: O(M), donde M es el tamaño del patrón.
     */
    private static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // Longitud del anterior prefijo sufijo más largo
        int i = 1;   // lps[0] siempre es 0 por definición

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // Si no coinciden, retrocedemos 'len' usando los valores previamente calculados
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        FR sc = new FR();

        // PrintWriter con BufferedOutputStream optimiza drásticamente la salida de datos,
        // agrupando las escrituras en memoria antes de volcarlas a la consola de golpe.
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        // El formato de entrada típico de este problema alterna:
        // Línea 1: Patrón
        // Línea 2: Texto donde buscar
        String pattern = sc.nextLine();
        while (pattern != null) {
            String texto = sc.nextLine();
            if (texto == null) break;

            int n = texto.length();
            int m = pattern.length();

            StringBuilder sb = new StringBuilder();

            // Validamos que el patrón quepa en el texto y no esté vacío
            if (m > 0 && n >= m) {
                // Paso 1: Obtenemos la tabla de saltos KMP
                int[] lps = computeLPS(pattern);

                int i = 0; // Índice para recorrer el texto principal
                int j = 0; // Índice para recorrer el patrón
                boolean primer = true;

                // Paso 2: Búsqueda lineal O(N)
                while (i < n) {
                    // Si los caracteres coinciden, avanzamos ambos punteros
                    if (pattern.charAt(j) == texto.charAt(i)) {
                        i++;
                        j++;
                    }

                    // Si encontramos el patrón completo en el texto
                    if (j == m) {
                        if (!primer) {
                            sb.append(" ");
                        } else {
                            primer = false;
                        }
                        // La posición de inicio de la coincidencia es (i - j)
                        sb.append(i - j);

                        // PLANTEAMIENTO PARA SOLAPAMIENTOS (Overlapping matches):
                        // Para permitir encontrar ocurrencias que se solapan (ej: buscar "ana" en "anana"),
                        // no reiniciamos j a 0. En su lugar, consultamos la tabla lps para retroceder
                        // eficientemente al mayor sufijo que también es prefijo.
                        j = lps[j - 1];
                    }
                    // Si hay un desajuste después de haber avanzado algunos caracteres
                    else if (i < n && pattern.charAt(j) != texto.charAt(i)) {
                        if (j != 0) {
                            // Usamos el valor anterior de lps para evitar retroceder el puntero 'i' del texto
                            j = lps[j - 1];
                        } else {
                            // Si j == 0, ningún prefijo coincide, avanzamos en el texto
                            i++;
                        }
                    }
                }
            }

            // Escribimos el resultado acumulado de esta línea en el búfer
            out.println(sb.toString());

            // Leemos el siguiente patrón para la siguiente iteración
            pattern = sc.nextLine();
        }

        // Vaciamos el búfer para garantizar que toda la salida se imprima correctamente
        out.flush();
    }
}