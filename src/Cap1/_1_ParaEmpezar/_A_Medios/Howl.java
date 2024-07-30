package Cap1._1_ParaEmpezar._A_Medios;

import java.util.Locale;
import java.util.Scanner;

public class Howl {

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Aullido a superar en longitud
         String aullido = scan.nextLine();

         //Tamaño
         int longitud = aullido.length();

         //Generación del aullido ganador: (AW)*HOO
         System.out.println("AW".repeat(longitud/2) + "HOO");

    }
}



