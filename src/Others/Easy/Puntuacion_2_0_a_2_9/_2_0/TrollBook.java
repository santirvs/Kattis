package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Guardar el texto en un array de Strings
 * Guardar cada palabra en su posición
 * Recorrer el array para imprimir el resultado
 *
 */

import java.util.Scanner;

public class TrollBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer el número de palabras y
        // definir el array de String donde se guardarán
        int numPalabras = sc.nextInt();
        String[] texto = new String[numPalabras];

        //Leer las palabras y guardarlas en la posición indicada
        for (int i=0; i<numPalabras; i++) {
            String palabra = sc.next();
            int posicion = sc.nextInt();

            texto[posicion-1] = palabra;
        }

        //Recorrer el array para imprimir las palabras
        for (int i=0; i<numPalabras;i++) {
            if (i>0) System.out.print(" ");
            System.out.print(texto[i]);
        }

    }
}
