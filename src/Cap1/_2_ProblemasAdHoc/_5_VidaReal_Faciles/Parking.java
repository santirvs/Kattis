package Cap1._2_ProblemasAdHoc._5_VidaReal_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class Parking {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Leer los datos del caso
         int[] coste = new int[4];
         coste[0] = 0;
         coste[1] = scan.nextInt();
         coste[2] = scan.nextInt();
         coste[3] = scan.nextInt();

         int[] minutos = new int[101]; //Los tiempos estan en el rango entre 1 y 100
         for (int i = 1; i <= 3; i++) {
             int inicio = scan.nextInt();
             int fin = scan.nextInt();
             //Incrementar los minutos en los que hay camiones
             for (int j = inicio; j < fin; j++) {
                 minutos[j]++;
             }
         }

         //Calcular el coste total
         int costeTotal = 0;
         for (int i = 1; i <= 100; i++) {
             costeTotal += coste[minutos[i]] * minutos[i];
         }

         //Mostrar el resultado
         System.out.println(costeTotal);

     }

}
