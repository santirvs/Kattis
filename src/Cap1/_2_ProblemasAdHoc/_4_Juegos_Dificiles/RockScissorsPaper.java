package Cap1._2_ProblemasAdHoc._4_Juegos_Dificiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * No queda indicado en el enunciado en qué orden debe luchar cada casilla con las adyacentes.
 * Pero es que no es necesario, ya que el resultado es el mismo independientemente del orden.
 * Una casilla sólo puede cambiar hacia un único valor (el único valor que le gana a esa casilla).
 * Si alguna de las casillas adyacentes tiene el valor que gana a la casilla original, la casilla original cambiará a ese valor.
 * En caso contrario, se mantiene el mismo valor.
 * Cada lucha se hace entre el valor original de la casilla y el valor de la casilla adyacente.
 * Los valores de la "nueva generación" se guardan en una matriz auxiliar hasta que se han calculado todos.
 *
 * */
public class RockScissorsPaper {

    public static boolean gana(char jugada1, char jugada2) {
        return jugada1=='R' && jugada2=='S' ||
                jugada1=='S' && jugada2=='P' ||
                jugada1=='P' && jugada2=='R';
    }

    public static void copiarMatriz(char[][] matrizOrigen, char[][] matrizDestino, int filas, int columnas) {
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                matrizDestino[fila][columna] = matrizOrigen[fila][columna];
            }
        }
    }

    public static char ganador(char[][] matriz, int filas, int columnas, int fila, int columna) {
        char jugada = matriz[fila][columna];
        List<Character> adyacentes = new ArrayList<>();

        char jugadaArriba = fila>0 ? matriz[fila-1][columna] : jugada;
        adyacentes.add(jugadaArriba);
        char jugadaAbajo = fila<filas-1 ? matriz[fila+1][columna] : jugada;
        adyacentes.add(jugadaAbajo);
        char jugadaIzquierda = columna>0 ? matriz[fila][columna-1] : jugada;
        adyacentes.add(jugadaIzquierda);
        char jugadaDerecha = columna<columnas-1 ? matriz[fila][columna+1] : jugada;
        adyacentes.add(jugadaDerecha);

        char winner = jugada;
        for (char adyacente : adyacentes) {
            if (gana(adyacente, jugada)) {
                winner = adyacente;
            }
        }

        return winner;

    }

    public static void luchar(char[][] matriz, int filas, int columnas) {
        char[][] nuevaMatriz = new char[filas][columnas];
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                nuevaMatriz[fila][columna] = ganador(matriz, filas, columnas, fila, columna);
            }
        }
        copiarMatriz(nuevaMatriz, matriz, filas, columnas);
    }

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         int numCasos = scan.nextInt();

         for (int caso = 0; caso < numCasos; caso++) {
             //Separador de casos
             if (caso!=0) System.out.println();

             //Datos del caso
             int filas = scan.nextInt();
             int columnas = scan.nextInt();
             int dias = scan.nextInt();
             scan.nextLine();

             //Definir la matriz y leerla
             char[][] matriz = new char[filas][columnas];
             for (int fila = 0; fila < filas; fila++) {
                 String linea = scan.nextLine();
                 matriz[fila] = linea.toCharArray();
             }


             //Luchar una vez cada día
             for (int dia=0; dia<dias; dia++) {
                 luchar(matriz, filas, columnas);
             }

             //Imprimir matriz
             for (int j = 0; j < filas; j++) {
                 for (int k = 0; k < columnas; k++) {
                     System.out.print(matriz[j][k]);
                 }
                 System.out.println();
             }
         }
     }

}
