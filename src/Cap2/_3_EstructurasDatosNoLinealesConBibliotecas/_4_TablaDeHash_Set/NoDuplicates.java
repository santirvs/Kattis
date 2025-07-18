package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHash_Set;


import java.util.HashSet;
import java.util.Scanner;

// Añadir cada palabra de la frase al set
// Indicar si el tamaño del set es igual al número de palabras de la frase


public class NoDuplicates {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        HashSet<String> palabras = new HashSet<String>();

        String[] frase = scan.nextLine().split(" ");
        for (String palabra : frase) {
            palabras.add(palabra);
        }

        if (palabras.size() == frase.length) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

}

