package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * La salida siempre será un array de 4 filas x 9 columnas
 * Cada dígito se presenta en una columna (de abajo hacia arriba)
 *
 */

import java.util.Scanner;

public class UltimateBinaryWatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String hora = sc.next();
        char[][] mapa = new char[4][9];

        //Inicializar el mapa
        for (int f=0; f<4; f++) {
            for (int c=0; c<9; c++) {
                if (c==1 || c>=3 && c<=5 || c==7) mapa[f][c] = ' ';
                else mapa[f][c] = '.';
            }
        }

        //Activar las casillas en binario
        for (int pos=0; pos<hora.length(); pos++) {
            int digito = Integer.parseInt("" + hora.charAt(pos));
            int delta = pos >= 2 ? 1 : 0;
            for (int fila=3; fila>=0; fila--) {
                if (digito%2!=0) mapa[fila][2*(pos+delta)] = '*';
                digito = digito / 2;
            }
        }

        //Mostrar el resultado;
        for (int i=0; i<4; i++) {
            System.out.println(mapa[i]);
        }



    }
}