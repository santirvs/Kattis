package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Leer el tablero en una matriz de 8x8
// Recorrer las filas y columnas para comprobar si hay una reina en la misma fila o columna
// Para cada reina, comprobar si hay otra en la misma diagonal, fila o columna

import java.util.Scanner;

public class EightQueens {

    static char[][] tablero = new char[8][8]; // Tablero de 8x8

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer el tablero de 8x8
        for (int i = 0; i < 8; i++) {
            String linea = scan.nextLine();
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = linea.charAt(j);
            }
        }

        // Buscar las reinas en el tablero, debe haber exactamente 8
        int reinas = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] == '*') {
                    reinas++;
                    // Comprobar si hay otra reina en la misma fila
                    for (int k = 0; k < 8; k++) {
                        if (k != j && tablero[i][k] == '*') {
                            System.out.println("invalid");
                            return;
                        }
                    }
                    // Comprobar si hay otra reina en la misma columna
                    for (int k = 0; k < 8; k++) {
                        if (k != i && tablero[k][j] == '*') {
                            System.out.println("invalid");
                            return;
                        }
                    }
                    // Comprobar diagonales
                    for (int k = 1; k < 8; k++) {
                        if (i + k < 8 && j + k < 8 && tablero[i + k][j + k] == '*') {
                            System.out.println("invalid");
                            return;
                        }
                        if (i - k >= 0 && j - k >= 0 && tablero[i - k][j - k] == '*') {
                            System.out.println("invalid");
                            return;
                        }
                        if (i + k < 8 && j - k >= 0 && tablero[i + k][j - k] == '*') {
                            System.out.println("invalid");
                            return;
                        }
                        if (i - k >= 0 && j + k < 8 && tablero[i - k][j + k] == '*') {
                            System.out.println("invalid");
                            return;
                        }
                    }
                }
            }
        }

        // Comprobar si hay exactamente 8 reinas
        if (reinas == 8) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }

    }
}