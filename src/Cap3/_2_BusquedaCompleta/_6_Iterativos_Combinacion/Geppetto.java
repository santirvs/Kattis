package Cap3._2_BusquedaCompleta._6_Iterativos_Combinacion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Calcular todas las combinaciones
// Para calcular las combinaciones de n elementos, podemos mapearlas sobre un entero usando bitmask (hasta 32 elementos)
// Probar todas las combinaciones y comprobar si cumplen las restricciones de incompatibilidad

public class Geppetto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numIngredientes = sc.nextInt();
        //Definir la matriz de incompatibilidades
        boolean[][] incompatibles = new boolean[numIngredientes][numIngredientes];

        // Leer las incompatibilidades
        int numIncompatibilidades = sc.nextInt();
        for (int i = 0; i < numIncompatibilidades; i++) {
            int ingrediente1 = sc.nextInt()-1;
            int ingrediente2 = sc.nextInt()-1;
            incompatibles[ingrediente1][ingrediente2] = true;
            incompatibles[ingrediente2][ingrediente1] = true; // Incompatibilidad mutua
        }

        // Generar todas las combinaciones posibles
        int numCombinacionesValidas = 0;
        for (int combi=0; combi < (1 << numIngredientes); combi++) {
            boolean ok = true;
            // Comprobar si la combinación es válida
            for (int i = 0; ok && i < numIngredientes; i++) {
                if ((combi & (1 << i)) != 0) { // Si el ingrediente i está en la combinación
                    for (int j = i + 1; ok && j < numIngredientes; j++) {
                        if ((combi & (1 << j)) != 0 && incompatibles[i][j]) { // Si el ingrediente j también está y son incompatibles
                            ok = false;
                        }
                    }
                }
            }
            if (ok) {
                // La combinación es válida,
                numCombinacionesValidas++;
            }


        }

        // Imprimir el número de combinaciones válidas
        System.out.println(numCombinacionesValidas);

    }
}
