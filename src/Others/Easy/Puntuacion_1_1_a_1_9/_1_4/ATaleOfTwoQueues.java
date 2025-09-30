package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de personas en las colas izquierda y derecha
// Leer cada una de las filas y acumular los tiempos
// Calcular el tiempo de cada una de ellas
// Mostrar cuál de las dos es la más rápida ("left" / "right") o "either" en caso de empate.

import java.util.Scanner;

public class ATaleOfTwoQueues {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el tamaño de las colas
        int left = sc.nextInt();
        int right = sc.nextInt();

        //Leer la cola izquierda
        int totalTiempoIzquierda = 0;
        for (int i=0; i < left; i++) {
            totalTiempoIzquierda += sc.nextInt();
        }

        //Leer la cola derecha
        int totalTiempoDerecha = 0;
        for (int i=0; i<right; i++) {
            totalTiempoDerecha += sc.nextInt();
        }

        //Comparar las colas
        if (totalTiempoIzquierda > totalTiempoDerecha) {
            System.out.println("right");
        } else if (totalTiempoIzquierda < totalTiempoDerecha) {
            System.out.println("left");
        } else System.out.println("either");

        sc.close();
    }
}

