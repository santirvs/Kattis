package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer las palabras
// Guardarlas en un array de Strings
// Dar la vuelta a cada palabra antes de añadirla al array
// Ordenar el array
// Imprimir desde el final

import java.util.Arrays;
import java.util.Scanner;


public class UpsideDown {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de clases
        int numPalabras = sc.nextInt();
        String[] palabras = new String[numPalabras];

        for (int i=0; i<numPalabras; i++) {
            StringBuilder palabra = new StringBuilder();
            palabra.append(sc.next());
            palabra.reverse();
            palabras[i] = palabra.toString();
        }

        //Ordenar el array
        Arrays.sort(palabras);

        //Recorrer el array desde el final hasta el inicio
        boolean primero=true;
        for (int pos=palabras.length-1; pos>=0; pos--) {
            if (primero) primero=false;
            else System.out.print(" ");
            System.out.print(palabras[pos]);
        }
        System.out.println();

        sc.close();
    }
}

