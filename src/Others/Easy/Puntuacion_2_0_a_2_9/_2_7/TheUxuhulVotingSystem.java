package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TheUxuhulVotingSystem {

    // Nombres de los 8 estados posibles en orden de 0 a 7
    private static final String[] OUTCOMES = {
            "NNN", "NNY", "NYN", "NYY",
            "YNN", "YNY", "YYN", "YYY"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int t = Integer.parseInt(line.trim()); // Número de casos de prueba

        while (t-- > 0) {
            // Leer número de sacerdotes
            String mStr = br.readLine();
            while (mStr != null && mStr.trim().isEmpty()) {
                mStr = br.readLine();
            }
            if (mStr == null) break;
            int m = Integer.parseInt(mStr.trim());

            // pref[i][s] almacenará la preferencia del sacerdote 'i' (0-indexed) por el estado 's' (0..7)
            int[][] pref = new int[m][8];

            for (int i = 0; i < m; i++) {
                String prefLine = br.readLine();
                while (prefLine != null && prefLine.trim().isEmpty()) {
                    prefLine = br.readLine();
                }
                StringTokenizer st = new StringTokenizer(prefLine);
                for (int s = 0; s < 8; s++) {
                    pref[i][s] = Integer.parseInt(st.nextToken());
                }
            }

            // dp[i][s] almacena el ESTADO FINAL al que llegará la votación
            // si el sacerdote 'i' recibe la mesa en el estado 's'.
            int[][] dp = new int[m][8];

            // 1. CASO BASE: Último sacerdote (m - 1)
            // Su decisión determina directamente el estado en el que termina el juego.
            int lastPriest = m - 1;
            for (int s = 0; s < 8; s++) {
                int bestOutcome = -1;
                int bestPref = Integer.MAX_VALUE;

                // Puede voltear la piedra 0, 1 o 2 (cambiar 1 bit del estado 's')
                for (int b = 0; b < 3; b++) {
                    int nextState = s ^ (1 << b); // Estado vecino tras dar la vuelta a 1 piedra
                    int outcomePref = pref[lastPriest][nextState];

                    if (outcomePref < bestPref) { // Menor número = mayor preferencia
                        bestPref = outcomePref;
                        bestOutcome = nextState;
                    }
                }
                dp[lastPriest][s] = bestOutcome;
            }

            // 2. PASO INDUCTIVO: Del penúltimo sacerdote (m - 2) al primero (0)
            for (int i = m - 2; i >= 0; i--) {
                for (int s = 0; s < 8; s++) {
                    int bestOutcome = -1;
                    int bestPref = Integer.MAX_VALUE;

                    // Probar las 3 opciones de voltear 1 piedra
                    for (int b = 0; b < 3; b++) {
                        int nextState = s ^ (1 << b);

                        // El resultado final si pasa a 'nextState' ya fue determinado
                        // por la respuesta óptima de los sacerdotes posteriores:
                        int finalOutcome = dp[i + 1][nextState];

                        int outcomePref = pref[i][finalOutcome];

                        if (outcomePref < bestPref) {
                            bestPref = outcomePref;
                            bestOutcome = finalOutcome;
                        }
                    }
                    dp[i][s] = bestOutcome;
                }
            }

            // El estado inicial siempre es NNN (índice 0).
            // Imprimimos el estado final calculado para el primer sacerdote (índice 0).
            int finalState = dp[0][0];
            System.out.println(OUTCOMES[finalState]);
        }
    }
}