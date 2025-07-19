package Cap2._2_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.Locale;
import java.util.Scanner;

public class VerifyThisYourMajesty {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int tamanyo = scan.nextInt();

        //Definir el tablero
        int[][] tablero = new int[tamanyo][tamanyo];
        // Valores de las casillas
        // 0 -> libre
        // 1 -> ocupada
        // 2 -> atacada

        boolean posible = true;

        //Leer las posiciones de las reinas
        for (int i = 0; i < tamanyo && posible; i++) {
            int columna = scan.nextInt();
            int fila = tamanyo-1 - scan.nextInt();
            //Marca la casilla como ocupada sólo si está libre
            //En caso contrario, no será posible colocar todas las reinas
            if (tablero[fila][columna] != 0) {
                posible = false;
            } else {
                tablero[fila][columna] = 1;
            }
            //Marca las casillas atacadas por la reina

            //Ataque horizontal
            for (int j = 0; j < tamanyo && posible; j++) {
                if (tablero[fila][j] != 1)
                    tablero[fila][j] = 2;
                else
                    if (j != columna) posible = false;
            }

            //Ataque vertical
            for (int j = 0; j < tamanyo && posible; j++) {
                if (tablero[j][columna] != 1)
                    tablero[j][columna] = 2;
                else
                    if (j!=fila) posible = false;
            }

            //Ataque diagonal 1
            for (int j = 1; j < tamanyo && posible; j++) {
                if (fila+j < tamanyo && columna+j < tamanyo) {
                    if (tablero[fila+j][columna+j] != 1)
                        tablero[fila+j][columna+j] = 2;
                    else
                        posible = false;
                }
            }

            //Ataque diagonal 2
            for (int j = 1; j < tamanyo && posible; j++) {
                if (fila+j < tamanyo && columna-j >= 0) {
                    if (tablero[fila+j][columna-j] != 1)
                        tablero[fila+j][columna-j] = 2;
                    else
                        posible = false;
                }
            }

            //Ataque diagonal 3
            for (int j = 1; j < tamanyo && posible; j++) {
                if (fila-j >= 0 && columna+j < tamanyo) {
                    if (tablero[fila-j][columna+j] != 1)
                        tablero[fila-j][columna+j] = 2;
                    else
                        posible = false;
                }
            }

            //Ataque diagonal 4
            for (int j = 1; j < tamanyo && posible; j++) {
                if (fila-j >= 0 && columna-j >= 0) {
                    if (tablero[fila-j][columna-j] != 1)
                        tablero[fila-j][columna-j] = 2;
                    else
                        posible = false;
                }
            }
        }

        //Imprimir el resultado
        if (posible) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }

     }
}
