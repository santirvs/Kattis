package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * La forma óptima es montar tantos 1s como pueda
 * y cuando me queden 3 montar un 7 al principio
 *
 * Dicho de otra forma:
 *    es par?  -> imprimir 1 y restar 2 a la cantidad pendiente
 *    es impar? --> imprimir 7 y restar 3 a la cantidad pendiente
 *    es 1 -> ya no se puede hacer nada más
 *
 */

import java.util.Scanner;

public class DigitDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cantidad = sc.nextInt();

        if (cantidad == 1) System.out.println("impossible");
        else {
            while (cantidad >= 2) {
                if (cantidad%2==1) {
                    System.out.print("7");
                    cantidad-=3;
                } else {
                    System.out.print("1");
                    cantidad-=2;
                }
            }
            System.out.println();
        }

    }
}