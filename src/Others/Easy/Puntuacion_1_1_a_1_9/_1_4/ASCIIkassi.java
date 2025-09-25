package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el tamaño del cuadrado
// Pintar el cuadrado con caracteres ASCII

import java.util.Scanner;

public class ASCIIkassi {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el tamanyo del cuadrado
        int n = sc.nextInt();
        n = n+2; // Añadir 2 para los bordes

        // Crear la fila del medio
        String middleRow = "|";
        for (int j = 1; j <= n - 2; j++) {
            middleRow += " ";
        }
        middleRow += "|";

        //Pintar la primera fila
        for (int j = 1; j <= n; j++) {
            if (j == 1 || j == n) {
                System.out.print("+");
            } else {
                System.out.print("-");
            }
        }
        System.out.println();

        // Pintar las filas intermedias
        for (int j = 1; j <= n - 2; j++) {
            System.out.println(middleRow);
        }

        //Pintar la ultima fila
        for (int j = 1; j <= n; j++) {
            if (j == 1 || j == n) {
                System.out.print("+");
            } else {
                System.out.print("-");
            }
        }
        System.out.println();

        sc.close();
    }
}

