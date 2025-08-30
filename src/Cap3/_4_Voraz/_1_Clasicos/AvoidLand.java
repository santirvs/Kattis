package Cap3._4_Voraz._1_Clasicos;

// Estrategia Voraz. Clásicos.

// Código original de: https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_3_Problem_Solving_Paradigms/Greedy/kattis_avoidland.cpp
/**
 * Kattis - avoidland
 * Observa que podemos manejar las filas y columnas por separado, es decir, con el primer caso
 * de prueba, necesitamos distribuir los tableros {1, 1, 1} y {1, 0, 2}, donde el primero es el
 * número de piezas en cada fila y el segundo es el número de piezas en cada columna.
 * Nuestro objetivo es distribuir cada arreglo en {1,1,1...,1}.
 * Podemos hacer esto realizando un barrido lineal: ajustamos A[i] a 1, tomando o dando tantas
 * piezas como sea necesario (A[i] - 1) de A[i+1].
 * Registramos la cantidad de piezas movidas en cada paso.
 *
 * Complejidad:
 * Tiempo: O(n), Memoria: O(n)
 */

// Destacar la manera de contar las piezas que se mueven en cada fila y columna!!!

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class AvoidLand {

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();

        int numCasillas = sc.nextInt();
        int[] filas = new int[numCasillas];
        int[] columnas = new int[numCasillas];

        // Contamos cuántas piezas hay en cada fila y columna
        for (int i = 0; i < numCasillas; i++) {
            int fila = sc.nextInt();
            int columna = sc.nextInt();
            filas[fila - 1]++;
            columnas[columna - 1]++;
        }

        int numMovimientos = 0;
        // Ajustamos filas y columnas con un barrido lineal ***  WOW!!!
        for (int i = 0; i < numCasillas - 1; i++) {
            filas[i + 1] += filas[i] - 1;
            numMovimientos += Math.abs(filas[i] - 1);

            columnas[i + 1] += columnas[i] - 1;
            numMovimientos += Math.abs(columnas[i] - 1);
        }

        System.out.println(numMovimientos);
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
