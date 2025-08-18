package Cap3._3_DivideYVenceras._1_BusquedaBinaria;

// Estrategia de D&C. Búsqueda binaria
// Leer las dos listas. Hacer una copia de la primera y ordenar la copia y la segunda
// Seguidamente, recorrer la primera lista y buscar cada elemento en la copia ordenada de la primera
// acceder a la segunda lista por el índice obtenido en la búsqueda binaria


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SynchronizingLists {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Leer el número de elementos en las listas
        int n = scan.nextInt();
        while (n > 0) {
            // Leer la primera lista
            ArrayList<Integer> lista1 = new ArrayList<>();
            ArrayList<Integer> lista1Copia = new ArrayList<>();
            // Leer n elementos para la primera lista
            for (int i = 0; i < n; i++) {
                int num = scan.nextInt();
                lista1.add(num);
                lista1Copia.add(num); // Hacer una copia de la primera lista
            }

            // Leer la segunda lista
            ArrayList<Integer> lista2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                lista2.add(scan.nextInt());
            }

            // Ordenar ambas listas
            Collections.sort(lista1Copia);
            Collections.sort(lista2);

            // Recorrer la primera lista y buscar cada elemento en la copia ordenada
            for (int i = 0; i < n; i++) {
                int index = Collections.binarySearch(lista1Copia, lista1.get(i));
                System.out.println(lista2.get(index));
            }

            // Leer el siguiente número de elementos
            n = scan.nextInt();

            // Linea en blanco para separar casos de prueba
            if (n > 0) {
                System.out.println("");
            }
        }
        scan.close();

    }
}
