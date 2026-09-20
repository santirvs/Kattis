package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Hay cambio de saque cada N rondas, por lo que vuelve a sacar Paul
 * cada 2*N puntos
 */

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class PaulEigon {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();

        int puntos = (P+Q) % (2*N);

        if (puntos < N) System.out.println("paul");
        else System.out.println("opponent");


        sc.close();
    }
}

