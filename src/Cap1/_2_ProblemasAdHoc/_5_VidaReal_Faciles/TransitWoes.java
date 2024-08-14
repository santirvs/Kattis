package Cap1._2_ProblemasAdHoc._5_VidaReal_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class TransitWoes {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Leer los datos del caso
         int salidaCasa = scan.nextInt();
         int inicioClase = scan.nextInt();
         int numBuses = scan.nextInt();

         int[] tiempoCaminar = new int[numBuses + 1];
         for (int i = 0; i <= numBuses; i++) {
             tiempoCaminar[i] = scan.nextInt();
         }

         int[] tiempoBuses = new int[numBuses];
         for (int i = 0; i < numBuses; i++) {
             tiempoBuses[i] = scan.nextInt();
         }

         int[] frecuenciaBuses = new int[numBuses];
         for (int i = 0; i < numBuses; i++) {
             frecuenciaBuses[i] = scan.nextInt();
         }

         //Calcular el tiempo total
         int tiempoTotal = salidaCasa;
         for (int i = 0; i < numBuses; i++) {
             //Llegada a la parada
             tiempoTotal += tiempoCaminar[i];
             //Esperar al siguiente bus
             int espera = frecuenciaBuses[i] - (tiempoTotal % frecuenciaBuses[i]);
             if (espera < frecuenciaBuses[i]) {
                 tiempoTotal += espera;
             }
             //Tiempo de viaje
             tiempoTotal += tiempoBuses[i];
         }
         //Llegada a la clase
         tiempoTotal += tiempoCaminar[numBuses];

         //Mostrar el resultado
         if (tiempoTotal <= inicioClase) {
             System.out.println("yes");
         } else {
             System.out.println("no");
         }

     }

}
