package Others.Easy.Puntuacion_2_0_a_2_9._2_3;

/*
    El problema es equivalente a buscar la cantidad de factores primos en los
    que se puede descomponer un número entero
 */

import java.util.Scanner;

public class AListGame {

    public static int countTotalPrimeFactors(int n) {
        int count = 0;

        // Contar todas las veces que el 2 divide a n
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }

        // Contar todas las veces que los números impares dividen a n
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                count++;
                n /= i;
            }
        }

        // Si n restante es mayor que 2, es primo
        if (n > 2) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero = sc.nextInt();

        System.out.println(countTotalPrimeFactors(numero));

    }
}
