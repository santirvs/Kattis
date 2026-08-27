package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 *
 */

import java.util.*;

public class MinesFootball {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numMeses = sc.nextInt();

        int maxPuntosPartido = Integer.MIN_VALUE;
        int minPuntosPartido = Integer.MAX_VALUE;

        int sumaMesMaximo = Integer.MIN_VALUE;
        int sumaMesMinimo = Integer.MAX_VALUE;

        while (numMeses-- > 0) {
            int numPartidos = sc.nextInt();
            int sumaMes = 0;

            while (numPartidos-- > 0) {

                int numPuntos = sc.nextInt();
                sumaMes += numPuntos;

                maxPuntosPartido = Math.max(maxPuntosPartido, numPuntos);
                minPuntosPartido = Math.min(minPuntosPartido, numPuntos);
            }

            //Actualizar el total de puntos del mes, si es necesario
            sumaMesMaximo = Math.max(sumaMesMaximo, sumaMes);
            sumaMesMinimo = Math.min(sumaMesMinimo, sumaMes);
        }

        System.out.println(maxPuntosPartido);
        System.out.println(minPuntosPartido);
        System.out.println(sumaMesMaximo);
        System.out.println(sumaMesMinimo);

    }
 }