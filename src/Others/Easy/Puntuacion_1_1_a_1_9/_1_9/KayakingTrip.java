package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Crear un grafo con sus adyacencias y aplicar un Dijkstra
 * O simplemente con programación dinámica y guardarnos el padre para llegar al nodo
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class KayakingTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Validar si hay datos de entrada
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();

        // Matriz de costos C[i][j] representará el costo de ir de la estación i a la j
        // Usamos tamaño n + 1 para mantener la indexación basada en 1 (1 a n)
        int[][] c = new int[n + 1][n + 1];

        // Lectura de la matriz de costos de entrada
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                c[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        // DP[i] almacenará el costo mínimo para llegar a la estación i desde la estación 1
        int[] dp = new int[n + 1];

        // padre[i] almacenará la estación previa óptima para llegar a la estación i
        int[] padre = new int[n + 1];

        // Inicializamos la tabla DP con un valor infinito (un número muy grande)
        int infinito = 1000000000;
        for (int i = 2; i <= n; i++) {
            dp[i] = infinito;
        }

        // Caso base: El costo para empezar en la estación 1 es 0
        dp[1] = 0;

        // Llenado de la tabla DP (Programación Dinámica)
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int costoActual = dp[j] + c[j][i];
                if (costoActual < dp[i]) {
                    dp[i] = costoActual;
                    padre[i] = j;
                }
            }
        }

        // Reconstrucción del camino óptimo desde el final (n) hacia el principio (1)
        ArrayList<Integer> ruta = new ArrayList<Integer>();
        int actual = n;
        while (actual != 0) {
            ruta.add(actual);
            actual = padre[actual]; // Moverse al nodo padre
        }

        // Como la ruta se construyó al revés (n -> ... -> 1), la invertimos
        Collections.reverse(ruta);

        // Imprimir la secuencia de estaciones separadas por un espacio
        for (int i = 0; i < ruta.size(); i++) {
            System.out.print(ruta.get(i));
            if (i < ruta.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        // Imprimir el costo total mínimo calculado
        System.out.println(dp[n]);
    }
}