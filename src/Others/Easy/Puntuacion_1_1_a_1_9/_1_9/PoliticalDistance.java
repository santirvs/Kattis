package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Squared Euclidean Distance es la hipotenusa, pero sin hacer la raíz
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class PoliticalDistance {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        long x1 = sc.nextInt();
        long y1 = sc.nextInt();
        long x2 = sc.nextInt();
        long y2 = sc.nextInt();

        long distX = Math.abs(x1-x2);
        long distY = Math.abs(y1-y2);

        long result = distX*distX + distY*distY;

        System.out.println(result);

        sc.close();
    }
}

