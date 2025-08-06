package Cap3._2_BusquedaCompleta._6_Iterativos_Combinacion;

import java.util.Scanner;

// Probar las diferentes combinaciones de los hasta 2^10 ingredientes (2^10 = 1024, asumible))
// Calcular el resultado de la acidez y amargura de la combinación de ingredientes
// Guardar la que tenga menor diferencia entre acidez y amargura

public class Perket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de ingredientes
        int numIngredientes = sc.nextInt();
        // Array para almacenar los ingredientes
        int[][] ingredientes = new int[numIngredientes][2];
        // Leer los ingredientes (acidez y amargura)
        for (int i = 0; i < numIngredientes; i++) {
            ingredientes[i][0] = sc.nextInt(); // acidez
            ingredientes[i][1] = sc.nextInt(); // amargura
        }
        // Inicializar la mejor diferencia como el máximo posible
        int mejorDiferencia = Integer.MAX_VALUE;
        // Probar todas las combinaciones de los ingredientes
        // Empezar desde 1 para evitar la combinación vacía
        for (int i = 1; i < (1 << numIngredientes); i++) {
            int acidez = 1, amargura = 0;
            for (int j = 0; j < numIngredientes; j++) {
                // Si el bit j está activo, incluir el ingrediente j
                if ((i & (1 << j)) != 0) {
                    acidez *= ingredientes[j][0];
                    amargura += ingredientes[j][1];
                }
            }
            // Calcular la diferencia entre acidez y amargura
            int diferencia = Math.abs(acidez - amargura);
            // Actualizar la mejor diferencia si es menor
            if (diferencia < mejorDiferencia) {
                mejorDiferencia = diferencia;
            }
        }

        // Mostrar la mejor diferencia encontrada
        System.out.println(mejorDiferencia);
    }
}
