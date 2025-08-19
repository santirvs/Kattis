package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// Busqueda binaria para a, donde a es un valor tal que f(a) = 0 ya que a es una raíz de f.
// Una vez tengamos a, calcular la l

import java.util.Scanner;

public class SuspensionBridge {
    static double d, s;

    // Definición de la función f(a)
    static double f(double a) {
        return -a + a * Math.cosh(d / (2.0 * a)) - s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        d = sc.nextDouble();
        s = sc.nextDouble();

        double l = 0.0;   // Valor mínimo de a
        double r = 1e6;  // Valor máximo de a (arbitrario lo suficientemente grande)

        // Búsqueda binaria (100 iteraciones)
        for (int i = 0; i < 100; i++) {
            double mid = (l + r) / 2.0;
            if (f(mid) < 0) {
                r = mid;
            } else {
                l = mid;
            }
        }

        // Resultado final
        double result = 2.0 * l * Math.sinh(d / (2.0 * l));
        System.out.println(result);

        sc.close();
    }
}
