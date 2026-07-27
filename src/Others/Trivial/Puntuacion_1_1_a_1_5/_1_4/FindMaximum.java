package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Leer los tres números y quedarnos con el mayor

import java.util.Scanner;

public class FindMaximum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int max = sc.nextInt();
        max = Math.max(max, sc.nextInt());
        max = Math.max(max, sc.nextInt());

        System.out.println(max);


        sc.close();
    }
}

