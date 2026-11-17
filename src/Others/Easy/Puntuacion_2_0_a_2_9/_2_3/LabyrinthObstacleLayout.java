package Others.Easy.Puntuacion_2_0_a_2_9._2_3;

// Leer un número N y dibujar una matriz de puntos de N x N con el interior con #

import java.util.Scanner;

public class LabyrinthObstacleLayout {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int fila = 0; fila<n ; fila++) {
            for (int columna = 0; columna<n; columna++) {
                if (fila == 0 || fila == n-1 || columna == 0 || columna == n-1)
                    System.out.print(".");
                else
                    System.out.print("#");
            }
            System.out.println();
        }

    }
}
