package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHashSet;

import java.util.Scanner;

// No veo donde usar un HashSet para evitar duplicados si las palabras se generan
// de forma que no hayan duplicados

public class Esej {

       public static String generarPalabra(int num) {
           String resultado = "";

           while (num > 0 ) {
               resultado += (char)(num%10 + 'a');
               num=num/10;
           }

           return resultado;
       }

       public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in);

        int minPalabras = scan.nextInt();
        int maxPalabras = scan.nextInt();

        //Hay que generar entre minPalabras y maxPalabras
           // que tengan entre 1 y 15 letras
           // debe tener, al menos B/2 palabras diferentes

           //Genera las maxPalabras/2 diferentes
           System.out.print("a");
           String palabra="a";
           int i = 1;
           for ( ; i< (maxPalabras/2) +1 ; i++) {
               palabra = generarPalabra(i);
               System.out.print(" " + palabra);
           }

           //Repite la palabra hasta minPalabras
           for ( ; i < minPalabras; i++) {
               System.out.print(" " + palabra);
           }

           System.out.println();
    }
}
