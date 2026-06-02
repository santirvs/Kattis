package Others.Medium.Puntuacion_2_0_a_2_9._2_8;

// Ver CrackingTheSafe.md

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CrackingTheSafe {

    // Matriz de adyacencia que define qué índices (0-8) se ven afectados
    // cuando se presiona el botón 'i'.
    // Los índices van de 0 a 8 correspondientes a:
    // 0 1 2
    // 3 4 5
    // 6 7 8
    private static final int[][] AFFECTED = {
            {0, 1, 2, 3, 6},    // Botón 0 afecta fila 0 (0,1,2) y col 0 (0,3,6)
            {0, 1, 2, 4, 7},    // Botón 1 afecta fila 0 (0,1,2) y col 1 (1,4,7)
            {0, 1, 2, 5, 8},    // Botón 2...
            {0, 3, 4, 5, 6},    // Botón 3...
            {1, 3, 4, 5, 7},    // Botón 4 (Centro)
            {2, 3, 4, 5, 8},    // Botón 5...
            {0, 3, 6, 7, 8},    // Botón 6...
            {1, 4, 6, 7, 8},    // Botón 7...
            {2, 5, 6, 7, 8}     // Botón 8...
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer el estado inicial del tablero y guardarlo como un arreglo de 9 dígitos
        int[] initialGrid = new int[9];
        int initialIndex = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (scan.hasNextInt()) {
                    initialGrid[initialIndex++] = scan.nextInt();
                }
            }
        }

        // Convertir el arreglo inicial a su representación en entero
        int initialState = gridToInt(initialGrid);

        // El estado objetivo son 9 ceros, es decir, el número 0
        int targetState = 0;

        // Si ya está en ceros, se necesitan 0 pasos
        if (initialState == targetState) {
            System.out.println(0);
            return;
        }

        // Arreglo para guardar la distancia (pasos) a cada estado.
        // El tamaño máximo posible es 4^9 = 262144 estados (del 000000000 al 333333333 en base 4)
        // Usamos -1 para indicar que un estado no ha sido visitado.
        int[] dist = new int[262144];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = -1;
        }

        // Cola para el BFS
        Queue<Integer> queue = new LinkedList<Integer>();

        // Empezamos desde el estado inicial
        int initialId = stateToId(initialState);
        dist[initialId] = 0;
        queue.add(initialState);

        boolean found = false;

        while (!queue.isEmpty()) {
            int currentState = queue.poll();
            int currentId = stateToId(currentState);

            // Si llegamos al objetivo (todos ceros)
            if (currentState == targetState) {
                System.out.println(dist[currentId]);
                found = true;
                break;
            }

            // Intentar presionar cada uno de los 9 botones
            for (int button = 0; button < 9; button++) {
                int nextState = pressButton(currentState, button);
                int nextId = stateToId(nextState);

                // Si este estado no ha sido visitado
                if (dist[nextId] == -1) {
                    dist[nextId] = dist[currentId] + 1;
                    queue.add(nextState);
                }
            }
        }

        // Si la cola se vacía y no encontramos el objetivo, es imposible
        if (!found) {
            System.out.println(-1);
        }
    }

    // Aplica el efecto de presionar un botón al estado actual entero
    private static int pressButton(int state, int button) {
        int[] grid = intToGrid(state);

        // Incrementar en módulo 4 las celdas afectadas por el botón
        for (int cell : AFFECTED[button]) {
            grid[cell] = (grid[cell] + 1) % 4;
        }

        return gridToInt(grid);
    }

    // Convierte un arreglo de 9 posiciones a un entero de 9 dígitos en base 10
    private static int gridToInt(int[] grid) {
        int res = 0;
        for (int i = 0; i < 9; i++) {
            res = res * 10 + grid[i];
        }
        return res;
    }

    // Convierte un entero de 9 dígitos de regreso a un arreglo de 9 posiciones
    private static int[] intToGrid(int state) {
        int[] grid = new int[9];
        for (int i = 8; i >= 0; i--) {
            grid[i] = state % 10;
            state /= 10;
        }
        return grid;
    }

    // Mapea el estado de 9 dígitos (ej. 312011323) a un ID único entre 0 y 262143
    // tratándolo como un número en Base 4. Esto optimiza el espacio del arreglo 'dist'.
    private static int stateToId(int state) {
        int id = 0;
        int power = 1;
        while (state > 0) {
            int digit = state % 10;
            id += digit * power;
            power *= 4;
            state /= 10;
        }
        return id;
    }
}