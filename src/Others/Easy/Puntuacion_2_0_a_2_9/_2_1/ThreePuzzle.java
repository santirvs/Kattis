package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ThreePuzzle {

    // Representa el mapa de vecinos (adyacencias) de cada posición (0, 1, 2, 3).
    // ADJACENT[i] contiene los índices del String con los que el espacio '-'
    // se puede intercambiar si actualmente se encuentra en la posición i.
    private static final int[][] ADJACENT = {
            {1, 2}, // Si '-' está en el índice 0, sus vecinos válidos son el 1 y el 2
            {0, 3}, // Si '-' está en el índice 1, sus vecinos válidos son el 0 y el 3
            {0, 3}, // Si '-' está en el índice 2, sus vecinos válidos son el 0 y el 3
            {1, 2}  // Si '-' está en el índice 3, sus vecinos válidos son el 1 y el 2
    };

    // Clase auxiliar para guardar un estado del tablero y cuántos movimientos
    // nos costó llegar a él desde el estado inicial.
    private static class State {
        String board; // Ejemplo: "2-13"
        int moves;    // Movimientos realizados hasta este punto

        State(String board, int moves) {
            this.board = board;
            this.moves = moves;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leemos las 2 líneas del tablero y las unimos en una sola cadena de 4 caracteres
        StringBuilder initialBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            if (scanner.hasNextLine()) {
                initialBuilder.append(scanner.nextLine().trim());
            }
        }
        scanner.close();

        String startState = initialBuilder.toString();
        String targetState = "123-"; // El estado final resuelto

        // Caso base: si el tablero ingresado ya está resuelto desde el inicio
        if (startState.equals(targetState)) {
            System.out.println(0);
            return;
        }

        // --- BÚSQUEDA EN ANCHURA (BFS) ---
        // 'queue' almacena los estados pendientes por explorar en orden de llegada (FIFO).
        // BFS garantiza que la primera vez que encontremos la meta, será por el camino más corto.
        Queue<State> queue = new ArrayDeque<State>();

        // 'visited' memoriza las configuraciones de tablero que ya procesamos
        // para no entrar en ciclos infinitos (ej. mover de 0 a 1 y luego de 1 a 0 sin parar).
        Set<String> visited = new HashSet<String>();

        // Registramos el estado inicial con 0 movimientos
        queue.add(new State(startState, 0));
        visited.add(startState);

        while (!queue.isEmpty()) {
            // Extraemos el estado más antiguo de la cola para procesarlo
            State current = queue.poll();

            // Si el estado actual es igual al estado objetivo, terminamos
            if (current.board.equals(targetState)) {
                System.out.println(current.moves);
                return;
            }

            // Ubicamos en qué índice (0, 1, 2 o 3) se encuentra la casilla vacía '-'
            int emptyIndex = current.board.indexOf('-');

            // Recorremos cada una de las posiciones adyacentes a donde está el '-'
            for (int neighborIndex : ADJACENT[emptyIndex]) {

                // Generamos un nuevo tablero intercambiando el '-' con la ficha vecina
                String nextBoard = swap(current.board, emptyIndex, neighborIndex);

                // Si nunca habíamos visto este tablero antes, lo procesamos
                if (!visited.contains(nextBoard)) {
                    visited.add(nextBoard);

                    // Lo agregamos a la cola sumándole 1 al número de movimientos
                    queue.add(new State(nextBoard, current.moves + 1));
                }
            }
        }
    }

    /**
     * Helper para intercambiar dos caracteres dentro de una cadena.
     * Retorna un nuevo String con los caracteres en las posiciones i y j intercambiados.
     */
    private static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}