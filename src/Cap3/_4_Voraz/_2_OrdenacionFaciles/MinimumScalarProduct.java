package Cap3._4_Voraz._2_OrdenacionFaciles;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.
// Leer los vectores, ordenar uno en orden ascendente y el otro en orden descendente.
// Multiplicar los elementos correspondientes y sumar los productos.
// Imprimir la suma.

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinimumScalarProduct {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Lectura del número de casos
        int numCasos = sc.nextInt();
        int caso = 0;

        while (caso++ < numCasos) {
            // Lectura del tamaño de los vectores
            int n = sc.nextInt();
            // Lectura de los vectores
            ArrayList<Long> vector1 = new ArrayList<>();
            ArrayList<Long> vector2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                vector1.add(sc.nextLong());
            }
            for (int i = 0; i < n; i++) {
                vector2.add(sc.nextLong());
            }
            // Ordenar el primer vector en orden ascendente
            Collections.sort(vector1);
            // Ordenar el segundo vector en orden descendente
            Collections.sort(vector2, Collections.reverseOrder());

            // Calcular el producto escalar mínimo
            long productoEscalarMinimo = 0;
            for (int i = 0; i < n; i++) {
                productoEscalarMinimo += vector1.get(i) * vector2.get(i);
            }
            // Imprimir el resultado
            System.out.println("Case #" + caso + ": " + productoEscalarMinimo);

        }

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
