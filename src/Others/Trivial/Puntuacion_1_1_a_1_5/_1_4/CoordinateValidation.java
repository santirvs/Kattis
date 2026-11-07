package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

import java.util.Locale;
import java.util.Scanner;

public class CoordinateValidation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        int numCasos = sc.nextInt();

        while (numCasos-- > 0) {
            double lat = sc.nextDouble();
            double lon = sc.nextDouble();

            if (lat >= -180 && lat <= 180 && lon >= -90 && lon <= 90) {
                System.out.println("VALID");
            } else
                System.out.println("INVALID");


        }
    }
}

