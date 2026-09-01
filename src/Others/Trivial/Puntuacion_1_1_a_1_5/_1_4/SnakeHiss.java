package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Bucle simple

import java.util.Scanner;

public class SnakeHiss {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de repeticiones
        int numS = sc.nextInt();

        // Inicio
        System.out.print("His");

        // Repeticiones de la s
        for (int i=0; i<numS; i++) {
            System.out.print("s");
        }

        //Final (con salto de línea)
        System.out.println("!");

        sc.close();
    }
}

