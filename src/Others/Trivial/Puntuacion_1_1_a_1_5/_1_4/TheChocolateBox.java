package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

/**
 * Contar las veces que se ha incrementado la observación
 * Si se ha incrementado de una vez a la siguiente, solo
 * puede haber sido debido a que se ha comprado una nueva tableta
 */

import java.util.Scanner;

public class TheChocolateBox {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el numero de observaciones
        int numObservaciones = sc.nextInt();
        int numCompradas = 0;

        int anteriorObservacion = sc.nextInt();
        for (int i=1; i<numObservaciones; i++) {
            int nuevaObservacion = sc.nextInt();

            if (nuevaObservacion > anteriorObservacion)
                numCompradas++;

            anteriorObservacion = nuevaObservacion;
        }

        System.out.println(numCompradas);

        sc.close();
    }
}

