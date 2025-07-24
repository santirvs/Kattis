package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Resolver por fuerza bruta con un bucle anidado
// No es un problema de ventana deslizante, ya que una vez que se empieza a comer
// se intentan comer todas las frutas siguientes pero, si no le cabe, simplemente se la salta

import java.util.Scanner;

public class Putovanje {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numFrutas = scan.nextInt(); // Número de frutas
        int capacidad = scan.nextInt(); // Capacidad que puede comer

        int frutas[] = new int[numFrutas]; // Array para guardar las frutas
        for (int i = 0; i < numFrutas; i++) {
            frutas[i] = scan.nextInt(); // Leer las frutas
        }

        int maxFrutas = 0; // Variable para guardar el máximo de frutas que puede comer
        // Recorrer todas las frutas
        for (int i = 0; i < numFrutas; i++) {
            int capacidadRestante = capacidad; // Capacidad restante para comer
            int frutasComidas = 0; // Contador de frutas comidas

            // Recorrer las frutas a partir de la actual
            for (int j = i; j < numFrutas; j++) {
                if (frutas[j] <= capacidadRestante) { // Si la fruta cabe en la capacidad restante
                    frutasComidas++; // Incrementar el contador de frutas comidas
                    capacidadRestante -= frutas[j]; // Reducir la capacidad restante
                }
                else {
                    // Si la fruta no cabe, se salta y no se come
                    // No es necesario hacer nada, simplemente se continúa con la siguiente fruta
                }
            }

            maxFrutas = Math.max(maxFrutas, frutasComidas); // Actualizar el máximo de frutas comidas
        }

        // Imprimir el máximo de frutas que puede comer
        System.out.println(maxFrutas);
    }
}