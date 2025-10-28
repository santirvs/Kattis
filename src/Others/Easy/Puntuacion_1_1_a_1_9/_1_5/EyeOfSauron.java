package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la cadena.
// Hacer un split por "()", siempre hay uno y solo uno
// Comprobar la longitud de las dos partes
// Si son iguales, mostrar "correct", sino mostrar "fix"

import java.util.Scanner;

public class EyeOfSauron {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cadena
        String partes[] = sc.nextLine().split("\\(\\)");
        // Comprobar la longitud de las dos partes
        if (partes[0].length() == partes[1].length()) {
            System.out.println("correct");
        } else {
            System.out.println("fix");
        }
        sc.close();
    }
}

