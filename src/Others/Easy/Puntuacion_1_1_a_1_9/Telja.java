package Others.Easy.Puntuacion_1_1_a_1_9;

// Leer un número e imprimir desde el 1 hasta ese número

import java.util.Scanner;

public class Telja {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numFinal = scan.nextInt();

        //Imprimir los números del 1 al numFinal
        for (int i = 1; i <= numFinal; i++) {
            System.out.println(i);
        }

    }
}