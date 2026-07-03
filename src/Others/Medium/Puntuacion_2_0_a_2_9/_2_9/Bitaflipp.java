package Others.Medium.Puntuacion_2_0_a_2_9._2_9;
import java.util.Scanner;

public class Bitaflipp {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);

        if (!sc.hasNextInt()) {
            return;
        }

        int n = sc.nextInt();
        int[] a = new int[n];

        //Cuenta el número total de unos a la vez que guardamos la secuencia de entrada
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] == 1) {
                totalOnes++;
            }
        }

        // Transformación del primer elemento para el algoritmo de Kadane
        // Si es 0 la ganancia es +1, si es 1 la ganancia es -1
        int gananciaInicial = (a[0] == 0) ? 1 : -1;

        int maxGananciaActual = gananciaInicial;
        int maxGananciaGlobal = gananciaInicial;

        // Algoritmo de Kadane para encontrar el subarray de suma máxima
        for (int i = 1; i < n; i++) {
            int valorTransformado = (a[i] == 0) ? 1 : -1;

            // ¿Es mejor continuar el subarreglo actual o empezar uno nuevo desde esta posición?
            maxGananciaActual = Math.max(valorTransformado, maxGananciaActual + valorTransformado);

            // Actualizamos el máximo global encontrado
            maxGananciaGlobal = Math.max(maxGananciaGlobal, maxGananciaActual);
        }

        // El resultado es la cantidad de 1s originales más la ganancia máxima por voltear el rango
        int resultadoFinal = totalOnes + maxGananciaGlobal;

        System.out.println(resultadoFinal);

        sc.close();
    }
}