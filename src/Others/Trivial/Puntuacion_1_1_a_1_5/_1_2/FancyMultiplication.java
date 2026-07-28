package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Leer dos números y multiplicarlos

import java.util.Scanner;

public class FancyMultiplication {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        long a = scan.nextInt();
        long b = scan.nextInt();
        long res = a*b;

        System.out.println(res);

    }
}