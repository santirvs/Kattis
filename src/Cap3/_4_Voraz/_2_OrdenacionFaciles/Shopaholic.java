package Cap3._4_Voraz._2_OrdenacionFaciles;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.
// Leer los precios, ordenarlos de mayor a menor y agruparlos de 3 en 3. Sumar los precios del tercero de cada grupo.
// Imprimir la suma.

// v1. WA en Caso de prueba 22
// v2. 200.000 productos * 200.000 $ ---> Usar LONG!!!

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Shopaholic {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Lectura del número de productos
        int n = sc.nextInt();
        // Lectura de los precios
        ArrayList<Integer> precios = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            precios.add(sc.nextInt());
        }
        // Ordenar los precios de mayor a menor
        Collections.sort(precios, Collections.reverseOrder());
        // Sumar los precios del tercer producto de cada grupo de 3
        long suma = 0;
        for (int i = 2; i < n; i+=3) {
            suma += precios.get(i);
        }
        // Imprimir el resultado
        System.out.println(suma);
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
