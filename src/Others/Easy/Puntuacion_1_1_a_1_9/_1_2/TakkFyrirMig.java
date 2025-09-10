package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer el número de personas.
// Luego leer cada una de las personas e imprimir "Takk " + nombre de la persona.

import java.util.Scanner;

public class TakkFyrirMig {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer el número de personas
        int numPersonas = scan.nextInt();
        scan.nextLine();

        //Leer el nombre y agradecer a cada persona
        for (int i = 0; i < numPersonas; i++) {
            String nombre = scan.nextLine();
            System.out.println("Takk " + nombre);
        }

    }
}