package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Construir la cantidad de pasajeros para una cantidad determinada de paradas
 * (número de paradas entre 1 y 30)
 * Responder para cada caso
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bus {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        //Construir las 30 soluciones posibles
        int[] numPersonas = new int[31];
        numPersonas[0] = 0;
        numPersonas[1] = 1;
        for (int i=2; i<=30; i++) {
            numPersonas[i] = 2 * numPersonas[i-1] + 1;

            //System.out.println(i + "::" + numPersonas[i]);
        }


        //Responder a las consultas
        int numConsultas = sc.nextInt();
        while (numConsultas-- > 0) {
            int num = sc.nextInt();
            System.out.println(numPersonas[num]);
        }


    }
}