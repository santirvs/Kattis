package Others.Easy.Puntuacion_1_1_a_1_9._1_5;


/*
    Leer la lista de personas
    Recorrerla de atras hacia delante.
    Mostrar todos aquellos que sean más altos que el último más alto,
    añadirlos a una lista y mostrarlos en orden opuesto

 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class StreetArtist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numPersonas = sc.nextInt();

        String[] nombres = new String[numPersonas];
        int[] alturas = new int[numPersonas];

        //Leer nombres y alturas
        for (int i=0; i<numPersonas; i++) {
            nombres[i] = sc.next();
            alturas[i] = sc.nextInt();
        }

        //Recorrer las alturas en orden inverso
        int maxAltura = 0;
        for (int i=numPersonas-1; i>=0; i--) {
            if (alturas[i] > maxAltura) {
                maxAltura = alturas[i];
            } else {
                nombres[i] = "";  //"Marcar" como eliminado
            }
        }

        //Recorrer los nombres
        boolean primero = true;
        for (int i=0; i<numPersonas; i++) {
            if (!nombres[i].equals("")) {
                if (!primero) System.out.print(" ");
                else primero = false;
                System.out.print(nombres[i]);
            }
        }
        System.out.println("");

    }
}
