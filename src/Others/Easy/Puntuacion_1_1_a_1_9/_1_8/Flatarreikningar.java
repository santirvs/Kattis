package Others.Easy.Puntuacion_1_1_a_1_9._1_8;
import java.util.Locale;
import java.util.Scanner;

public class Flatarreikningar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextDouble()) {
            double volumen = scanner.nextDouble();
            double superficie = calcularSuperficieDesdeVolumen(volumen);

            // Formato con punto decimal para la salida estándar
            System.out.println(superficie);
        }

        scanner.close();
    }

    /**
     * Calcula la superficie de una esfera a partir de su volumen mediante el método de 2 pasos.
     */
    public static double calcularSuperficieDesdeVolumen(double V) {
        /*
         * =========================================================================
         * PLANTEAMIENTO EN 2 PASOS:
         *
         * PASO 1: Despejar el radio (r) a partir del volumen (V).
         *         Fórmula del Volumen: V = (4/3) * pi * r^3
         *         Despejando r:        r = (3 * V / (4 * pi)) ^ (1/3)
         *
         * PASO 2: Calcular el área de la superficie (A) usando el radio obtenido.
         *         Fórmula del Área:    A = 4 * pi * r^2
         * =========================================================================
         */

        // PASO 1: Obtener el radio mediante raíz cúbica (Math.cbrt en Java 1.7)
        double radio = Math.cbrt((3.0 * V) / (4.0 * Math.PI));

        // PASO 2: Obtener la superficie usando el radio recién calculado
        double superficie = 4.0 * Math.PI * Math.pow(radio, 2);

        return superficie;
    }
}