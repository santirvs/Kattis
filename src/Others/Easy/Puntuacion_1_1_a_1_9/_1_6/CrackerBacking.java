package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Devolver el mínimo cuadrado que puede contener N snacks
 */

import java.io.IOException;
import java.util.Scanner;


public class CrackerBacking {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numSnacks = sc.nextInt();

        double raiz = Math.sqrt(numSnacks);

        System.out.println((int)Math.ceil(raiz));

        sc.close();
    }
}

