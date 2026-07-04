package Others.Medium.Puntuacion_2_0_a_2_9._2_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class DraftLottery {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int n = Integer.parseInt(line.trim());

        String[] teamNames = new String[n];
        int[] balls = new int[n];
        Map<String, Integer> teamNameToId = new HashMap<String, Integer>();

        long totalBalls = 0;
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int b = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            balls[i] = b;
            teamNames[i] = name;
            teamNameToId.put(name, i);
            totalBalls += b;
        }

        // P_pos[equipo_id][pick]
        // Nota: Los picks irán indexados de 1 a n para facilitar la lectura.
        double[][] pPos = new double[n][n + 1];

        // Simulación de todas las permutaciones posibles para los 3 primeros picks O(N^3)
        for (int i = 0; i < n; i++) {
            double p1 = (double) balls[i] / totalBalls;
            long remainingAfter1 = totalBalls - balls[i];

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                double p2 = p1 * ((double) balls[j] / remainingAfter1);
                long remainingAfter2 = remainingAfter1 - balls[j];

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    double p3 = p2 * ((double) balls[k] / remainingAfter2);

                    // Registramos las probabilidades del Top 3
                    pPos[i][1] += p3;
                    pPos[j][2] += p3;
                    pPos[k][3] += p3;

                    // Asignamos del Pick 4 en adelante a los equipos restantes
                    int currentPick = 4;
                    for (int m = 0; m < n; m++) {
                        if (m != i && m != j && m != k) {
                            pPos[m][currentPick] += p3;
                            currentPick++;
                        }
                    }
                }
            }
        }

        // Procesar las Consultas (Queries)
        line = br.readLine();
        if (line != null) {
            int q = Integer.parseInt(line.trim());
            for (int i = 0; i < q; i++) {
                line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                String queryTeam = st.nextToken();
                int k = Integer.parseInt(st.nextToken());

                int teamId = teamNameToId.get(queryTeam);

                // Calculamos la probabilidad acumulada hasta el pick k
                double cumulativeProbability = 0.0;
                // Si k es mayor que el número total de equipos, lo limitamos a n
                int limit = Math.min(k, n);
                for (int p = 1; p <= limit; p++) {
                    cumulativeProbability += pPos[teamId][p];
                }

                // Imprimir con el formato de alta precisión requerido (< 10^-8)
                System.out.printf("%.9f\n", cumulativeProbability);
            }
        }
    }
}