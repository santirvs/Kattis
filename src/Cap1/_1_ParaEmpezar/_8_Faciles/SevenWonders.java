package Cap1._1_ParaEmpezar._8_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class SevenWonders {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer las cartas
       char[] cartas = scan.next().toCharArray();

       //Contadores de cartas
       int t = 0;
       int c = 0;
       int g = 0;

       //Contar las cartas
       for (int i=0; i<cartas.length; i++) {
           if (cartas[i] == 'T') t++;
           if (cartas[i] == 'C') c++;
           if (cartas[i] == 'G') g++;
       }

        //Calcular el número de sets que se pueden formar
         int sets = Math.min(t, Math.min(c, g));
         //Calcular la puntuació
         int puntos = t*t + c*c + g*g + 7*sets;

         System.out.println(puntos);
    }
}
