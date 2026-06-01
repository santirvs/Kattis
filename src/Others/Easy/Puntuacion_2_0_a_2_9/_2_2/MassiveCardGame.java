package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

/**
 * v1 : Vector de frecuencias acumulado
 *  Leer la cantidad de cartas
 *  Si se crea un vector, como el tamaño es 10^9 MLE!!
 *  Debe usarse un mapa ordenado TreeMap y las funciones .ceilingKey y .floorKey
 *
 *  v2: TLE -> 100.000 elementos son muchos para un TreeMap.
 *   - Guardar los elementos en un vector
 *   - Ordenar
 *   - Hacer búsqueda binaria
 *   - Contar los elementos iguales desde la posición
 *   - 100.000 escrituras también son muchas --> BufferedWriter
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MassiveCardGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. Leer la cantidad de cartas
        String line = br.readLine();
        if (line == null) return;
        int numValores = Integer.parseInt(line.trim());

        // 2. Guardar en un array
        int[] cartas = new int[numValores];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numValores; i++) {
            cartas[i] = Integer.parseInt(st.nextToken());
        }

        // 3. Ordenar el arreglo - O(N log N)
        Arrays.sort(cartas);

        // 4. Resolver las consultas
        line = br.readLine();
        if (line == null) return;
        int numConsultas = Integer.parseInt(line.trim());

        StringBuilder sb = new StringBuilder();

        for (int consulta = 0; consulta < numConsultas; consulta++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            // Buscamos los límites usando búsqueda binaria modificada
            int indiceDerecho = upperBound(cartas, right);
            int indiceIzquierdo = lowerBound(cartas, left);

            int contador = indiceDerecho - indiceIzquierdo;

            // Acumulamos en el StringBuilder en lugar de hacer System.out.println
            sb.append(contador).append("\n");

            // Evitamos que el StringBuilder crezca demasiado en memoria
            if (sb.length() > 65536) {
                bw.write(sb.toString());
                sb.setLength(0);
            }
        }

        // Imprimir lo que quede en el buffer
        if (sb.length() > 0) {
            bw.write(sb.toString());
        }
        bw.flush();
    }

    /**
     * Encuentra el primer índice cuyo valor es MAYOR que la llave.
     * Si no existe, devuelve la longitud del arreglo.
     */
    private static int upperBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * Encuentra el primer índice cuyo valor es MAYOR O IGUAL que la llave.
     * Si no existe, devuelve la longitud del arreglo.
     */
    private static int lowerBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}