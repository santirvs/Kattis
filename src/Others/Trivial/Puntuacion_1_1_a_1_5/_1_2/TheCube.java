package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Calcular el cubo de un número entero leído

import java.util.Scanner;

public class TheCube {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        System.out.println(num*num*num);

    }
}