package Others.Easy.Puntuacion_2_0_a_2_9._2_5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConnectN {

    static int numFilas;
    static int numColumnas;
    static char[][] tablero;

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        numFilas = sc.nextInt();
        numColumnas = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        tablero = new char[numFilas][numColumnas];

        int[][] direcciones = { {1,0}, {1,1}, {0,1}, {1,-1} };

        //Leer el tablero
        for (int i=0; i<numFilas; i++) {
            for (int j=0; j<numColumnas; j++) {
                tablero[i][j] = sc.next().charAt(0);
            }
        }

        char ganador = 'O';
        for (int fila=0; fila<numFilas && ganador =='O'; fila++) {
            for (int columna=0; columna<numColumnas && ganador == 'O'; columna++) {

                if (tablero[fila][columna] != 'O') {
                    for (int i=0; i<direcciones.length && ganador == 'O'; i++) {
                    ganador = esGanador(fila, columna, N-1,direcciones[i]);
                    }
                }
            }
        }

        switch (ganador) {
            case 'R':
                System.out.println("RED WINS");
                break;
            case 'B':
                System.out.println("BLUE WINS");
                break;
            default:
                System.out.println("NONE");
                break;
        }
    }

    public static char esGanador(int fila, int columna, int N,int[] direccion) {

        if (N==0) return tablero[fila][columna];

        int filaNueva = fila+direccion[0];
        int columnaNueva = columna+direccion[1];

        if (filaNueva >=0 && filaNueva < numFilas && columnaNueva >=0 && columnaNueva < numColumnas) {
            if (tablero[fila][columna] == tablero[filaNueva][columnaNueva]) {
                return esGanador(filaNueva, columnaNueva, N-1, direccion);
            }
            else return 'O';
        } else return 'O';

    }
}