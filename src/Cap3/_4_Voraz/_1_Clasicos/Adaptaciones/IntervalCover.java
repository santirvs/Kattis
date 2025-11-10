package Cap3._4_Voraz._1_Clasicos.Adaptaciones;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.
// Problema de cobertura de intervalos.
// Dado un conjunto de intervalos, encontrar el subconjunto mínimo de intervalos que cubra un intervalo [0, M].
// Tomar el intervalo que comience antes de la cobertura actual y que termine lo más lejos posible.
// La entrada consiste en dos decimales que representan el intervalo a ser cubierto.
// Le sigue un entero que indica la cantidad de rangos y luego los rangos (cada uno representado por dos decimales).
// La salida es el número mínimo de intervalos necesarios para cubrir el intervalo [0, M] y los intervalos usados
// o impossible si no es posible cubrir el intervalo.

// v1 -> TLE en caso #2 -> Usar FastScanner
// v2 -> Aceptada.

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IntervalCover {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
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
                    intervalos.add(new double[]{inicio, fin, i});  // Guardar el inicio y fin del intervalo, y su índice original (i)
                }

                // Ordenar los intervalos por el inicio del intervalo
                Collections.sort(intervalos, (a, b) -> Double.compare(a[0], b[0]));

                // Descartar los intervalos que no pueden cubrir el rango
                ArrayList<Integer> rangosUsados = new ArrayList<>();
                int numUsados = 0;
                boolean posible = true;

                // Algoritmo voraz
                double inicio = Double.NEGATIVE_INFINITY;
                double coberturaActual = Double.NEGATIVE_INFINITY;
                ArrayList<Integer> indicesUsados = new ArrayList<>();
                int idx = 0;
                int indiceUsado = -1;
                // Buscar el primer rango que empiece lo más cerca del rangoMin y que termine lo más lejos posible
                while (idx < intervalos.size() && intervalos.get(idx)[0] <= rangoMin) {
                    if (inicio < intervalos.get(idx)[0] && intervalos.get(idx)[1] >= coberturaActual) {
                        inicio = intervalos.get(idx)[0];
                        coberturaActual = intervalos.get(idx)[1];
                        indiceUsado = (int) intervalos.get(idx)[2];
                    }
                    idx++;
                }
                // Si no se ha usado ningun intervalo significa que no es posible cubrir el césped
                if (indiceUsado == -1) {
                    posible = false;
                } else {
                    numUsados++;
                    indicesUsados.add(indiceUsado); // Guardar el índice del intervalo usado
                }

                // Buscar el resto de intervalos
                while (coberturaActual < rangoMax) {
                    double mejorCobertura = coberturaActual;
                    // Buscar el aspersor que su rango empiece antes de la cobertura actual y que su rango termine lo más lejos posible
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
            } catch (Exception e) {
                // Fin de la entrada
                break;
            }
        }

    }

}
