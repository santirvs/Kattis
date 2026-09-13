package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Cargar los datos
 * Verificar filas
 * Verificar columnas
 * Verificar grupo
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class SudokuVerify {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Definir la matriz
        int[][] matriz = new int[9][9];

        //Leer los datos
        for (int fila=0; fila < 9; fila++) {
            for (int columna=0; columna < 9; columna++) {
                matriz[fila][columna] = sc.nextInt();
            }
        }

        boolean valido = true;
        //Verificar filas
        for (int fila=0; fila<9 && valido; fila++) {
            boolean[] aparecidos = new boolean[10];
            for (int columna=0; columna<9 && valido; columna++) {
                if (aparecidos[matriz[fila][columna]]) valido=false;
                else aparecidos[matriz[fila][columna]] = true;
            }
        }
        //Verificar columnas
        for (int columna=0; columna<9 && valido; columna++) {
            boolean[] aparecidos = new boolean[10];
            for (int fila=0; fila<9 && valido; fila++) {
                if (aparecidos[matriz[fila][columna]]) valido=false;
                else aparecidos[matriz[fila][columna]] = true;
            }
        }
        //Verificar grupos
        for (int iniFilaGrupo=0; iniFilaGrupo<9 && valido; iniFilaGrupo+=3) {
            for (int iniColGrupo=0; iniColGrupo<9 && valido; iniColGrupo+=3) {

                boolean[] aparecidos = new boolean[10];
                for (int fila = 0; fila < 3 && valido; fila++) {
                    for (int columna = 0; columna < 3 && valido; columna++) {
                        if (aparecidos[matriz[iniFilaGrupo+fila][iniColGrupo+columna]]) valido = false;
                        else aparecidos[matriz[iniFilaGrupo+fila][iniColGrupo+columna]] = true;
                    }
                }
            }
        }

        //Mostrar resultado
        if (valido) System.out.println("VALID");
        else System.out.println("INVALID!");

    }
}

