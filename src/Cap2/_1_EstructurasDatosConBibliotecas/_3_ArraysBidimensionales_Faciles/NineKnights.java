package Cap2._1_EstructurasDatosConBibliotecas._3_ArraysBidimensionales_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class NineKnights {

    public static boolean analizarPosicion(char[][]tablero, int fila, int columna) {
        boolean valido = true;
        if (fila >=2 && columna >= 1) valido = valido & (tablero[fila-2][columna-1] == '.');
        if (fila >=2 && columna <= 3) valido = valido & (tablero[fila-2][columna+1] == '.');
        if (fila >=1 && columna >= 2) valido = valido & (tablero[fila-1][columna-2] == '.');
        if (fila >=1 && columna <= 2) valido = valido & (tablero[fila-1][columna+2] == '.');

        if (fila <=2 && columna >= 1) valido = valido & (tablero[fila+2][columna-1] == '.');
        if (fila <=2 && columna <= 3) valido = valido & (tablero[fila+2][columna+1] == '.');
        if (fila <=3 && columna >= 2) valido = valido & (tablero[fila+1][columna-2] == '.');
        if (fila <=3 && columna <= 2) valido = valido & (tablero[fila+1][columna+2] == '.');

        return valido;
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        char[][] tablero = new char[5][5];
        for (int f=0; f<5; f++) {
            tablero[f] = scan.nextLine().toCharArray();
        }

        //Análisis del tablero
        boolean valido = true;
        int numCaballos = 0;
        for (int f=0; f<5 && valido; f++) {
            for (int c=0; c<5 && valido; c++) {
                if (tablero[f][c]=='k') {
                    numCaballos++;
                    valido = analizarPosicion(tablero, f,c);
                }
            }
        }

        if (valido && numCaballos==9)
            System.out.println("valid");
        else
            System.out.println("invalid");

  }
}