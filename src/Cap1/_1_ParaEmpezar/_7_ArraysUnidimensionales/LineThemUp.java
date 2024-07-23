package Cap1._1_ParaEmpezar._7_ArraysUnidimensionales;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class LineThemUp {

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer el tamaño de la lista
       int numPersonas = scan.nextInt();
       String nombreAnterior = scan.next();
       boolean ordenadoAsc = true;
       boolean ordenadoDesc = true;

       //Leer los nombres
       for (int i=1; i<numPersonas; i++) {
           String nombre = scan.next();

           if (nombre.compareTo(nombreAnterior) > 0)
               ordenadoDesc &= false;

           if (nombre.compareTo(nombreAnterior) < 0)
               ordenadoAsc &= false;

           nombreAnterior = nombre;
       }

       //Mostrar el resultado
       if (!ordenadoAsc && !ordenadoDesc) {
           System.out.println("NEITHER");
       } else if (ordenadoAsc) {
           System.out.println("INCREASING");
       } else {
           System.out.println("DECREASING");
       }

    }
}
