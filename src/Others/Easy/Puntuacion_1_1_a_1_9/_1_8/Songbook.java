package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Leer las duraciones (en segundos) y ordenarlas
 * Ir cogiendo por orden de menor a mayor y acumulando la duración
 * comprobando que no exceda el límite (en minutos)
 */


import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class Songbook {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        int tiempoLimite = sc.nextInt();
        tiempoLimite *=60;  //Pasar a segundos

        int numCanciones = sc.nextInt();

        int duracion =0;

        //Leer la duración de las canciones
        int[] duraciones = new int[numCanciones];

        for (int i=0; i < numCanciones ; i++) {
            duraciones[i] = sc.nextInt();
        }

        Arrays.sort(duraciones);
        boolean fin = false;

        for (int i=0; i < numCanciones && !fin ; i++)  {
            if (duracion + duraciones[i] <= tiempoLimite)
                duracion += duraciones[i];
            else fin = true;
        }

        System.out.println(duracion);

        sc.close();
    }
}

