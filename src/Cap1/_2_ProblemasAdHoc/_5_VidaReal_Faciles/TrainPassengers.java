package Cap1._2_ProblemasAdHoc._5_VidaReal_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class TrainPassengers {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Lectura de datos
         int capacidad = scan.nextInt();
         int numEstaciones = scan.nextInt();

         //Tratamiento del caso

         //De entrada, es posible y hay 0 pasajeros
         boolean posible = true;
         int pasajeros = 0;

         for(int i=1; i<=numEstaciones; i++) {
             //Lectura de datos
             int bajan = scan.nextInt();
             int suben = scan.nextInt();
             int esperan = scan.nextInt();

             //Si en alguna estación hay pasajeros esperando habiendo espacio libre, no es posible
             int espacioLibre = capacidad - (pasajeros + suben - bajan);
             if (espacioLibre > 0 && esperan > 0) {
                 posible = false;
             }

             //Si en alguna estación se excede la capacidad, no es posible
             if (pasajeros + suben - bajan > capacidad) {
                 posible = false;
             }

             //Si en alguna estación hay un número negativo de pasajeros, no es posible
             if (pasajeros + suben - bajan < 0) {
                 posible = false;
             }

             //Si en alguna estación bajan más pasajeros de los que hay, no es posible
             if (pasajeros < bajan) {
                 posible = false;
             }

             //Si en la última estación esperan pasajeros, no es posible
             if (i == numEstaciones && esperan > 0) {
                 posible = false;
             }

             //Actualizar el número de pasajeros
             pasajeros += suben - bajan;
         }

         //Mostrar el resultado
         if (posible && pasajeros == 0) {
             System.out.println("possible");
         } else {
             System.out.println("impossible");
         }

     }

}
