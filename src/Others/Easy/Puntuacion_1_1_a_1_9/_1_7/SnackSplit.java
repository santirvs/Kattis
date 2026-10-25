package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Dividir el peso entre el número de personas más 1 (Grace)
 */

import java.util.Scanner;

public class SnackSplit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        while (numCasos-- >0) {
            int peso = sc.nextInt();
            int numPersonas = sc.nextInt() + 1;

            System.out.println(peso / numPersonas);
         }
    }
}