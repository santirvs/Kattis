package Cap3._4_Voraz._1_Clasicos.Adaptaciones;

// Estrategia voraz.
// Problema de cobertura de intervalos.
// Dado un conjunto de intervalos, encontrar el subconjunto mínimo de intervalos que cubra un intervalo [0, M].
// Tomar el intervalo que comience antes de la cobertura actual y que termine lo más lejos posible.
// La entrada consiste en dos decimales que representan el intervalo a ser cubierto.
// Le sigue un entero que indica la cantidad de rangos y luego los rangos (cada uno representado por dos decimales).
// La salida es el número mínimo de intervalos necesarios para cubrir el intervalo [0, M] y los intervalos usados
// o impossible si no es posible cubrir el intervalo.


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class PorALaFoscor {

    public static void main(String[] args) throws IOException {
        // 20.000 entradas, mejor usar un FastScanner
        FastScanner sc = new FastScanner();

        boolean primerCaso = true;
        while (true) {  // El FastScanner no tiene hasNext(), necesito el while(true) + try/catch
            try {
                // Lectura del rango a cubrir
                double rangoMin = sc.nextDouble();
                double rangoMax = sc.nextDouble();

                // Línea separadora de casos (excepto la primera)
                if (!primerCaso) {
                    System.out.println();
                } else {
                    primerCaso = false;
                }
                // Asegurar que rangoMin <= rangoMax
                if (rangoMin > rangoMax) {
                    double aux = rangoMin;
                    rangoMin = rangoMax;
                    rangoMax = aux;
                }

                // Lectura del numero de intervalos
                int numIntervalos = sc.nextInt();

                // Lectura de los intervalos
                ArrayList<double[]> intervalos = new ArrayList<>();
                for (int i = 0; i < numIntervalos; i++) {
                    double inicio = sc.nextDouble();
                    double fin = sc.nextDouble();
                    intervalos.add(new double[]{inicio, fin, i});  // Guardar el inicio y fin del intervalo, y su índice original (i)
                }

                // Ordenar los intervalos por el inicio del intervalo
                Collections.sort(intervalos, (a, b) -> Double.compare(a[0], b[0]));

                // Algoritmo voraz
                double inicio = Double.NEGATIVE_INFINITY;
                double coberturaActual = Double.NEGATIVE_INFINITY;
                ArrayList<Integer> indicesUsados = new ArrayList<>();
                int idx = 0;
                int indiceUsado = -1;
                int numUsados = 0;
                boolean posible = true;
                // Buscar el primer rango que empiece lo más cerca del rangoMin y que termine lo más lejos posible
                while (idx < intervalos.size() && intervalos.get(idx)[0] <= rangoMin) {
                    if (inicio < intervalos.get(idx)[0] && intervalos.get(idx)[1] >= coberturaActual) {
                        inicio = intervalos.get(idx)[0];
                        coberturaActual = intervalos.get(idx)[1];
                        indiceUsado = (int) intervalos.get(idx)[2];
                    }
                    idx++;
                }
                // Si no se ha usado ningún intervalo significa que no es posible cubrir el inicio de la carretera
                if (indiceUsado == -1) {
                    posible = false;
                } else {
                    numUsados++;
                    indicesUsados.add(indiceUsado); // Guardar el índice del intervalo usado
                }

                // Buscar el resto de intervalos
                while (coberturaActual < rangoMax) {
                    double mejorCobertura = coberturaActual;
                    // Buscar la farola que su rango empiece antes o igual de la cobertura actual y que su rango termine lo más lejos posible
                    while (idx < intervalos.size() && intervalos.get(idx)[0] <= coberturaActual) {
                        if (intervalos.get(idx)[1] > mejorCobertura) {
                            indiceUsado = (int) intervalos.get(idx)[2];
                            mejorCobertura = intervalos.get(idx)[1];
                        }
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
                    indicesUsados.add(indiceUsado); // Guardar el índice del intervalo usado
                }

                //Mostrar el resultado
                if (posible) {
                    Collections.sort(indicesUsados);
                    System.out.println(numUsados);
                    boolean primero = true;
                    for (Integer i : indicesUsados) {
                        if (!primero) System.out.print(" ");
                        else primero = false;
                        System.out.print(i);
                    }
                    System.out.println();
                } else {
                    System.out.println("PayStayXon all the night!");
                }
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

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
