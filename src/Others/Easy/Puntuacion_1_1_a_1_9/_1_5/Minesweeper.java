package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el tamaño de la matriz (filas y columnas) y el número de minas
// Para cada mina, leer su posición (fila y columna) y marcarla en la matriz
// Imprimir la matriz resultante, usando '*' para las minas y '.' para las casillas vacías

import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el tamaño de la matriz y el número de minas
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int mines = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea
        char[][] board = new char[rows][cols];
        // Inicializar la matriz con '.'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '.';
            }
        }
        // Leer las posiciones de las minas y marcarlas en la matriz
        for (int m = 0; m < mines; m++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea
            board[r-1][c-1] = '*';
        }
        // Imprimir la matriz resultante
        for (int i = 0; i < rows; i++) {
            System.out.println(board[i]);
        }

        sc.close();
    }
}

