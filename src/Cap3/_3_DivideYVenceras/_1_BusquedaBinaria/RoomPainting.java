package Cap3._3_DivideYVenceras._1_BusquedaBinaria;

// Estrategia de D&C. Búsqueda binaria
// Leer todos los tamaños de latas, ordenar el array
// Seguidamente buscar cada uno de los tamaños necesitados
// Si se encuentra, ok, sino, quedarnos con la lata siguiente más grande y acumular la diferencia
// entre el tamaño de la lata y el tamaño necesario

// v1. WA en Caso #8
// v2. El excedente puede llegar a ser de 1.000.000 de ml * 100.000 colores = 10^11 --> usar long para el excedente!
//     AC!


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RoomPainting {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Leer el número de latas
        int n = scan.nextInt();
        // Leer el número de colores necesarios
        int numColores = scan.nextInt();

        // Leer los tamaños de las latas
        ArrayList<Integer> latas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            latas.add(scan.nextInt());
        }
        // Ordenar los tamaños de las latas
        Collections.sort(latas);

        // Buscar cada uno de los tamaños necesarios
        long excedente = 0;
        for (int i=0; i < numColores; i++) {
            int cantidadNecesaria = scan.nextInt();
            int index = Collections.binarySearch(latas, cantidadNecesaria);
            // Si se encontró el tamaño exacto no hay excedente
            // Si no se encontró, buscar el siguiente más grande y acumular el excedente
            if (index < 0) {
                // No se encontró el tamaño exacto, buscar el siguiente más grande
                index = -index - 1; // Convertir a índice positivo para obtener el siguiente más grande
                // El enunciado indica que siempre hay una lata más grande de lo necesario
                // por lo que no hay que preocuparse de si existe o no
                excedente += latas.get(index) - cantidadNecesaria;
            }
        }
        // Imprimir el excedente total
        System.out.println(excedente);
        scan.close();

    }
}
