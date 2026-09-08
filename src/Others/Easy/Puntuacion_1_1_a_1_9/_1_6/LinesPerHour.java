package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Ordenar los problemas de menor a mayor
 * Ir sumando las líneas de código hasta alcanzar el máximo
 */


import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class LinesPerHour {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Leer los datos
        int numProblemas = sc.nextInt();
        int maxLineas = sc.nextInt() * 5;  //lph * 5 horas de concurso

        //Cargar la duración de todos los problemas
        int[] problemas = new int[numProblemas];
        for (int i=0; i<numProblemas; i++) {
            problemas[i] = sc.nextInt();
        }

        //Ordenar los problemas de menor a mayor
        Arrays.sort(problemas);

        //Sumar las loc de los problemas
        int locTotal = 0;
        int problema = 0;
        while (problema < numProblemas && (locTotal + problemas[problema]) <= maxLineas ) {
            locTotal += problemas[problema];
            problema++;
        }

        //Mostrar el resultado
        System.out.println(problema);

        sc.close();
    }
}

