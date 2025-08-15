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

import java.util.Scanner;

public class Robotopia_WA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt(); // Leer el número de casos
        scan.nextLine(); // Consumir el salto de línea después del número de casos

        // Procesar cada caso
        for (int i = 0; i < numCasos; i++) {
            //Leer los datos de cada caso
            double numPiernasGrupo1 = scan.nextInt();
            double numBrazosGrupo1 = scan.nextInt();
            double numPiernasGrupo2 = scan.nextInt();
            double numBrazosGrupo2 = scan.nextInt();
            double numPiernasTotal = scan.nextInt();
            double numBrazosTotal = scan.nextInt();

            // Calcular el número de grupos
            int combinaciones = 0;
            int solNumGrupo1 = 0;
            int solNumGrupo2 = 0;
            for (int grupo2 = 0; grupo2 <= 10000; grupo2++) {
                //     g2 = ((pt - p1*bt) / b1) / (p2 - p1*b2/b1)
                int numGrupo2 = (int) (((numPiernasTotal - numPiernasGrupo1 * numBrazosTotal) / numBrazosGrupo1) / (numPiernasGrupo2 - numPiernasGrupo1 * numBrazosGrupo2 / numBrazosGrupo1));
                //     g1 = (bt - b2*g2) / b1
                int numGrupo1 = (int) ((numBrazosTotal - numBrazosGrupo2 * grupo2) / numBrazosGrupo1);

                if (numBrazosGrupo1 * numGrupo1 + numBrazosGrupo2 * grupo2 == numBrazosTotal &&
                        numPiernasGrupo1 * numGrupo1 + numPiernasGrupo2 * grupo2 == numPiernasTotal) {
                    combinaciones++;
                    solNumGrupo1 = numGrupo1;
                    solNumGrupo2 = grupo2;
                    if (combinaciones > 1) {
                        break; // Si ya hay más de una combinación, no necesitamos seguir buscando
                    }
                }
            }

            // Imprimir el resultado
            if (combinaciones == 1) {
                System.out.println(solNumGrupo1 + " " + solNumGrupo2);
            } else
                System.out.println("?");

        }
    }
}
