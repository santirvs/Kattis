package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Hacer una regla de 3 para cada ingrediente
 * Nos aseguran que van a ser números enteros
 * y que son menores de 40.000
 * por lo que 40.000 * 40.000 cabe en un un Int
 */

import java.io.IOException;
import java.util.Scanner;

public class ScalingRecipe {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numIngredientes = sc.nextInt();
        int numPorcionesResultantes =sc.nextInt();
        int numPorcionesNecesarias = sc.nextInt();

        for (int i=0; i<numIngredientes; i++) {
            int cantidad = sc.nextInt();
            System.out.println(cantidad * numPorcionesNecesarias / numPorcionesResultantes);
        }


        sc.close();
    }
}