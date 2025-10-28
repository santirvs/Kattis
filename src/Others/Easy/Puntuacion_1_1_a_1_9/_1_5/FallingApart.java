package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de pedazos
// Leer los pedazos en un array
// Ordenar el array
// Sumar las posiciones pares e impares por separado
// Imprimir la suma de los pares seguido de la suma de los pares

import java.util.Scanner;

public class FallingApart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de pedazos
        int numPedazos = sc.nextInt();

        // Leer los pedazos en un array
        Integer[] pedazos = new Integer[numPedazos];
        for (int i = 0; i < numPedazos; i++) {
            pedazos[i] = sc.nextInt();
        }

        // Ordenar el array
        java.util.Arrays.sort(pedazos, java.util.Collections.reverseOrder());

        // Sumar las posiciones pares e impares por separado
        int sumaPares = 0;
        int sumaImpares = 0;
        for (int i = 0; i < numPedazos; i++) {
            if (i % 2 == 0) {
                sumaPares += pedazos[i];
            } else {
                sumaImpares += pedazos[i];
            }
        }

        // Imprimir la suma de los pares seguido de la suma de los impares
        System.out.println(sumaPares + " " + sumaImpares);

        sc.close();

    }
}

