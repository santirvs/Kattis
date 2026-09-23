package Others.Medium.Puntuacion_3_0_a_3_9._3_7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Locale;

public class Circumpsphere {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // Almacenar las coordenadas de los 4 puntos
        double[][] p = new double[4][3];
        for (int i = 0; i < 4; i++) {
            line = br.readLine();
            if (line == null || line.trim().isEmpty()) break;
            StringTokenizer st = new StringTokenizer(line);
            p[i][0] = Double.parseDouble(st.nextToken());
            p[i][1] = Double.parseDouble(st.nextToken());
            p[i][2] = Double.parseDouble(st.nextToken());
        }

        // Construcción del sistema lineal A * X = B tomando P1 como referencia (p[0])
        // Ecuación generalizada para cada punto i (i = 1, 2, 3):
        // (x_i - x_1)x + (y_i - y_1)y + (z_i - z_1)z = 0.5 * [(x_i^2 + y_i^2 + z_i^2) - (x_1^2 + y_1^2 + z_1^2)]

        double[][] A = new double[3][3];
        double[] B = new double[3];

        double normP0 = p[0][0]*p[0][0] + p[0][1]*p[0][1] + p[0][2]*p[0][2];

        for (int i = 1; i <= 3; i++) {
            // Coeficientes de las diferencias de coordenadas (Matriz A)
            A[i-1][0] = p[i][0] - p[0][0];
            A[i-1][1] = p[i][1] - p[0][1];
            A[i-1][2] = p[i][2] - p[0][2];

            // Norma al cuadrado del punto actual
            double normPi = p[i][0]*p[i][0] + p[i][1]*p[i][1] + p[i][2]*p[i][2];

            // Término independiente B
            B[i-1] = 0.5 * (normPi - normP0);
        }

        // Resolución del sistema de 3x3 utilizando la Regla de Cramer
        double detA = determinant(A);

        double[][] Ax = replaceColumn(A, B, 0);
        double[][] Ay = replaceColumn(A, B, 1);
        double[][] Az = replaceColumn(A, B, 2);

        double x = determinant(Ax) / detA;
        double y = determinant(Ay) / detA;
        double z = determinant(Az) / detA;

        // Imprimir las coordenadas del centro con formato estándar (Locale.US para el punto decimal)
        System.out.printf(Locale.US, "%.8f %.8f %.8f\n", x, y, z);
    }

    /**
     * Calcula el determinante de una matriz de 3x3 por expansión de cofactores.
     */
    private static double determinant(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
                - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
                + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    /**
     * Retorna una nueva matriz reemplazando una columna específica con el vector B.
     */
    private static double[][] replaceColumn(double[][] m, double[] col, int colIndex) {
        double[][] res = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = (j == colIndex) ? col[i] : m[i][j];
            }
        }
        return res;
    }
}