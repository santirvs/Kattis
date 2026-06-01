package Others.Easy.Puntuacion_2_0_a_2_9._2_8;

/**
 * v1 : Leer la cadena
 *      Mientras sea diferente de #
 *      leer último caracter y comprobar si es "even"
 *      calcular la longitud de la cadena -1
 *      reemplazar en la cadena 1s por ""
 *      calcular la longitud de la cadena -1
 *      si es par, imprimir 1, sino 0
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Parity {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String linea = sc.nextLine();
        while (!linea.equals("#")) {
            int longitudCadena = linea.length();
            boolean isOdd = linea.charAt(linea.length()-1) == 'o';
            System.out.print(linea.substring(0, longitudCadena-1));
            linea = linea.replace("1", "");
            int num1s = longitudCadena - linea.length();

            if (isOdd) {
                if (num1s % 2 == 0) System.out.println("1");
                else System.out.println("0");
            }
            else {
                if (num1s % 2 == 0) System.out.println("0");
                else System.out.println("1");
            }

            linea = sc.nextLine();
        }
    }
}

