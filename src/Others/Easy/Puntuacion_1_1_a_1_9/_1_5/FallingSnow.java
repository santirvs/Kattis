package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer las dimensiones de la matriz de nieve
// Declarar una matriz de caracteres pero la vamos a referenciar por columnas y filas
// Leer la matriz por filas pero guardarla por columnas
// Ordenar cada columna
// Imprimir la matriz por filas

import java.util.Scanner;

public class FallingSnow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Leer las dimensiones de la matriz de nieve
        int filas = sc.nextInt();
        int columnas = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea después del entero
        // Declarar una matriz de caracteres pero la vamos a referenciar por columnas y filas
        char[][] nieve = new char[columnas][filas];
        // Leer la matriz por filas pero guardarla por columnas
        for (int i = 0; i < filas; i++) {
            String linea = sc.nextLine();
            for (int j = 0; j < columnas; j++) {
                nieve[j][i] = linea.charAt(j);
            }
        }

        // Ordenar cada columna
        for (int j = 0; j < columnas; j++) {
            java.util.Arrays.sort(nieve[j]);
        }

        // Imprimir la matriz por filas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(nieve[j][i]);
            }
            System.out.println();
        }


        sc.close();

    }
}

