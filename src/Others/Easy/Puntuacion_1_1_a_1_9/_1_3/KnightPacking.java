package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer el tamaño del tablero
// Si es par --> ganará el segundo jugador
// Si es impar --> ganará el primer jugador

import java.util.Scanner;

public class KnightPacking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el tamaño del tablero
        int num = sc.nextInt();

        //Imprimir el resultado
        if (num%2==0) {
            System.out.println("second");
        }
        else {
            System.out.println("first");
        }

        sc.close();
    }
}

