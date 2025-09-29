package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de cartas, la predicción y el número de pasos
// Para cada caso, leer el tamaño y las cartas
// Si las cartas contienen la predicción, escribir "KEEP"
// sino, escribir "REMOVE"

import java.util.Scanner;

public class ForcedChoice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de cartas, la predicción y el número de pasos
        int numCartas = sc.nextInt();
        int prediccion = sc.nextInt();
        int numPasos = sc.nextInt();

        // Para cada caso, leer el tamaño y las cartas
        for (int i=0; i<numPasos; i++) {
            int tamanyo = sc.nextInt();
            boolean encontrada = false;
            for (int j=0; j<tamanyo; j++) {
                int carta = sc.nextInt();
                if (carta==prediccion) {
                    encontrada = true;
                }
            }
            if (!encontrada) {
                System.out.println("REMOVE");
            } else {
                System.out.println("KEEP");
            }
        }

        sc.close();
    }
}

