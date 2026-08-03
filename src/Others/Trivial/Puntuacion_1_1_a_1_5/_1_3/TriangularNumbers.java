package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Dado un número imprimir las sumas desde 1 hasta N

import java.util.Scanner;

public class TriangularNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int suma = 0;
        for (int i=1; i<=num; i++) {
            suma += i;
            System.out.println(suma);
        }
    }
}