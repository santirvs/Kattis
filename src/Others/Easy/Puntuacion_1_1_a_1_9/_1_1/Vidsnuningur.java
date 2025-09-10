package Others.Easy.Puntuacion_1_1_a_1_9._1_1;

// Leer la cadena e imprimirla al revés

import java.util.Scanner;

public class Vidsnuningur {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char[] cadena = scan.nextLine().toCharArray();
        for (int i = cadena.length - 1; i >= 0; i--) {
            System.out.print(cadena[i]);
        }
        System.out.println();

    }
}