package Cap1._2_ProblemasAdHoc._2_Juegos_Ajedrez;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class EmagEhtHtiwEmPleh {


     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         char[][] tablero = new char[17][33];

         //Montar el tablero
         tablero[0] = "+---+---+---+---+---+---+---+---+".toCharArray();
         for (int i = 1; i <= 8; i++) {
             if (i%2==1) {
                 tablero[2*i-1] = "|...|:::|...|:::|...|:::|...|:::|".toCharArray();
             } else {
                 tablero[2*i-1] = "|:::|...|:::|...|:::|...|:::|...|".toCharArray();
             }
             tablero[2*i] = "+---+---+---+---+---+---+---+---+".toCharArray();
         }

         //Leer las piezas
         for (int i=0; i<2; i++) {
             String linea = scan.nextLine();
             if (linea.split(" ").length > 1) {

                 String[] piezas = linea.split(" ")[1].split(",");

                 for (String pieza : piezas) {
                     char c;
                     int fila = 0;
                     int columna = 0;
                     if (pieza.length() == 2) {
                         //Es un peón
                         fila = 2 * (pieza.charAt(1) - '1') + 1;
                         columna = 4 * (pieza.charAt(0) - 'a') + 2;
                         c = 'P';
                     } else {
                         //Es una pieza no peón
                         fila = 2 * (pieza.charAt(2) - '1') + 1;
                         columna = 4 * (pieza.charAt(1) - 'a') + 2;
                         c = pieza.charAt(0);
                     }

                     if (i == 1) {
                         //Es pieza negra, hay que pasar a minúsculas
                         c -= 'A' - 'a';
                     }
                     tablero[16 - fila][columna] = c;
                 }
             }
         }
         //Mostrar el tablero
        for (int i=0; i<17; i++) {
            System.out.println(tablero[i]);
        }


     }


}



