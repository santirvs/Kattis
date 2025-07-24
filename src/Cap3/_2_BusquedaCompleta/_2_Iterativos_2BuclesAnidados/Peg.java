package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Leer el tablero (7x7)
// Para cada pieza, comprobar si se puede mover en alguna de las 4 direcciones
// Para que se pueda mover, debe haber una casilla ocupada en la dirección del movimiento y
// una casilla libre a distancia 2 de la pieza en la misma dirección

import java.util.Scanner;

public class Peg {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char tablero[][] = new char[7][7];

        // Leer el tablero
        for (int i = 0; i < 7; i++) {
            String linea = scan.nextLine();
            for (int j = 0; j < 7; j++) {
                tablero[i][j] = linea.charAt(j); // Guardar cada carácter en el tablero
            }
        }

        int numMovimientos = 0; // Contador de movimientos
        // Recorrer el tablero
        for (int fila = 0; fila < 7; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                // Si hay una pieza en la casilla
                if (tablero[fila][columna] == 'o') {
                    // Comprobar si se puede mover hacia arriba
                    if (fila-2 >= 0 && tablero[fila - 1][columna] == 'o' && tablero[fila - 2][columna] == '.') {
                        numMovimientos++;
                    }
                    // Comprobar si se puede mover hacia abajo
                    if (fila+2 < 7 && tablero[fila + 1][columna] == 'o' && tablero[fila + 2][columna] == '.') {
                        numMovimientos++;
                    }
                    // Comprobar si se puede mover hacia la izquierda
                    if (columna-2 >= 0 && tablero[fila][columna - 1] == 'o' && tablero[fila][columna - 2] == '.') {
                        numMovimientos++;
                    }
                    // Comprobar si se puede mover hacia la derecha
                    if (columna+2 < 7 && tablero[fila][columna + 1] == 'o' && tablero[fila][columna + 2] == '.') {
                        numMovimientos++;
                    }
                }
            }
        }

        // Imprimir el número de movimientos
        System.out.println(numMovimientos);
    }
}