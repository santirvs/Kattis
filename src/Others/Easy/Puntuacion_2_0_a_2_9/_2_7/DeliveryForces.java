package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DeliveryForces {

    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader + StringTokenizer para lectura rápida en Java 7,
        // evitando cuellos de botella si N es grande (por ejemplo, N <= 3 * 10^5).
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        if (firstLine == null || firstLine.trim().isEmpty()) {
            return;
        }

        int n = Integer.parseInt(firstLine.trim());
        int[] fuerzas = new int[n];

        // Leemos los N valores (pueden venir en una o varias líneas)
        int count = 0;
        StringTokenizer st = null;
        while (count < n) {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                st = new StringTokenizer(line);
            }
            if (st == null || !st.hasMoreTokens()) {
                break;
            }
            fuerzas[count++] = Integer.parseInt(st.nextToken());
        }

        /*
         * PLANTEAMIENTO DEL ALGORITMO (ESTRATEGIA GREEDY / VORAZ):
         *
         * 1. Ordenamos las N fuerzas de menor a mayor:
         *       fuerzas[0] <= fuerzas[1] <= ... <= fuerzas[N - 1]
         *
         * 2. Queremos formar K = N / 3 equipos de 3 personas y maximizar la suma
         *    de las medianas (el elemento central de cada trío).
         *
         * 3. Observación clave:
         *    - El elemento más grande (fuerzas[N - 1]) nunca puede ser mediana porque
         *      no hay nadie mayor que él para ocupar el tercer puesto del equipo.
         *      Por tanto, la mayor mediana posible para el primer equipo es fuerzas[N - 2].
         *    - Para no "desperdiciar" repartidores fuertes en el puesto más débil
         *      de un trío, completamos cada equipo con el repartidor más débil
         *      disponible al principio del arreglo.
         *
         * 4. Así, los K equipos óptimos quedan formados como:
         *    - Equipo 1: (fuerzas[0],     fuerzas[N - 2], fuerzas[N - 1]) -> mediana: fuerzas[N - 2]
         *    - Equipo 2: (fuerzas[1],     fuerzas[N - 4], fuerzas[N - 3]) -> mediana: fuerzas[N - 4]
         *    ...
         *    - Equipo K: (fuerzas[K - 1], fuerzas[K],     fuerzas[K + 1]) -> mediana: fuerzas[K]
         *
         *    Es decir: los primeros K = N / 3 elementos van uno a cada equipo como el mínimo,
         *    y de los 2K elementos restantes tomamos alternadamente el segundo de cada pareja
         *    empezando desde el final (índices N - 2, N - 4, ..., N / 3).
         */
        Arrays.sort(fuerzas);

        // Usamos long para evitar desbordamiento (overflow) si N y las fuerzas son grandes
        long sumaMaxima = 0L;
        int k = n / 3;

        // Recorremos desde N - 2 retrocediendo de 2 en 2 hasta llegar al índice K (= N / 3),
        // sumando exactamente K medianas.
        for (int i = n - 2; i >= k; i -= 2) {
            sumaMaxima += fuerzas[i];
        }

        System.out.println(sumaMaxima);
    }
}