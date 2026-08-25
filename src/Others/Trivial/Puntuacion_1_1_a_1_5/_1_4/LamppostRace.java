package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

/**
 * Sumar los valores absolutos de la resta de las posiciones
 * entre dos farolas
 */

import java.util.Scanner;

public class LamppostRace {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numFarolas = sc.nextInt();
        int posA = 0;
        int distanciaTotal = 0;

        while (numFarolas-- >0) {
            int posB = sc.nextInt();
            distanciaTotal += Math.abs(posA-posB);
            posA = posB;
        }

        System.out.println(distanciaTotal);
    }
}

