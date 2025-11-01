package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la cantidad de elementos
// Leer la cantidad de pasillos
// Hacer una array de integer con la cantidad de elementos
// Leer los pasillos
// Para cada pasillo, leer su posición y hacer el intercambio con el siguiente
// Finalmente, imprimir el array

import java.util.Scanner;

public class GhostLeg {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de elementos
        int numElementos = sc.nextInt();

        // Leer la cantidad de pasillos
        int numPasillos = sc.nextInt();

        // Hacer una array de integer con la cantidad de elementos (con base 1)
        int[] elementos = new int[numElementos+1];
        for (int i = 1; i <= numElementos; i++) {
            elementos[i] = i;
        }

        // Leer los pasillos
        for (int i = 0; i < numPasillos; i++) {
            int posicion = sc.nextInt();
            // Hacer el intercambio con el siguiente
            int temp = elementos[posicion];
            elementos[posicion] = elementos[posicion + 1];
            elementos[posicion + 1] = temp;
        }
        // Finalmente, imprimir el array
        for (int i = 1; i <= numElementos; i++) {
            System.out.println(elementos[i]);
        }

        sc.close();
    }
}

