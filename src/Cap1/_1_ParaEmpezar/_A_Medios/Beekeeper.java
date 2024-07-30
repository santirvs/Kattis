package Cap1._1_ParaEmpezar._A_Medios;

import java.util.Locale;
import java.util.Scanner;

public class Beekeeper {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
       int numPalabras = scan.nextInt();

       while (numPalabras > 0 ) {
           scan.nextLine();
           int maxDobles = 0;
           String palabraMax = "";

           while (numPalabras > 0) {
               String palabra = scan.nextLine();

               //Analizar la palabra
                int numDobles = 0;
                char anterior = palabra.charAt(0);
                for (int i = 1; i < palabra.length(); i++) {
                    char c = palabra.charAt(i);
                    if (c == anterior && (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y')) {
                        numDobles++;
                    }
                    anterior = c;
                }

                //Me guardo la palabra si es la que tiene más dobles
                if (numDobles > maxDobles) {
                    maxDobles = numDobles;
                    palabraMax = palabra;
                }

                //Siguiente palabra
               numPalabras--;
           }

           //Mostrar la palabra con más dobles
           System.out.println(palabraMax);

            //Siguiente caso
           numPalabras = scan.nextInt();
       }
   }

}

