package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

import java.util.Scanner;
import java.util.Locale;

public class TrackSmoothing {

    public static void main(String[] args) {
        // Configuramos Locale.US para asegurar la lectura y formato de punto decimal '.'
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        if (!sc.hasNextInt()) {
            return;
        }

        int t = sc.nextInt(); // Número de casos de prueba

        while (t-- > 0) {
            double r = sc.nextDouble(); // Radio mínimo requerido
            int n = sc.nextInt();       // Número de vértices del polígono

            double[] x = new double[n];
            double[] y = new double[n];

            for (int i = 0; i < n; i++) {
                x[i] = sc.nextDouble();
                y[i] = sc.nextDouble();
            }

            // 1. Calcular el perímetro total (L) del polígono original
            double L = 0.0;
            for (int i = 0; i < n; i++) {
                int nextIndex = (i + 1) % n; // El último punto se conecta con el primero
                double dx = x[nextIndex] - x[i];
                double dy = y[nextIndex] - y[i];
                L += Math.sqrt(dx * dx + dy * dy);
            }

            // 2. Calcular el factor de escala s = (L - 2 * PI * R) / L
            double minLengthRequired = 2.0 * Math.PI * r;

            if (L <= minLengthRequired) {
                // Si el perímetro es menor o igual al perímetro del círculo formado por las esquinas,
                // el factor de escala s sería <= 0, lo cual es imposible.
                System.out.println("Not possible");
            } else {
                double s = (L - minLengthRequired) / L;
                System.out.printf(Locale.US, "%.6f\n", s);
            }
        }

        sc.close();
    }
}