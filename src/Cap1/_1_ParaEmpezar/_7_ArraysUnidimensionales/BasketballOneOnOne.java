package Cap1._1_ParaEmpezar._7_ArraysUnidimensionales;

import java.util.Locale;
import java.util.Scanner;

public class BasketballOneOnOne {

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Gana el último en encestar...
       String resultado = scan.nextLine();

       System.out.println(resultado.charAt(resultado.length()-2));


    }
}
