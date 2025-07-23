package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Leer la lista de números y ordenarlos de mayor a menor
// Dado un número n, calcular todas las parejas de números que se acerquen a n. Guardarnos la diferencia mínima
// Al estar ordenados, si una suma se aleja de la diferencia mínima, podemos dejar de buscar

import java.util.Scanner;

public class ClosestSums {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCaso = 0; // Contador de casos

        while (scan.hasNext()) {
            numCaso++;
            System.out.println("Case " + numCaso + ":");

            int numElementos = scan.nextInt(); // Número de elementos en la lista

            int[] numeros = new int[numElementos];
            for (int i = 0; i < numElementos; i++) {
                numeros[i] = scan.nextInt();
            }

            // Ordenar los números de menor a mayor
            java.util.Arrays.sort(numeros);


            int numConsultas = scan.nextInt(); // Número de consultas para este caso
            for (int consulta = 0; consulta < numConsultas; consulta++) {

                int n = scan.nextInt(); // Número al que queremos acercarnos

                int minDiferencia = Integer.MAX_VALUE;
                int sumaCercana = 0; // Variable para almacenar la suma más cercana

                // Buscar las parejas que se acerquen a n
                for (int j = 0; j < numElementos; j++) {
                    for (int k = j + 1; k < numElementos; k++) {
                        int suma = numeros[j] + numeros[k];
                        int diferencia = Math.abs(suma - n);
                        if (diferencia < minDiferencia) {
                            minDiferencia = diferencia;
                            sumaCercana = suma;
                        }
                    }
                }

                // Mostrar el resultado
                System.out.println("Closest sum to " + n + " is " + sumaCercana + ".");
            }

        }

    }
}