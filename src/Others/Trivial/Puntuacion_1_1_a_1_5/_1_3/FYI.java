package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Leer un teléfono y determinar si empieza por 555
// Si empieza por 555, imprimir 1, sino 0

import java.util.Scanner;

public class FYI {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        String phone = scan.nextLine();
        if (phone.startsWith("555")) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}