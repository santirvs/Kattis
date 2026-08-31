package Others.Easy.Puntuacion_2_0_a_2_9._2_0;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problema: Blaster the Daredevil (Kattis)
 *
 * PLANTEAMIENTO DEL PROBLEMA:
 * --------------------------
 * 1. La trayectoria de Blaster es una línea recta que parte desde el origen (0,0)
 *    con un ángulo determinado. Su ecuación en el plano XY es: y = m * x,
 *    donde 'm' es la pendiente (m = tan(ángulo)).
 *
 * 2. Un aro 'i' ubicado en x_i cubre un intervalo de alturas [y_bottom_i, y_top_i].
 *    Para que la trayectoria intercepte el aro, la altura de la línea en x_i debe
 *    estar dentro del rango:
 *       y_bottom_i <= m * x_i <= y_top_i
 *
 * 3. Despejando la pendiente 'm' (dividiendo por x_i > 0):
 *       (y_bottom_i / x_i) <= m <= (y_top_i / x_i)
 *
 * 4. Por lo tanto, cada aro se reduce a un INTERVALO DE PENDIENTES VÁLIDAS [L_i, R_i].
 *    Cualquier elección de pendiente 'm' dentro de ese intervalo atravesará el aro.
 *
 * 5. El problema se transforma en: Dado un conjunto de N intervalos [L_i, R_i],
 *    encontrar un valor único de 'm' que esté contenido en el MÁXIMO NÚMERO DE INTERVALOS.
 *
 * ESTRATEGIA: ALGORITMO DE BARRIDO (SWEEP LINE)
 * --------------------------------------------
 * - Convertimos cada intervalo en dos eventos:
 *      * Un evento de ENTRADA (+1) en m = L_i.
 *      * Un evento de SALIDA (-1) en m = R_i.
 * - Ordenamos todos los eventos por el valor de su pendiente 'm'.
 * - Recorremos los eventos acumulando las entradas y salidas para saber cuántos
 *   aros están activos simultáneamente. El valor máximo alcanzado es la respuesta.
 */
public class BlasterTheDaredevil {

    // Clase que representa un punto de cambio en el número de aros atravesables
    static class Evento implements Comparable<Evento> {
        double m;   // Valor de la pendiente en el que ocurre el evento
        int tipo;  // +1 para el inicio de un aro, -1 para el fin de un aro

        public Evento(double m, int tipo) {
            this.m = m;
            this.tipo = tipo;
        }

        @Override
        public int compareTo(Evento otro) {
            // 1. Ordenar primordialmente por la posición de la pendiente 'm'
            if (Double.compare(this.m, otro.m) != 0) {
                return Double.compare(this.m, otro.m);
            }
            // 2. Si las pendientes son idénticas, el evento de entrada (+1)
            //    debe procesarse ANTES que el de salida (-1). Esto garantiza
            //    que si dos aros se tocan en el extremo, se cuenten ambos.
            return Integer.compare(otro.tipo, this.tipo);
        }
    }

    public static void main(String[] args) throws IOException {
        // Uso de BufferedReader y StringTokenizer para lectura rápida de entrada
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        st = new StringTokenizer(line);
        int numAros = Integer.parseInt(st.nextToken());

        List<Evento> eventos = new ArrayList<>(numAros * 2);

        // Paso 1: Mapear cada aro a su intervalo de pendientes [L_i, R_i]
        for (int i = 0; i < numAros; i++) {
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            st = new StringTokenizer(line);

            double x = Double.parseDouble(st.nextToken());
            double yBottom = Double.parseDouble(st.nextToken());
            double yTop = Double.parseDouble(st.nextToken());

            // Cálculo de los límites del intervalo de pendientes
            double pendienteMinima = yBottom / x;
            double pendienteMaxima = yTop / x;

            // Registrar los eventos de inicio y fin
            eventos.add(new Evento(pendienteMinima, 1));  // Entra al aro
            eventos.add(new Evento(pendienteMaxima, -1)); // Sale del aro
        }

        // Paso 2: Ordenar los eventos a lo largo del eje de pendientes 'm'
        Collections.sort(eventos);

        // Paso 3: Barrido (Sweep Line) para encontrar la máxima solapación
        int arosActivos = 0;
        int maxArosAtravesados = 0;

        for (Evento e : eventos) {
            // Modifica la cantidad de aros cruzados actualmente
            arosActivos += e.tipo;

            // Actualiza el máximo histórico encontrado
            if (arosActivos > maxArosAtravesados) {
                maxArosAtravesados = arosActivos;
            }
        }

        // Paso 4: Mostrar el resultado óptimo
        System.out.println(maxArosAtravesados);
    }
}