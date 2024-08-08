package Cap1._2_ProblemasAdHoc._3_Juegos_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class GuessingGame {


     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         int num = scan.nextInt();

         while (num!=0) {
             boolean[] numsPosibles = new boolean[11];
             for (int i=0; i<11; i++) {
                    numsPosibles[i] = true;
             }
             scan.nextLine();
             String respuesta = scan.nextLine();

             while (respuesta.equals("right on")==false) {
                 //Si es demasiado alto, todos los números mayores que el que ha dicho Stan no son posibles
                 if (respuesta.equals("too high")) {
                     for (int i=num; i<11; i++) {
                         numsPosibles[i] = false;
                     }
                 } else {
                     //Si es demasiado bajo, todos los números menores que el que ha dicho Stan no son posibles
                     for (int i=num; i>0; i--) {
                         numsPosibles[i] = false;
                     }
                 }
                 //Siguiente número y respuesta
                 num= scan.nextInt();
                 scan.nextLine();
                 respuesta = scan.nextLine();
             }

             //El número que ha dicho Stan está dentro de los posibles?
            if (numsPosibles[num]==false) {
                System.out.println("Stan is dishonest");
            } else {
                System.out.println("Stan may be honest");
            }

            //Siguiente número
            num= scan.nextInt();
         }
     }

}
