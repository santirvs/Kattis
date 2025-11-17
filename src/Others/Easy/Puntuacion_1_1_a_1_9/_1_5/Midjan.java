package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer los tamaños de los arrays
// Leer cada uno de los dos arrays
// Para el primer array, imprimir los números que no estan en el segundo
// Para el segundo array, imprimir los números que no están en el primero

import java.util.Scanner;

public class Midjan {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tamanyo1 = sc.nextInt();
        int tamanyo2 = sc.nextInt();

        // Definir los arrays
        int[] lunes = new int[tamanyo1];
        int[] martes = new int[tamanyo2];

        //Leer los arrays
        for (int i=0; i<tamanyo1; i++) {
            lunes[i] = sc.nextInt();
        }
        for (int i=0; i<tamanyo2; i++) {
            martes[i] = sc.nextInt();
        }

        // Para el primer array, imprimir los números que no están en el segundo
        boolean primero = true;
        for (int i=0; i<tamanyo1; i++) {
            boolean encontrado = false;
            for (int j=0; j<tamanyo2 && !encontrado; j++) {
                if (lunes[i] == martes[j]) encontrado = true;
            }
            if (!encontrado) {
                if (primero) primero=false;
                else System.out.print(" ");
                System.out.print(lunes[i]);
            }
        }
        System.out.println();
        // Para el segundo array, imprimir los números que no están en el primero
        primero = true;
        for (int i=0; i<tamanyo2; i++) {
            boolean encontrado = false;
            for (int j=0; j<tamanyo1 && !encontrado; j++) {
                if (martes[i] == lunes[j]) encontrado = true;
            }
            if (!encontrado) {
                if (primero) primero=false;
                else System.out.print(" ");
                System.out.print(martes[i]);
            }
        }

        sc.close();
    }
}

