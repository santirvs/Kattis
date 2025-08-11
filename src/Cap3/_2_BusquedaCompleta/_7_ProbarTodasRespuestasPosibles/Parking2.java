package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;

import java.io.*;
import java.util.Scanner;

// No veo la necesidad de hacer una búsqueda completa para este problema.
// Si se aparca en la primera tienda y se anda hasta la última, se pasará por todas las tiendas.
// Luego habrá que volver al coche por lo que la distancia recorrida será el doble de la distancia entre la primera y la última tienda.
// Si se aparca en la última tienda pasará lo mismo. Y si se aparca en cualquier posición intermedia, la distancia recorrida será la misma.
// Por lo tanto, la distancia a recorrer será siempre el doble de la distancia entre la primera y la última tienda.

public class Parking2 {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos
        int casos = sc.nextInt();

        for (int i = 0; i < casos; i++) {
            // Leer el número de tiendas
            int n = sc.nextInt();
            // Leer las posiciones de las tiendas y guardarnos la mínima y la máxima
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                int posicion = sc.nextInt();
                min = Math.min(min, posicion);
                max = Math.max(max, posicion);
            }
            // Calcular la distancia entre la primera y la última tienda
            int distancia = max-min;
            // La distancia total a recorrer es el doble de esa distancia
            System.out.println(2 * distancia);
        }

    }

}
