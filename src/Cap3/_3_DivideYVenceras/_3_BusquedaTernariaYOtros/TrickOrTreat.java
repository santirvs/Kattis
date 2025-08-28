package Cap3._3_DivideYVenceras._3_BusquedaTernariaYOtros;

// Estrategia de D&C. Búsqueda ternaria y otros

/** Kattis - tricktreat
 *
 * Original de: https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_3_Problem_Solving_Paradigms/Divide_and_Conquer/kattis_tricktreat.cpp
 *
 * La versión traducida a Java da TLE en Caso #2
 * Al ser Java más lento, debe apurarse más el código:
 * - Usar Math.sqrt en lugar de Math.hypot
 * - Usar un scanner más rápido
 * - Definir los límites del problema en -200.000 y 200.000 en lugar de -1e9 y 1e9
 * - Reducir el número de iteraciones de la búsqueda ternaria a 70 en lugar de 100 hasta conseguir una precisión de 10^-5
 *
 * Simplemente se usa búsqueda ternaria para minimizar la distancia máxima
 * que cualquier niño debe correr hasta el punto de reunión.
 * Se puede probar que la búsqueda ternaria funciona considerando
 * las gráficas de las distancias entre el punto inicial y el de reunión
 * a medida que varía el punto de reunión.
 * Por contradicción, se puede demostrar que solo hay un punto mínimo
 * del máximo de todas las gráficas.
 *
 * Tiempo: O(n), Espacio: O(1)
 */
import java.io.*;
import java.util.*;

public class TrickOrTreat {
    static double[][] points;

    // Calcula el coste para un punto de reunión en x
    static double cost(double x) {
        double ans = 0;
        for (double[] p : points) {
            double dx = p[0] - x;
            double dy = p[1];
            double dist = Math.sqrt(dx * dx + dy * dy); // más rápido que Math.hypot
            if (dist > ans) ans = dist;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            points = new double[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = sc.nextDouble();
                points[i][1] = sc.nextDouble();
            }

            double lo = -200000, hi = 200000;  // límites del problema
            for (int i = 0; i < 70; i++) { // 60 iteraciones son suficientes para precisión de 10^-5
                double midLo = lo + (hi - lo) / 3.0;
                double midHi = hi - (hi - lo) / 3.0;

                if (cost(midLo) < cost(midHi)) {
                    hi = midHi;
                } else {
                    lo = midLo;
                }
            }

            sb.append(String.format(Locale.US, "%.10f %.10f\n", lo, cost(lo)));
        }

        System.out.print(sb.toString());
    }

    // Scanner muy rápido
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1 && c <= ' ');
            if (c == -1) return null;
            do {
                sb.append((char)c);
            } while ((c = readByte()) != -1 && c > ' ');
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
