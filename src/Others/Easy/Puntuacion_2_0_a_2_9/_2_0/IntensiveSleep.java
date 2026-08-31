package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Hacer una ventana deslizante saltandose un máximo de k clases
 * Maximizar el período en el que dormir
 *
 */

import java.util.Scanner;

public class IntensiveSleep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int siguienteCompeticion = sc.nextInt();
        int numClases = sc.nextInt();
        int numKampanas = sc.nextInt();

        int[] inicios = new int[numClases+2];
        int[] finales = new int[numClases+2];

        //Caso especial: tengo 0 clases
        //Caso especial: puedo hacer todas las kampanas
        if (numKampanas >= numClases) {
            System.out.println(siguienteCompeticion);
            System.exit(0);
        }

        //Clases "fantasma"
        inicios[0] = Integer.MIN_VALUE;
        finales[0] = 0;
        inicios[numClases+1] = siguienteCompeticion;
        finales[numClases+1] = Integer.MAX_VALUE;

        //Leer los horarios de clases
        for (int i=1; i<=numClases; i++) {
            inicios[i] = sc.nextInt();
            finales[i] = sc.nextInt();
        }

        //Revisar las posibilidades saltandose k clases (ventana deslizante)
        int maxDuracion = 0;
        for (int i=numKampanas; i<=numClases; i++) {
            int duracion = inicios[i+1] - finales[i-numKampanas];
            maxDuracion = Math.max(duracion, maxDuracion);
        }

        //Mostrar el resultado
        System.out.println(maxDuracion);

    }
}