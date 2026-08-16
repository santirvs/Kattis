package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Dibujar un marco cuadrado de lado n
 */


import java.io.IOException;
import java.util.Scanner;


public class SquareButNotTheMathKind {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Leer el tamaño del marco
        int tamanyo = sc.nextInt();

        //La primera fila
        System.out.print("*");
        for (int i=2; i<=tamanyo; i++)  {
            System.out.print(" *");
        }
        System.out.println();

        //Filas intermedias
        int fila = 2;
        for ( ; fila < tamanyo; fila++) {
            System.out.print("* ");
            for (int i=2; i<tamanyo;i++)
                System.out.print("  ");
            System.out.println("*");
        }

        //Ultima fila
        if (fila == tamanyo) {
            System.out.print("*");

            for (int i = 2; i <= tamanyo; i++) {
                System.out.print(" *");
            }
            System.out.println();
        }


        sc.close();
    }
}

