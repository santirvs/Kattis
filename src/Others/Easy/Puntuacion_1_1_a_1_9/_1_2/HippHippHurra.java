package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer el nombre y la cantidad de veces que se debe imprimir "Hipp, Hipp, hurra"
// Imprimir "Hipp hipp hurra " y el nombre la cantidad de veces indicada

import java.util.Scanner;

public class HippHippHurra {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String nombre = scan.next();
        int numVeces = scan.nextInt();

        // Imprimir "Hipp, Hipp, hurra " y el nombre la cantidad de veces indicada
        for (int i = 0; i < numVeces; i++) {
            System.out.println("Hipp hipp hurra, " + nombre + "!");
        }


    }
}