package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer la cantidad de hoteles
// Leer las distancias a los hoteles e ir contando cuantas distancias hay entre 2 y 12 (que son las que se pueden alcanzar con dos dados de 6 caras)
// La probabilidad de caer en un hotel es la suma de las probabilidades de caer en ese hotel dividido entre 36 (total de combinaciones posibles con dos dados de 6 caras)
// No se dice nada respecto a si hay distancias repetidas, así que se cuentan todas las distancias
// Mostrar la probabilidad con 2 decimales

import java.util.Scanner;

public class Monopoly {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        //Construir la tabla de probabilidades de sacar cada suma con dos dados de 6 caras
        int[] prob = new int[13]; // prob[i] = número de combinaciones para obtener la suma i
        // int[] prob = {0, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1}; // prob[i] = número de combinaciones para obtener la suma
        // int totalCombinations = 36; // Total de combinaciones posibles con dos dados
        for (int dado1 = 1; dado1 <= 6; dado1++) {
            for (int dado2 = 1; dado2 <= 6; dado2++) {
                int suma = dado1 + dado2;
                // System.out.println("Suma: " + suma + " Combinación: (" + dado1 + ", " + dado2 + ")");
                prob[suma]++; // Incrementar el contador para esta suma
            }
        }

        //Leer los datos
        int n = scan.nextInt();
        boolean distancias[] = new boolean[13]; // Array para marcar las distancias alcanzables
        int count = 0;
        for (int i = 0; i < n; i++) {
            int distance = scan.nextInt();
            distancias[distance] = true; // Marcar la distancia como alcanzable
        }

        // Contar las distintas distancias alcanzables entre 2 y 12
        for (int i = 2; i <= 12; i++) {
            if (distancias[i]) {
                count+=prob[i];
            }
        }

        // Calcular la probabilidad
        double probability = (double) count / 36.0;

        // Mostrar el resultado con 4 decimales
        System.out.printf("%.4f%n", probability);

    }
}