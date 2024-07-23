package Cap1._1_ParaEmpezar._8_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class HangingOutOnTheTerrace {

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer el maximo de personas permitidas y el número de grupos que participan
       int maxPersonas = scan.nextInt();
       int numGrupos = scan.nextInt();

       //Contador de personas en la terraza
       int totalPersonas = 0;
       int numGruposNoPermitidos = 0;

       for (int i=0; i<numGrupos; i++) {
           String accion = scan.next();
           int cantidad = scan.nextInt();

           if (accion.equals("enter")) {
               if (totalPersonas + cantidad > maxPersonas) {
                 numGruposNoPermitidos++;
               } else {
                 totalPersonas += cantidad;
               }
          } else {
            totalPersonas -= cantidad;
          }
       }

       //Mostrar el resultado
       System.out.println(numGruposNoPermitidos);

    }
}
