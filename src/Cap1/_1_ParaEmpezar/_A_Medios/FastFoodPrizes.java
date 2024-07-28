package Cap1._1_ParaEmpezar._A_Medios;

import java.util.Locale;
import java.util.Scanner;

// Fast Food Prizes
// Explicación del enunciado
// Las pegatinas del entrenador son la cantidad de pegatinas que tiene de cada tipo

public class FastFoodPrizes {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       int numCasos = scan.nextInt();

       while (numCasos > 0) {
           int tiposPremios = scan.nextInt();
           int numStickers = scan.nextInt();

           //Leer los premios
           int[][] premios = new int[tiposPremios][];

           int i = 0;
           while (i < tiposPremios) {
               int k = scan.nextInt()+1; //Una columna adicional para el importe del premio
               int[] stickers = new int[k];
               for (int j = 0; j < k; j++) {
                   int e = scan.nextInt();
                   stickers[j] = e;
               }

               premios[i] = stickers;
               i++;
           }

           //Leer los stickers del entrenador
           int[] entrenador = new int[numStickers+1];
           for ( i = 1; i <= numStickers; ++i) {
               int e = scan.nextInt();
               entrenador[i] = e;
           }

           //Calcular el importe del premio
           int premio = 0;
           for ( i = 0; i < premios.length; ++i) {
               int p = Integer.MAX_VALUE;
               int j = 0;
               while (j < premios[i].length - 1)
                   p = Math.min(p, entrenador[premios[i][j++]]);

               //El premio es el mínimo de los stickers que se tiene para ese tipo de premio, multiplicado por el premio
               premio += (p * premios[i][j]);
           }

           System.out.println(premio);

           numCasos--;
       }


   }

}

