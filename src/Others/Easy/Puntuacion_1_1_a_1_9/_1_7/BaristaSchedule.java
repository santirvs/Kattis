package Others.Easy.Puntuacion_1_1_a_1_9._1_7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaristaSchedule {

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

        // n: número de pedidos; m: número de baristas idénticos en paralelo
        int n = Integer.parseInt(nToken);
        int m = sc.nextInt();

        // Almacenamos las duraciones de los pedidos en un arreglo de long
        // para evitar desbordamientos al operar o sumar tiempos.
        long[] durations = new long[n];
        for (int i = 0; i < n; i++) {
            durations[i] = sc.nextLong();
        }

        // 1. Propiedad óptima (Shortest Processing Time):
        // Ordenar de menor a mayor garantiza que los pedidos cortos vayan antes,
        // reduciendo el tiempo de espera acumulado de los pedidos posteriores.
        Arrays.sort(durations);

        // 2. Montículo de mínimos (min-heap) de tamaño m:
        // Cada elemento representa el instante (en segundos desde t = 0) en el que
        // un barista queda libre tras terminar su último pedido asignado.
        PriorityQueue<Long> baristasFreeAt = new PriorityQueue<Long>(Math.max(1, m));

        // Al inicio (t = 0), todos los baristas están disponibles.
        // Si m > n, los baristas sobrantes simplemente nunca recibirán pedidos.
        int initialHeapSize = Math.min(n, m);
        for (int i = 0; i < initialHeapSize; i++) {
            baristasFreeAt.add(0L);
        }

        // Acumulador de 64 bits para la suma de los tiempos de terminación
        long totalCompletionTime = 0L;

        // 3. Asignación voraz:
        // Procesamos cada pedido (ya ordenado de menor a mayor) y lo asignamos
        // al barista que quede libre antes (mínimo en el heap).
        for (int i = 0; i < n; i++) {
            long t = durations[i];
            long startTime = baristasFreeAt.poll();
            long completionTime = startTime + t;

            totalCompletionTime += completionTime;

            // Actualizamos el momento en que este barista volverá a estar libre
            baristasFreeAt.add(completionTime);
        }

        out.println(totalCompletionTime);
        out.flush();
    }
}