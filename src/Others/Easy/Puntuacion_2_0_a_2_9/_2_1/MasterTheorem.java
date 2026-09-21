package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Locale;

public class MasterTheorem {

    // Tolerancia para comparar los exponentes.
    private static final double EPS = 1e-7;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringBuilder output = new StringBuilder();

        String line;
        StringTokenizer st = new StringTokenizer("");

        // Procesamos todos los casos hasta EOF.
        while (true) {

            while (!st.hasMoreTokens()) {
                line = br.readLine();

                if (line == null) {
                    System.out.print(output.toString());
                    return;
                }

                st = new StringTokenizer(line);
            }

            // Entrada:
            // a: número de subproblemas
            // b: factor de división
            // c: coeficiente multiplicativo de f(n)
            // d: exponente de n en f(n)
            // k: exponente del logaritmo

            long a = Long.parseLong(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            double d = Double.parseDouble(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // Exponente crítico: log_b(a).
            double x0 = Math.log(a) / Math.log(b);

            // Diferencia entre el exponente crítico y d.
            double diff = x0 - d;

            double x;
            String logPart = "";

            if (diff > EPS) {

                // CASO 1:
                // d < log_b(a)
                // T(n) = Theta(n^(log_b(a))).

                x = x0;

            } else if (diff < -EPS) {

                // CASO 3:
                // d > log_b(a)
                // La regularidad se cumple para las entradas
                // válidas del problema.
                // T(n) = Theta(n^d log^k(n)).

                x = d;
                logPart = formatLogPart(k);

            } else {

                // CASO 2:
                // d = log_b(a)

                x = x0;

                if (k >= 0) {

                    // T(n) = Theta(n^d log^(k+1)(n)).
                    logPart = formatLogPart(k + 1);

                } else if (k == -1) {

                    // T(n) = Theta(n^d log(log(n))).
                    logPart = "log log n";

                } else {

                    // k < -1:
                    // T(n) = Theta(n^d).
                    logPart = "";
                }
            }

            String polyPart = formatPolynomial(x);

            // Componer la respuesta respetando los espacios.
            String result;

            if (polyPart.isEmpty()) {
                result = logPart;
            } else if (logPart.isEmpty()) {
                result = polyPart;
            } else {
                result = polyPart + " " + logPart;
            }

            output.append(result).append('\n');
        }
    }

    /**
     * Formatea el factor log^k(n).
     */
    private static String formatLogPart(int k) {

        if (k == 0) {
            return "";
        }

        if (k == 1) {
            return "log n";
        }

        return "log^" + k + " n";
    }

    /**
     * Formatea n^x:
     *
     * x = 0  -> cadena vacía
     * x = 1  -> n
     * x entero -> n^entero
     * resto -> n^x redondeado a una décima
     */
    private static String formatPolynomial(double x) {

        if (Math.abs(x) < EPS) {
            return "";
        }

        if (Math.abs(x - 1.0) < EPS) {
            return "n";
        }

        long nearestInteger = Math.round(x);

        if (Math.abs(x - nearestInteger) < EPS) {
            return "n^" + nearestInteger;
        }

        double roundedTenth = Math.round(x * 10.0) / 10.0;

        // Evitar imprimir n^2.0, n^3.0, etc.
        long roundedInteger = Math.round(roundedTenth);

        if (Math.abs(roundedTenth - roundedInteger) < EPS) {
            return "n^" + roundedInteger;
        }

        return "n^" + String.format(Locale.US, "%.1f", roundedTenth);
    }
}