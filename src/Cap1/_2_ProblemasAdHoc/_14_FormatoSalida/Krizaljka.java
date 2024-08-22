package Cap1._2_ProblemasAdHoc._14_FormatoSalida;

import java.util.Locale;
import java.util.Scanner;

public class Krizaljka {

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        String horizontal = scan.next();
        String vertical = scan.next();

        //Crear el tablero y buscar el primer caracter coincidente
         char[][] tablero = new char[vertical.length()][horizontal.length()];
         int posH = 0;
         int posV = 0;
         boolean encontrado = false;

         for (int j=0; j<horizontal.length();j++) {
             for (int i = 0; i < vertical.length(); i++) {
                 tablero[i][j] = '.';

                 if (!encontrado && horizontal.charAt(j) == vertical.charAt(i)) {
                     posH = j;
                     posV = i;
                     encontrado = true;
                 }
             }
         }

         //Escribir la palabra horizontal en la fila posH
         tablero[posV] = horizontal.toCharArray();

         //Escribir la palabra vertical en la columna posV
         for (int i=0; i<vertical.length(); i++) {
             tablero[i][posH] = vertical.charAt(i);
         }

         //Mostrar el tablero
         for (int i=0; i<vertical.length(); i++) {
             for (int j=0; j<horizontal.length(); j++)
                 System.out.print(tablero[i][j]);
             System.out.println();
         }



    }
}


