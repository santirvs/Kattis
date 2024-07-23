package Cap1._1_ParaEmpezar._8_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class PokerHand {

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Hay que contar cuantas cartas del mismo numero hay
       //Defino el array donde haré el conteo de frecuencias
       int[] cartas = new int[13];

       for (int i=1; i<=5; i++) {
           char carta = scan.next().charAt(0);
           switch (carta) {
               case 'A': cartas[0]++; break;
               case '2': cartas[1]++; break;
               case '3': cartas[2]++; break;
               case '4': cartas[3]++; break;
               case '5': cartas[4]++; break;
               case '6': cartas[5]++; break;
               case '7': cartas[6]++; break;
               case '8': cartas[7]++; break;
               case '9': cartas[8]++; break;
               case 'T': cartas[9]++; break;
               case 'J': cartas[10]++; break;
               case 'Q': cartas[11]++; break;
               case 'K': cartas[12]++; break;
           }
       }

       //Busco la carta con mayor frecuencia
       int max = 0;
       for (int i=0; i<13; i++) {
              if (cartas[i] > max) {
                max = cartas[i];
              }
       }

       //Mostrar el resultado
       System.out.println(max);

    }
}
