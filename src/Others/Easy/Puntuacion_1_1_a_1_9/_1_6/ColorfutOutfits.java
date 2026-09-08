package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * 1 --> 1 (no puede ser, porque n >= 3
 * Par --> 2
 * Impar --> 3
 */

import java.util.Scanner;

public class ColorfutOutfits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numAmigos = sc.nextInt();

        if (numAmigos % 2 == 0)
            System.out.println(2);
        else
            System.out.println(3);
    }
}