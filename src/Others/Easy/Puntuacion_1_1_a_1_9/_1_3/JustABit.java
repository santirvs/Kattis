package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

/**
 * Contar 1s y 0s en el
 */


import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class JustABit {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Leer los datos
        String linea = sc.next();
        int longitud = linea.length();

        int num1s = longitud - linea.replace("1","").length();
        int num0s = longitud - linea.replace("0","").length();

        System.out.println(num0s + " " + num1s);

    }
}

