package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Leer el importe como String y mostrar su longitud
 */

import java.io.IOException;
import java.util.Scanner;


public class QuickEstimates {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        while (numCasos-- > 0) {

            String num = sc.next();
            System.out.println(num.length());

        }

        sc.close();
    }
}

