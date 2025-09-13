package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer dos números y compararlos
// Imprimir 1 si el primero es mayor y 0 en caso contrario

import java.util.Scanner;

public class WhichIsGreater {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int a = scan.nextInt();
        int b = scan.nextInt();

        if (a > b) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}