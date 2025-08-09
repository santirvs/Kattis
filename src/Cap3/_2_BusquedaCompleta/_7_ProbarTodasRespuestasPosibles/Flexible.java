package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// Probar todas las combinaciones posibles de las divisiones de los paneles
// Tener en cuenta que el panel 0 y el panel N siempre van a estar
// Usar un TreeSet para no repetir los tamaños de los espacios y mostrar los resultados ordenados


public class Flexible {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el tamaño del salón y el número de paneles
        // El panel 0 y el panel N siempre van a estar
        int tamanyo = sc.nextInt();
        int numPaneles = sc.nextInt();
        // Crear un array para almacenar las posiciones de los paneles
        int[] paneles = new int[numPaneles+2];
        paneles[0] = 0; // Panel 0
        paneles[numPaneles + 1] = tamanyo; // Panel N

        //Leer la posición de los paneles
        for (int i = 1; i <= numPaneles; i++) {
            paneles[i] = sc.nextInt();
        }

        // Recorrer todas las combinaciones posibles de paneles (todos los paneles contra todos los paneles anteriores)
        // Añadir el tamanyo de cada nuevo espacio a un Set para evitar duplicados
        Set<Integer> espacios = new TreeSet<>();

        // Calcular el tamaño de cada espacio
        for (int k = 1; k < paneles.length; k++) {
            for (int j = 0; j < k; j++) {
                espacios.add(paneles[k] - paneles[j]);
            }
        }

        // Imprimir los tamaños de los espacios creados
        boolean primero = true;
        for (Integer espacio : espacios) {
            if (!primero) System.out.print(" ");
            else primero = false;
            System.out.print(espacio);
        }
        System.out.println();
    }
}
