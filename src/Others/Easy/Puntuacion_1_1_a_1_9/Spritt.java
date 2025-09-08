package Others.Easy.Puntuacion_1_1_a_1_9;

// Leer el numero de aulas y la cantidad de botellas que de desinfectante
// Seguidamente, leer la cantidad de botellas que necesita cada aula
// Imprimir si hay suficientes botellas para todas las aulas o no

import java.util.Scanner;

public class Spritt {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numAulas = scan.nextInt();
        int botellasDisponibles = scan.nextInt();

        // Inicialmente es posible.
        // Restar las botellas necesarias para cada aula a las botellas disponibles.
        // Si en algún momento las botellas disponibles son menores a 0, no es posible.
        boolean posible = true;
        for (int i = 0; i < numAulas; i++) {
            int botellasNecesarias = scan.nextInt();
            botellasDisponibles -= botellasNecesarias;
            if (botellasDisponibles < 0) {
                posible = false;
            } ;
        }

        // Imprimir si hay suficientes botellas para todas las aulas o no
        if (posible) {
            System.out.println("Jebb");
        } else {
            System.out.println("Neibb");
        }

    }
}