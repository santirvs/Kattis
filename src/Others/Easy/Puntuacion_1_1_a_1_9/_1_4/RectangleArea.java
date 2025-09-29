package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer las coordenadas del rectángulo (numeros reales)
// Calcular los lados del rectángulo
// Calcular el área del rectángulo
// Imprimir el área del rectángulo con tres decimales

import java.util.Locale;
import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer las coordenadas del rectángulo (numeros reales)
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        // Calcular los lados del rectángulo
        double lado1 = Math.abs(x2 - x1);
        double lado2 = Math.abs(y2 - y1);

        // Calcular el área del rectángulo
        double area = lado1 * lado2;

        // Imprimir el área del rectángulo con dos decimales
        System.out.printf("%.3f%n", area);

        sc.close();
    }
}

