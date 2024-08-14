package Cap1._2_ProblemasAdHoc._6_VidaReal_Medios;


import java.util.Locale;
import java.util.Scanner;

public class ToiletSeat {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Leer los datos del caso
         String posiciones = scan.nextLine();
         char inicio = posiciones.charAt(0);
         String secuencia = posiciones.substring(1);

         //Calcular los cambios en las diferentes políticas
         int cambios_ALWAYS_UP = 0;
         int cambios_ALWAYS_DOWN = 0;
         int cambios_PREFER = 0;
         char actual_ALWAYS_UP = inicio;
         char actual_ALWAYS_DOWN = inicio;
         char actual_PREFER = inicio;
         for (int i = 0; i < secuencia.length(); i++) {
             char siguiente = secuencia.charAt(i);

             //Política ALWAYS UP
             if (siguiente != actual_ALWAYS_UP)
                 cambios_ALWAYS_UP++;
             //Y si lo quiero diferente a como tengo que dejarlo, tendré que volver a cambiarlo
             if (siguiente != 'U')
                 cambios_ALWAYS_UP++;
             actual_ALWAYS_UP = 'U';

             //Política ALWAYS DOWN
             if (siguiente != actual_ALWAYS_DOWN)
                 cambios_ALWAYS_DOWN++;
             if (siguiente != 'D')
                 cambios_ALWAYS_DOWN++;
             actual_ALWAYS_DOWN = 'D';


             //Política PREFER
             if (siguiente != actual_PREFER)
                 cambios_PREFER++;
             actual_PREFER = siguiente;


         }



         System.out.println(cambios_ALWAYS_UP);
         System.out.println(cambios_ALWAYS_DOWN);
         System.out.println(cambios_PREFER);



     }

}
