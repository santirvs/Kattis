package Others.Easy.Puntuacion_1_1_a_1_9._1_5;


/**
 * Mucho rollo que se reduce a leer el primer número y determinar
 * si es mayor o igual a 8 o no
 */

import java.util.Scanner;

public class CountingClauses {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        if (num>=8) System.out.println("satisfactory");
        else System.out.println("unsatisfactory");
    }
}
