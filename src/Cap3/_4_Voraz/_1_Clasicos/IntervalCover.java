package Cap3._4_Voraz._1_Clasicos;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.
// Problema de cobertura de intervalos.
// Dado un conjunto de intervalos, encontrar el subconjunto mínimo de intervalos que cubra un intervalo [0, M].
// Tomar el intervalo que comience antes de la cobertura actual y que termine lo más lejos posible.
// La entrada consiste en dos decimales que representan el intervalo a ser cubierto.
// Le sigue un entero que indica la cantidad de rangos y luego los rangos (cada uno representado por dos decimales).
// La salida es el número mínimo de intervalos necesarios para cubrir el intervalo [0, M] y los intervalos usados
// o impossible si no es posible cubrir el intervalo.


// NO ESTÁ SUPERANDO EL CASO DE PRUEBAS PÚBLICO!!!!
// --> Revisar el código que determina el primer intervalo a ser usado

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class IntervalCover {

    public static void main(String[] args) throws IOException {
        // 20.000 entradas, mejor usar un FastScanner
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        while (sc.hasNext()) {
            // Lectura del rango a cubrir
            double rangoMin = sc.nextDouble();
            double rangoMax = sc.nextDouble();

            // Lectura del numero de intervalos
            int numIntervalos = sc.nextInt();

            // Lectura de los intervalos
            ArrayList<double[]> intervalos = new ArrayList<>();
            for (int i = 0; i < numIntervalos; i++) {
                double inicio = sc.nextDouble();
                double fin = sc.nextDouble();
                intervalos.add(new double[]{inicio, fin});
            }

            // Ordenar los intervalos por el inicio del intervalo
            Collections.sort(intervalos, (a, b) -> Double.compare(a[0], b[0]));

            // Descartar los intervalos que no pueden cubrir el rango
            ArrayList<Integer> rangosUsados = new ArrayList<>();
            int numUsados = 0;
            boolean posible = true;

            // Algoritmo voraz
            double coberturaActual = Double.NEGATIVE_INFINITY;
            ArrayList<Integer> indicesUsados = new ArrayList<>();
            int idx = 0;
            // Buscar el rango que empiece antes del rangoMin y que termine lo más lejos posible
            while (idx < intervalos.size() && intervalos.get(idx)[0] <= rangoMin) {
                coberturaActual = Math.max(coberturaActual, intervalos.get(idx)[0]);
                idx++;
            }
            // Si no mejora la cobertura actual significa que no es posible cubrir el césped
            if (coberturaActual == Double.NEGATIVE_INFINITY) {
                posible = false;
            } else {
                numUsados++;
                indicesUsados.add(idx); // Guardar el índice del intervalo usado
                coberturaActual = intervalos.get(idx)[1];
            }


            while (coberturaActual < rangoMax) {
                double mejorCobertura = coberturaActual;
                // Buscar el aspersor que su rango empiece antes de la cobertura actual y que su rango termine lo más lejos posible
                while (idx < intervalos.size() && intervalos.get(idx)[0] <= coberturaActual) {
                    mejorCobertura = Math.max(mejorCobertura, intervalos.get(idx)[1]);
                    idx++;
                }
                // Si no mejora la cobertura actual significa que no es posible cubrir el césped
                if (mejorCobertura == coberturaActual) {
                    posible = false;
                    break;
                }
                //Actualizar la cobertura actual e incrementar el número de aspersores usados
                coberturaActual = mejorCobertura;
                numUsados++;
                indicesUsados.add(idx); // Guardar el índice del intervalo usado
            }

            //Mostrar el resultado
            if (posible) {
                System.out.println(numUsados);
                boolean primero = true;
                for (Integer i : indicesUsados) {
                    if (!primero) System.out.print(" ");
                    else primero = false;
                    System.out.print(i);
                }
                System.out.println();
            } else {
                System.out.println("impossible");
            }


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
