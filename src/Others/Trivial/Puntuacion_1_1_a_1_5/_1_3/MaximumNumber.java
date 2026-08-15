package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Deteminar el máximo de una lista de números

import java.util.Scanner;

public class MaximumNumber {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int max = Integer.MIN_VALUE;

        while (scan.hasNext()) {
            max = Math.max(max, scan.nextInt());
        }

        System.out.println(max);
    }
}