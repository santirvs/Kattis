package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;

// Buscar por fuerza bruta
// 10.000 x 10.000 = 100.000.000 posibilidades ???  TLE???
// pero siempre hay una solución por lo que es necesario buscar todas las posibilidades
// y además, al encontrar un caso en que no se cumpla la ecuación, se descarta ese par (a, b)
// Y al encontrar un caso que sí se cumpla, se imprime el resultado y se termina la ejecución.

// La entrada consiste en v[1], v[3], ..., v[2*n-1]
// y la salida es v[2], v[4], ..., v[2*n].


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;
import java.util.*;

public class DisgruntledJudge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Leer el número de casos
        int numCasos = Integer.parseInt(br.readLine().trim());

        // Almacenar en un array los valores de cada caso
        long[] v = new long[numCasos];
        for (int i = 0; i < numCasos; i++) {
            v[i] = Long.parseLong(br.readLine().trim());
        }

        // Buscar los valores que satisfacen la ecuación
        // v[i] = (a * v[i-1] + b) mod 10001

        // Para cada valor posible de a y b
        for (long a = 0; a <= 10000; a++) {
            for (long b = 0; b <= 10000; b++) {
                boolean valid = true;

                // Probar el valor para cada caso
                // Si se encuentra un caso que no cumple la ecuación, se descarta este par (a, b)
                for (int i = 1; i < numCasos; i++) {
                    if (v[i] != (a * a * v[i-1] + a * b + b) % 10001L) {
                        valid = false;
                        break;
                    }
                }

                // Si todos los casos cumplen la ecuación, se imprime el resultado
                if (valid) {
                    for (int i = 0; i < numCasos; i++) {
                        sb.append((a * v[i] + b) % 10001L).append("\n");
                    }
                    System.out.print(sb);
                    return;
                }
            }
        }

        throw new AssertionError("No valid solution found");
    }
}
