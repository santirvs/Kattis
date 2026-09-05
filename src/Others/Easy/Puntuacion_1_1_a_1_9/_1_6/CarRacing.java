package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Calcular la media de las posiciones de cada elemento.
 * Quedarnos con la mejor
 */


import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;


public class CarRacing {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] sumaPosiciones = new int[5];
        int[] frecuencia = new int[5];

        //Leer los resultados de las partidas
        int numPartidas = sc.nextInt();
        while (numPartidas-- > 0) {
            int coche = sc.nextInt();
            int posicion = sc.nextInt();

            sumaPosiciones[coche-1] += posicion;
            frecuencia[coche-1]++;
        }

        //Calcular el que tiene mejor media
        int mejorCoche = 1;
        int mejorMedia = sumaPosiciones[0] / frecuencia[0];
        for (int c = 1; c<5; c++) {
            int media = sumaPosiciones[c] / frecuencia[c];
            if (media < mejorMedia) {
                mejorCoche = c+1;
                mejorMedia = media;
            }
        }

        //Mostrar el resultado
        System.out.println(mejorCoche);
        System.out.println(mejorMedia);

        sc.close();
    }
}

