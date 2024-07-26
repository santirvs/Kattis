package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.Locale;
import java.util.Scanner;

public class EventPlanning {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
        int numParticipantes = scan.nextInt();
        int presupuesto = scan.nextInt();
        int numHoteles = scan.nextInt();
        int numSemanas = scan.nextInt();

        int precioMinimo = Integer.MAX_VALUE;

        for (int i=0; i < numHoteles; i++) {
            int precioPorPersona = scan.nextInt();
            scan.nextLine();
            if (precioPorPersona * numParticipantes > presupuesto || precioPorPersona > precioMinimo) {
                //El precio excede el presupuesto o el mejor precio, saltar las habitaciones de cada semana
                scan.nextLine();    //Saltar las habitaciones de cada semana
            }
            else {
                //Buscar si hay habitaciones disponibles
                boolean hayHabitaciones = false;
                for (int j = 0; j < numSemanas; j++) {
                    int numCamas = scan.nextInt();
                    if (numCamas >= numParticipantes) {
                        hayHabitaciones = true;
                    }
                }
                if (hayHabitaciones) {
                    precioMinimo = Math.min(precioMinimo, precioPorPersona);
                }
            }


        }

        if (precioMinimo == Integer.MAX_VALUE) {
            System.out.println("stay home");
        }
        else {
            System.out.println(precioMinimo * numParticipantes);
        }


    }
}
