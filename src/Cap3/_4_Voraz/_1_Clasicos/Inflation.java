package Cap3._4_Voraz._1_Clasicos;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.
// Ordenar tamaños de globlos (ya ordenados de 1..N) y ordenar la capacidad de cada bombona.
// Asignar bombonas y globos por orden.
// Calcular la proporción a la que se puede llenar cada globo y quedarnos con la menor fracción.
// Si alguno explota, el resultado es impossible

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Inflation {

    public static void main(String[] args) throws IOException {
        // 10.000 entradas, mejor usar un FastScanner
        Scanner sc = new Scanner(System.in);

        // Lectura de los datos
        int numGlobos = sc.nextInt();
        // Leer la capacidad de las bombonas
        ArrayList<Integer> capacidades = new ArrayList<>();
        for (int i = 0; i < numGlobos; i++) {
            capacidades.add(sc.nextInt());
        }

        // Ordenar las capacidades de las bombonas
        Collections.sort(capacidades);

        // Verificar el inflado de cada globo
        int numGlobo = 0;
        double proporcionMinima = Double.MAX_VALUE;
        boolean posible = true;
        for (int capacidad : capacidades) {
            numGlobo++; // Los globos van de 1 a N
            // Si la capacidad de la bombona es mayor que el tamaño del globo, éste explotará --> no es posible
            if (capacidad > numGlobo) {
                posible = false;
                break;
            } else {
                //Calcular la proporción a la que se inflará el globo
                double proporcion = (double) capacidad / numGlobo;
                proporcionMinima = Math.min(proporcionMinima, proporcion);
            }
        }

        // Mostrar el resultado
        if (posible) {
            System.out.printf("%.6f\n", proporcionMinima);
        } else {
            System.out.println("impossible");
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
