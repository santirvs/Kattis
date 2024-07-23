package Cap1._1_ParaEmpezar._8_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class BatterUp {

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer el numero de valores
       int numValores = scan.nextInt();
       int suma = 0;
       int numBateadores = 0;

       for (int i=0; i<numValores; i++) {
           int valor = scan.nextInt();

           //El -1 se ignora (walk)
           //El resto se suma y se incrementa el número de bateadores
           if (valor != -1) {
               suma += valor;
               numBateadores++;
           }

       }

       //Mostrar el resultado
       System.out.println((float) suma/numBateadores);

    }
}
