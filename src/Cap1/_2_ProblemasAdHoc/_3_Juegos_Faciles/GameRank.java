package Cap1._2_ProblemasAdHoc._3_Juegos_Faciles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class GameRank {

    public static int numEstrellas(int rango) {
        if (rango >= 21) return 2;
        if (rango >= 16) return 3;
        if (rango >= 11) return 4;
        return 5;
    }

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         String s = scan.nextLine();
         int victorias = 0;
         int estrellas = 0;
         int rango = 25;

         for (int i = 0; i < s.length(); i++) {
             if (s.charAt(i) == 'W') {
                 //Ha ganado. Se incrementa la racha de victorias y se gana una estrella
                 victorias++;
                 estrellas++;
                 //Una estrella adicional si se ha ganado 3 o más partidas seguidas y el rango es mayor o igual a 6
                 if (victorias >= 3 && rango >= 6) estrellas++;
             } else {
                 //Ha perdido. Se pierde la racha de victorias
                 victorias = 0;
                 //Si el rango es menor de 20, se pierde una estrella
                 if (rango >=1 && rango <= 20)
                     estrellas--;
                 //Una vez alcanzado, no se puede caer del rango 20
                 if (rango == 20 && estrellas < 0) estrellas = 0;
             }

             //Se comprueba si se ha bajado de rango
             if (estrellas < 0) {
                 rango++;
                 estrellas = numEstrellas(rango) - 1;
             }

             //Se comprueba si se ha subido de rango
             if (estrellas > numEstrellas(rango)) {
                 rango--;
                 estrellas = estrellas - numEstrellas(rango+1);
             }

         }

         //Se imprime el rango final
         if (rango >= 1) System.out.println(rango);
         else System.out.println("Legend");

     }

}
