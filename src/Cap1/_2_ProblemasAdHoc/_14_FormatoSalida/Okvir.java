package Cap1._2_ProblemasAdHoc._14_FormatoSalida;

import java.util.Locale;
import java.util.Scanner;

public class Okvir {

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int numPalabras = scan.nextInt();
        int numLetras = scan.nextInt();

        //Leer el marco
         int up = scan.nextInt();
         int left = scan.nextInt();
         int right = scan.nextInt();
         int down = scan.nextInt();

         //Calcular el tamaño del tablero
         int ancho = numLetras + right + left;
         int alto = numPalabras + up + down;

         //Crear el tablero
         char[][] tablero = new char[alto][ancho];
         for (int i=0; i<alto; i++) {
             for (int j = 0; j < ancho; j++) {
                 char c = (i + j) % 2 == 0 ? '#' : '.';
                 tablero[i][j] = c;
             }
         }

         //Leer las palabras y guardarlas en el tablero
         scan.nextLine();
         for (int i=0; i<numPalabras; i++) {
             String palabra = scan.nextLine();
             for (int j=0; j<numLetras; j++) {
                 tablero[up+i][left+j] = palabra.charAt(j);
             }
         }

         //Mostrar el tablero
         for (int i=0; i<tablero.length; i++) {
             System.out.println(tablero[i]);
         }
    }
}


