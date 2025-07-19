package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHash_Set;


import java.util.HashSet;
import java.util.Scanner;

// Convertir la frase a keyword en minúsculas y añadirlas al set
//Mostrar el tamaño del set


public class Keywords {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();
        scan.nextLine();

        HashSet<String> keywords = new HashSet<String>();
        while (numCasos > 0) {
            String palabra = scan.nextLine();
            palabra = palabra.replaceAll("-", " ").toLowerCase();
            keywords.add(palabra.toLowerCase());
            numCasos--;
        }

        System.out.println(keywords.size());

    }

}

