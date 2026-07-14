package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

import java.util.Scanner;

public class CompetitiveMorality {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numR = sc.nextInt();
        int numB = sc.nextInt();

        if (numR > numB+1) {
            System.out.println("RED");
        } else {
            System.out.println("BLUE");
        }
    }
}
