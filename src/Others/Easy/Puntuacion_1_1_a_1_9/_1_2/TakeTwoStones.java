package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer el número de piedras que hay disponibles
// Si el número de piedras es par, ganará Bob, si es impar, ganará Alice

import java.util.Scanner;

public class TakeTwoStones {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int a = scan.nextInt();
        if (a % 2 == 0) {
            System.out.println("Bob");
        } else {
            System.out.println("Alice");
        }


    }
}