package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Traducir el número M de babas a binario y contar el número de 1s
// N es irrelevante (es el número máximo de bits del resultado)

import java.util.Scanner;

public class BabyPanda {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long M = sc.nextLong();
        long num1s = 0;

        while (M > 0) {
            if (M%2==1) num1s++;
            M = M / 2;
        }

        System.out.println(num1s);

    }
}
