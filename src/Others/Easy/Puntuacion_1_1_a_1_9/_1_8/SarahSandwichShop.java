package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Leer los casos
 * Traducir caracter a caracter
 *
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;


public class SarahSandwichShop {

    public static int mapear(char c) {
        switch (c) {
            case 'A','B','C': return 2;
            case 'D','E','F': return 3;
            case 'G','H','I': return 4;
            case 'J','K','L': return 5;
            case 'M','N','O': return 6;
            case 'P','Q','R','S': return 7;
            case 'T','U','V': return 8;
            default: return 9;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer los datos
        int numCasos = sc.nextInt();

        while (numCasos-- > 0) {
            String palabra = sc.next().toUpperCase();

            for (int i=0; i<palabra.length(); i++) {
                System.out.print(mapear(palabra.charAt(i)));
            }
            System.out.println();
        }

    }
}

