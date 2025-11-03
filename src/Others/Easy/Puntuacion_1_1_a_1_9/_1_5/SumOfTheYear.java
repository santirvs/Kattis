package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número
// Hacer un bucle desde 1 hasta número
// Comprobar si los dígitos del número cumplen que (1+ ... +n)^2 = 1^3 + ... + n^3
// Contar los que se cumplen
// Imprimir el contador de los que se cumplen

import java.util.Scanner;


public class SumOfTheYear {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número
        int num = sc.nextInt();
        // Hacer un bucle desde 1 hasta número
        int sumaNumeros = 0;
        int sumaCubos = 0;
        int contador = 0;
        for (int i = 1; i <= num; i++) {
            sumaNumeros += i;
            sumaCubos += i*i*i;
            // Comprobar si los dígitos del número cumplen que (1+ ... +n)^2 = 1^3 + ... + n^3
            if ((sumaNumeros * sumaNumeros) == sumaCubos) {
                // Contar los que se cumplen
                contador++;
            }

        }
        // Imprimir el contador de los que se cumplen
        System.out.println(contador);

        sc.close();
    }
}

