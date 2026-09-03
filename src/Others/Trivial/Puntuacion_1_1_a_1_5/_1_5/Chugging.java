package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Iterar N veces y calcular el tiempo acumulado

import java.util.Scanner;


public class Chugging {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numBotellas = sc.nextInt();

        //Alice
        int tA = sc.nextInt();
        int dA = sc.nextInt();
        int penalizacionA = 0;
        int tiempoAlice = 0;
        for (int i=0; i<numBotellas; i++) {
            tiempoAlice += tA + penalizacionA;
            penalizacionA += dA;
        }

        //Bob
        int tB = sc.nextInt();
        int dB = sc.nextInt();
        int penalizacionB = 0;
        int tiempoBob = 0;
        for (int i=0; i<numBotellas; i++) {
            tiempoBob += tB + penalizacionB;
            penalizacionB += dB;
        }

        if (tiempoBob > tiempoAlice) System.out.println("Alice");
        else if (tiempoBob < tiempoAlice) System.out.println("Bob");
        else System.out.println("=");

        sc.close();
    }
}

