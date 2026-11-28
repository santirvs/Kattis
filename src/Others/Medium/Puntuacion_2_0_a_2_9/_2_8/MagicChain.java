package Others.Medium.Puntuacion_2_0_a_2_9._2_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class MagicChain {

    private static double f(double x, double p) {
        if (x <= 0.0) {
            return 1.0;
        }
        if (x >= 1.0) {
            return 0.0;
        }
        double base = 1.0 - Math.pow(x, p);
        if (base <= 0.0) {
            return 0.0;
        }
        return Math.pow(base, 1.0 / p);
    }

    // Regla compuesta de Simpson en [0, 1] con n subintervalos (n par)
    private static double simpsonIntegral(double p, int n) {
        if (n % 2 != 0) {
            n++;
        }
        double h = 1.0 / n;
        double sum = f(0.0, p) + f(1.0, p);

        for (int i = 1; i < n; i++) {
            double x = i * h;
            double weight = (i % 2 == 0) ? 2.0 : 4.0;
            sum += weight * f(x, p);
        }

        return (h / 3.0) * sum;
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

        double p = Double.parseDouble(st.nextToken());
        int intervals = 2000000;
        double reachableArea = simpsonIntegral(p, intervals);
        double safeProportion = 1.0 - reachableArea;

        System.out.printf(Locale.US, "%.15f%n", safeProportion);
    }
}