package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Calcular la superficie de cada sector circular
 * Un círculo de radio R tiene superficie PI * R^2
 * Un sector de radio R y de ángulo a tiene una superficie:  PI/360 * a * R^2
 * Un sector de radio exterior R y radio interior r y ángulo a tiene una superfície:
 *    PI/360*a* (R^2-r^2)
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class CircularPainting {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numSectores = sc.nextInt();
        double superficieTotal = 0;

        while (numSectores-- > 0) {
            int angulo = sc.nextInt();
            int radioInterior = sc.nextInt();
            int radioExterior = sc.nextInt();

            superficieTotal += Math.PI / 360.0 * angulo * ((radioExterior*radioExterior) - (radioInterior*radioInterior));

        }

        System.out.println(superficieTotal);


        sc.close();
    }
}

