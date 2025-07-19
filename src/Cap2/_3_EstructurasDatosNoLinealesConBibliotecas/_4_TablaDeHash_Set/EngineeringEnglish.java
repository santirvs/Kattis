package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHash_Set;

import java.util.HashSet;
import java.util.Scanner;

// Leer las palabras y, si ya se han leído, imprimir "." en lugar de la palabra
// Si no se ha leído, imprimir la palabra y añadirla al conjunto

public class EngineeringEnglish {

      public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in);
        HashSet<String> lista = new HashSet<String>();

        while (scan.hasNext()) {
            String[] palabras = scan.nextLine().split(" ");
            boolean primeraPalabra = true;
            for (String palabra : palabras) {
                //Poner espacio separador de palabras (excepto la primera)
                if (!primeraPalabra) System.out.print(" ");
                else primeraPalabra = false;

                //Si la palabra ya se ha leído, imprimir "."
                if (lista.contains(palabra.toLowerCase())) {
                    System.out.print(".");
                } else {
                    //Si no se ha leído, imprimir la palabra y añadirla al conjunto
                    System.out.print(palabra);
                    lista.add(palabra.toLowerCase());
                }
            }
            System.out.println();
        }

    }
}
