package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Sumar la cantidad de caramelos y ver si es divisible entre la cantidad de niños
 *
 * El problema es que cada niño puede tener hasta 2^63, por lo que si 2 niños tienen 2^63 caramelos
 * ya no vamos a poderlos sumar.
 * Solución: hay dos opciones
 * a) usar BigInteger
 * b) sumar sólo el módulo
 *
 *
 */

import java.io.IOException;
import java.util.Scanner;


public class AnotherCandies {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();
        sc.nextLine();

        while (numCasos-- > 0) {

            sc.nextLine();

            int numNinos = sc.nextInt();
            int suma = 0;
            for (int i=1; i <= numNinos; i++) {
                long caramelos = sc.nextLong();
                suma = (suma +  (int)(caramelos % numNinos)) % numNinos;
            }

            if (suma == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}

