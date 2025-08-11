package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;

import java.io.IOException;
import java.util.Scanner;

// La solución a este problema se encuentra antes del primer hijo, después del último hijo o entre dos hijos.
// Por lo tanto, hay que ordenar las edades de los hijos y calcular la máxima de las distancias entre dos hijos consecutivos.
// La solución será el punto que se encuentra a la mitad de esa distancia, siempre que se encuentre dentro del rango de edades válido.
// Si no se ha encontrado una solución válida, es que el rango de edades válido no se solapa con el rango de edades de los hijos
// por lo tanto, la solución será el extremo más lejano del rango de edades válido.

// v1. WA en Caso #4
// v2. Ajusto el caso final en que no se ha encontrado una solución válida. Devolvía -1 --> Sigue el WA en el Caso #4


public class Prinova_WA {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Leer el número de hijos
        int numHijos = sc.nextInt();

        // Leer las edades de los hijos
        int[] edades = new int[numHijos];
        for (int i = 0; i < numHijos; i++) {
            edades[i] = sc.nextInt();
        }
        // Ordenar las edades de los hijos
        java.util.Arrays.sort(edades);
        // Leer el rango de edades válido
        int minEdad = sc.nextInt();
        int maxEdad = sc.nextInt();
        // Inicializar la máxima distancia entre dos hijos consecutivos
        int maxDistancia = -1;
        // Verificar la distancia entre cada pareja de hijos consecutivos
        for (int i = 0; i < numHijos - 1; i++) {
            boolean ajustarImpar = false;
            // Calcular la distancia entre los hijos i y i+1
            int posibleNombre = (edades[i + 1] - edades[i]) / 2 + edades[i];
            if (posibleNombre % 2 == 0) {
                ajustarImpar = true;
            }

            if (!ajustarImpar && posibleNombre >= minEdad && posibleNombre <= maxEdad) {
                // Si la distancia es válida, actualizar la máxima distancia
                maxDistancia = Math.max(maxDistancia, posibleNombre);
            } else if (ajustarImpar && posibleNombre + 1 >= minEdad && posibleNombre + 1 <= maxEdad) {
                // Si la distancia es válida, actualizar la máxima distancia
                maxDistancia = Math.max(maxDistancia, posibleNombre+1);
            } else if (ajustarImpar && posibleNombre - 1 >= minEdad && posibleNombre - 1 <= maxEdad) {
                // Si la distancia es válida, actualizar la máxima distancia
                maxDistancia = Math.max(maxDistancia, posibleNombre-1);
            }
        }

        if (maxDistancia == -1) {
            // Si no se ha encontrado una distancia válida, la solución será el extremo más lejano del rango de edades válido
            if (minEdad <= edades[0]) {
                maxDistancia = minEdad;
                if (maxDistancia %2 == 0) {
                    maxDistancia += 1;
                }
            }
            else if (maxEdad >= edades[numHijos - 1]) {
                maxDistancia = maxEdad;
                if (maxDistancia %2 == 0) {
                    maxDistancia -= 1;
                }
            }
        }

        // Imprimir la solución
        System.out.println(maxDistancia);
        sc.close();


    }

}
