package Cap1._2_ProblemasAdHoc._2_Juegos_Ajedrez;

import java.util.Locale;
import java.util.Scanner;

public class Bijele {


     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Leer las piezas
         for (int i=1; i<=6; i++) {
             int numPiezas = scan.nextInt();
             switch (i) {
                 case 1,2: System.out.print((1-numPiezas)+ " "); break;
                 case 3,4,5: System.out.print((2-numPiezas)+ " "); break;
                 case 6: System.out.println((8-numPiezas)); break;
             }
         }

     }


}



