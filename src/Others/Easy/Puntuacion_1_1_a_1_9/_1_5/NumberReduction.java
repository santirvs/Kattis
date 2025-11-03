package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número
// Mientras el número no sea 1
// Si es par, dividir entre 2
// Si es impar, añadir el doble + 1
// Ir contando el número de vueltas del bucle
// Imprimir el contador

import java.util.Scanner;


public class NumberReduction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número
        int num = sc.nextInt();
        // Mientras el número no sea 1
        int contador = 0;
        while (num!=1) {
            // Si es par, dividir entre 2
            if (num%2==0) num = num/2;
            // Si es impar, añadir el doble + 1
            else  num += 2*num +1 ;
            // Ir contando el número de vueltas del bucle
            contador ++;
        }
        // Imprimir el contador
        System.out.println(contador);
        sc.close();
    }
}

