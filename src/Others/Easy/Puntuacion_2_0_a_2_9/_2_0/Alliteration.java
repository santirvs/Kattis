package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Contar las frecuencias del primer caracter de la palabra
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Alliteration {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();
        sc.nextLine();

        while (numCasos-- > 0) {
            int[] freq = new int[26];

            String[] s = sc.nextLine().split(" ");
            for (int i=0 ; i < s.length ; i++) {
                char c = s[i].charAt(0);
                freq[c-'a']++;
            }

            //Mostrar la frequencia más alta
            int maxFreq = 0;
            char maxChar = 'a';
            for (int i=0; i<26;i++) {
                if (freq[i] > maxFreq) {
                    maxFreq = freq[i];
                    maxChar = (char) ('a'+ i);
                }
            }

            //Mostrar el resultado
            System.out.println(maxChar);

        }

    }
}

