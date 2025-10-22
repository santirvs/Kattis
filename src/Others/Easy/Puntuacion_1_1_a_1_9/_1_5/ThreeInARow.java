package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el valor máximo que puede alcanzar un triplet
// Empezar por el triplet 1*2*3
// Mientras el triplet sea menor que el valor máximo
//     incrementar contador y la base del triplet
// Finalmente, mostrar el contador

import java.util.Scanner;


public class ThreeInARow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el valor máximo
        int maxValor = sc.nextInt();
        int contador = 0;
        int n = 1;
        // Calcular los triplets
        while ( (n * (n + 1) * (n + 2)) < maxValor) {
            contador++;
            n++;
        }

        // Mostrar el resultado
        System.out.println(contador);

        sc.close();
    }
}

