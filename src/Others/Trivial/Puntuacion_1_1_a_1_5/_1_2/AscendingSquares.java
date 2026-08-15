package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Imprimir los cuadrados hasta n^2
// Tener en cuenta que puede llegar a ser 10^10 --> debe usarse long

import java.util.Scanner;

public class AscendingSquares {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        long num = scan.nextLong();
        System.out.print("[1");
        for (long i=2; i<=num; i++) {
            System.out.print( ", " + i*i );
        }
        System.out.println("]");


    }
}