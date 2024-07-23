package Cap1._1_ParaEmpezar._8_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class HissingMicrophone {

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer la cadena de entrada
       String cadena = scan.nextLine();

      if (cadena.contains("ss")) {
          System.out.println("hiss");
      } else {
          System.out.println("no hiss");
      }

    }
}
