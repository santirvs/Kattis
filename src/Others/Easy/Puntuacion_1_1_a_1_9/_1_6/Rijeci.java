package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Esto es un Fibbonacci camuflado
 */


import java.io.IOException;
import java.util.Scanner;


public class Rijeci {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[][] solucion = new int[2][2];
        //inicial --> A
        solucion[0][0] = 1;
        solucion[0][1] = 0;
        //1 click --> B
        solucion[1][0] = 0;
        solucion[1][1] = 1;

        int numClicks = sc.nextInt();

        for (int i=1; i<numClicks; i++) {
            int As = solucion[0][0] + solucion[1][0];
            int Bs = solucion[0][1] + solucion[1][1];

            //Desplazar la solucion
            solucion[0][0] = solucion[1][0];
            solucion[0][1] = solucion[1][1];

            //Registrar la nueva solucion
            solucion[1][0] = As;
            solucion[1][1] = Bs;

            //System.out.println( i + "::" + solucion[1][0] + " " + solucion[1][1]);
        }

        System.out.println(solucion[1][0] + " " + solucion[1][1]);


        sc.close();
    }
}

