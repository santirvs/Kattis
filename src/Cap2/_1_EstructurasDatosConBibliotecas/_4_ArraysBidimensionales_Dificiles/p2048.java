package Cap2._1_EstructurasDatosConBibliotecas._4_ArraysBidimensionales_Dificiles;

import java.util.Locale;
import java.util.Scanner;

public class p2048 {

    public static int[][] rotar90(int[][] tablero) {
        int[][] nuevo = new int[4][4];
        for (int f = 0; f < 4; f++) {
            for (int c = 0; c < 4; c++) {
                nuevo[f][c] = tablero[3 - c][f];
            }
        }
        return nuevo;
    }
     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Lectura de datos
         int[][] tablero = new int[4][4];

         //Leer el tablero
         for (int f = 0; f < 4; f++) {
             for (int c = 0; c < 4; c++) {
                 tablero[f][c] = scan.nextInt();
             }
         }
         int direccion = scan.nextInt();


         //Rotar el tablero para mover siempre hacia abajo
         if (direccion == 0) {
             tablero = rotar90(tablero);
             tablero = rotar90(tablero);
             tablero = rotar90(tablero);
         } else if (direccion == 1) {
             tablero = rotar90(tablero);
             tablero = rotar90(tablero);
         } else if (direccion == 2) {
             tablero = rotar90(tablero);
         }

         //Mover los números
         for (int c = 0; c < 4; c++) {
             for (int f = 3; f >= 0; f--) {
                 if (tablero[f][c] == 0) {
                     //Buscar el primer número diferente de 0
                     for (int i = f - 1; i >= 0; i--) {
                         if (tablero[i][c] != 0) {
                             tablero[f][c] = tablero[i][c];
                             tablero[i][c] = 0;
                             break;
                         }
                     }
                 }
                 //Solapar con el número siguiente
                 if (f < 3 && tablero[f][c]!=0 && tablero[f][c] == tablero[f+1][c]) {
                     tablero[f+1][c] *= 2;
                     tablero[f][c] = 0;
                     //Volver a buscar el primer número diferente de 0
                     //Buscar el primer número diferente de 0
                     for (int i = f - 1; i >= 0; i--) {
                         if (tablero[i][c] != 0) {
                             tablero[f][c] = tablero[i][c];
                             tablero[i][c] = 0;
                             break;
                         }
                     }
                 }
             }
         }

            //Rotar el tablero de nuevo
            if (direccion == 0) {
                tablero = rotar90(tablero);
            } else if (direccion == 1) {
                tablero = rotar90(tablero);
                tablero = rotar90(tablero);
            } else if (direccion == 2) {
                tablero = rotar90(tablero);
                tablero = rotar90(tablero);
                tablero = rotar90(tablero);
            }

            //Imprimir el tablero
            for (int f = 0; f < 4; f++) {
                for (int c = 0; c < 4; c++) {
                    System.out.print(tablero[f][c] + " ");
                }
                System.out.println();
            }

  }
}