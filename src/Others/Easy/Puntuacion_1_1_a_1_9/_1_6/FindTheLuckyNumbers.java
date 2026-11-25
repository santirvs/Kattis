package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class FindTheLuckyNumbers {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numFilas = sc.nextInt();
        int numColumnas = sc.nextInt();
        int numLucky = sc.nextInt();

        int[][] matriz = new int[numFilas][numColumnas];
        for (int i=0; i<numFilas; i++) {
            for (int j=0; j<numColumnas; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        int[][] diagonales = { {-1,-1}, {-1,1}, {1,-1}, {1,1} };
        int numEncontrados = 0;

        for (int fila=1; fila<numFilas-1; fila++) {
            for (int columna=1; columna<numColumnas-1; columna++) {
                if (matriz[fila][columna] == numLucky) {
                    int sumaDiagonales = 0;
                    for (int d=0; d<diagonales.length; d++) {
                        int dFila = fila + diagonales[d][0];
                        int dColumna = columna + diagonales[d][1];
                        sumaDiagonales+=matriz[dFila][dColumna];
                    }
                    if (sumaDiagonales % numLucky == 0) {
                        numEncontrados++;
                    }
                }
            }
        }

        System.out.println(numEncontrados);

    }
}

