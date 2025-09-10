package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer los dos números
// Comparar ambos números y mostrar:
// MAGA! si el primero es mayor que el segundo
// WORLD WAR 3! si son iguales
// FAKE NEWS! si el primero es menor que el segundo

import java.util.Scanner;

public class Takkar {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();

        //Comparar y mostrar el resultado
        if (num1 < num2) {
            System.out.println("FAKE NEWS!");
        } else if (num1 > num2) {
            System.out.println("MAGA!");
        } else {
            System.out.println("WORLD WAR 3!");
        }

    }
}