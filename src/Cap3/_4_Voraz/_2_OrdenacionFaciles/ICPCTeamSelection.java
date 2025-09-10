package Cap3._4_Voraz._2_OrdenacionFaciles;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.
// Leer las puntuaciones, ordenarlas, eliminar los N/3 peores y emparejar los mejores, sumando la puntuación del segundo.

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ICPCTeamSelection {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Lectura del número de casos
        int numCasos = sc.nextInt();

        while (numCasos-- > 0) {
            // Lectura del número de participantes
            int numAlumnos = sc.nextInt();
            // Lectura de las puntuaciones
            ArrayList<Integer> puntuaciones = new ArrayList<>();
            for (int i = 0; i < 3*numAlumnos; i++) {
                puntuaciones.add(sc.nextInt());
            }
            // Ordenar las puntuaciones
            Collections.sort(puntuaciones, Collections.reverseOrder());

            // Hacer parejas con los 2N mejores y sumar la puntuación del segundo de cada pareja
            int suma = 0;
            for (int i = 1; i < 2*numAlumnos; i+=2) {
                suma += puntuaciones.get(i);
            }
            // Imprimir el resultado
            System.out.println(suma);
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
