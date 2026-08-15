package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

import java.util.Scanner;

public class StarArrangements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numEstrellas = sc.nextInt();

        System.out.println(numEstrellas + ":");

        for (int i=2; i<=(numEstrellas / 2) +1; i++) {
            int resto = numEstrellas % (i+i-1);
            if ( resto == 0 || resto == i) {
                System.out.println(i + "," + (i-1));
            }
            if (numEstrellas % i == 0) {
                System.out.println(i + "," + i);
            }
        }
    }
}
