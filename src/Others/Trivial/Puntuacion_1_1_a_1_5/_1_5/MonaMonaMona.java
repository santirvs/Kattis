package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Leer la línia
// Obtener el primer nombre
// Repetir 3 veces

import java.util.Scanner;


public class MonaMonaMona {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String linea = sc.nextLine();
        System.out.print(linea);

        String[] parts = linea.split(" ");
        for (int i=parts.length; i<3; i++) {
            System.out.print(" " + parts[0]);
        }
        sc.close();
    }
}

