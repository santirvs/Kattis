package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la matriz
// Recorrer el rectangulo interior y comprobar los elementos adyacentes
// Salir en el momento en que se encuentre una baja presión

import java.util.Scanner;

public class LaegoYfirLandinu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la matriz
        int filas = sc.nextInt();
        int columnas = sc.nextInt();
        int[][] matriz = new int[filas][columnas];

        // Leer la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        // Comprobar el rectangulo interior
        boolean bajaPresion = false;
        for (int i = 1; i < filas - 1 && !bajaPresion; i++) {
            for (int j = 1; j < columnas - 1 && !bajaPresion; j++) {
                int current = matriz[i][j];
                if (current < matriz[i-1][j] && current < matriz[i+1][j] &&
                    current < matriz[i][j-1] && current < matriz[i][j+1]) {
                    bajaPresion = true;
                }
            }
        }
        // Mostrar el resultado
        if (bajaPresion) {
            System.out.println("Jebb");
        } else {
            System.out.println("Neibb");
        }

        sc.close();
    }
}

