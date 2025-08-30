package Cap3._4_Voraz._1_Clasicos;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.
// Vender el pescado al mejor postor para maximizar los beneficios.
// Ordenar los precios de los compradores de mayor a menor.
// Ordenar los tamaños de los pescados de mayor a menor.
// Vender cada pescado al comprador más caro hasta que no queden pescados o compradores.
// Complejidad: O(n log n) por la ordenación.

// v1. WA en Caso #7  - 100.000 kilos * 100.000 € = 10^10 > 2^31, necesita long
// v2. AC en todos los casos - Usar long para beneficioTotal y asegurarse que la operación también se hace en long
//        int * int = int y se puede asignar a long, pero si la multiplicación ya supera el rango de int, habrá desbordamiento
//        (aunque luego se asigne a long). Hacer la multiplicación en long forzando uno de los operandos a long.

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Fishmongers {

    public static class Pescador implements Comparable {

        int cantidad;
        int precioOfrecido;

        public Pescador(int cantidad, int precioOfrecido) {
            this.cantidad = cantidad;
            this.precioOfrecido = precioOfrecido;
        }

        public int compareTo(Object other) {
            return Integer.compare(this.precioOfrecido,((Pescador)other).precioOfrecido ); // Ordenar por precio ofrecido de mayor a menor
        }

    }



    public static void main(String[] args) throws IOException {
        // 100.000 entradas, mejor usar un FastScanner
        FastScanner sc = new FastScanner();

        // Leer el número de pescados y el número de compradores
        int numPescados = sc.nextInt();
        int numCompradores = sc.nextInt();

        // Leer los pesos de los pescados
        int[] pescados = new int[numPescados];
        for (int i = 0; i < numPescados; i++) {
            pescados[i] = sc.nextInt();
        }
        // Leer los precios que ofrecen los compradores
        ArrayList<Pescador> pescadores = new ArrayList<Pescador>();
        for (int i = 0; i < numCompradores; i++) {
            int cantidad = sc.nextInt();
            int precioOfrecido = sc.nextInt();
            pescadores.add(new Pescador(cantidad, precioOfrecido));
        }

        // Ordenar los pescados por peso (de menor a mayor) (algoritmo de ordenación nativa de Java, O(n log n))
        java.util.Arrays.sort(pescados);
        // Ordenar los pescadores por precio ofrecido (de mayor a menor)
        Collections.sort(pescadores, Collections.reverseOrder());

        // Vender los pescados al mejor postor
        long beneficioTotal = 0;
        int j = 0; // Puntero para los pescadores
        for (int i = numPescados - 1; i >= 0; i--) {
            int pesoPescado = pescados[i];
            // Avanzar el puntero de pescadores hasta encontrar uno que pueda comprar el pescado
            while (j < numCompradores && pescadores.get(j).cantidad == 0) {
                j++;
            }
            if (j < numCompradores) {
                // Se ha encontrado un pescador que puede comprar el pescado
                beneficioTotal += ((long) pesoPescado) * pescadores.get(j).precioOfrecido;
                pescadores.get(j).cantidad--; // Vender un pescado a este pescador
            } else {
                // No hay más pescadores que puedan comprar este pescado
                break;
            }
        }
        // Imprimir el beneficio total
        System.out.println(beneficioTotal);

    }

    // Scanner rápido
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1 && c <= ' ');
            if (c == -1) return null;
            do {
                sb.append((char)c);
            } while ((c = readByte()) != -1 && c > ' ');
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
