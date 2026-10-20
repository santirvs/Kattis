package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DomeConstruction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        int numNubes = sc.nextInt();
        int numNecesarias = sc.nextInt();

        double[] distancias = new double[numNubes];

        for (int i=0; i<numNubes; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double z = sc.nextDouble();

            //Suponer que el centro está en 0,0
            double distancia = Math.sqrt( x*x + y*y + z*z );

            distancias[i] = distancia;
        }

        //Ordenar las distancias
        Arrays.sort(distancias);

        //La distancia ordenada en posicion numNecesarias-1 es la solución
        System.out.println(distancias[numNecesarias-1]);
    }
}