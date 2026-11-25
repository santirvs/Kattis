package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DimensionalDebugging {

    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String nToken = sc.next();
        if (nToken == null) {
            out.flush();
            return;
        }

        // n: número de algoritmos; k: número de parámetros (dimensiones)
        int n = Integer.parseInt(nToken);
        int k = sc.nextInt();

        // L[i][j]: límite inferior mínimo requerido en la dimensión j para verificar el algoritmo i
        // H[i][j]: límite superior máximo que el algoritmo i puede ejecutar en la dimensión j
        // Usamos long por seguridad ante posibles cotas grandes (> 2^31 - 1).
        long[][] L = new long[n][k];
        long[][] H = new long[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                L[i][j] = sc.nextLong();
            }
            for (int j = 0; j < k; j++) {
                H[i][j] = sc.nextLong();
            }
        }

        // Cola implementada con un arreglo primitivo para evitar overhead de objetos en el BFS
        int[] queue = new int[n];
        int head = 0;
        int tail = 0;

        // Mantenemos el conjunto de algoritmos aún no verificados en un arreglo compacto
        // para iterar únicamente sobre los candidatos pendientes en cada paso del BFS.
        int[] unverified = new int[n];
        int unverifiedCount = 0;

        // 1. Inicialización con el caso base (0, 0, ..., 0):
        // Un algoritmo i puede verificarse directamente con el caso base si y solo si
        // su cota inferior L[i][j] es 0 en todas las dimensiones j.
        for (int i = 0; i < n; i++) {
            boolean allZero = true;
            for (int j = 0; j < k; j++) {
                if (L[i][j] != 0L) {
                    allZero = false;
                    break;
                }
            }

            if (allZero) {
                queue[tail++] = i;
            } else {
                unverified[unverifiedCount++] = i;
            }
        }

        // 2. Recorrido BFS para propagar la verificación:
        // Cada algoritmo 'curr' que sale de la cola ya está demostrado como correcto.
        while (head < tail) {
            int curr = queue[head++];
            long[] currHigh = H[curr];

            // Revisamos todos los algoritmos que aún no han sido verificados
            int idx = 0;
            while (idx < unverifiedCount) {
                int cand = unverified[idx];
                long[] candLow = L[cand];

                // Un algoritmo 'curr' puede verificar a 'cand' si existe un punto x
                // tal que L[cand][j] <= x_j <= H[curr][j] para todo j,
                // lo cual equivale a comprobar L[cand][j] <= H[curr][j] en cada dimensión.
                boolean canVerify = true;
                for (int j = 0; j < k; j++) {
                    if (candLow[j] > currHigh[j]) {
                        canVerify = false;
                        break;
                    }
                }

                if (canVerify) {
                    // 'cand' queda verificado y entra en la cola para verificar a otros
                    queue[tail++] = cand;
                    // Eliminamos 'cand' de la lista de no verificados en O(1)
                    // intercambiándolo con el último elemento activo
                    unverified[idx] = unverified[--unverifiedCount];
                } else {
                    idx++;
                }
            }
        }

        // 'tail' contiene exactamente la cantidad total de algoritmos que entraron en la cola
        out.println(tail);
        out.flush();
    }
}