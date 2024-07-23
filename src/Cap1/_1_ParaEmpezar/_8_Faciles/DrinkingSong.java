package Cap1._1_ParaEmpezar._8_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class DrinkingSong {

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       // Leer el número de botellas
       int numBotellas = scan.nextInt();
       String contenido = scan.next();

       //Mientras queden botellas
       while (numBotellas > 0) {
            if (numBotellas > 2) {
                System.out.println(numBotellas + " bottles of " + contenido + " on the wall, " + numBotellas + " bottles of " + contenido + ".");
                System.out.println("Take one down, pass it around, " + (numBotellas-1) + " bottles of " + contenido + " on the wall.");
            }
            else if (numBotellas == 2) {
                System.out.println(numBotellas + " bottles of " + contenido + " on the wall, " + numBotellas + " bottles of " + contenido + ".");
                System.out.println("Take one down, pass it around, " + (numBotellas-1) + " bottle of " + contenido + " on the wall.");
            }
            else {
                System.out.println(numBotellas + " bottle of " + contenido + " on the wall, " + numBotellas + " bottle of " + contenido + ".");
                System.out.println("Take it down, pass it around, no more bottles of " + contenido + ".");
            }

           numBotellas--;
       }

    }
}
