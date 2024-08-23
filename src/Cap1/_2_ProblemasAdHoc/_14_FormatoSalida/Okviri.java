package Cap1._2_ProblemasAdHoc._14_FormatoSalida;

import java.util.Locale;
import java.util.Scanner;

public class Okviri {

    public static void rellenaLinea(char[] linea, int inicio, int intervalo) {
        for (int i=0; i <linea.length; i++)
            linea[i] = '.';
        for (int i=inicio; i < linea.length; i+=intervalo) {
            char c = '#';
            if ((i-1)%12 >= 7 && (i-1)%12 <=11) c = '*';
            //si es la última posición de la última letra, no hay solapamiento con *
            if ( (i-1)%12 == 7 && (i == linea.length-1))
                c = '#';
            linea[i] = c;
        }
    }

    public static void rellenaPalabra(char[] linea, String palabra) {
        for (int i=0; i<palabra.length(); i++) {
            linea[2+i*4] = palabra.charAt(i);
        }
    }
     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la palabra
        String palabra = scan.nextLine();

        //Crear el tablero
         char[][] tablero = new char[5][1+palabra.length()*4];

         //Rellenar el tablero
         rellenaLinea(tablero[0], 2, 4);
         rellenaLinea(tablero[1], 1, 2);
         rellenaLinea(tablero[2], 0, 4);
         rellenaLinea(tablero[3], 1, 2);
         rellenaLinea(tablero[4], 2, 4);

         //Escribir palabra en tablero
         rellenaPalabra(tablero[2], palabra);

         //Mostrar tablero
         for (int i=0; i<tablero.length; i++) {
             for (int j=0; j<tablero[0].length; j++) {
                 System.out.print(tablero[i][j]);
             }
             System.out.println();
         }

    }
}


