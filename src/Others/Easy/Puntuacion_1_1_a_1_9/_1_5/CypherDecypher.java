package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Hacer el mapa básico: 0..25 -> A..Z
// Obtener el número a partir de un carácter y su posición
// Mulplicarlo por el dígito de la clave
// Obtener el carácter a partir de su códgo y posición

import java.util.Locale;
import java.util.Scanner;


public class CypherDecypher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer la clave
        String clave = sc.nextLine();

        //Leer el número de casos
        int numCasos = sc.nextInt();
        sc.nextLine();
        while (numCasos-- > 0) {
            String palabra = sc.nextLine();
            int posicion = 0;
            for (char c: palabra.toCharArray()) {
                int numChar = c - 'A';
                numChar *= Integer.parseInt(""+clave.charAt(posicion));
                numChar = numChar %26;
                numChar += 'A';
                System.out.print(""+(char)numChar);
                posicion++;
            }
            System.out.println();
        }


        sc.close();
    }
}

