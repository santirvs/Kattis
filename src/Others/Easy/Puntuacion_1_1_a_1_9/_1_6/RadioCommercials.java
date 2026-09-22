package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RadioCommercials {

    public static void main(String[] args) throws IOException {
        // Lectura rápida de datos mediante BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken()); // Cantidad total de comerciales
        int P = Integer.parseInt(st.nextToken()); // Costo fijo por comercial

        /* =========================================================================
         * PLANTEAMIENTO Y DEDUCCIÓN ALGORÍTMICA (KADANE):
         *
         * 1. Transformación del Problema:
         *    - Cada estudiante genera 1 corona de ingreso.
         *    - Transmitir un comercial cuesta P coronas.
         *    - Por ende, la ganancia NETA de un comercial 'i' con S_i estudiantes es:
         *
         *          GananciaNeta_i = S_i - P
         *
         * 2. Maximización por Subarreglo Contiguo:
         *    Queremos encontrar un subintervalo continuo [L...R] de comerciales que
         *    maximice la suma total de las ganancias netas:
         *
         *          MaxProfit = Max( sum_{k=L}^{R} (S_k - P) )
         *
         * 3. Algoritmo de Kadane en O(N):
         *    Iteramos sobre el arreglo ajustado. En cada posición `i`, decidimos si:
         *    a) Unir el comercial actual al subarreglo anterior acumulado.
         *    b) Empezar un nuevo subarreglo desde la posición actual (si lo acumulado
         *       anteriormente era negativo y reducía nuestra ganancia).
         * =========================================================================
         */

        st = new StringTokenizer(br.readLine());

        int currentMax = 0; // Ganancia neta máxima acumulada terminando en la posición actual
        int globalMax = 0;  // Ganancia neta máxima global encontrada hasta el momento

        for (int i = 0; i < N; i++) {
            int students = Integer.parseInt(st.nextToken());
            int netProfit = students - P; // Ganancia neta de este comercial individual

            // Kadane: Tomar el máximo entre empezar un nuevo subarreglo desde este punto (netProfit)
            // o extender el subarreglo actual sumando la ganancia previa (currentMax + netProfit).
            currentMax = Math.max(netProfit, currentMax + netProfit);

            // Actualizar el récord global si encontramos una ganancia mejor
            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }

        // Imprimir la mayor ganancia esperada alcanzable
        System.out.println(globalMax);
    }
}