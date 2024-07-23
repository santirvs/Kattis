package Cap1._1_ParaEmpezar._7_ArraysUnidimensionales;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Cetiri {

   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer las tres posiciones
        int[] posiciones = new int[3];
        for (int i = 0; i<3; i++) {
            posiciones[i] = scan.nextInt();
        }

        //Ordenar las posiciones
        Arrays.sort(posiciones);


        //Analizar las distancias
        int d1 = posiciones[1] - posiciones[0];
        int d2 = posiciones[2] - posiciones[1];
        if (d1 == d2) {
            //Si las posiciones son iguales, añadir un nuevo valor a la distancia del último
            System.out.println(posiciones[2] + d1);
        } else if (d1 > d2) {
            //Si el hueco entre 1o y 2o es mayor que entre 2o y 3o, añadir un nuevo valor a la d2 del primero
            System.out.println(posiciones[0] + d2);
        } else {
            //Si el hueco entre 1o y 2o es menor que entre 2o y 3o, añadir un nuevo valor a la d1 del segundo
            System.out.println(posiciones[1] + d1);
        }

    }
}
