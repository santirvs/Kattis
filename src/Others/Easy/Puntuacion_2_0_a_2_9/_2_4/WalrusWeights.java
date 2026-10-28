package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

import java.util.Scanner;

public class WalrusWeights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] plates = new int[n];
        for (int i = 0; i < n; i++) {
            plates[i] = scanner.nextInt();
        }
        scanner.close();

        // 1. Definición del rango máximo de pesos a evaluar.
        // El objetivo es acercarse lo más posible a 1000 kg.
        // Dado que un peso superior a 2000 kg está a una distancia mayor a 1000 de nuestro objetivo
        // (lo cual es peor que no elegir ningún plato y sumar 0), no necesitamos calcular más allá de 2000.
        int maxWeight = 2000;

        // Arreglo booleano donde possible[w] será true si es posible
        // obtener exactamente el peso 'w' sumando un subconjunto de discos.
        boolean[] possible = new boolean[maxWeight + 1];

        // Caso base: con 0 platos se puede obtener un peso de 0 kg.
        possible[0] = true;

        // 2. Programación Dinámica (Variante de Subset Sum / Mochila 0/1)
        // Para cada plato disponible, actualizamos qué pesos se pueden formar.
        for (int i = 0; i < n; i++) {
            int w = plates[i];

            // Recorremos de derecha a izquierda (de maxWeight hacia w)
            // Esto es crucial para asegurar que cada plato se use a lo sumo una vez.
            for (int j = maxWeight; j >= w; j--) {
                // Si ya podíamos formar el peso (j - w), ahora también podemos formar el peso j
                // agregando este nuevo plato 'w'.
                if (possible[j - w]) {
                    possible[j] = true;
                }
            }
        }

        // 3. Búsqueda del resultado óptimo
        int bestWeight = 0;
        int minDiff = 1000; // La máxima diferencia inicial posible respecto a 1000

        for (int j = 0; j <= maxWeight; j++) {
            // Evaluamos únicamente los pesos que realmente se pueden formar
            if (possible[j]) {
                int diff = Math.abs(j - 1000);

                // Si encontramos un peso cuya distancia a 1000 es menor estrictamente
                if (diff < minDiff) {
                    minDiff = diff;
                    bestWeight = j;
                }
                // Regla de desempate: Si la distancia es exactamente la misma (ej. 998 y 1002),
                // el problema exige elegir el valor mayor (en este caso, 1002).
                else if (diff == minDiff) {
                    if (j > bestWeight) {
                        bestWeight = j;
                    }
                }
            }
        }

        // 4. Imprimir el peso ganador
        System.out.println(bestWeight);
    }
}