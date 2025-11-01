package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la cantidad de muestras
// Leer la primera muestra
// Para cada muestra,
//    Leer t y V
//    Calcular el valor de Tais usando la fórmula (Va+Vb)/2 * (tb-ta)
//    Acumular el resultado
//    Valores de b = a+ 1
// Imprimir el resultado acumulado con 6 decimales


import java.util.Locale;
import java.util.Scanner;

public class TaisFormula {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer la cantidad de muestras
        int numMuestras = sc.nextInt();

        // Leer la primera muestra
        double tAnterior = sc.nextDouble();
        double vAnterior = sc.nextDouble();
        double resultado = 0.0;

        // Para cada muestra,
        for (int i = 1; i < numMuestras; i++) {
            // Leer t y V
            double tActual = sc.nextDouble();
            double vActual = sc.nextDouble();

            // Calcular el valor de Tais usando la fórmula (Va+Vb)/2 * (tb-ta)
            double tais = (vAnterior + vActual) / 2.0 * (tActual - tAnterior);

            // Acumular el resultado
            resultado += tais;

            // Valores de b = a
            tAnterior = tActual;
            vAnterior = vActual;
        }

        // Imprimir el resultado acumulado con 6 decimales
        System.out.printf(Locale.UK, "%.6f%n", resultado/1000);

        sc.close();
    }
}

