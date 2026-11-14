package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Nicknames {

    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader en lugar de Scanner para optimizar la lectura (Fast I/O)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Leer el número de nombres (N)
        String line = br.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());

        // 2. Almacenar los nombres
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = br.readLine().trim();
        }

        // 3. Ordenar los nombres lexicográficamente (alfabéticamente).
        // Esto es crucial porque agrupa todos los prefijos comunes en rangos contiguos.
        Arrays.sort(names);

        // 4. Leer el número de apodos (M)
        line = br.readLine();
        if (line == null) return;
        int m = Integer.parseInt(line.trim());

        // Usamos StringBuilder para acumular las respuestas y hacer una sola impresión final,
        // lo cual es mucho más rápido que imprimir con System.out.println en cada iteración.
        StringBuilder sb = new StringBuilder();

        // 5. Procesar cada apodo (nickname)
        for (int i = 0; i < m; i++) {
            String nick = br.readLine().trim();

            // LÍMITE INFERIOR:
            // Encuentra la primera posición en el array donde el nombre es mayor o igual al apodo.
            int lowerIndex = lowerBound(names, nick);

            // LÍMITE SUPERIOR:
            // Queremos encontrar el primer elemento que YA NO tenga al apodo como prefijo.
            // Truco: Al apodo le sumamos '{' (que en la tabla ASCII va inmediatamente después de 'z').
            // Cualquier palabra que comience con el apodo será estrictamente menor que "nick{".
            String upperNick = nick + "{";
            int upperIndex = lowerBound(names, upperNick);

            // El número total de coincidencias es la diferencia de índices del rango encontrado.
            int count = upperIndex - lowerIndex;
            sb.append(count).append("\n");
        }

        // Imprimir todas las respuestas acumuladas
        System.out.print(sb.toString());
    }

    /**
     * Implementación personalizada de lower_bound (similar a C++).
     * Encuentra el índice del primer elemento en el arreglo que sea mayor o igual al objetivo (target).
     *
     * @param arr El array ordenado de nombres.
     * @param target La cadena a buscar (o el límite superior del prefijo).
     * @return El índice de la primera coincidencia potencial.
     */
    private static int lowerBound(String[] arr, String target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // compareTo devuelve < 0 si arr[mid] es lexicográficamente menor que target
            if (arr[mid].compareTo(target) < 0) {
                low = mid + 1; // Descartamos la mitad izquierda
            } else {
                high = mid;  // Podría ser la respuesta, buscamos más a la izquierda
            }
        }
        return low;
    }
}