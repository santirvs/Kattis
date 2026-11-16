package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

import java.util.Locale;
import java.util.Scanner;

public class BuildingPyramids {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.UK);

        int numPisos = scanner.nextInt();

        long numBolas = 0;
        long numBolasPiso = 0;
        for (int piso=1; piso <= numPisos; piso++) {
            numBolasPiso += piso;
            numBolas += numBolasPiso;
        }

        System.out.println(numBolas);
    }
}