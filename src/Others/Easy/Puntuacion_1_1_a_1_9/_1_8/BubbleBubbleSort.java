package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleBubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int numBurbujas = sc.nextInt();
        int amplitud = sc.nextInt(); // Equivalente a 'k'

        int[] numeros = new int[numBurbujas];
        for (int i = 0; i < numBurbujas; i++) {
            numeros[i] = sc.nextInt();
        }

        int horas = 0;

        while (!estaOrdenado(numeros)) {
            horas++;

            // Desplazamos la ventana de tamaño 'amplitud' de izquierda a derecha
            for (int i = 0; i <= numBurbujas - amplitud; i++) {
                // Ordenamos la subventana de tamaño 'amplitud' [i, i + amplitud)
                Arrays.sort(numeros, i, i + amplitud);
            }
        }

        System.out.println(horas);
    }

    private static boolean estaOrdenado(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}