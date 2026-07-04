package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

/**
 * Problema que disfraza la aritmética de números complejos
 */

import java.util.Scanner;
import java.util.Locale;

public class Invoker_Easy {
    public static void main(String[] args) {
        // Usamos Locale.US para asegurarnos de que el formato de salida use puntos decimales (.)
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        // Comprobamos si hay datos disponibles en la entrada
        if (sc.hasNextDouble()) {
            // Lectura de tus fuentes mágicas (Tu número complejo A)
            double rA = sc.nextDouble();
            double iA = sc.nextDouble();

            // Lectura de las fuentes mágicas del oponente (Su número complejo B)
            double rB = sc.nextDouble();
            double iB = sc.nextDouble();

            // Cálculo del denominador común: (Real_B^2 + Imag_B^2)
            double denominador = (rB * rB) + (iB * iB);

            // Aplicación de las fórmulas de división de números complejos
            double rFinal = ((rA * rB) + (iA * iB)) / denominador;
            double iFinal = ((iA * rB) - (rA * iB)) / denominador;

            // Impresión del resultado con el formato requerido
            // %.2f formatea a dos decimales, pero el problema acepta cualquier salida
            // siempre que el error sea menor a 10^-3. Usamos 6 decimales por seguridad.
            System.out.printf(Locale.US, "%.6f %.6f\n", rFinal, iFinal);
        }

        sc.close();
    }
}