package Others.Easy.Puntuacion_1_1_a_1_9._1_1;

// Sumar los dos primeros números y restarlos del tercero

import java.util.Scanner;

public class ALeidIBio {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();
        System.out.println(num3 - (num1 + num2));
    }
}