package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.Locale;
import java.util.Scanner;

public class DeliciousBubbleTea {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer la cantidad de tipos de té y los precios
       int numTe = scan.nextInt();
        int[] preciosTe = new int[numTe];
        for (int i=0; i<numTe; i++) {
            preciosTe[i] = scan.nextInt();
        }

        //Leer la cantidad de tipos de toppings y los precios
        int numToppings = scan.nextInt();
        int[] preciosToppings = new int[numToppings];
        for (int i=0; i<numToppings; i++) {
            preciosToppings[i] = scan.nextInt();
        }

        int precioMenor = Integer.MAX_VALUE;

        //Leer los tipos de tipos de topping de cada té
        for (int i=0; i<numTe; i++) {
           int numToppingsTe = scan.nextInt();
           for (int j=0; j<numToppingsTe; j++) {
               int tipoTopping = scan.nextInt();
               int precio = preciosTe[i] + preciosToppings[tipoTopping - 1];
               precioMenor = Math.min(precioMenor, precio);
           }
       }

       //Ya tengo el precio menor.
        //Ahora leo el presupuesto
        int presupuesto = scan.nextInt();
        //Divido el presupuesto entre el precio menor y obtengo el número de tés que puedo comprar
        //Y le resto 1 ya uno es para PVH y el resto para los estudiantes
        int numTes = Math.max(0, (presupuesto / precioMenor) -1 );

        //Mostrar el resultado
        System.out.println(numTes);
    }
}
