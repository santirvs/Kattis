package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._2_TablasDireccionamientoDirecto_ASCII;

// Contar las apariciones de cada letra (bastaría con un booleano)
// Revisar las letras que no han aparecido
// Si son todas -> pangrama
// Sino, --> mostrar las que faltan

import java.util.Scanner;

public class QuickBrownFox {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();
        scan.nextLine();

        while (numCasos > 0 ) {

            char[] cuentas = new char['Z' - 'A' + 1];

            String cadena = scan.nextLine().toLowerCase();
            for (int i = 0; i < cadena.length(); i++) {
                char c = cadena.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    cuentas[c - 'a']++;
                }
            }

            String missing = "";
            for (int i = 0; i < cuentas.length; i++) {
                if (cuentas[i] == 0) {
                    missing += (char)(i + 'a');
                }
            }

            if (missing.isEmpty()) {
                System.out.println("pangram");
            } else {
                System.out.println("missing " + missing);
            }

            numCasos--;
        }

    }
}