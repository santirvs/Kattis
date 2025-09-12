package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer los valores a, b y c y calcular a*c . El valor de b no se usa.

import java.util.Scanner;

public class Hack_a_Holicks {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        scan.nextInt();  // b no se usa
        int c = scan.nextInt();

        System.out.println(a*c);

    }
}