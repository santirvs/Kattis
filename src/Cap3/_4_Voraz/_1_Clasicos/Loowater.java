package Cap3._4_Voraz._1_Clasicos;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.
// Emparejar cabezas y caballeros por orden ascendente.
// Para cada cabeza de dragón se necesita al caballero de menor altura que sea igual o mayor que la altura de la cabeza.
// Eso garantiza el coste mínimo para cortar esa cabeza.


// v1.TLE en el caso #4
// v2. Usar FastScanner


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Loowater {

    public static void main(String[] args) throws IOException {
        // 20.000 entradas, mejor usar un FastScanner?
        FastScanner sc = new FastScanner();

        // Lectura de datos
        int numCabezas = sc.nextInt();
        int numCaballeros = sc.nextInt();

        // Mientras no sea el caso de fin
        while (numCabezas != 0 || numCaballeros != 0) {
            // Lectura de las cabezas
            ArrayList<Integer> cabezas = new ArrayList<>();
            for (int i = 0; i < numCabezas; i++) {
                cabezas.add(sc.nextInt());
            }
            Collections.sort(cabezas);

            // Lectura de los caballeros
            ArrayList<Integer> caballeros = new ArrayList<>();
            for (int i = 0; i < numCaballeros; i++) {
                caballeros.add(sc.nextInt());
            }
            Collections.sort(caballeros);

            // Algoritmo voraz
            int costeTotal = 0;
            boolean posible = true;
            int idxCaballero = 0;

            for (int cabeza : cabezas) {
                // Buscar el caballero más barato que pueda cortar esta cabeza
                while (idxCaballero < caballeros.size() && caballeros.get(idxCaballero) < cabeza) {
                    idxCaballero++;
                }
                if (idxCaballero == caballeros.size()) {
                    // No hay caballero que pueda cortar esta cabeza
                    posible = false;
                    break;
                } else {
                    // Usar este caballero
                    costeTotal += caballeros.get(idxCaballero);
                    idxCaballero++;
                }
            }

            if (posible) {
                System.out.println(costeTotal);
            } else {
                System.out.println("Loowater is doomed!");
            }

            // Leer el siguiente caso
            numCabezas = sc.nextInt();
            numCaballeros = sc.nextInt();
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
