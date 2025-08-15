package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;

// Buscar por fuerza bruta
// Calcular las combinaciones de grupos de robots que pueden ser formados con las piernas y brazos disponibles.
// Posible TLE (10.000 * 10.000 = 100.000.000 iteraciones en el peor caso), buscar una solución más eficiente si es necesario.

// v1. TLE en Caso #2
// v2. Limitar las iteraciones a 10.000 / numero de piernas o brazos de cada tipo, para evitar iteraciones innecesarias.
//     TLE en Caso #3
// v3. Resolver por sistema de ecuaciones lineales, de forma que solo se necesite un bucle
//     p1*g1 + p2*g2 = pt
//     b1*g1 + b2*g2 = bt
//     g1 = (bt - b2*g2) / b1
//     g2 = ((pt - p1*bt) / b1) / (p2 - p1*b2/b1)
//     Buscar una solucion entera para g1 y g2, que exista y que sea positiva
//     Iterar en g2 desde 0 hasta el máximo posible (10000), y calcular g1
//     WA en Caso #11
// v4. Cambio de planteamiento:
//     Similar al anterior, pero sin hacer uso de decimales.
//     Utilizando enteros para evitar problemas de precisión y errores de redondeo.

import java.util.*;
import java.io.*;

public class Robotopia {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt(); // Leer el número de casos

        while (numCasos-- > 0) {
            int numPiernas1 = scan.nextInt();
            int numBrazos1 = scan.nextInt();
            int numPiernas2 = scan.nextInt();
            int numBrazos2 = scan.nextInt();
            int numPiernasTotal = scan.nextInt();
            int numBrazosTotal = scan.nextInt();

            // Basicamente numPiernas1*x + numPiernas2*y = numPiernasTotal
            // y numBrazos1*x + numBrazos2 *y = numBrazosTotal
            // Donde x es el número de grupos del primer tipo y y es el número de grupos del segundo tipo

            int numSoluciones = 0; // número de soluciones
            int fx = 0, fy = 0;

            // Iterar sobre el número de grupos del primer tipo (x)  (hasta el máximo de piernas y brazos totales)
            for (int x = 1; x <= Math.max(numPiernasTotal, numBrazosTotal); x++) {
                // Si sobran brazos y piernas después de formar x grupos del primer tipo
                if (numPiernasTotal > numPiernas1 * x && numBrazosTotal > numBrazos1 * x) {
                    // Calcular el número de grupos del segundo tipo (y) siempre que resulte un número entero
                    if ((numPiernasTotal - numPiernas1 * x) % numPiernas2 == 0 && (numBrazosTotal - numBrazos1 * x) % numBrazos2 == 0) {
                        int y = (numPiernasTotal - numPiernas1 * x) / numPiernas2;
                        if (y > 0 && numBrazos1 * x + numBrazos2 * y == numBrazosTotal) {
                            // Si encontramos una solución válida, incrementamos el contador de soluciones
                            numSoluciones++;
                            // Guardamos la solución
                            fx = x;
                            fy = y;
                        }
                    }
                }
            }

            if (numSoluciones == 1) {
                System.out.println(fx + " " + fy);
            } else {
                System.out.println("?");
            }
        }

    }
}
