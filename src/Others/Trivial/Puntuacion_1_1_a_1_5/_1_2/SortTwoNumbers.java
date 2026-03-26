package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Leer dos números. Imprimir primero el menor y luego el mayor

import java.util.Scanner;

public class SortTwoNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int a = scan.nextInt();
        int b = scan.nextInt();
        if (a < b) {
            System.out.println(a + " " + b);
        } else {
            System.out.println(b + " " + a);
        }

    }
}