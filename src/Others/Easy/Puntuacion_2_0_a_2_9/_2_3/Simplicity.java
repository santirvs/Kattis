package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Conteo de frecuencias.
    Nos quedamos con las dos letras de mayor capacidad y contamos el resto
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.out;

public class Simplicity {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int[] freq = new int[26];

        String s = scan.nextLine();

        //Analizar la palabra
        for (int i=0; i < s.length(); i++) {
            freq[s.charAt(i)-'a']++;
        }

        //Ordenar el array
        Arrays.sort(freq);

        //Sumar todas las apariciones excepto de las dos primeras
        int suma = 0;
        for (int i=0; i<freq.length-2; i++) {
            suma+=freq[i];
        }

        //Mostrar el resultado
        out.println(suma);

    }
}
