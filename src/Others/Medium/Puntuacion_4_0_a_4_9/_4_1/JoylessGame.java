package Others.Medium.Puntuacion_4_0_a_4_9._4_1;

import java.util.Scanner;

/**
 * Si la cadena empieza y acaba por el mismo caracter ->
 *    Longitud par -> gana Chikapu
 *    Longitud impar -> gana Bash
 * Sino ->
 *    Longitud impar -> gana Chikapu
 *    Longitud par -> gana Bash
 */

public class JoylessGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        while (numCasos-- >0) {
            String cadena = sc.next();

            if (cadena.charAt(0) == cadena.charAt(cadena.length()-1)) {
                //La cadena empieza y acaba igual
                if (cadena.length()%2==0)
                    System.out.println("Chikapu");
                else
                    System.out.println("Bash");
            }
            else {
                if (cadena.length()%2==0)
                    System.out.println("Bash");
                else
                    System.out.println("Chikapu");
            }
        }
    }
}
