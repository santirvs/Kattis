package Cap3._2_BusquedaCompleta._5_Iterativos_Permutacion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// Calcular todas las permutaciones
// Aquí deberíamos usar un enfoque de todas las permutaciones, limitado a 10 personas.
// Usaremos DP con bitmask para optimizar el proceso O(n * 2^n) donde n es el número de personas
// Para cada persona, calcular si se puede poner adyacente a la anterior

public class ClassPicture {

    static int numPersonas;
    static HashMap<String, Integer> nombres;
    static boolean[][] incompatibles; // Incompatibilidades entre las personas de la clase
    static int[][] dp;  // Array para programación dinámica

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            //Leer número de personas
            numPersonas = sc.nextInt();
            //Leer las personas
            for (int i = 0; i < numPersonas; i++) {
                String nombre = sc.next();
                nombres.put(nombre, i); // Guardar el nombre de la persona
            }

            //Leer las incompatibilidades entre miembros de la clase, inicializado a false
            incompatibles = new boolean[numPersonas][numPersonas];
            int numIncompatibilidades = sc.nextInt();
            for (int i = 0; i < numIncompatibilidades; i++) {
                String persona1 = sc.next();
                String persona2 = sc.next();
                // Son mútuamente incompatibles
                incompatibles[nombres.get(persona1)][nombres.get(persona2)] = true;
                incompatibles[nombres.get(persona2)][nombres.get(persona1)] = true;
            }

            >>>> VOY POR AQUÍ!!!


            // Inicializar DP
            int size = 1 << numPersonas;
            dp = new int[size][numPersonas];
            for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

            // Inicializar DP: solo una rutina en uso
            for (int i = 0; i < numPersonas; i++)
                dp[1 << i][i] = 0;

            // Llenar tabla DP
            for (int mask = 0; mask < size; mask++) {
                for (int last = 0; last < numPersonas; last++) {
                    if ((mask & (1 << last)) == 0 || dp[mask][last] == Integer.MAX_VALUE) continue;
                    for (int next = 0; next < numPersonas; next++) {
                        if ((mask & (1 << next)) != 0) continue;
                        int nextMask = mask | (1 << next);
                        int change = incompatibles[last][next];
                        dp[nextMask][next] = Math.min(dp[nextMask][next], dp[mask][last] + change);
                    }
                }
            }

            // Encontrar el mínimo de cambios rápidos al final de todas las rutinas
            int minQuickChanges = Integer.MAX_VALUE;
            for (int i = 0; i < numPersonas; i++)
                minQuickChanges = Math.min(minQuickChanges, dp[size - 1][i]);

            // Mostrar el mínimo de cambios rápidos
            System.out.println(minQuickChanges);
        }
    }
}
