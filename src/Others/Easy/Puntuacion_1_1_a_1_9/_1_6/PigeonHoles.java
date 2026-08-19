package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Teorema de las casillas.
 * Si hay más objetos que casillas, obligatoriamente en alguna casilla
 * habrá más de un objeto.
 */

import java.io.IOException;
import java.util.Scanner;


public class PigeonHoles {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numObjetos = sc.nextInt();
        int numCasillas = sc.nextInt();

        if (numObjetos > numCasillas)
            System.out.println("Dufur passa ekki");
        else if (numObjetos == numCasillas)
            System.out.println("Dufur passa fullkomlega");
        else
            System.out.println("Dufur passa");

        sc.close();
    }
}

