package Others.Easy.Puntuacion_1_1_a_1_9;

// Leer una palabra e imprimir su primera letra

import java.util.Scanner;

public class LubbiLaerir {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String palabra = scan.nextLine();
        System.out.println(palabra.charAt(0));

    }
}