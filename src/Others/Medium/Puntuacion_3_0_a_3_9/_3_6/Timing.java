package Others.Medium.Puntuacion_3_0_a_3_9._3_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * PROBLEMA: Timing
 * ============================================================================
 * EXPLICACIÓN DEL PLANTEAMIENTO
 * ============================================================================
 * 1. FASE DE SIMULACIÓN (Transición de Tropas):
 * Cada fuerte 'i' tiene inicialmente S_i unidades.
 * En cada uno de los T pasos de tiempo, una fracción de las tropas de cada fuerte
 * migra hacia otros fuertes mediante los enlaces dirigidos.
 * - Si un enlace va de u -> v con fracción p, el fuerte 'v' recibe (p * tropas_actuales[u]).
 * - Las tropas de 'u' disminuyen en esa misma cantidad.
 * - Para garantizar la conservación de la masa, calculamos el porcentaje de tropas
 * que se QUEDAN en cada fuerte 'u' como: 1.0 - (suma de todas las fracciones de salida de 'u').
 * - La simulación se debe realizar utilizando dos arreglos (el estado actual y el
 * siguiente estado en t+1) para evitar que las actualizaciones "in-place" afecten
 * las operaciones del mismo paso de tiempo.
 * * 2. FASE DE REACCIÓN (Agregación de Vecinos):
 * El ataque ocurre en el tiempo T. Si decidimos atacar un fuerte 'X':
 * - Nos enfrentamos a las tropas en 'X' en el tiempo T.
 * - Adicionalmente, se movilizan de inmediato todas las tropas de los fuertes vecinos
 * que estén conectados con 'X' por un enlace, SIN IMPORTAR la dirección del enlace.
 * - Por lo tanto, la resistencia en 'X' es: Fuerza(X) + Suma de Fuerza(vecinos de X).
 * * 3. OBJETIVO:
 * Encontrar el fuerte que ofrezca la MENOR resistencia total posible y reportar dicho valor.
 */
public class Timing {

    // Estructura para representar un enlace de transferencia dirigido
    static class Link {
        int source;
        int target;
        double fraction;

        Link(int source, int target, double fraction) {
            this.source = source;
            this.target = target;
            this.fraction = fraction;
        }
    }

    // Lector rápido optimizado para la lectura rápida de enteros y dobles
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        String tStr = sc.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr); // Número de casos de prueba

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt(); // Número de fuertes
            int m = sc.nextInt(); // Número de enlaces
            int time = sc.nextInt(); // Tiempo de simulación (T)

            double[] strength = new double[n];
            for (int i = 0; i < n; i++) {
                strength[i] = sc.nextDouble();
            }

            Link[] links = new Link[m];
            // Arreglo para calcular cuánta fracción de tropas sale de cada fuerte
            double[] outFractionSum = new double[n];

            // Grafo no dirigido para saber los vecinos de reacción en el paso de ataque
            boolean[][] adjMat = new boolean[n][n];

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                double p = sc.nextDouble();
                links[i] = new Link(u, v, p);

                outFractionSum[u] += p; // Acumulamos las fracciones de salida de 'u'

                // Marcamos la conectividad bidireccional (reacción del MdI)
                adjMat[u][v] = true;
                adjMat[v][u] = true;
            }

            // ====================================================================
            // FASE 1: SIMULACIÓN DE TRÁNSITO DE TROPAS (T PASOS DE TIEMPO)
            // ====================================================================
            double[] current = Arrays.copyOf(strength, n);

            for (int step = 0; step < time; step++) {
                double[] next = new double[n];

                // Paso A: Cada fuerte retiene la fracción de tropas que no viaja a otros lugares
                for (int i = 0; i < n; i++) {
                    double stayFraction = 1.0 - outFractionSum[i];
                    next[i] = current[i] * stayFraction;
                }

                // Paso B: Añadir las porciones de tropas que viajan por cada enlace
                for (int i = 0; i < m; i++) {
                    Link link = links[i];
                    next[link.target] += current[link.source] * link.fraction;
                }

                current = next; // Actualizamos para la siguiente unidad de tiempo
            }

            // ====================================================================
            // FASE 2 Y 3: CÁLCULO DE RESISTENCIA LOCAL Y BÚSQUEDA DEL MÍNIMO
            // ====================================================================
            double minResistance = Double.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                // Si atacamos al fuerte 'i', nos enfrentamos a sus tropas finales...
                double resistance = current[i];

                // ... más las tropas de todos los fuertes directamente conectados (enlaces bidireccionales)
                for (int j = 0; j < n; j++) {
                    if (adjMat[i][j]) {
                        resistance += current[j];
                    }
                }

                // Buscamos el punto de ataque más débil (menor resistencia)
                if (resistance < minResistance) {
                    minResistance = resistance;
                }
            }

            // Impresión del menor indicador con alta precisión decimal
            System.out.printf("%.9f\n", minResistance);
        }
    }
}