package Cap1._1_ParaEmpezar._A_Medios;

import java.util.Locale;
import java.util.Scanner;

public class ClimbingWorm {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
       int subir = scan.nextInt();
       int bajar = scan.nextInt();
       int altura = scan.nextInt();

       //El primer dia sube
       altura -= subir;
       int dias = 1;

       //Hasta que no llegue arriba
       while (altura > 0) {
           //Baja por la noche, sube por la mañana y así pasa un dia más
           altura += bajar;
           altura -= subir;
           dias++;
       }

       //Mostrar resultado
       System.out.println(dias);

   }

}

