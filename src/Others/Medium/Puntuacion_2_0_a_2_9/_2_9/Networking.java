package Others.Medium.Puntuacion_2_0_a_2_9._2_9;

/**
 * A primera vista, parece el típico Problema de la Mochila (Knapsack Problem),
 * pero con un "giro": no podemos repetir profesores.
 *
 * Si agrupamos los cursos por profesor, el problema se transforma en:
 * "De cada grupo de cursos (profesor), podemos elegir como máximo un curso (o ninguno)".
 *
 * Esto convierte nuestro problema en el Problema de la Mochila Unidimensional con Restricciones de Grupo
 * (también conocido como Multiple-Choice Knapsack Problem o MCKP).
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Networking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // Agrupamos los cursos por profesor utilizando un HashMap
        Map<String, List<Integer>> groups = new HashMap<String, List<Integer>>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int credits = Integer.parseInt(st.nextToken());
            String lecturer = st.nextToken();

            // Java 1.7: Control manual de la existencia de la clave en el Map
            if (!groups.containsKey(lecturer)) {
                groups.put(lecturer, new ArrayList<Integer>());
            }
            groups.get(lecturer).add(credits);
        }

        // dp[w] guardará el máximo de créditos que podemos obtener con un peso <= w
        int[] dp = new int[C + 1];

        // Iteramos sobre cada grupo de profesores
        for (Map.Entry<String, List<Integer>> entry : groups.entrySet()) {
            List<Integer> courses = entry.getValue();

            // Creamos una copia del estado anterior para la transición del grupo actual
            int[] nextDp = new int[C + 1];
            System.arraycopy(dp, 0, nextDp, 0, C + 1);

            // Para cada curso del profesor actual
            for (int i = 0; i < courses.size(); i++) {
                int credits = courses.get(i);

                // Intentamos colocar este curso en cada capacidad posible w
                for (int w = C; w >= credits; w--) {
                    if (dp[w - credits] + credits > nextDp[w]) {
                        nextDp[w] = dp[w - credits] + credits;
                    }
                }
            }

            // El estado 'dp' se actualiza con las decisiones tomadas para este grupo
            dp = nextDp;
        }

        // La respuesta final es el valor máximo alcanzable con capacidad C
        System.out.println(dp[C]);
    }
}