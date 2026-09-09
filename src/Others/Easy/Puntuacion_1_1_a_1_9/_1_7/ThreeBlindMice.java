package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Tipico problema del choque de trenes, pero con ratones.
 * Calcular la distancia de ida y vuelta de cada uno de los ratones por separado y sumarlos
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class ThreeBlindMice {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        double distancia = sc.nextDouble();

        double velEsposa = sc.nextDouble();
        double velRaton1 = sc.nextDouble();
        double velRaton2 = sc.nextDouble();
        double velRaton3 = sc.nextDouble();

        double distanciaTotal = 0;
        distanciaTotal += resuelve(distancia, velEsposa, velRaton1);
        distanciaTotal += resuelve(distancia, velEsposa, velRaton2);
        distanciaTotal += resuelve(distancia, velEsposa, velRaton3);

        System.out.println( Math.round(distanciaTotal));

    }

    static double resuelve(double distancia, double vel1, double vel2) {

        double tiempo = distancia / (vel1+vel2);

        double distancia2 = 2*vel2*tiempo;

        return distancia2;
    }
}

