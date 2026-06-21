package Others.Easy.Puntuacion_2_0_a_2_9._2_6;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class WalkingOnSunshine {

    /**
     * ESTRATEGIA GENERAL DE RESOLUCIÓN:
     * 1. El enunciado establece que caminar hacia el Este, Oeste o Norte cuesta 0 (no daña los ojos).
     * 2. Solo pagamos penalización por el desplazamiento NETO vertical hacia el Sur (descenso en Y).
     * 3. Como el movimiento horizontal (X) es gratis, si existe una sombra en cualquier coordenada X
     * entre la altura de inicio y fin, podemos "viajar" hacia ella horizontalmente sin costo,
     * utilizarla para descender verticalmente protegidos, y luego salir de ella.
     * 4. Por lo tanto, el problema se reduce a:
     * Costo Total = (Distancia vertical total del viaje) - (Unión de todas las sombras útiles en Y).
     * 5. Esto transforma un problema complejo de caminos mínimos en 2D a un algoritmo ultra rápido
     * de "Fusión de Intervalos 1D" (Interval Merging) en el eje Y, logrando una complejidad O(N log N).
     */

    // Clase para almacenar los intervalos de sombra proyectados en el eje Y
    static class Interval implements Comparable<Interval> {
        double y1, y2;

        Interval(double y1, double y2) {
            this.y1 = y1;
            this.y2 = y2;
        }

        // Ordenamos los intervalos de abajo hacia arriba (por su base Y1) para el algoritmo de fusión
        @Override
        public int compareTo(Interval o) {
            if (Double.compare(this.y1, o.y1) != 0) {
                return Double.compare(this.y1, o.y1);
            }
            return Double.compare(this.y2, o.y2);
        }
    }

    public static void main(String[] args) throws Exception {
        // Uso de BufferedReader para optimizar la lectura de datos masivos (N = 100,000)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        double xc = Double.parseDouble(st.nextToken()); // Origen X (Contest)
        double yc = Double.parseDouble(st.nextToken()); // Origen Y
        double xa = Double.parseDouble(st.nextToken()); // Destino X (Awards)
        double ya = Double.parseDouble(st.nextToken()); // Destino Y

        // CASO BASE DE CONTROL: Si el destino está más al norte o igual que el origen,
        // podemos llegar caminando horizontalmente o hacia arriba, lo cual cuesta 0.
        if (ya >= yc) {
            System.out.printf(java.util.Locale.US, "%.1f\n", 0.0);
            return;
        }

        List<Interval> activeIntervals = new ArrayList<Interval>();

        // PROCESAMIENTO DE RECTÁNGULOS O(N)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());

            // FILTRADO GEOMÉTRICO: Solo nos interesan las sombras contenidas en el rango
            // vertical de nuestro viaje, es decir, entre la altura 'ya' (destino) y 'yc' (origen).
            double boundedY1 = Math.max(y1, ya); // Recortamos el fondo si excede el destino
            double boundedY2 = Math.min(y2, yc); // Recortamos el techo si excede el origen

            // Si el rectángulo intercepta el rango vertical del viaje de forma válida
            if (boundedY1 < boundedY2) {
                // Almacenamos su proyección unidimensional en Y
                activeIntervals.add(new Interval(boundedY1, boundedY2));
            }
        }

        // FASE DE ORDENAMIENTO O(N log N)
        // Ordenamos los intervalos para poder unificar aquellos que se solapan o tocan continuamente
        Collections.sort(activeIntervals);

        // FASE DE FUSIÓN DE INTERVALOS (INTERVAL MERGING) O(N)
        double totalShadow = 0; // Guardará la cantidad neta de distancia vertical protegida por sombra

        if (!activeIntervals.isEmpty()) {
            // Inicializamos nuestro intervalo de barrido actual con el primero de la lista
            Interval current = activeIntervals.get(0);
            double currentY1 = current.y1;
            double currentY2 = current.y2;

            for (int i = 1; i < activeIntervals.size(); i++) {
                Interval next = activeIntervals.get(i);

                // Si el siguiente intervalo comienza antes (o justo donde) termina el actual, se solapan
                if (next.y1 <= currentY2) {
                    // Extendemos el techo del intervalo actual si el nuevo llega más arriba
                    currentY2 = Math.max(currentY2, next.y2);
                } else {
                    // Si no se solapan, significa que hay un "hueco de sol".
                    // Guardamos la distancia acumulada del bloque de sombra que acabamos de cerrar.
                    totalShadow += (currentY2 - currentY1);
                    // Saltamos al nuevo bloque disjunto
                    currentY1 = next.y1;
                    currentY2 = next.y2;
                }
            }
            // No olvidar sumar el último intervalo procesado tras salir del bucle
            totalShadow += (currentY2 - currentY1);
        }

        // CÁLCULO FINAL DEL COSTO
        // El peor de los casos (ir directo al sur totalmente descubierto) es la diferencia neta de altura
        double totalVerticalDrop = yc - ya;

        // Le restamos los tramos donde logramos avanzar protegidos por las sombras fusionadas
        double ans = totalVerticalDrop - totalShadow;

        // Control de errores de precisión flotante por si la sombra supera la caída por decimales
        if (ans < 0) ans = 0;

        // Imprimir con el formato de un decimal requerido
        System.out.printf(java.util.Locale.US, "%.1f\n", ans);
    }
}