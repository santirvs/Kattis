package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Leer la cadena
 * Calcular el código ASCII de cada caracter
 * Calcular la media
 * Transformar a caracter
 */


import java.io.IOException;
import java.util.Scanner;

public class AverageCharacter {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String cadena = sc.nextLine();
        int sumaASCII = 0;

        for (int i=0; i<cadena.length();i++) {
            sumaASCII += cadena.charAt(i);
        }

        int media = sumaASCII / cadena.length();
        char mediaChar = (char) media;

        System.out.println(mediaChar);

        sc.close();
    }
}