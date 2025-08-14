package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;

// Búsqueda completa
// Enfoque:
// La idea es:
//     Tenemos M tiempos T (diferencias proporcionales a la distancia) y N distancias X.
//     CLAVE!!! La velocidad es constante, así que la secuencia de distancias que se ven debe ser proporcional a la secuencia de tiempos.
//     Probar cada posible piedra real como candidata a la primera piedra vista, calculamos la velocidad y comprobamos si todas las M piedras vistas encajan.
//     La velocidad posible se deduce como:
//     v = (X[k] - X[inicio]) / (T[1] - T[0]) y se valida para todas las piedras.
//    Lo que el problema pide realmente en la segunda línea no son las velocidades sino las distancias entre la primera y la segunda piedra vista (que equivalen a X[k+1] - X[k] para cada alineación válida).

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Búsqueda completa
// Buscar la constante de Lipschitz de una función dada por puntos
// CLAVE:: La constante de Lipschitz es el máximo valor de |dy/dx| entre puntos consecutivos

import java.io.*;
import java.util.*;

public class MilestonesCounter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Leer piedrasConsecutivas y numTotalPiedras
        st = new StringTokenizer(br.readLine());
        int numPiedrasConsecutivas = Integer.parseInt(st.nextToken());
        int numTotalPiedras = Integer.parseInt(st.nextToken());

        long[] piedrasConsecutivas = new long[numPiedrasConsecutivas];
        long[] totalPiedras = new long[numTotalPiedras];

        // Leer tiempos de las piedras consecutivas
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numPiedrasConsecutivas; i++) {
            piedrasConsecutivas[i] = Long.parseLong(st.nextToken());
        }

        // Leer distancias de las piedras totales
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numTotalPiedras; i++) {
            totalPiedras[i] = Long.parseLong(st.nextToken());
        }

        Set<Long> distanciasPosibles = new TreeSet<>();

        // Probar cada piedra real como candidata a piedrasConsecutivas[0]
        for (int inicio = 0; inicio <= numTotalPiedras - numPiedrasConsecutivas; inicio++) {
            long distancia = totalPiedras[inicio + 1] - totalPiedras[inicio]; // Distancia entre primera y segunda piedra vistas
            long tiempo = piedrasConsecutivas[1] - piedrasConsecutivas[0];

            // Evitar división por cero
            if (tiempo == 0) continue;

            boolean ok = true;
            // Chequear si secuencia es proporcional
            for (int j = 1; j < numPiedrasConsecutivas; j++) {
                long dx = totalPiedras[inicio + j] - totalPiedras[inicio];
                long dt = piedrasConsecutivas[j] - piedrasConsecutivas[0];

                // Comparar proporción evitando coma flotante
                if (dx * tiempo != dt * distancia) {
                    // Si la proporción no se cumple, no es una secuencia válida
                    ok = false;
                    break;
                }
            }

            // Si todas las piedras cumplen la proporción, añadir la distancia
            if (ok) {
                distanciasPosibles.add(distancia);
            }
        }

        // Imprimir resultados
        System.out.println(distanciasPosibles.size());
        if (!distanciasPosibles.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (long d : distanciasPosibles) {
                sb.append(d).append(" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            System.out.println();
        }
    }
}



