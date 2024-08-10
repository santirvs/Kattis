package Cap1._2_ProblemasAdHoc._5_VidaReal_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class Wertyu {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Crear un mapa del teclado
         String teclado = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

         //Procesar cada línea mientras hayan lineas
         String linea;
         while (scan.hasNextLine()) {
             linea = scan.nextLine();
             for (int i = 0; i < linea.length(); i++) {
                 if (linea.charAt(i) == ' ') {
                     //El espacio no se traduce
                     System.out.print(" ");
                 } else {
                     //Buscar la posición de la letra en el teclado y mostrar la letra anterior
                     int posicion = teclado.indexOf(linea.charAt(i));
                     System.out.print(teclado.charAt(posicion - 1));
                 }
             }
             System.out.println();
         }

     }

}
