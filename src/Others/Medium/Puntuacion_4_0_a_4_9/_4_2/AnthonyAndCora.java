package Others.Medium.Puntuacion_4_0_a_4_9._4_2;


import java.util.Scanner;
import java.util.Locale;

public class AnthonyAndCora {
        public static void main(String[] args) {
            // Configuramos Locale.US para asegurar el parseo correcto del punto decimal '.'
            Scanner sc = new Scanner(System.in).useLocale(Locale.US);

            if (!sc.hasNextInt()) {
                return;
            }

            int n = sc.nextInt(); // Puntos iniciales de Anthony
            int m = sc.nextInt(); // Puntos iniciales de Cora

            // El número máximo de rondas posibles es (n + m - 1)
            int maxRounds = n + m - 1;
            double[] p = new double[maxRounds + 1];

            // Lectura de la probabilidad p_r para cada ronda r (basada en índice 1)
            for (int r = 1; r <= maxRounds; r++) {
                if (sc.hasNextDouble()) {
                    p[r] = sc.nextDouble();
                }
            }

            // dp[a][c] representa la probabilidad de alcanzar el estado donde
            // a Anthony le quedan 'a' puntos y a Cora le quedan 'c' puntos.
            double[][] dp = new double[n + 1][m + 1];

            // Estado inicial: Anthony con n puntos y Cora con m puntos tiene probabilidad 1.0
            dp[n][m] = 1.0;

            double probWinAnthony = 0.0;

            // Recorremos los estados desde los puntos máximos hacia abajo
            for (int a = n; a >= 1; a--) {
                for (int c = m; c >= 1; c--) {
                    if (dp[a][c] == 0.0) {
                        continue; // Estado inalcanzable
                    }

                    // Cálculo de la ronda actual basada en los puntos perdidos acumulados
                    int r = (n - a) + (m - c) + 1;
                    double pWinRound = p[r];
                    double pLoseRound = 1.0 - pWinRound;

                    // 1. Anthony gana la ronda 'r' (Cora pierde 1 punto)
                    if (c - 1 == 0) {
                        // Cora se queda sin puntos -> Anthony gana el juego
                        probWinAnthony += dp[a][c] * pWinRound;
                    } else {
                        // El juego continúa con Cora teniendo (c - 1) puntos
                        dp[a][c - 1] += dp[a][c] * pWinRound;
                    }

                    // 2. Anthony pierde la ronda 'r' (Anthony pierde 1 punto)
                    if (a - 1 > 0) {
                        // El juego continúa con Anthony teniendo (a - 1) puntos
                        dp[a - 1][c] += dp[a][c] * pLoseRound;
                    }
                    // Si a - 1 == 0, Anthony pierde el juego y Cora gana (no sumamos a la victoria)
                }
            }

            // Imprimir la probabilidad con precisión adecuada
            System.out.printf(Locale.US, "%.6f\n", probWinAnthony);

            sc.close();
        }
    }
