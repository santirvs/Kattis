package Cap1._2_ProblemasAdHoc._5_VidaReal_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class HeartRate {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Lectura de datos
         int casos = scan.nextInt();
         scan.nextLine();

         //Procesar cada caso
         for (int i = 0; i < casos; i++) {
             int numLatidos = scan.nextInt();
             double tiempo = scan.nextDouble();

             //Calcular el ritmo cardiaco
             double ritmo = 60 * numLatidos / tiempo;

             //Calcular el margen de error
             double margen = 60 / tiempo;

             //Mostrar el resultado
             System.out.printf("%.4f %.4f %.4f\n", ritmo - margen, ritmo, ritmo + margen);
         }

     }

}
