package Cap2._1_EstructurasDatosConBibliotecas._4_ArraysBidimensionales_Dificiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class FunHouse {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numColumnas = scan.nextInt();
        int numFilas = scan.nextInt();
        scan.nextLine();

        int numCaso = 0;

        while (numColumnas != 0 && numFilas != 0) {
            numCaso++;

            //Leer el tablero
            char[][] tablero = new char[numFilas][numColumnas];
            for (int f = 0; f < numFilas; f++) {
                tablero[f] = scan.nextLine().toCharArray();
            }

            //Encontrar la entrada
            int f = 0;
            int c = 0;
            for (int i = 0; i < numColumnas; i++) {
                for (int j = 0; j < numFilas; j++) {
                    if (tablero[j][i] == '*') {
                        f = j;
                        c = i;
                        break;
                    }
                }
            }

            //Moverse por el tablero
            int direccion; // 0 arriba, 1 derecha, 2 abajo, 3 izquierda
            //La entrada debe estar en un muro
            if (f==0) direccion = 2;
            else if (f==numFilas-1) direccion = 0;
            else if (c==0) direccion = 1;
            else direccion = 3;

            //Moverse por el tablero hasta que se encuentre un muro (x)
            while (tablero[f][c] != 'x') {
                //Avanzar una posición en la dirección actual
                if (direccion == 0) {
                    f--;
                } else if (direccion == 1) {
                    c++;
                } else if (direccion == 2) {
                    f++;
                } else {
                    c--;
                }

                //Cambiar de dirección si se encuentra un espejo
                if (tablero[f][c] == '/') {
                    if (direccion == 0) {
                        direccion = 1;
                    } else if (direccion == 1) {
                        direccion = 0;
                    } else if (direccion == 2) {
                        direccion = 3;
                    } else {
                        direccion = 2;
                    }
                } else if (tablero[f][c] == '\\') {
                    if (direccion == 0) {
                        direccion = 3;
                    } else if (direccion == 1) {
                        direccion = 2;
                    } else if (direccion == 2) {
                        direccion = 1;
                    } else {
                        direccion = 0;
                    }
                }
            }

            //Poner la puerta de salida
            tablero[f][c] = '&';

            //Mostrar el tablero
            System.out.println("HOUSE " + numCaso);
            for (int i = 0; i < numFilas; i++) {
                System.out.println(tablero[i]);
            }

            //Leer siguiente caso
            numColumnas = scan.nextInt();
            numFilas = scan.nextInt();
            scan.nextLine();
        }

    }


}
