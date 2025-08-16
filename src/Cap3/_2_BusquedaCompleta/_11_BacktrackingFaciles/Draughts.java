package Cap3._2_BusquedaCompleta._11_BacktrackingFaciles;

// Backtracking para encontrar el máximo número posible de capturas en un tablero de damas de 10x10
// Las capturas posibles son aquellas que se realizan en diagonal y saltando sobre una pieza del oponente
// cayendo sobre una casilla libre

// v1. WA en Caso #2  (no he reiniciado maxCaptura para el nuevo juego de pruebas) -> AC!

import java.util.*;

public class Draughts {

    static char[][] tablero = new char[10][10];
    static int maxCapturas = 0;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // Leer los casos de prueba
        int numCasos = scan.nextInt();
        scan.nextLine(); // Consumir el salto de línea del número de casos
        for (int i = 0; i < numCasos; i++) {
            cargarTablero();
            maxCapturas = 0;

            for (int fila = 0; fila < 10; fila++) {
                for (int columna = 0; columna < 10; columna++) {
                    // Si encontramos una pieza blanca, iniciamos el backtracking desde ahí
                    if (tablero[fila][columna] == 'W') {
                        maxCapturas = Math.max(maxCapturas, backtracking(fila, columna));
                    }
                }
            }
            // Imprimir el número máximo de capturas
            System.out.println(maxCapturas);
        }
    }

    // Devolverá el número máximo de capturas posibles desde la posición indicada
    private static int backtracking(int fila, int columna) {
        int capturas = 0;

        // Casos directos de finalización
        if (fila < 0 || fila >= 10 || columna < 0 || columna >= 10) {
            return 0; // Fuera de los límites del tablero
        }

        // No deberíamos llegar aquí nunca... pero por si acaso
        if (tablero[fila][columna] != 'W') {
            return 0; // No hay una pieza blanca en la posición actual
        }

        // Casos recusivos de captura
        // Comprobar las 4 direcciones posibles de captura en cada una de las diagonales
        int[][] direcciones = {{-2, -2}, {-2, 2}, {2, -2}, {2, 2}};
        for (int[] dir : direcciones) {
            int nuevaFila = fila + dir[0];
            int nuevaColumna = columna + dir[1];
            int filaOponente = fila + dir[0] / 2;
            int columnaOponente = columna + dir[1] / 2;
            // Comprobar si la captura es válida
            boolean dentroLimites = nuevaFila >= 0 && nuevaFila < 10 && nuevaColumna >= 0 && nuevaColumna < 10;
            boolean casillaVacia = false;
            boolean piezaOponenteNegra = false;
            if (dentroLimites) {
                casillaVacia = tablero[nuevaFila][nuevaColumna] == '#'; // Casilla de destino vacía
                piezaOponenteNegra = tablero[filaOponente][columnaOponente] == 'B'; // Hay una pieza negra en la casilla de salto
            }
            if (dentroLimites && casillaVacia && piezaOponenteNegra) {
                // Realizar la captura
                tablero[fila][columna] = '#'; // La pieza blanca se mueve a la casilla vacía
                tablero[filaOponente][columnaOponente] = '#'; // La pieza negra es capturada
                tablero[nuevaFila][nuevaColumna] = 'W'; // La pieza blanca se coloca en la nueva posición
                // Llamada recursiva para seguir capturando desde la nueva posición
                capturas = Math.max(capturas, 1 + backtracking(nuevaFila, nuevaColumna));
                // Deshacer la captura (backtracking)
                tablero[fila][columna] = 'W'; // Volver a colocar la pieza blanca en la posición original
                tablero[filaOponente][columnaOponente] = 'B'; // Volver a colocar la pieza negra
                tablero[nuevaFila][nuevaColumna] = '#'; // Volver a dejar la casilla de destino vacía
            }
        }
        return capturas; // Devolver el número máximo de capturas realizadas
    }

    private static void cargarTablero() {
        scan.nextLine(); // Consumir la línea vacía antes del tablero
        for (int i = 0; i < 10; i++) {
            tablero[i] = scan.nextLine().toCharArray();
        }
    }

}
