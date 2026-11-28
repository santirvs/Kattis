package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.util.Arrays;
import java.util.Scanner;

public class RecessRocks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numAlumnos = sc.nextInt();
        int[] alumnos = new int[numAlumnos];

        //Leer las piedras que lleva cada alumno
        for (int i=0; i<numAlumnos; i++) {
            alumnos[i] = sc.nextInt();
        }

        //Ordenar de menor a mayor
        //Esto elimina el problema de que un alumno llore porque otro delante suyo tenga más piedras
        Arrays.sort(alumnos);

        //Ahora sólo nos debemos preocupar de contar los alumnos que llorarán porque otro alumno delante
        //suyo tenga el mismo número de piedras

        int numAlumnosLlorando = 0;
        int maxPiedras = 0;
        for (int i=0; i<numAlumnos; i++) {
            int numPiedras = alumnos[i];
            if (numPiedras == maxPiedras) numAlumnosLlorando++;
            maxPiedras = Math.max(maxPiedras, numPiedras);
        }

        System.out.println(numAlumnosLlorando);
    }
}
