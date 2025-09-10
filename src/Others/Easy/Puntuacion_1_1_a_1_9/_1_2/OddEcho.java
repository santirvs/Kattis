package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer la cantidad de palabras e imprimir únicamente las impares

import java.util.Scanner;

public class OddEcho {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numPalabras = scan.nextInt();

        for (int i = 1; i <= numPalabras; i++) {
            if (i % 2 != 0) {
                System.out.println(scan.next());
            } else {
                scan.next();
            }
        }

    }
}