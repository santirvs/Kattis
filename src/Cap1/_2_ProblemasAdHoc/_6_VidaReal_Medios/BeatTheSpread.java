package Cap1._2_ProblemasAdHoc._6_VidaReal_Medios;


import java.util.Locale;
import java.util.Scanner;

public class BeatTheSpread {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Leer los datos del caso
         int casos = scan.nextInt();
         scan.nextLine();

         for (int i = 0; i < casos; i++) {
             int suma = scan.nextInt();
             int diferencia = scan.nextInt();

             if (suma < diferencia || (suma + diferencia) % 2 != 0) {
                 System.out.println("impossible");
             } else {
                 int a = (suma + diferencia) / 2;
                 int b = suma - a;
                 System.out.println(a + " " + b);
             }


         }


     }

}
