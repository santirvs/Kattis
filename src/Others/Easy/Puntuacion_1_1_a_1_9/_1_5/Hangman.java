package Others.Easy.Puntuacion_1_1_a_1_9._1_5;


/*
    Máximo se pueden hacer 10 fallos
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String palabra = sc.nextLine();

        String intentos = sc.nextLine();
        int fallos = 0;

        for (int i=0; i<intentos.length() && fallos < 10 && !palabra.equals(""); i++) {

            int longInicial = palabra.length();
            palabra=palabra.replace( ""+intentos.charAt(i), "");
            int longFinal = palabra.length();

            if (longInicial == longFinal)  fallos++;
        }

        if (palabra.equals("")) System.out.println("WIN");
        else System.out.println("LOSE");

    }
}
