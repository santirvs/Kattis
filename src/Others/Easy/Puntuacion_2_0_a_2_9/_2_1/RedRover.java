package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Dado el bajo tamaño de la cadena (100 caracteres)
// Se puede emplear un algoritmo de fuerza bruta y probar todos los casos

import java.util.Scanner;

public class RedRover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            String route = scanner.nextLine().trim();
            int originalLength = route.length();
            int minCharacters = originalLength; // El peor de los casos es no usar macros

            // Generamos todas las subcadenas posibles para usarlas como macro
            for (int i = 0; i < originalLength; i++) {
                for (int j = i + 1; j <= originalLength; j++) {
                    String macro = route.substring(i, j);
                    int macroLength = macro.length();

                    // Contamos cuántas veces aparece el macro sin solaparse
                    int frequency = 0;
                    int index = 0;
                    while ((index = route.indexOf(macro, index)) != -1) {
                        frequency++;
                        index += macroLength; // Saltamos la longitud del macro para evitar solapamientos
                    }

                    // Calculamos el costo total con este macro
                    // Costo = (Longitud de la ruta reemplazando el macro por 'M') + (Longitud del macro)
                    int newRouteLength = originalLength - (frequency * macroLength) + frequency;
                    int totalCost = newRouteLength + macroLength;

                    // Si encontramos una mejor opción, actualizamos el mínimo
                    if (totalCost < minCharacters) {
                        minCharacters = totalCost;
                    }
                }
            }

            // Imprimimos la respuesta óptima
            System.out.println(minCharacters);
        }

        scanner.close();
    }
}