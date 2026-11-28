package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

public class ClubSpending {

    // Convierte una cadena como "$161.80" a centimos exactos (16180L)
    private static long parseCents(String priceToken) {
        String s = priceToken.startsWith("$") ? priceToken.substring(1) : priceToken;
        int dotIndex = s.indexOf('.');
        if (dotIndex == -1) {
            return Long.parseLong(s) * 100L;
        }
        long dollars = Long.parseLong(s.substring(0, dotIndex));
        String frac = s.substring(dotIndex + 1);
        if (frac.length() == 1) {
            frac = frac + "0";
        } else if (frac.length() > 2) {
            frac = frac.substring(0, 2);
        }
        long cents = Long.parseLong(frac);
        return dollars * 100L + cents;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st = null;

        while ((st == null || !st.hasMoreTokens()) && (line = br.readLine()) != null) {
            st = new StringTokenizer(line);
        }
        if (st == null || !st.hasMoreTokens()) {
            return;
        }

        int n = Integer.parseInt(st.nextToken());
        HashMap<String, Long> totalsInCents = new HashMap<String, Long>();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (st == null || !st.hasMoreTokens()) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                st = new StringTokenizer(line);
            }
            if (st == null || !st.hasMoreTokens()) {
                break;
            }

            String club = st.nextToken();
            if (!st.hasMoreTokens()) {
                break;
            }
            String priceToken = st.nextToken();

            long cents = parseCents(priceToken);
            Long current = totalsInCents.get(club);
            long updated = (current == null ? 0L : current.longValue()) + cents;
            totalsInCents.put(club, Long.valueOf(updated));

            long dollarsPart = updated / 100L;
            long centsPart = updated % 100L;
            out.append(String.format(Locale.US, "%s $%d.%02d%n", club, dollarsPart, centsPart));
        }

        System.out.print(out.toString());
    }
}