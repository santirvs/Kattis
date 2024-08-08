package Cap1._2_ProblemasAdHoc._3_Juegos_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class Trik {


     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         char[] posiciones = new char[3];
         posiciones[0] = '1';
         posiciones[1] = '0';
         posiciones[2] = '0';

         String movimientos = scan.next();
         for (int i=0; i<movimientos.length(); i++) {
                switch (movimientos.charAt(i)) {
                    case 'A':
                        //Cambiar posiciones 0 y 1
                        char auxA = posiciones[0];
                        posiciones[0] = posiciones[1];
                        posiciones[1] = auxA;
                        break;
                    case 'B':
                        //Cambiar posiciones 1 y 2
                        char auxB = posiciones[1];
                        posiciones[1] = posiciones[2];
                        posiciones[2] = auxB;
                        break;
                    case 'C':
                        //Cambiar posiciones 0 y 2
                        char auxC = posiciones[0];
                        posiciones[0] = posiciones[2];
                        posiciones[2] = auxC;
                        break;
                }
         }

         //mostrar el resultado
         System.out.println(posiciones[0]=='1'?1:posiciones[1]=='1'?2:3);

     }

}
