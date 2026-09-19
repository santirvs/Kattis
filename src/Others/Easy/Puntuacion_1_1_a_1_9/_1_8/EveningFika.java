package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Ordenar los pastelitos por precios
 * Ir cogiendo los más baratos siempre que no excedamos la cantidad máxima de cada categoría
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EveningFika {

    static public class Pastelito implements Comparable<Pastelito> {
        long precio;
        int categoria;

        Pastelito(long precio, int categoria) {
            this.precio = precio;
            this.categoria = categoria;
        }

        @Override
        public int compareTo(Pastelito o) {
            return Long.compare(this.precio, o.precio);
        }
    }

    static class FR_Int {
        private InputStream in = System.in;
        private byte[] buffer = new byte[1 << 16];
        private int head = 0;
        private int tail = 0;

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public long nextLong() throws IOException {
            int c = read();
            while (c != -1 && c <= 32) {
                c = read();
            }
            if (c == -1) return -1;
            boolean negativo = false;
            if (c == '-') {
                negativo = true;
                c = read();
            }
            long res = 0;
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return negativo ? -res : res;
        }

        public int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws IOException {
        FR_Int sc = new FR_Int();

        int numItems = sc.nextInt();
        long presupuesto = sc.nextLong(); // El presupuesto puede ser de hasta 10^18
        int maxItemsCategoria = sc.nextInt();

        Pastelito[] items = new Pastelito[numItems];

        for (int i = 0; i < numItems; i++) {
            items[i] = new Pastelito(sc.nextLong(), -1);
        }

        for (int i = 0; i < numItems; i++) {
            items[i].categoria = sc.nextInt();
        }

        Arrays.sort(items);

        // Usamos un Map para soportar cualquier ID de categoría sin importar su valor o tamaño
        Map<Integer, Integer> categorias = new HashMap<>();
        int numItemsComprados = 0;

        for (int i = 0; i < numItems && presupuesto >= items[i].precio; i++) {
            int cat = items[i].categoria;
            int actualCount = categorias.getOrDefault(cat, 0);

            if (actualCount < maxItemsCategoria) {
                numItemsComprados++;
                categorias.put(cat, actualCount + 1);
                presupuesto -= items[i].precio;
            }
        }

        System.out.println(numItemsComprados);
    }
}