package Cap2._2_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.Locale;
import java.util.Scanner;

/**
 * No entiendo que hace este problema en la categoria de "ordenacion dificil" ya que no se ordena nada.
 *
 * Miro en Methods To Solve y proponen ordenar la matriz por columnas. Lo encuentro un poco rebuscado, pero efectivo.
 *
 */

public class ChartingProgress {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);
        int numEstrellasTotal = 0;

        //Lectura de datos
        while (scan.hasNext()) {
            String linea = scan.nextLine();
            if (linea.equals("")) {
                System.out.println();
                numEstrellasTotal = 0;
            } else {
                char[] lista = linea.toCharArray();
                int numEstrellas=0;
                for (int i = 0; i < linea.length(); i++) {
                    if (lista[i] == '*') {
                        numEstrellas++;
                    }
                }
                for (int i = 0; i < lista.length; i++) {
                   if (i < lista.length - numEstrellasTotal - numEstrellas || i >= lista.length - numEstrellasTotal) {
                       System.out.print(".");
                   } else {
                       System.out.print("*");
                   }
                }
                System.out.println();
                numEstrellasTotal += numEstrellas;
            }
        }

    }


}