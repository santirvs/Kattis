package Cap3._2_BusquedaCompleta._5_Iterativos_Permutacion;

import java.util.*;

// Calcular todas las permutaciones
// Como está limitado a 10 rutinas, se puede usar un enfoque de búsqueda completa 10! -> 3628800 estamos al límite
// Si no funciona, se puede usar DP con bitmask para optimizar el proceso O(n * 2^n) donde n es el número de rutinas
// que para n = 10 es 1024, por lo que el tiempo de ejecución es aceptable

// v1 -> TLE en Caso #5--> abortar si se encuentra una permutación con 0 repeticiones --> continua el TLE
// v2 : Cambiar planteamiento y usar DP con bitmask para evitar TLE

public class DanceRecital {

    static int numRutinas;
    static String[] rutinas;
    static int[][] quickChanges; // Número de bailarinas comunes entre rutina i y j
    static int[][] dp;  // Array para programación dinámica

    private static int quickChangesRequired(String anterior, String actual) {
        int repeticiones = 0;
        for (int i = 0; i < anterior.length(); i++) {
            for (int j = 0; j < actual.length(); j++) {
                if (anterior.charAt(i) == actual.charAt(j)) {
                    repeticiones++; // Al menos hay una repetición
                }
            }
        }
        return repeticiones;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Leer número de rutinas
        numRutinas = sc.nextInt();
        //Leer las rutinas
        rutinas = new String[numRutinas];
        for (int i = 0; i < numRutinas; i++) rutinas[i] = sc.next();

        // Preprocesar intersecciones entre rutinas, todas contra todas (N^2)
        quickChanges = new int[numRutinas][numRutinas];
        for (int i = 0; i < numRutinas; i++) {
            for (int j = 0; j < numRutinas; j++) {
                quickChanges[i][j] = quickChangesRequired(rutinas[i], rutinas[j]);
            }
        }

        // Inicializar DP
        int size = 1 << numRutinas;
        dp = new int[size][numRutinas];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        // Inicializar DP: solo una rutina en uso
        for (int i = 0; i < numRutinas; i++)
            dp[1 << i][i] = 0;

        // Llenar tabla DP
        for (int mask = 0; mask < size; mask++) {
            for (int last = 0; last < numRutinas; last++) {
                if ((mask & (1 << last)) == 0 || dp[mask][last] == Integer.MAX_VALUE) continue;
                for (int next = 0; next < numRutinas; next++) {
                    if ((mask & (1 << next)) != 0) continue;
                    int nextMask = mask | (1 << next);
                    int change = quickChanges[last][next];
                    dp[nextMask][next] = Math.min(dp[nextMask][next], dp[mask][last] + change);
                }
            }
        }

        // Encontrar el mínimo de cambios rápidos al final de todas las rutinas
        int minQuickChanges = Integer.MAX_VALUE;
        for (int i = 0; i < numRutinas; i++)
            minQuickChanges = Math.min(minQuickChanges, dp[size - 1][i]);

        // Mostrar el mínimo de cambios rápidos
        System.out.println(minQuickChanges);
    }
}
