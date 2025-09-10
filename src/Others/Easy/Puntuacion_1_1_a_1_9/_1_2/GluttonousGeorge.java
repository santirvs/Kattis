package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer el primer número, ignorar el ? (siempre será un ?), y leer el segundo número
// Comparar ambos números y mostrar:
// < si el primero es menor que el segundo
// = Goggi svangur!
// > si el primero es mayor que el segundo

import java.util.Locale;
import java.util.Scanner;

public class GluttonousGeorge {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int num1 = scan.nextInt();
        scan.next(); // Ignorar el ?
        int num2 = scan.nextInt();

        //Comparar y mostrar el resultado
        if (num1 < num2) {
            System.out.println("<");
        } else if (num1 > num2) {
            System.out.println(">");
        } else {
            System.out.println("Goggi svangur!");
        }

    }
}