package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Sok {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
       double l1= scan.nextDouble();
       double l2= scan.nextDouble();
       double l3= scan.nextDouble();

       double p1= scan.nextDouble();
       double p2= scan.nextDouble();
       double p3= scan.nextDouble();

       //Buscar la proporcion menor de los ingredientes
       //nos indicará cuantas veces se puede hacer la receta
        double proporcion1 = l1/p1;
        double proporcion2 = l2/p2;
        double proporcion3 = l3/p3;

        double proporcionMenor = Math.min(proporcion1, Math.min(proporcion2, proporcion3));

        //Imprimir la cantidad de litros que se usaran de cada zumo
        System.out.print(l1 - proporcionMenor*p1);
        System.out.print(" ");
        System.out.print(l2 - proporcionMenor*p2);
        System.out.print(" ");
        System.out.print(l3 - proporcionMenor*p3);
        System.out.println();

   }

}

