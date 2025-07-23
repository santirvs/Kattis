package Cap3._2_BusquedaCompleta._1_CalculoPrevio;

import java.util.Scanner;

// Nos piden calcular el último digito del factorial de un número entre 1 y 10.
// Basta con guardarnos las 10 posibles soluciones. No hace falta calcularlo.

public class LastFactorialDigit {



    // Ejecutar el código con los valores predefinidos de m[i]
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soluciones[] = {1, 1, 2, 6, 4, 0, 0, 0, 0, 0, 0}; // Último dígito del factorial de 0 a 10

        int numCasos = scanner.nextInt();
        while (numCasos-- > 0) {
            int n = scanner.nextInt();
            System.out.println(soluciones[n]); // n-1 porque el array empieza en 0
        }
    }
}
