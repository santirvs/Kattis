package Others.Trivial.Puntuacion_1_1_a_1_5._1_1;

// Restar los dos números e imprimir el resultado

import java.util.Scanner;

public class DragaFra {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numInicial = scan.nextInt();
        int numFinal = scan.nextInt();
        System.out.println(numInicial - numFinal);

    }
}