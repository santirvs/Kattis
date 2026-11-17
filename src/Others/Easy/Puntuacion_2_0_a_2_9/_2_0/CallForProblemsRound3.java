package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Leer la cantidad de problemas y la distancia mínima entre ellos
 * Leer todos los problemas
 * Ordenarlos por dificultad
 * Tomar el primero
 * Ir recorriendo la lista, saltándonos los que tengan una distancia menor que la esperada
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class CallForProblemsRound3 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numProblemas = sc.nextInt();
        int distancia = sc.nextInt();
        int[] problemas = new int[numProblemas];

        //Leer la dificultad de los problemas
        for (int i=0; i<numProblemas; i++) {
            problemas[i] = sc.nextInt();
        }

        //Ordenar
        Arrays.sort(problemas);

        //El de dificultad más baja siempre se coge
        int ultimaDificultad = problemas[0];
        int numProblemasSeleccionados = 1;


        //Descartar problemas con diferencia de dificultad menor a la esperada
        for (int i=1; i<numProblemas; i++) {
            if (problemas[i] - ultimaDificultad >= distancia) {
                numProblemasSeleccionados++;
                ultimaDificultad = problemas[i];
            }
        }

        //Mostrar el resultado
        System.out.println(numProblemasSeleccionados);

    }
}

