package Cap3._2_BusquedaCompleta._12_BacktrackingDificiles;

// Resolver mediante backtracking
// Para cada clavija existente en el tablero, intentar saltar a una posición vacía sobre una clavija adyacente
// Si se puede hacer el salto, actualizar el tablero y continuar buscando saltos
// Si solo queda una clavija, se ha encontrado una solución. Comprobar que sea la de menor longitud
// Si no quedan más saltos, se comprueba que sea la mejor solución encontrada hasta el momento (menor número de clavijas restantes y menor numero de movimientos)

import java.util.*;

public class PegSolitaire {

    static char[][] tablero = new char[5][9];
    static int numClavijas = 0; // Número de clavijas en el tablero
    static int minNumClavijas = 0; // Número mínimo de clavijas restantes
    static int minNumMovimientos = 0; // Número de movimientos realizados

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Lectura del número de casos
        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            scan.nextLine(); // Consumir el salto de línea inicial
            //Inicializar datos para cada caso
            numClavijas = 0;
            minNumClavijas = Integer.MAX_VALUE;
            minNumMovimientos = Integer.MAX_VALUE;
            // Leer el tablero
            for (int i = 0; i < 5; i++) {
                // Leer cada fila del tablero
                String fila = scan.nextLine();
                for (int j = 0; j < 9; j++) {
                    tablero[i][j] = fila.charAt(j);
                    if (tablero[i][j] == 'o') {
                        numClavijas++;
                    }
                }
            }

            // iniciar el backtracking
            backtracking( 0, numClavijas);

            //Siguiente caso
            numCasos--;

            // Mostrar el resultado
            System.out.println(minNumClavijas + " " + minNumMovimientos);

        }



    }

    private static void backtracking( int numMovimientos, int totalClavijas) {

        // Caso directo. Se ha encontrado una solución
        if (totalClavijas == 1) {
            // Si es la primera buena solución encontrada, inicializar los mínimos
            if (minNumClavijas > 1) {
                minNumClavijas = 1; // Solo queda una clavija
                minNumMovimientos = numMovimientos; // Número de movimientos realizados
            } else {
                // Si ya había una solución con una clavija, comprobar si es mejor
                minNumMovimientos = Math.min(numMovimientos, minNumMovimientos);
            }
            return;
        }

        // Casos recursivos. Recorrer las clavijas del tablero y buscar las que se pueden saltar
        boolean haySaltos = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (tablero[i][j] == 'o') { // Si hay una clavija en la posición (i,j)
                    // Comprobar las 4 direcciones posibles
                    int[][] direcciones = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Arriba, Abajo, Izquierda, Derecha
                    for (int[] dir : direcciones) {
                        int ni = i + dir[0]; // Nueva fila
                        int nj = j + dir[1]; // Nueva columna
                        int ni2 = i + 2 * dir[0]; // Fila de la posición a saltar
                        int nj2 = j + 2 * dir[1]; // Columna de la posición a saltar

                        // Comprobar si se puede saltar
                        if (ni >= 0 && ni < 5 && nj >= 0 && nj < 9 && ni2 >= 0 && ni2 < 5 && nj2 >= 0 && nj2 < 9) {
                            if (tablero[ni][nj] == 'o' && tablero[ni2][nj2] == '.') {
                                // Realizar el salto
                                tablero[i][j] = '.'; // Quitar la clavija original
                                tablero[ni][nj] = '.'; // Quitar la clavija saltada
                                tablero[ni2][nj2] = 'o'; // Poner la clavija en la nueva posición

                                // Llamada recursiva al backtracking
                                backtracking(numMovimientos + 1, totalClavijas - 1);

                                // Deshacer el salto (backtracking)
                                tablero[i][j] = 'o'; // Volver a poner la clavija original
                                tablero[ni][nj] = 'o'; // Volver a poner la clavija saltada
                                tablero[ni2][nj2] = '.'; // Quitar la clavija de la nueva posición

                                haySaltos = true; // Hay al menos un salto posible
                            }
                        }
                    }
                }
            }
        }

        if (!haySaltos) {
            // Si no hay más saltos posibles, se ha llegado a un punto muerto
            // Comprobar si es la mejor solución encontrada hasta el momento
            if (totalClavijas < minNumClavijas) {
                minNumClavijas = totalClavijas;
                minNumMovimientos = numMovimientos;
            } else if (totalClavijas == minNumClavijas && numMovimientos < minNumMovimientos) {
                minNumMovimientos = numMovimientos;
            }
        }
    }
}
