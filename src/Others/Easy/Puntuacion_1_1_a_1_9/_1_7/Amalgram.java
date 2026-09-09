package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Contar la frecuencia de aparación de cada letra en cada una de las dos palabras
 * Generar una palabra con el máximo de caracteres de cada una de las apariciones
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Amalgram {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String palabra1 = sc.nextLine();
        String palabra2 = sc.nextLine();

        int[] freq1= new int[26];
        int[] freq2= new int[26];

        //Contar la frecuencia de aparicion de cada caracter en cada palabra
        for(int i=0; i<palabra1.length(); i++) {
            freq1[ (int) palabra1.charAt(i) - 'a']++;
        }
        for(int i=0; i<palabra2.length(); i++) {
            freq2[ (int) palabra2.charAt(i) - 'a']++;
        }

        //Generar la palabra
        for (int i=0; i<26; i++) {
            int repeticiones = Math.max( freq1[i], freq2[i]);
            for (int j=0; j<repeticiones; j++) {
                System.out.print((char) (i+ 'a')) ;
            }
        }
        System.out.println();



    }
}

