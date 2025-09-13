package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer el número de cerillas y las dimensiones de la caja
// Leer cada una de las cerillas y determinar si caben en la caja
// Pueden caber si la longitud de la cerilla es menor o igual a la diagonal de la caja (sqrt(n^2 + m^2))
// Imprimir "DA" si caben y "NE" si no caben

import java.util.Scanner;

public class Sibice {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Leer los datos
        int k = scan.nextInt();
        int n = scan.nextInt();
        int m = scan.nextInt();
        double diagonal = Math.sqrt(n * n + m * m);
        for (int i = 0; i < k; i++) {
            int cerilla = scan.nextInt();
            if (cerilla <= diagonal) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }

    }
}