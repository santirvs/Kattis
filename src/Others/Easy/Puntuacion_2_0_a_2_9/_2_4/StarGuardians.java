package Others.Easy.Puntuacion_2_0_a_2_9._2_4;


/**
 * Leer el incremento de problemas por tener un equipo de i miembros
 * Leer los problemas que puede resolver cada miembro
 * Ordenar las lista de problemas que puede resolver cada miembro
 * Escoger los N primeros miembros que resuelven más problemas
 * Quedarnos con la mejor media de problemas resueltos por
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StarGuardians {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numMiembros = sc.nextInt();

        //Leer los problemas adicionales
        int[] adicionales = new int[numMiembros];
        for (int i=0; i<numMiembros; i++) {
            adicionales[i] = sc.nextInt();
        }

        //Leer los problemas que es capaz de resolver cada miembro
        Integer[] individual = new Integer[numMiembros];  // Usar Integer para poder ordenar de forma descendiente
        for (int i=0; i<numMiembros; i++) {
            individual[i] = sc.nextInt();
        }

        //Ordenar la lista de problemas individual
        Arrays.sort(individual, Collections.reverseOrder());


        //Buscar la mejor media
        double mejorMedia = 0.0;
        int sumaProblemasIndividuales = 0;
        for (int i=0; i<numMiembros; i++) {
            sumaProblemasIndividuales += individual[i];
            double totalProblemas = sumaProblemasIndividuales + adicionales[i];
            double media = totalProblemas / (i+1);
            mejorMedia = Math.max(mejorMedia, media);
        }

        //Mostrar el resultado
        System.out.printf("%.6f",mejorMedia);


    }
}