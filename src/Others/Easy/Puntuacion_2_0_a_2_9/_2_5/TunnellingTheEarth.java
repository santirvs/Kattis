package Others.Easy.Puntuacion_2_0_a_2_9._2_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TunnellingTheEarth {
    // Radio exacto de la Tierra definido en el problema en metros
    private static final double R = 6371009.0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int numTestCases = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < numTestCases; tc++) {
            line = br.readLine();
            if (line == null) break;
            st = new StringTokenizer(line);

            double lat1 = Double.parseDouble(st.nextToken());
            double lon1 = Double.parseDouble(st.nextToken());
            double lat2 = Double.parseDouble(st.nextToken());
            double lon2 = Double.parseDouble(st.nextToken());

            // 1. Convertir las latitudes y longitudes de grados a radianes
            double lat1Rad = Math.toRadians(lat1);
            double lon1Rad = Math.toRadians(lon1);
            double lat2Rad = Math.toRadians(lat2);
            double lon2Rad = Math.toRadians(lon2);

            // 2. Transformar ambos puntos esféricos a coordenadas cartesianas 3D (x, y, z)
            double x1 = R * Math.cos(lat1Rad) * Math.cos(lon1Rad);
            double y1 = R * Math.cos(lat1Rad) * Math.sin(lon1Rad);
            double z1 = R * Math.sin(lat1Rad);

            double x2 = R * Math.cos(lat2Rad) * Math.cos(lon2Rad);
            double y2 = R * Math.cos(lat2Rad) * Math.sin(lon2Rad);
            double z2 = R * Math.sin(lat2Rad);

            // 3. Calcular la distancia en línea recta (túnel) a través de la Tierra
            double dx = x1 - x2;
            double dy = y1 - y2;
            double dz = z1 - z2;
            double tunnelDistance = Math.sqrt(dx * dx + dy * dy + dz * dz);

            // 4. Calcular el ángulo central (theta) entre ambos vectores posición
            // Usamos el producto escalar (dot product) normalizado por R^2
            double dotProduct = x1 * x2 + y1 * y2 + z1 * z2;
            double cosTheta = dotProduct / (R * R);

            // Control de precisión para evitar imprecisiones de coma flotante que resulten en valores fuera de [-1.0, 1.0]
            if (cosTheta > 1.0) cosTheta = 1.0;
            if (cosTheta < -1.0) cosTheta = -1.0;

            double theta = Math.acos(cosTheta);

            // 5. Distancia sobre el arco (gran círculo)
            double surfaceDistance = R * theta;

            // 6. La respuesta requerida es la diferencia entre ambas distancias
            double difference = surfaceDistance - tunnelDistance;

            // Mostrar el resultado redondeando dinámicamente con precisión matemática
            System.out.printf("%.6f\n", difference);
        }
    }
}