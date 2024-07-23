package Cap1._1_ParaEmpezar._7_ArraysUnidimensionales;

import java.util.Locale;
import java.util.Scanner;

public class HotHike {

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer el número de días
       int numDias = scan.nextInt();

       //Leer la temperatura de los dos primeros días
       int temp1 = scan.nextInt();
       int temp2 = scan.nextInt();

       //Variables para guardar la temperatura mínima y el día de inicio
       int maxTemp = Integer.MAX_VALUE;
       int diaInicio = 1;

       for (int i = 3; i<=numDias; i++) {
           //Temperatura del tercer día
           int temp3 = scan.nextInt();

           //Si la temperatura del dia y de anteayer es menor que la mínima, actualizo la mínima y el día de inicio
           //En caso que sean iguales, mantengo la anterior
           if (Math.max(temp1, temp3) < maxTemp) {
               maxTemp = Math.max(temp1, temp3);
               diaInicio = i-2;
           }

           temp1 = temp2;
           temp2 = temp3;
       }

       //Mostrar el resultado
       System.out.println(diaInicio + " " + maxTemp);


    }
}
