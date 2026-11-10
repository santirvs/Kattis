package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

import java.io.IOException;
import java.util.Scanner;

public class WellContamination {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numFilas = sc.nextInt();
        int numColumnas = sc.nextInt();
        sc.nextLine();

        char[][] matriz = new char[numFilas][numColumnas];
        for (int i=0; i<numFilas; i++) {
            matriz[i] = sc.nextLine().toCharArray();
        }

        int numPozosContaminados = 0;

        for (int i=0; i<numFilas; i++) {
            for (int j=0; j<numColumnas; j++) {
                if (matriz[i][j] == 'W') {
                    numPozosContaminados += comprobarPozo(matriz, i,j);
                }
            }
        }

        System.out.println(numPozosContaminados);


        sc.close();
    }

    private static int comprobarPozo(char[][] matriz, int fila, int columna) {

        int[][] direcciones = { {1,0},{-1,0},{0,-1},{0,1} };
        int result = 0;

        for (int i=0; i< direcciones.length; i++) {
            int f = fila+direcciones[i][0];
            int c = columna+direcciones[i][1];

            if (f >= 0 && f<matriz.length && c>=0 && c<matriz[0].length && matriz[f][c] == 'O') {
                result = 1;
            }
        }

        return result;

    }
}