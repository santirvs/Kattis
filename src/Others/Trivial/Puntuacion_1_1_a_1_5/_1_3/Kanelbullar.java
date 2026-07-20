package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Dividir la cantidad que se tiene de cada ingrediente entre la cantidad necesaria
// Eso nos da la cantidad máxima que podemos hacer con ese ingrediente
// La respuesta será el mínimo de cada una de las cantidades de cada ingrediente

import java.util.Scanner;

public class Kanelbullar {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        final int NUM_INGREDIENTES = 5;

        //Leer los datos

        int[] receta = new int[NUM_INGREDIENTES];
        int[] cantidades = new int[NUM_INGREDIENTES];

        //Leer los 5 ingredientes de la receta
        for (int i=0; i<NUM_INGREDIENTES; i++) {
            receta[i] = scan.nextInt();
        }

        //Leer la cantidad s 5 ingredientes de la receta
        for (int i=0; i<NUM_INGREDIENTES; i++) {
            cantidades[i] = scan.nextInt();
        }

        //Revisar las cantidades y quedarnos con el mínimo
        int maxCantidad = Integer.MAX_VALUE;
        for (int i=0; i<NUM_INGREDIENTES; i++) {
            int cantidad = cantidades[i] / receta[i];
            maxCantidad = Math.min(maxCantidad, cantidad);
        }

        //Mostrar el resultado
        System.out.println(maxCantidad);

    }
}