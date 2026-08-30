package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Leer los tiempos en que tardan en crecer los árboles
 * Ordenarlos de mayor a menor
 * Tener en cuenta que cada día solo podemos plantar uno
 * La fiesta se realiza al día siguiente de haber crecido todos
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class PlantingTrees {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numArboles = sc.nextInt();

        // 1.- Leer los tiempos de crecimiento de cada árbol
        int[] tiempos = new int[numArboles];
        for (int i=0; i<numArboles; i++) {
            tiempos[i] = sc.nextInt();
        }

        // 2. Ordenar (de forma ascendente)
        Arrays.sort(tiempos);

        // 3. Invertir el array para que quede de forma descendente
        for (int i = 0; i < tiempos.length / 2; i++) {
            int temp = tiempos[i];
            tiempos[i] = tiempos[tiempos.length - 1 - i];
            tiempos[tiempos.length - 1 - i] = temp;
        }

        // 4. Recorrer el array y guardar el instante máximo de crecimiento
        int maxCrecimiento = Integer.MIN_VALUE;
        for (int i=0; i < tiempos.length; i++) {
            maxCrecimiento = Math.max( maxCrecimiento, i+1 + tiempos[i]);
        }

        // 5. El día de la fiesta será el día siguiente al que haya crecido el último
        System.out.println(maxCrecimiento+1);


        sc.close();
    }
}

