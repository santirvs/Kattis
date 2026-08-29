package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Leer los puntos y aplicar la fórmula
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class DifferentDistances {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        double x1 = sc.nextDouble();

        while (x1 != 0) {
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();

            double p = sc.nextDouble();

            double dx = Math.pow( Math.abs( x1-x2), p);
            double dy = Math.pow( Math.abs( y1-y2), p);

            double result = Math.pow( dx + dy , 1/p);

            System.out.printf("%.6f\n", result);


            x1 = sc.nextDouble();

        }

    }
}