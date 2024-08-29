package Cap2._1_EstructurasDatosConBibliotecas._3_ArraysBidimensionales_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class ThisAintYourGrandpasCheckerboard {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Lectura de datos
         int tamanyo = scan.nextInt();
         scan.nextLine();

         //Leer el tablero
         char[][] tablero = new char[tamanyo][tamanyo];
         for (int f = 0; f < tamanyo; f++) {
             tablero[f] = scan.next().toCharArray();
         }

         //Analizar el tablero por filas
         boolean valido = true;
         int numSeguidas = 0;

         for (int f = 0; f < tamanyo && valido; f++) {
             numSeguidas = 1;
             char anterior = 'X';
             int blancas = 0;
             int negras = 0;

             for (int c = 0; c < tamanyo && valido; c++) {
                 if (tablero[f][c] == anterior) {
                     numSeguidas++;
                 } else {
                     numSeguidas = 1;
                 }
                 if (numSeguidas == 3) {
                     valido = false;
                 }
                 anterior = tablero[f][c];
                 if (tablero[f][c] == 'W') {
                     blancas++;
                 } else negras++;
             }
             if (blancas != negras) {
                 valido = false;
             }
         }

         //Analizar el tablero por columnas
         for (int c = 0; c < tamanyo && valido; c++) {
             numSeguidas = 1;
             char anterior = 'X';
             int blancas = 0;
             int negras = 0;

             for (int f = 0; f < tamanyo && valido; f++) {
                 if (tablero[f][c] == anterior) {
                     numSeguidas++;
                 } else {
                     numSeguidas = 1;
                 }
                 if (numSeguidas == 3) {
                     valido = false;
                 }
                 anterior = tablero[f][c];
                 if (tablero[f][c] == 'W') {
                     blancas++;
                 } else negras++;
             }
             if (blancas != negras) {
                 valido = false;
             }
         }

         //Imprimir resultado
            if (valido) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }


     }

}