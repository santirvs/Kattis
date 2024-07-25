package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.Locale;
import java.util.Scanner;

public class PeaSoupAndPancakes {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer la cantidad de restaurantes
        int numRestaurantes = scan.nextInt();
        boolean encontrado = false;

        //Recorrer los restaurantes
       while (numRestaurantes > 0  && !encontrado) {
           numRestaurantes--;
           //Leer la cantidad de platos del restaurante
           int numPlatos = scan.nextInt();
           scan.nextLine();
           //Leer el nombre del restaurante
           String nombre = scan.nextLine();
           //Inicializar detectores de platos
           boolean peaSoup = false;
           boolean pancakes = false;
           //Leer los platos y comprobarlos
           for (int i=0; i<numPlatos; i++) {
               String plato = scan.nextLine();
               if (plato.equals("pancakes")) pancakes = true;
               if (plato.equals("pea soup")) peaSoup = true;
           }
           //Si el restaurante tiene ambos platos, ya se ha encontrado!
           if (peaSoup && pancakes) {
               encontrado = true;
               System.out.println(nombre);
           }
       }

         //Si no se ha encontrado ningún restaurante, se muestra el mensaje
       if (!encontrado)
            System.out.println("Anywhere is fine I guess");

    }
}
