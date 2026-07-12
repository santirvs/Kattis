package Others.Easy.Puntuacion_1_1_a_1_9._1_6;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HalfACookie {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                StringTokenizer st = new StringTokenizer(line);
                if (!st.hasMoreTokens()) continue;

                double r = Double.parseDouble(st.nextToken());
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());

                // Distancia desde el centro (0,0) al punto de impacto
                double d = Math.sqrt(x * x + y * y);

                // Si la distancia es mayor o igual al radio, es un fallo (miss)
                if (d >= r) {
                    System.out.println("miss");
                } else {
                    // Área total del círculo
                    double areaTotal = Math.PI * r * r;

                    // Ángulo central theta utilizando el coseno
                    double theta = 2.0 * Math.acos(d / r);

                    // Área del segmento circular menor
                    double areaPequena = 0.5 * r * r * (theta - Math.sin(theta));

                    // Área del segmento mayor
                    double areaGrande = areaTotal - areaPequena;

                    // El problema pide imprimir primero la porción más grande
                    System.out.printf("%.6f %.6f\n", areaGrande, areaPequena);
                }
            }
        } catch (Exception e) {
            // Manejo silencioso de excepciones requerido para plataformas de jueceo de código
            System.exit(0);
        }
    }
}