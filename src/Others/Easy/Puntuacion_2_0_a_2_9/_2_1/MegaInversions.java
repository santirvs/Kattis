package Others.Easy.Puntuacion_2_0_a_2_9._2_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class MegaInversions {

    // Clase interna que implementa un Árbol de Fenwick (Binary Indexed Tree - BIT).
    // Permite actualizar frecuencias y consultar sumas de prefijos en O(log n).
    static class FenwickTree {
        private int[] tree;
        private int size;

        public FenwickTree(int size) {
            this.size = size;
            // Se usa indexación base 1, por lo que el arreglo necesita tamaño (size + 1)
            this.tree = new int[size + 1];
        }

        // Reinicia el árbol a ceros para reutilizarlo en la segunda pasada
        public void clear() {
            Arrays.fill(this.tree, 0);
        }

        // Suma 'val' a la posición 'idx' y propaga el cambio hacia arriba en el árbol
        public void add(int idx, int val) {
            while (idx <= size) {
                tree[idx] += val;
                // idx & -idx obtiene el bit menos significativo encendido (LSB)
                idx += idx & -idx;
            }
        }

        // Devuelve la suma acumulada de frecuencias desde 1 hasta 'idx' inclusive
        public int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        // Leemos la longitud de la secuencia 'n'
        int n = Integer.parseInt(line.trim());
        int[] seq = new int[n];
        int maxVal = 0;

        // Leemos la secuencia de enteros. Usamos un bucle con StringTokenizer
        // por si los números vienen divididos en múltiples líneas.
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            while (st == null || !st.hasMoreTokens()) {
                String nextLine = reader.readLine();
                if (nextLine == null) break;
                st = new StringTokenizer(nextLine);
            }
            seq[i] = Integer.parseInt(st.nextToken());
            if (seq[i] > maxVal) {
                maxVal = seq[i];
            }
        }

        // El tamaño del BIT está acotado por el valor máximo en la secuencia (en este problema <= n)
        FenwickTree bit = new FenwickTree(maxVal);

        // rightSmaller[j] almacenará cuántos elementos a la derecha de 'j' son menores que seq[j]
        long[] rightSmaller = new long[n];

        // PASO 1: Recorremos de derecha a izquierda para contar elementos menores a la derecha
        for (int j = n - 1; j >= 0; j--) {
            int val = seq[j];
            // Consultamos la frecuencia acumulada de los valores estrictamente menores (1 hasta val - 1)
            rightSmaller[j] = bit.query(val - 1);
            // Registramos la aparición del valor actual en el BIT
            bit.add(val, 1);
        }

        // Limpiamos el BIT para reutilizarlo en la siguiente pasada
        bit.clear();

        // Usamos 'long' para evitar desbordamiento de enteros (overflow), ya que el número
        // máximo de tripletes es n*(n-1)*(n-2)/6, lo cual supera el límite de 'int' si n >= 2500.
        long totalTriples = 0;

        // PASO 2 y 3: Recorremos de izquierda a derecha para contar elementos mayores a la izquierda
        // y acumulamos el producto directamente.
        for (int j = 0; j < n; j++) {
            int val = seq[j];
            // 'j' es la cantidad total de elementos ya procesados a la izquierda.
            // bit.query(val) nos da cuántos de ellos son menores o iguales a 'val'.
            // La resta nos da exactamente los que son estrictamente mayores.
            long leftGreater = j - bit.query(val);

            // Sumamos las combinaciones válidas tomando seq[j] como elemento central
            totalTriples += leftGreater * rightSmaller[j];

            // Registramos el valor actual en el BIT
            bit.add(val, 1);
        }

        // Imprimimos el número total de tripletes invertidos
        System.out.println(totalTriples);
    }
}