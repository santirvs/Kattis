package Others.Easy.Puntuacion_2_0_a_2_9._2_4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class DistributingBallotBoxes {

    /**
     * Función de validación (check) para la búsqueda binaria.
     * Determina si es posible distribuir las cajas de votación de modo que
     * ninguna ciudad supere un máximo de 'maxPeople' personas por caja,
     * sin exceder el número total de cajas disponibles ('totalBoxes').
     *
     * @param populations Arreglo con las poblaciones de cada ciudad.
     * @param totalBoxes  Número total de cajas de votación disponibles.
     * @param maxPeople   Límite máximo permitido de personas por caja en esta prueba.
     * @return true si la distribución es factible, false en caso contrario.
     */
    private static boolean canDistribute(int[] populations, int totalBoxes, int maxPeople) {
        long boxesNeeded = 0;

        for (int i = 0; i < populations.length; i++) {
            // Para cada ciudad, calculamos cuántas cajas se necesitan si el límite por caja es 'maxPeople'.
            // Matemáticamente esto equivale a calcular el techo de (población / maxPeople).
            // Usando división entera, la fórmula (A + B - 1) / B evita usar punto flotante:
            boxesNeeded += (populations[i] + maxPeople - 1) / maxPeople;
        }

        // La distribución es válida si el número total de cajas requeridas
        // es menor o igual al número de cajas disponibles.
        return boxesNeeded <= totalBoxes;
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader y StringTokenizer garantizan una lectura rápida y eficiente
        // de la entrada estándar, crucial para problemas de programación competitiva.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            line = line.trim();

            // Ignorar líneas en blanco que puedan venir en la entrada
            if (line.isEmpty()) continue;

            st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) continue;

            int n = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // Condición de parada del problema: N = -1 y B = -1
            if (n == -1 && b == -1) {
                break;
            }

            int[] populations = new int[n];
            int maxPopulation = 0;

            // Lectura de las poblaciones de las N ciudades
            for (int i = 0; i < n; i++) {
                // Asegurarnos de leer nuevos tokens si la línea actual se agota
                while (st == null || !st.hasMoreTokens()) {
                    String nextLine = br.readLine();
                    if (nextLine == null) break;
                    st = new StringTokenizer(nextLine);
                }
                populations[i] = Integer.parseInt(st.nextToken());

                // Encontramos la población máxima para usarla como límite superior de la búsqueda binaria
                if (populations[i] > maxPopulation) {
                    maxPopulation = populations[i];
                }
            }

            // -----------------------------------------------------------------
            // BÚSQUEDA BINARIA SOBRE LA RESPUESTA
            // -----------------------------------------------------------------
            // Rango de posibles respuestas para el número máximo de personas por caja:
            // - low: 1 (el caso ideal donde hay suficientes cajas para que cada persona tenga casi su propia caja).
            // - high: maxPopulation (el peor caso donde a la ciudad más grande se le asigna una sola caja).
            int low = 1;
            int high = maxPopulation;
            int ans = high; // Inicializamos con el peor caso posible

            while (low <= high) {
                int mid = low + (high - low) / 2; // Evita desbordamiento de enteros

                if (canDistribute(populations, b, mid)) {
                    // Si es posible lograr un máximo de 'mid' personas por caja,
                    // guardamos esta respuesta factible e intentamos buscar un número aún menor
                    // reduciendo el límite superior.
                    ans = mid;
                    high = mid - 1;
                } else {
                    // Si no es factible, significa que el límite 'mid' es muy restrictivo
                    // y necesitamos más cajas de las disponibles; aumentamos el límite inferior.
                    low = mid + 1;
                }
            }

            // Imprimimos el resultado óptimo (el mínimo valor máximo de personas por caja)
            System.out.println(ans);
        }
    }
}