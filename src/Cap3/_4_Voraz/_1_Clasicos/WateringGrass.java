package Cap3._4_Voraz._1_Clasicos;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.
// Problema del riego del césped.
// Dado un conjunto de intervalos, encontrar el subconjunto mínimo de intervalos que cubra un intervalo [0, M].
// Cada intervalo representa el rango que puede cubrir un aspersor.
// Un aspersor i está representado por un intervalo [a_i, b_i], donde a_i es la posición del aspersor y b_i es el alcance del aspersor.
// El intervalo [a_i, b_i] se calcula como [x_i - r_i, x_i + r_i], donde x_i es la posición del aspersor y r_i es el alcance del aspersor.
// La entrada consiste en un entero M, seguido de un conjunto de pares de enteros (x_i, r_i) que representan la posición y el alcance de cada aspersor.
// La salida es el número mínimo de aspersores necesarios para cubrir el intervalo [0, M] o -1 si no es posible cubrir el intervalo.


// v1. TLE en Caso #1 !!!  No funciona bien el FastScanner con el final del fichero...
// Sí que funciona bien, pero en el catch hay que forzar la salida del bucle principal


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WateringGrass {

    public static void main(String[] args) throws IOException {
        // 10.000 entradas, mejor usar un FastScanner
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            try {
                // Lectura de los datos
                int numAspersores = sc.nextInt();
                int longitudCesped = sc.nextInt();
                double anchoCesped = sc.nextInt();

                int numUsados = 0;
                boolean posible = true;

                //Lectura de los aspersores. Inicio del rango y fin del rango de los aspersores
                ArrayList<double[]> aspersores = new ArrayList<>();
                for (int i = 0; i < numAspersores; i++) {
                    int x = sc.nextInt();
                    double r = sc.nextInt();
                    // Descartar los aspersores que no pueden cubrir el césped en su altura
                    if (r * r >= (anchoCesped / 2.0) * (anchoCesped / 2.0)) {
                        double alcanceHorizontal = Math.sqrt(r * r - (anchoCesped / 2) * (anchoCesped / 2));
                        double inicio = Math.max(0, x - alcanceHorizontal);
                        double fin = Math.min(longitudCesped, x + alcanceHorizontal);
                        aspersores.add(new double[]{inicio, fin});
                    }
                }
                // Ordenar los aspersores por el inicio del intervalo
                Collections.sort(aspersores, (a, b) -> Double.compare(a[0], b[0]));
                // Algoritmo voraz
                double coberturaActual = 0;
                int idx = 0;

                while (coberturaActual < longitudCesped) {
                    double mejorCobertura = coberturaActual;
                    // Buscar el aspersor que su rango empiece antes de la cobertura actual y que su rango termine lo más lejos posible
                    while (idx < aspersores.size() && aspersores.get(idx)[0] <= coberturaActual) {
                        mejorCobertura = Math.max(mejorCobertura, aspersores.get(idx)[1]);
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
                }

                //Mostrar el resultado
                // Si no es posible cubrir el césped, mostrar -1
                // Si es posible, mostrar el número de aspersores usados
                System.out.println(posible ? numUsados : -1);

            } catch (Exception e) {
                // Fin de la entrada
                break;
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
