package Others.Medium.Puntuacion_3_0_a_3_9._3_3;

import java.util.Scanner;
import java.util.Arrays;

public class DrivingLanes {

    private static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            return;
        }

        // 1. Lectura de parámetros iniciales
        int n = sc.nextInt();      // Número de rectas
        int lanes = sc.nextInt();  // Número de carriles (1 a lanes)

        long m = sc.nextLong();    // Avance requerido por cada cambio de carril
        long r = sc.nextLong();    // Distancia extra por cada cambio de carril

        long[] l = new long[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextLong();
        }

        // CASO BORDE: Si solo hay 1 recta, no hay curvas
        if (n == 1) {
            System.out.println(l[0]);
            sc.close();
            return;
        }

        // Hay (n - 1) curvas
        long[] s = new long[n - 1];
        long[] k = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            s[i] = sc.nextLong();
            k[i] = sc.nextLong();
        }

        // dp[c] representa la distancia mínima acumulada tras pasar la curva actual en el carril 'c'
        long[] dp = new long[lanes + 1];
        Arrays.fill(dp, INF);

        // ---------------------------------------------------------------------
        // CASO BASE: Primera recta (l[0]) + Primera curva (s[0], k[0])
        // Sam inicia en el carril 1
        // ---------------------------------------------------------------------
        for (int c = 1; c <= lanes; c++) {
            int cambios = c - 1; // Cambios del carril 1 al carril c
            if (cambios * m <= l[0]) {
                long distRecta = l[0] + (cambios * r);
                long distCurva = s[0] + (c * k[0]);
                dp[c] = distRecta + distCurva;
            }
        }

        // ---------------------------------------------------------------------
        // TRANSICIONES: De la recta 2 a la recta (n - 1)
        // ---------------------------------------------------------------------
        for (int i = 1; i < n - 1; i++) {
            long[] nextDp = new long[lanes + 1];
            Arrays.fill(nextDp, INF);

            for (int cPrev = 1; cPrev <= lanes; cPrev++) {
                if (dp[cPrev] == INF) continue;

                for (int cNext = 1; cNext <= lanes; cNext++) {
                    int cambios = Math.abs(cNext - cPrev);
                    if (cambios * m <= l[i]) {
                        long distRecta = l[i] + (cambios * r);
                        long distCurva = s[i] + (cNext * k[i]);

                        long total = dp[cPrev] + distRecta + distCurva;
                        if (total < nextDp[cNext]) {
                            nextDp[cNext] = total;
                        }
                    }
                }
            }
            dp = nextDp;
        }

        // ---------------------------------------------------------------------
        // PASO FINAL: Última recta (l[n - 1]) -> Sam debe terminar en el carril 1
        // ---------------------------------------------------------------------
        long minResult = INF;
        int targetLane = 1;

        for (int cPrev = 1; cPrev <= lanes; cPrev++) {
            if (dp[cPrev] == INF) continue;

            int cambios = Math.abs(targetLane - cPrev);
            if (cambios * m <= l[n - 1]) {
                long distRectaFinal = l[n - 1] + (cambios * r);
                long total = dp[cPrev] + distRectaFinal;
                if (total < minResult) {
                    minResult = total;
                }
            }
        }

        System.out.println(minResult);
        sc.close();
    }
}