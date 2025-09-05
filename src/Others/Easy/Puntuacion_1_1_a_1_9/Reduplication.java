package Others.Easy.Puntuacion_1_1_a_1_9;

// Leer el texto y el número de repeticiones, y repetir el texto ese número de veces

import java.util.Scanner;

public class Reduplication {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String texto = scan.nextLine();
        int repeticiones = scan.nextInt();

        for (int i = 0; i < repeticiones; i++) {
            System.out.print(texto);
        }
        System.out.println();

    }
}