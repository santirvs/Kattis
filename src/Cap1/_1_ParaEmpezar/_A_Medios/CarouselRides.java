package Cap1._1_ParaEmpezar._A_Medios;

import java.util.Locale;
import java.util.Scanner;

public class CarouselRides {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
       int numLineas = scan.nextInt();
       int maxTickets = scan.nextInt();

       while (numLineas!=0 || maxTickets!=0) {

           double mejorRelacion = Double.MAX_VALUE;
           int mejorPrecio = 0;
           int mejorNumTickets = 0;
           for (int i=0; i<numLineas; i++) {
               int tickets = scan.nextInt();
               double precio = scan.nextDouble();
               if (tickets <= maxTickets) {
                   double precioTicket = precio/tickets;
                   if (precioTicket < mejorRelacion) {
                       mejorRelacion = precioTicket;
                       mejorNumTickets = (int) tickets;
                       mejorPrecio = (int) precio;
                   }
                   else if (precioTicket == mejorRelacion && tickets > mejorNumTickets) {
                       mejorNumTickets = (int) tickets;
                       mejorPrecio = (int) precio;
                   }
               }
           }

           //Mostrar resultado
           if (mejorNumTickets == 0)
               System.out.println("No suitable tickets offered");
           else
               System.out.println("Buy " + mejorNumTickets + " tickets for $" + mejorPrecio);


           //Siguiente caso
           numLineas = scan.nextInt();
           maxTickets = scan.nextInt();
       }

   }

}

