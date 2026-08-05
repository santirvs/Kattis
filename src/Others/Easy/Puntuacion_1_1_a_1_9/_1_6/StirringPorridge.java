package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Por ser < de 10^6 se puede intentar por fuerza bruta ( TL: 1seg)
 * Si da TLE se puede hacer por búsqueda binaria
 */


import java.io.IOException;
import java.util.Scanner;


public class StirringPorridge {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int segundosVuelta = 1;
        int numVueltas = 0;

        while (n >= segundosVuelta) {
            n -= segundosVuelta;
            numVueltas++;
            segundosVuelta++;
        }

        System.out.println(numVueltas);

        sc.close();
    }
}

