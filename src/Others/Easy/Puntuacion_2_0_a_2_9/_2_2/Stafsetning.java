package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

/**
 *
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Stafsetning {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        long totalErrores = 0;
        for (int i=0;i<n;i++) {
            totalErrores += sc.nextInt();
        }

        if (k < m) System.out.println(":(");  //Por cada problema debo dedicar más tiempo del que dispongo diariamente
        else {
            //Cuantos problemas puedo solucionar diariamente?
            int numProblemasDia = k / m;
            //Cuantos días voy a tardar en solucionar todos los problemas?
            long numDias = totalErrores / numProblemasDia;
            if (totalErrores % numProblemasDia !=0) numDias++;  //Día extra con el sobrante

            System.out.println(numDias);
        }

    }
}