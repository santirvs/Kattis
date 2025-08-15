package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;

// Buscar por fuerza bruta
// Calcular las combinaciones de grupos de robots que pueden ser formados con las piernas y brazos disponibles.
// Posible TLE (10.000 * 10.000 = 100.000.000 iteraciones en el peor caso), buscar una solución más eficiente si es necesario.

// v1. TLE en Caso #2
// v2. Limitar las iteraciones a 10.000 / numero de piernas o brazos de cada tipo, para evitar iteraciones innecesarias.
//     TLE en Caso #3

import java.util.Scanner;

public class Robotopia_TLE {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt(); // Leer el número de casos
        scan.nextLine(); // Consumir el salto de línea después del número de casos

        // Procesar cada caso
        for (int i = 0; i < numCasos; i++) {
            //Leer los datos de cada caso
            int numPiernasGrupo1 = scan.nextInt();
            int numBrazosGrupo1 = scan.nextInt();
            int numPiernasGrupo2 = scan.nextInt();
            int numBrazosGrupo2 = scan.nextInt();
            int numPiernasTotal = scan.nextInt();
            int numBrazosTotal = scan.nextInt();

            int maximoGrupo1 = Math.max(numPiernasTotal/numPiernasGrupo1, numBrazosTotal/numBrazosGrupo1);
            int maximoGrupo2 = Math.max(numPiernasTotal/numPiernasGrupo2, numBrazosTotal/numBrazosGrupo2);

            // Calcular el número de combinaciones posibles que satisfacen las condiciones
            int combinaciones = 0;
            int numGrupo1 = 0;
            int numGrupo2 = 0;
            outer:
            for (int grupo1 = 0; grupo1 <= maximoGrupo1; grupo1++) {
                for (int grupo2 = 0; grupo2 <= maximoGrupo2; grupo2++) {
                    // Verificar si el número de piernas es válido
                    if (grupo1 * numPiernasGrupo1 + grupo2 * numPiernasGrupo2 == numPiernasTotal &&
                            grupo1 * numBrazosGrupo1 + grupo2 * numBrazosGrupo2 == numBrazosTotal) {
                        combinaciones++;
                        numGrupo1 = grupo1;
                        numGrupo2 = grupo2;
                        if (combinaciones > 1) {
                            break outer; // Si ya hay más de una combinación, no necesitamos seguir buscando
                        }
                    }
                }
            }


            // Imprimir el resultado
            if (combinaciones == 1) {
                System.out.println(numGrupo1 + " " + numGrupo2);
            } else
                System.out.println("?");
        }
    }

}


