package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;

import java.io.IOException;
import java.io.*;
import java.util.*;

// La solución a este problema se encuentra antes del primer hijo, después del último hijo o entre dos hijos.
// Por lo tanto, hay que ordenar las edades de los hijos y calcular la máxima de las distancias entre dos hijos consecutivos.
// La solución será el punto que se encuentra a la mitad de esa distancia, siempre que se encuentre dentro del rango de edades válido.
// Si no se ha encontrado una solución válida, es que el rango de edades válido no se solapa con el rango de edades de los hijos
// por lo tanto, la solución será el extremo más lejano del rango de edades válido.

// v1. WA en Caso #4
// v2. Ajusto el caso final en que no se ha encontrado una solución válida. Devolvía -1 --> Sigue el WA en el Caso #4
// v3. Cambio el enfoque para considerar todos los impares posibles en el rango [A, B]
//    Leer N y el array de Pᵢ.
//    Ordenar Pᵢ.
//    Añadir A y B como límites adicionales para evaluar posibles puntos candidatos.
//    Generar candidatos:
//       Impares cercanos a A y B.
//       Para cada par consecutivo P[i], tomar (P[i] + P[i+1]) / 2 y ajustar a impar.
//       Filtrar candidatos para que estén en [A, B] y sean impares.
//       Calcular para cada candidato min(|X - Pᵢ|) y elegir el que tenga el máximo valor.
//       Si hay empate, cualquiera sirve.

public class Prinova {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        long[] boys = new long[N];
        for (int i = 0; i < N; i++) boys[i] = Long.parseLong(parts[i]);
        String[] range = br.readLine().split(" ");
        long A = Long.parseLong(range[0]);
        long B = Long.parseLong(range[1]);

        Arrays.sort(boys);
        List<Long> candidates = new ArrayList<>();

        // A y B si son impares
        if (A % 2 == 1) candidates.add(A);
        if (B % 2 == 1) candidates.add(B);

        // Ajustar extremos a impares
        long aOdd = (A % 2 == 0) ? A + 1 : A;
        long bOdd = (B % 2 == 0) ? B - 1 : B;
        if (aOdd <= B) candidates.add(aOdd);
        if (bOdd >= A) candidates.add(bOdd);

        // Candidatos entre pares consecutivos
        for (int i = 0; i < N - 1; i++) {
            long mid = (boys[i] + boys[i + 1]) / 2;
            if (mid % 2 == 0) mid++; // debe ser impar
            if (mid >= A && mid <= B) candidates.add(mid);
            if (mid - 2 >= A && mid - 2 <= B) candidates.add(mid - 2); // por si el impar cae a un lado
            if (mid + 2 >= A && mid + 2 <= B) candidates.add(mid + 2);
        }

        // Candidatos cercanos a A y B respecto a los pares más cercanos
        for (long boy : boys) {
            long left = boy - 1;
            long right = boy + 1;
            if (left >= A && left <= B && left % 2 == 1) candidates.add(left);
            if (right >= A && right <= B && right % 2 == 1) candidates.add(right);
        }

        // Eliminar duplicados
        Set<Long> set = new HashSet<>(candidates);
        candidates = new ArrayList<>(set);

        long best = A;
        long bestDist = -1;
        for (long x : candidates) {
            long minDist = Long.MAX_VALUE;
            for (long boy : boys) {
                minDist = Math.min(minDist, Math.abs(x - boy));
            }
            if (minDist > bestDist) {
                bestDist = minDist;
                best = x;
            }
        }

        System.out.println(best);
    }
}


