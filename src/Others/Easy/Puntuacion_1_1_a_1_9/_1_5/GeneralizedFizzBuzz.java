package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer cantidad de números
// Leer los números a y b
// Hacer un bucle desde 1 hasta la cantidad de números
//     Si el número es divisible por a y b, contar "FizzBuzz"
//     Si el número es divisible por a, contar "Fizz"
//     Si el número es divisible por b, contar "Buzz"
//     Si no, no contar el número
//     Acumular a los totales y seguir contando
// Imprimir los totales de Fizz, Buzz y FizzBuzz

import java.util.Scanner;


public class GeneralizedFizzBuzz {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer cantidad de números
        int cantidadNumeros = sc.nextInt();
        // Leer los números a y b
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Inicializar contadores individuales
        int fizzCount = 0;
        int buzzCount = 0;
        int fizzBuzzCount = 0;

        // Hacer un bucle desde 1 hasta la cantidad de números
        for (int i = 1; i <= cantidadNumeros; i++) {

            boolean divisiblePorA = (i % a == 0);
            boolean divisiblePorB = (i % b == 0);
            // Si el número es divisible por a y b, contar "FizzBuzz"
            if (divisiblePorA && divisiblePorB) {
                fizzBuzzCount++;
            }
            // Si el número es divisible por a, contar "Fizz"
            else if (divisiblePorA) {
                fizzCount++;
            }
            // Si el número es divisible por b, contar "Buzz"
            else if (divisiblePorB) {
                buzzCount++;
            }
            // Si no, no contar el número
        }

        // Imprimir los totales de Fizz, Buzz y FizzBuzz
        System.out.println(fizzCount + " " + buzzCount + " " + fizzBuzzCount);

        sc.close();
    }
}

