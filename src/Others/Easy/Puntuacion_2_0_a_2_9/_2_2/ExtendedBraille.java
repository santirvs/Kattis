package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class ExtendedBraille {

    /**
     * Clase que representa un punto 2D en el plano.
     * Implementa Comparable para poder ordenar los puntos lexicográficamente,
     * y sobrescribe equals y hashCode para poder almacenar listas de puntos
     * dentro de un HashSet y comparar formas de manera exacta.
     */
    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Orden lexicográfico: primero por coordenada X, y en caso de empate por Y
        @Override
        public int compareTo(Point other) {
            if (this.x != other.x) {
                return Integer.compare(this.x, other.x);
            }
            return Integer.compare(this.y, other.y);
        }

        // Necesario para que List.equals() compare los puntos por valor y no por referencia
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point other = (Point) obj;
            return this.x == other.x && this.y == other.y;
        }

        // Necesario para que HashSet calcule correctamente el hash de una List<Point>
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader y StringTokenizer para entrada rápida (Fast I/O)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int n = Integer.parseInt(line.trim());

        // HashSet almacena únicamente las representaciones canónicas distintas.
        // En Java, dos ArrayList<Point> son iguales (equals) si tienen el mismo tamaño
        // y sus elementos en cada posición son iguales según Point.equals().
        Set<List<Point>> uniqueShapes = new HashSet<List<Point>>();

        for (int i = 0; i < n; i++) {
            // Leemos la cantidad de puntos (M) del carácter braille actual
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            List<Point> points = new ArrayList<Point>(m);
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;

            // 1. Lectura de puntos y búsqueda de los valores mínimos de X e Y
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                points.add(new Point(x, y));

                if (x < minX) minX = x;
                if (y < minY) minY = y;
            }

            // 2. Normalización por traslación:
            // Desplazamos toda la figura restando (minX, minY) a cada punto.
            // Esto ancla el límite inferior izquierdo de la figura al origen (0, 0).
            for (int j = 0; j < m; j++) {
                Point p = points.get(j);
                p.x -= minX;
                p.y -= minY;
            }

            // 3. Ordenamiento canónico:
            // Ordenamos los puntos para que el orden de entrada no afecte la comparación.
            Collections.sort(points);

            // (Opcional) Si pudiera haber puntos duplicados dentro del mismo carácter,
            // los filtramos aquí para obtener un conjunto estricto de puntos únicos.
            List<Point> canonicalShape = new ArrayList<Point>(m);
            for (int j = 0; j < m; j++) {
                if (j == 0 || !points.get(j).equals(points.get(j - 1))) {
                    canonicalShape.add(points.get(j));
                }
            }

            // 4. Registro de la forma:
            // Si la forma normalizada ya existe en el HashSet, no se vuelve a añadir.
            uniqueShapes.add(canonicalShape);
        }

        // El tamaño del conjunto representa el total de caracteres únicos salvo traslación
        System.out.println(uniqueShapes.size());
    }
}