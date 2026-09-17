package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Cargar el tablero
 * Buscar las X en filas, en columnas y en diagonales
 * Idem para O
 * Si no se ha encontrado ninguno, mostrar N
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class TicTacToeSolver {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        char[][] tablero = new char[3][3];

        //Leer tablero
        for(int i=0; i<3; i++) {
            tablero[i] = sc.nextLine().toCharArray();
        }

        char c = 'N';
        //Buscar filas
        for(int fila=0; fila<3; fila++) {
            if (tablero[fila][0] == 'X' && tablero[fila][1] == 'X' && tablero[fila][2] == 'X' )
                c = 'X';
            if (tablero[fila][0] == 'O' && tablero[fila][1] == 'O' && tablero[fila][2] == 'O' )
                c = 'O';
        }
        //Buscar columnas
        for(int columna=0; columna<3; columna++) {
            if (tablero[0][columna] == 'X' && tablero[1][columna] == 'X' && tablero[2][columna] == 'X' )
                c = 'X';
            if (tablero[0][columna]== 'O' && tablero[1][columna]== 'O' && tablero[2][columna] == 'O' )
                c = 'O';
        }

        //Buscar diagonal ascendente

        if (tablero[0][0] == 'X' && tablero[1][1] == 'X' && tablero[2][2] == 'X' )
            c = 'X';
        if (tablero[0][0]== 'O' && tablero[1][1]== 'O' && tablero[2][2] == 'O' )
            c = 'O';

    //Buscar diagonal descendente
        if (tablero[0][2] == 'X' && tablero[1][1] == 'X' && tablero[2][0] == 'X' )
            c = 'X';
        if (tablero[0][2]== 'O' && tablero[1][1]== 'O' && tablero[2][0] == 'O' )
            c = 'O';


        System.out.println(c);

    }


}

