package Others.Easy.Puntuacion_1_1_a_1_9._1_1;

// Leer un String y buscar la secuencia "COV"
// Si se encuentra, imprimir "Veikur!", si no, "Ekki veikur!"

import java.util.Scanner;

public class Hradgreining {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String secuencia = scan.nextLine();

        if (secuencia.contains("COV")) {
            System.out.println("Veikur!");
        } else {
            System.out.println("Ekki veikur!");
        }
    }
}