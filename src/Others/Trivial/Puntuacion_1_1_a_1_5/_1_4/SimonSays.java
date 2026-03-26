package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Leer la cantidad de frases a la entrada
// Leer cada frase
// Si la frase empieza por "Simon says ", imprimir la frase sin "Simon says "
// Si no, no imprimir nada

import java.util.Scanner;

public class SimonSays {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de frases a la entrada
        int n = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea
        // Leer cada frase
        for (int i = 0; i < n; i++) {
            String frase = sc.nextLine();
            // Si la frase empieza por "Simon says ", imprimir la frase sin "Simon says "
            if (frase.startsWith("Simon says ")) {
                System.out.println(frase.substring(11));
            }
            // Si no, no imprimir nada
        }

        sc.close();
    }
}

