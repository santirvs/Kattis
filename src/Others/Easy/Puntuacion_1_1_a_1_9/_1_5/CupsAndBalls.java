package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.util.Scanner;

public class CupsAndBalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int posBola = 1;

        for (int i=0; i<5; i++) {
            int copa1 = sc.nextInt();
            int copa2 = sc.nextInt();

            if (copa1 == posBola) posBola = copa2;
            else if (copa2 == posBola) posBola = copa1;
        }

        System.out.println(posBola);

    }
}
