package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class UnlockPattern {

    // Clase auxiliar estática para representar las coordenadas de un pivote
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        // Arreglo para almacenar la posición de cada número del 1 al 9.
        // Usamos índice de 1 a 9 para mayor claridad (tamaño 10).
        Point[] positions = new Point[10];

        // ------------------------------------------------------------------
        // 1. LECTURA Y MAPEO DE COORDENADAS
        // ------------------------------------------------------------------
        // La cuadrícula es de 3x3. Recorremos las filas (r) y columnas (c).
        // Guardamos las coordenadas (r, c) asociadas al número leído.
        for (int r = 0; r < 3; r++) {
            String line = reader.readLine();
            if (line == null || line.trim().isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            for (int c = 0; c < 3; c++) {
                int val = Integer.parseInt(st.nextToken());
                // El valor 'val' representa el paso en el patrón de desbloqueo.
                // Registramos su coordenada plana (r, c).
                positions[val] = new Point(r, c);
            }
        }

        // ------------------------------------------------------------------
        // 2. CÁLCULO DE LA LONGITUD TOTAL
        // ------------------------------------------------------------------
        // Acumulamos las distancias euclídeas entre puntos consecutivos:
        // P1 -> P2, P2 -> P3, ..., P8 -> P9.
        double totalLength = 0.0;

        for (int k = 1; k <= 8; k++) {
            Point p1 = positions[k];
            Point p2 = positions[k + 1];

            double dx = p1.x - p2.x;
            double dy = p1.y - p2.y;

            // Distancia euclídea: sqrt((x1 - x2)^2 + (y1 - y2)^2)
            double dist = Math.sqrt(dx * dx + dy * dy);
            totalLength += dist;
        }

        // ------------------------------------------------------------------
        // 3. SALIDA
        // ------------------------------------------------------------------
        // Imprimimos el resultado con precisión decimal.
        writer.printf("%.10f%n", totalLength);
        writer.flush();
    }
}