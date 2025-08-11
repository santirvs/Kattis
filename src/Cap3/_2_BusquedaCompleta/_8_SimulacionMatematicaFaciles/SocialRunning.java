package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;

// Búsqueda completa
// Tratar cada uno de los nodos. Calcular la distancia recorrida en solitario y escoger el menor.
// La distancia recorrida en solitario es la suma de las distancias del nodo seleccionado y del nodo n-2
// El nodo n-2 es el que lleva al nodo n-1, que es el nodo de destino del último corredor.

import java.util.Scanner;

public class SocialRunning {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer el número de corredores
        int n = scan.nextInt();
        // Leer las distancias de cada corredor desde su casa a la casa siguiente
        int[] distancias = new int[n];
        for (int i = 0; i < n; i++) {
            distancias[i] = scan.nextInt();
        }

        // Buscar la distancia mínima recorrida en solitario
        int distanciaMinima = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // Calcular la distancia recorrida en solitario para el corredor i
            int distanciaRecorrida = distancias[i] + distancias[(i + n - 2) % n]; // Añadir la distancia del nodo i y del nodo n-2
            // Actualizar la distancia mínima si es menor que la actual
            distanciaMinima = Math.min(distanciaMinima, distanciaRecorrida);
        }

        // Imprimir la distancia mínima recorrida en solitario
        System.out.println(distanciaMinima);
    }

}


