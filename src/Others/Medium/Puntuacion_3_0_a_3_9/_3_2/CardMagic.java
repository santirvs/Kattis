package Others.Medium.Puntuacion_3_0_a_3_9._3_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CardMagic {

    private static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // Bucle para leer la primera línea no vacía por si hay líneas en blanco
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                break;
            }
        }

        if (line == null || line.isEmpty()) {
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        // CASOS IMPOSIBLES:
        // 1. La suma mínima con N mazos es N (eligiendo unos)
        // 2. La suma máxima con N mazos es N * K (eligiendo Ks)
        if (t < n || (long) n * k < t) {
            System.out.println(0);
            return;
        }

        // Si K es más grande que T, ninguna carta mayor a T puede ser elegida
        k = Math.min(k, t);

        // dp[s] es el número de formas de sumar 's'
        int[] dp = new int[t + 1];
        dp[0] = 1;

        // Procesamos mazo por mazo
        for (int deck = 1; deck <= n; deck++) {
            int[] nextDp = new int[t + 1];

            // La suma mínima alcanzable en el mazo actual es 'deck'
            // La suma máxima alcanzable en el mazo actual es min(t, deck * k)
            int minSum = deck;
            int maxSum = (int) Math.min((long) t, (long) deck * k);

            for (int s = minSum; s <= maxSum; s++) {
                long currentWays = 0;

                // Probamos cada carta posible c desde 1 hasta min(k, s)
                int maxCard = Math.min(k, s);
                for (int c = 1; c <= maxCard; c++) {
                    currentWays += dp[s - c];
                    if (currentWays >= MOD) {
                        currentWays %= MOD;
                    }
                }

                nextDp[s] = (int) (currentWays % MOD);
            }

            dp = nextDp;
        }

        System.out.println(dp[t]);
    }
}