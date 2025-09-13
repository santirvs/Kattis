package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer la cantidad de filas y columnas. Determinar el tamaño total (filas * columnas).
// Leer las filas y contar cuantas veces aparece el caracter '.' (punto, que representa un espacio libre).
// El resultado es la proporción de espacios libres sobre el tamaño total, con 5 decimales

import java.util.Scanner;

public class Umferd {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int cols = scan.nextInt();
        int rows = scan.nextInt();
        scan.nextLine(); // Consumir el salto de línea restante
        int totalSize = rows * cols;
        int freeSpaces = 0;
        for (int i = 0; i < rows; i++) {
            String line = scan.nextLine();
            for (char c : line.toCharArray()) {
                if (c == '.') {
                    freeSpaces++;
                }
            }
        }
        //Calcular la proporción y mostrar el resultado con 5 decimales
        double proportion = (double) freeSpaces / totalSize;
        System.out.printf("%.5f%n", proportion);


    }
}