package Cap3._3_DivideYVenceras._3_BusquedaTernariaYOtros;

// Estrategia de D&C. Búsqueda ternaria y otros
/** Original de https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_3_Problem_Solving_Paradigms/Divide_and_Conquer/kattis_reconnaissance.cpp
 * *
 * Problema de búsqueda ternaria relativamente sencillo. En esencia se busca ternariamente el mejor tiempo.
 * Para cada tiempo, verificamos el valor máximo de las rectas y el valor mínimo de las rectas, luego tomamos
 * la diferencia.

 * Tiempo: O(100 n), Memoria: O(n)
 */

import java.io.*;
import java.util.*;

public class Reconnaissance {

    static int numVehiculos;
    static List<Pair> vehiculos = new ArrayList<>();

    static double val(double tiempo) {
        double maxi = -1e12;   // Valor muy pequeño, si se usa Double.MIN_VALUE da WA en el caso #18
        double mini = 1e12;    // Valor muy grande
        for (Pair p : vehiculos) {
            double posicion = p.first, velocidad = p.second;
            double y = posicion + velocidad * tiempo;
            maxi = Math.max(maxi, y);
            mini = Math.min(mini,y);
        }
        // En el caso que no haya vehículos, el resultado es 0
        mini = Math.min(mini,maxi);
        return maxi - mini;
    }

    public static void main(String[] args) throws IOException {
        // Uso de FastScanner, ya que hay hasta 100.000 entradas
        FastScanner fs = new FastScanner();

        //Leer el número de vehículos
        numVehiculos = fs.nextInt();

        // Leer la posición inicial y velocidad de cada vehículo
        for (int i = 0; i < numVehiculos; i++) {
            int posicion = fs.nextInt();
            int velocidad = fs.nextInt();
            vehiculos.add(new Pair(posicion, velocidad));
        }

        // Búsqueda ternaria en el tiempo. Límites: 0..1e12
        double lo = 0, hi = 1e12;
        for (int i = 0; i < 100; i++) {  //Hasta 100 iteraciones
            // búsqueda ternaria
            double midLo = lo + (hi - lo) / 3;
            double midHi = hi - (hi - lo) / 3;

            if (val(midLo) < val(midHi)) {
                hi = midHi;
            } else {
                lo = midLo;
            }
        }

        // Imprimir el resultado con 3 decimales
        System.out.printf("%.3f%n", val(hi));
    }

    // Clase auxiliar para pares
    static class Pair {
        int first, second;
        Pair(int f, int s) {
            first = f;
            second = s;
        }
    }

    // Lector rápido
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
