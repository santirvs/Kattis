package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;


// Problema fácil de simulación por búsqueda completa.
// Como máximo se podrá multiplicar por 100, por lo que no hay peligro de bucle infinito.

import java.util.Scanner;

public class TheEasiestProblemIsThisOne {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            // Leer los datos de entrada
            int n = scan.nextInt();
            if (n == 0) {
                break; // Terminar si n es 0
            }

            int sumaDigitosN = sumaDigitos(n);

            for (int i = 11; ; i++) {
                int sumaDigitosNI = sumaDigitos(n*i);
                if (sumaDigitosNI == sumaDigitosN) {
                    System.out.println(i);
                    break; // Encontramos el primer número con la misma suma de dígitos
                }
            }
        }

    }

    private static int sumaDigitos(int n) {
        int suma = 0;
        while (n > 0) {
            suma += n % 10; // Sumar el último dígito
            n /= 10; // Eliminar el último dígito
        }
        return suma; // Devolver la suma de los dígitos
    }
}


