package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Escribir sh y tantas h adicionales como nos pidan

import java.util.Scanner;

public class Regarde {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();
        while (numCasos-- > 0) {
            int numHs = scan.nextInt();
            System.out.print("sh");
            for (int i = 0; i < numHs; i++) {
                System.out.print("h");
            }
            System.out.println();
        }

    }
}