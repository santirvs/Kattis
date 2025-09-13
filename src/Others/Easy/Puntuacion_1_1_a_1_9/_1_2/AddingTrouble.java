package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer dos números y sumarlos. Comparar si la suma es igual al tercer número
// Imprimir corect! o wrong!

import java.util.Scanner;

public class AddingTrouble {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int a = scan.nextInt();
        int b = scan.nextInt();
        int res = a+b;
        int c = scan.nextInt();

        if (res == c) {
            System.out.println("correct!");
        } else {
            System.out.println("wrong!");
        }

    }
}