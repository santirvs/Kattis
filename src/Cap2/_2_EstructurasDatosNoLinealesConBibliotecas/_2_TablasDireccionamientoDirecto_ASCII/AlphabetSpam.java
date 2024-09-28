package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._2_TablasDireccionamientoDirecto_ASCII;

// Contar los caracteres de cada tipo y dividirlos por el total

import java.util.Scanner;

public class AlphabetSpam {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        String cadena = scan.nextLine();
        int espacios = 0;
        int minusculas = 0;
        int mayusculas = 0;
        int simbolos = 0;

        for (int i=0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c == '_') {
                espacios++;
            } else if (c >= 'a' && c <= 'z') {
                minusculas++;
            } else if (c >= 'A' && c <= 'Z') {
                mayusculas++;
            } else {
                simbolos++;
            }
        }

        double total = cadena.length();
        System.out.println(espacios/total);
        System.out.println(minusculas/total);
        System.out.println(mayusculas/total);
        System.out.println(simbolos/total);


    }
}