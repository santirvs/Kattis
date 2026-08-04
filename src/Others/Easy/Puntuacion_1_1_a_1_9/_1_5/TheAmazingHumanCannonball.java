package Others.Easy.Puntuacion_1_1_a_1_9._1_5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TheAmazingHumanCannonball {

    // Constante de gravedad definida en el enunciado
    private static final double GRAVITY = 9.81;
    // Margen de seguridad requerido por arriba y por abajo (en metros)
    private static final double SAFETY_MARGIN = 1.0;

    public static void main(String[] args) throws IOException {
        // Uso de BufferedReader para eficientar la lectura de la entrada estándar
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        // N representa el número total de casos de prueba
        int n = Integer.parseInt(line.trim());

        // Procesamos cada caso de prueba
        for (int i = 0; i < n; i++) {
            line = br.readLine();

            // Leamos la línea ignorando posibles líneas vacías intermedias
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line == null) {
                break;
            }

            // StringTokenizer permite parsear los números flotantes separados por espacio
            StringTokenizer st = new StringTokenizer(line);

            double v0 = Double.parseDouble(st.nextToken());
            double thetaDegrees = Double.parseDouble(st.nextToken());
            double x = Double.parseDouble(st.nextToken());
            double h1 = Double.parseDouble(st.nextToken());
            double h2 = Double.parseDouble(st.nextToken());

            // Evaluación de la trayectoria para el caso de prueba actual
            if (esSeguro(v0, thetaDegrees, x, h1, h2)) {
                System.out.println("Safe");
            } else {
                System.out.println("Not Safe");
            }
        }
    }

    /**
     * Calcula la trayectoria parabólica y evalúa si la persona pasa a través
     * de la apertura cumpliendo con los márgenes de seguridad requeridos.
     */
    private static boolean esSeguro(double v0, double thetaDegrees, double x, double h1, double h2) {
        // 1. Convertir el ángulo de grados a radianes.
        // Las funciones trigonométricas de java.lang.Math (sin, cos) requieren radianes.
        double thetaRad = Math.toRadians(thetaDegrees);

        // 2. Calcular el instante de tiempo (t) en que el proyectil alcanza el muro (distancia x).
        // De la fórmula x(t) = v0 * t * cos(theta), despejamos:
        // t = x / (v0 * cos(theta))
        double t = x / (v0 * Math.cos(thetaRad));

        // 3. Calcular la altura (y) alcanzada por el proyectil en ese instante t.
        // Ecuación de posición vertical: y(t) = v0 * t * sin(theta) - 0.5 * g * t^2
        double y = (v0 * t * Math.sin(thetaRad)) - (0.5 * GRAVITY * t * t);

        // 4. Verificar la condición de seguridad:
        // Debe haber un margen de al menos 1.0 m tanto sobre h1 como debajo de h2.
        // Es decir: (h1 + 1.0) <= y <= (h2 - 1.0)
        double limiteInferiorSeguro = h1 + SAFETY_MARGIN;
        double limiteSuperiorSeguro = h2 - SAFETY_MARGIN;

        return (y >= limiteInferiorSeguro) && (y <= limiteSuperiorSeguro);
    }
}