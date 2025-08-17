package Cap3._2_BusquedaCompleta._12_BacktrackingDificiles;

// Resolver mediante backtracking
// Sólo hay un espacio vacío en la rejilla de hasta 250x250
// Por lo tanto, solo podrá moverse uno de los 4 coches adyacentes al espacio vacío
// Una vez que se mueve un coche, se deja bloqueado, se comprueba si se ha llegado a la solución,
// y si no es así, se siguen moviendo los coches adyacentes al espacio vacío hasta que no puedan moverse más coches

// ¿Tiene sentido tener que mover dos veces el mismo coche?
// Dado que los coches tienen una longitud de 2 y solo pueden moverse horizontalmente o verticalmente,
// no tiene sentido mover un coche dos veces en la misma dirección, ya que se volvería a la posición original.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarVet {

    static int[][] parking;
    static List<Integer> solucion;
    static List<Integer> movimientos;

    static int filaLibre;
    static int columnaLibre;

    static int filaDeseada;
    static int columnaDeseada;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Leer las dimensiones del parking
        int filas = scan.nextInt();
        int columnas = scan.nextInt();
        parking = new int[filas][columnas];

        // Leer el parking
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                parking[i][j] = scan.nextInt();
                if (parking[i][j] == -1) {
                    filaLibre = i; // Guardar la fila donde se encuentra el espacio libre
                    columnaLibre = j; // Guardar la columna donde se encuentra el espacio libre
                }
            }
        }

        // Inicializar la solución
        solucion = new ArrayList<>();
        movimientos = new ArrayList<>();

        // Leer las coordenadas a liberar
        filaDeseada = scan.nextInt()-1;
        columnaDeseada = scan.nextInt()-1;

        // Buscar la solución mediante backtracking
        backtracking(filaLibre, columnaLibre);

        // Imprimir la solución
        if (solucion.size() == 0) {
            // Si no se ha encontrado ninguna solución, imprimir "impossible"
            System.out.println("impossible");
        }
        else {
            boolean esPrimero = true;
            for (Integer s: solucion) {
                if (esPrimero) esPrimero = false; // Marcar que ya no es el primer coche
                else System.out.print(" ");

                System.out.print(s);
            }
        }

    }

    private static void backtracking(int filaLibre, int columnaLibre) {

        // Casos directos de finalización
        if (filaLibre == filaDeseada && columnaLibre == columnaDeseada) {
            // Si hemos llegado a la posición deseada, hemos encontrado una solución
            if (movimientos.size() < solucion.size() || solucion.size() == 0) {
                // Si es la primera solución o es más corta que la solución actual, la guardamos
                solucion = new ArrayList<>(movimientos);
            }
            else if (movimientos.size() == solucion.size() && menorLexicograficamente()) {
                // Si es de la misma longitud pero lexicográficamente menor, la guardamos
                solucion = new ArrayList<>(movimientos);
            }
            // Si no es una solución mejor, simplemente retornamos
            return;
        }

        // Casos recursivos de movimiento
        // Comprobar los 4 movimientos posibles (arriba, abajo, izquierda, derecha)

        //Probar movimiento horizontal desde la izquierda
        if (columnaLibre-2 >= 0 && parking[filaLibre][columnaLibre-1] >= 0 && parking[filaLibre][columnaLibre-2] == parking[filaLibre][columnaLibre-1]) {
            // Hay un coche a la izquierda del espacio libre, moverlo hacia la derecha
            // Mover el coche a la derecha
            int numCoche = parking[filaLibre][columnaLibre-1];
            parking[filaLibre][columnaLibre-2] = -1; // El espacio libre aparece dos columnas hacia la izquierda
            parking[filaLibre][columnaLibre-1] = -2; // Marcar el coche como bloqueado
            parking[filaLibre][columnaLibre] = -2;
            movimientos.add(numCoche);
            backtracking(filaLibre, columnaLibre-2);
            // Deshacer el movimiento
            parking[filaLibre][columnaLibre-2] = numCoche;
            parking[filaLibre][columnaLibre-1] = numCoche;
            parking[filaLibre][columnaLibre] = -1;
            movimientos.remove(movimientos.size()-1);
        }

        //Probar movimiento horizontal desde la derecha
        if (columnaLibre+2 < parking[0].length && parking[filaLibre][columnaLibre+1] >= 0 && parking[filaLibre][columnaLibre+2] == parking[filaLibre][columnaLibre+1]) {
            // Hay un coche a la derecha del espacio libre, moverlo hacia la izquierda
            // Mover el coche a la izquierda
            int numCoche = parking[filaLibre][columnaLibre+1];
            parking[filaLibre][columnaLibre+2] = -1; // El espacio libre aparece dos columnas hacia la derecha
            parking[filaLibre][columnaLibre+1] = -2; // Marcar el coche como bloqueado
            parking[filaLibre][columnaLibre] = -2;
            movimientos.add(numCoche);
            backtracking(filaLibre, columnaLibre+2);
            // Deshacer el movimiento
            parking[filaLibre][columnaLibre+2] = numCoche;
            parking[filaLibre][columnaLibre+1] = numCoche;
            parking[filaLibre][columnaLibre] = -1;
            movimientos.remove(movimientos.size()-1);
        }

        //Probar movimiento vertical desde arriba
        if (filaLibre-2 >= 0 && parking[filaLibre-1][columnaLibre] >= 0 && parking[filaLibre-2][columnaLibre] == parking[filaLibre-1][columnaLibre]) {
            // Hay un coche arriba del espacio libre, moverlo hacia abajo
            // Mover el coche hacia abajo
            int numCoche = parking[filaLibre - 1][columnaLibre];
            parking[filaLibre - 2][columnaLibre] = -1; // El espacio libre aparece dos filas hacia arriba
            parking[filaLibre - 1][columnaLibre] = -2; // Marcar el coche como bloqueado
            parking[filaLibre][columnaLibre] = -2;
            movimientos.add(numCoche);
            backtracking(filaLibre - 2, columnaLibre);
            // Deshacer el movimiento
            parking[filaLibre - 2][columnaLibre] = numCoche;
            parking[filaLibre - 1][columnaLibre] = numCoche;
            parking[filaLibre][columnaLibre] = -1;
            movimientos.remove(movimientos.size() - 1);
        }

        //Probar movimiento vertical desde abajo
        if (filaLibre+2 < parking.length && parking[filaLibre+1][columnaLibre] >= 0 && parking[filaLibre+2][columnaLibre] == parking[filaLibre+1][columnaLibre]) {
            // Hay un coche abajo del espacio libre, moverlo hacia arriba
            // Mover el coche hacia arriba
            int numCoche = parking[filaLibre + 1][columnaLibre];
            parking[filaLibre + 2][columnaLibre] = -1; // El espacio libre aparece dos filas hacia abajo
            parking[filaLibre + 1][columnaLibre] = -2; // Marcar el coche como bloqueado
            parking[filaLibre][columnaLibre] = -2;
            movimientos.add(numCoche);
            backtracking(filaLibre + 2, columnaLibre);
            // Deshacer el movimiento
            parking[filaLibre + 2][columnaLibre] = numCoche;
            parking[filaLibre + 1][columnaLibre] = numCoche;
            parking[filaLibre][columnaLibre] = -1;
            movimientos.remove(movimientos.size() - 1);
        }
    }

    private static boolean menorLexicograficamente() {
        // Compara dos listas de movimientos lexicográficamente
        int minSize = Math.min(movimientos.size(), solucion.size());
        for (int i = 0; i < minSize; i++) {
            if (movimientos.get(i).compareTo(solucion.get(i)) < 0) {
                return true; // movimientos es menor
            } else if (movimientos.get(i).compareTo(solucion.get(i)) > 0) {
                return false; // movimientos es mayor
            }
        }
        // Si son iguales hasta el tamaño mínimo, la más corta es menor
        if ( Integer.compare(movimientos.size(), solucion.size()) <= 0)  {;
            return true; // movimientos es menor
        } else  {
            return false; // movimientos es mayor
        }
    }

}
