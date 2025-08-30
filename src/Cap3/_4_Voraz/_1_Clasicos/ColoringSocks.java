package Cap3._4_Voraz._1_Clasicos;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.
// Leer el color de los calcetines. Ordenarlos por color.
// Iniciar una lavadora con el color del primer calcetín.
// Recorrer los calcetines en orden. Si el color del calcetín no excede el límite de color y aún cabe, se añade.
// Sinó es necesaria una nueva lavadora.
// Complejidad: O(n log n) por la ordenación.

import java.io.IOException;
import java.io.InputStream;

public class ColoringSocks {

    public static void main(String[] args) throws IOException {
        // 10.000 entradas, mejor usar un FastScanner
        FastScanner sc = new FastScanner();

        // Leer el número de calcetines, la capacidad de la lavadora y el límite de color
        int numCalcetines = sc.nextInt();
        int capacidadLavadora = sc.nextInt();
        int distanciaColor = sc.nextInt();

        // Leer los colores de los calcetines
        int[] colores = new int[numCalcetines];
        for (int i = 0; i < numCalcetines; i++) {
            colores[i] = sc.nextInt();
        }

        // Ordenar los colores de los calcetines (algoritmo de ordenación nativa de Java, O(n log n))
        java.util.Arrays.sort(colores);
        // Contar el número de lavadoras necesarias
        int numLavadoras = 1; // Siempre se necesita al menos una lavadora
        int primerColor = colores[0]; // Color del primer calcetín en la lavadora actual
        int calcetinesEnLavadora = 1; // Ya hemos metido el primer calcetín
        for (int i = 1; i < numCalcetines; i++) {
            // Si el color del calcetín actual no excede el límite de color y aún cabe en la lavadora, se añade
            if (colores[i]-primerColor <= distanciaColor && calcetinesEnLavadora < capacidadLavadora) {
                calcetinesEnLavadora++;
            } else {
                // Es necesaria una nueva lavadora
                numLavadoras++;
                primerColor = colores[i];
                calcetinesEnLavadora = 1;
            }
        }

        // Imprimir el número de lavadoras necesarias
        System.out.println(numLavadoras);
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
