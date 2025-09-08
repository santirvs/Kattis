package Others.Easy.Puntuacion_1_1_a_1_9;

// Leer las edades y detectar la menor

import java.util.Scanner;

public class Aldur {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numAmigos = scan.nextInt();
        int edadMasJoven = Integer.MAX_VALUE;

        // Leer las edades y encontrar la menor
        while (numAmigos-- > 0) {
            int edad = scan.nextInt();
            edadMasJoven = Math.min(edadMasJoven, edad);
        }

        //Imprimir la edad más joven
        System.out.println(edadMasJoven);


    }
}