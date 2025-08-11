package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;

// Simular el lanzamiento de cada uno de los dados
// y apuntar el resultado de cada lanzamiento
// Recorrer el array de resultados y mostrar todos los resultados que salen el máximo número de veces

import java.util.Scanner;

public class DiceCup {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Leer los datos
        int dado1 = scan.nextInt(); // Caras del primer dado
        int dado2 = scan.nextInt(); // Caras del segundo dado

        // Array para contar las combinaciones
        // El máximo resultado posible es dado1 + dado2
        // El mínino resultado posible es 2 (1+1)
        // Lo hacemos con base 1 para simplificar el acceso
        int[] combinaciones = new int[dado1 + dado2 + 1];

        // Simular el lanzamiento de los dados
        int maximo = 0; // Variable para almacenar el máximo número de combinaciones
        for (int i = 1; i <= dado1; i++) {
            for (int j = 1; j <= dado2; j++) {
                // Incrementar el contador de la combinación
                combinaciones[i + j]++;
                // Actualizar el máximo si es necesario
                maximo = Math.max(maximo, combinaciones[i + j]);
            }
        }

        // Recorrer el array de combinaciones y mostrar los resultados
        for (int i = 2; i < combinaciones.length; i++) {
            // Si la combinación tiene el máximo número de veces
            if (combinaciones[i] == maximo) {
                // Imprimir el resultado
                System.out.println(i);
            }
        }

    }

}


