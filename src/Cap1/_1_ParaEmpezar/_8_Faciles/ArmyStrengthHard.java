package Cap1._1_ParaEmpezar._8_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class ArmyStrengthHard {

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Segun las reglas del juego, el ejército con el monstruo de mayor valor será el ganador

       //A diferencia de la version Eays este problema, por las dimensiones del juego de pruebas,
       // no se puede resolver ordenando los valores de los monstruos de cada ejército
       //e ir eliminando el menor en cada batalla.

       // Leer el número de casos de prueba
       int numCasos = scan.nextInt();

       while (numCasos > 0) {

          //Leer el número de monstruos de cada ejército
          int numMostruosGodzilla = scan.nextInt();
          int numMostruosMechaGodzilla = scan.nextInt();

            //Leer los valores de los monstruos de cada ejército
           int mejorMonstruoGodzilla = 0;
           for (int i=0; i<numMostruosGodzilla; i++) {
               int monstruo = scan.nextInt();
               if (monstruo > mejorMonstruoGodzilla)
                     mejorMonstruoGodzilla = monstruo;
           }
           int mejorMonstruoMechaGodzilla = 0;
           for (int i=0; i<numMostruosMechaGodzilla; i++) {
               int monstruo = scan.nextInt();
               if (monstruo > mejorMonstruoMechaGodzilla)
                   mejorMonstruoMechaGodzilla = monstruo;
           }

           if (mejorMonstruoGodzilla >= mejorMonstruoMechaGodzilla) {
               System.out.println("Godzilla");
           } else {
               System.out.println("MechaGodzilla");
           }

           numCasos --;
       }

    }
}
