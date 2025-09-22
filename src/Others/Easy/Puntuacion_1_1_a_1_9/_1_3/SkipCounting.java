package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer el número de entrada
// Hacer un bucle desde 1 hasta 12
// A cada vuelta del bucle, imprimir el número por el índice del bucle

import java.util.Scanner;

public class SkipCounting {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número
        int num = sc.nextInt();

        //Bucle desde 1 hasta 12
        for (int i=1; i <= 12; i++) {
            //Imprimir el valor
            System.out.println(i*num);
        }

        sc.close();
    }
}

