package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Calcular el tiempo que tardará un caballo en recorrer la distancia
 * y quedarnos con el mínimo
 * Tiempo = min(stamina, distancia) a máxima velocidad + (distancia-stamina) a la mitad de velocidad si es que no
 * se llegó a la meta
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class HorseRacing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCaballos = sc.nextInt();
        int distancia = sc.nextInt();

        double tiempoMinimo = Double.MAX_VALUE;
        int mejorCaballo = 0;

        for (int i=0; i<numCaballos; i++) {
            int maxVelocidad = sc.nextInt();
            int stamina = sc.nextInt();
            double tiempo = 0.0;

            int distanciaMaxVelocidad = Math.min(stamina, distancia);

            tiempo = distanciaMaxVelocidad / maxVelocidad;
            if (distanciaMaxVelocidad < distancia) {
                //Recorrer a la mitad de velocidad el resto de la carrera
                tiempo += (distancia - distanciaMaxVelocidad) / (maxVelocidad / 2);
            }

            if (tiempo < tiempoMinimo) {
                mejorCaballo = i;
                tiempoMinimo = tiempo;
            }

        }

        System.out.println(mejorCaballo);


    }
}