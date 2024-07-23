package Cap1._1_ParaEmpezar._7_ArraysUnidimensionales;

import java.util.Locale;
import java.util.Scanner;

public class LostLineUp {

   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer el numero de personas en la fila
        int numPersonas = scan.nextInt()-1;  // Resto 1 porque no tendré en cuenta a Jimmy

       //Cargar la posición de cada persona en un array
       //El 1 es el Jimmy
       //Cada persona (i+1) estará en la posición persDelante del array
       int[] personas = new int[numPersonas];
       for (int i = 1; i<=numPersonas; i++) {
           int persDelante = scan.nextInt();
           personas[persDelante] = i+1;
       }

       //Recorrer el array para mostrar la posición de cada persona
       System.out.print("1");
       for (int i = 0; i<numPersonas; i++) {
           System.out.print(" " + personas[i]);
       }
       System.out.println();

    }
}
