package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de frases que se van a procesar
// Para cada frase
//     Leer la frase
//     Pasarlo a minúsculas
//     Poner la primera letra en mayúsculas
//     Mostrar la frase modificada

import java.util.Scanner;


public class Afjormun {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de frases
        int numFrases = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea
        for (int i = 0; i < numFrases; i++) {
            // Leer la frase
            String frase = sc.nextLine();
            // Pasarlo a minúsculas
            frase = frase.toLowerCase();
            // Poner la primera letra en mayúsculas
            if (frase.length() > 0) {
                frase = Character.toUpperCase(frase.charAt(0)) + frase.substring(1);
            }
            // Mostrar la frase modificada
            System.out.println(frase);
        }

        sc.close();
    }
}

