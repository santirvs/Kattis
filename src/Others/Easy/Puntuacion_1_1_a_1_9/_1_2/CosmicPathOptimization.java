package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer los valores y calcular la media

import java.util.Scanner;

public class CosmicPathOptimization {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numMediciones = scan.nextInt();
        int sumaMediciones = 0;

        for (int i = 1; i <= numMediciones; i++) {
            sumaMediciones += scan.nextInt();
        }

        //Mostrar la media
        System.out.println(sumaMediciones / numMediciones);

    }
}