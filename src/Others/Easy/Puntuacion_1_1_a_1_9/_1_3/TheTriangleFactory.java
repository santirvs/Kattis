package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer los angulos de un triángulo
// Mirar si alguno es mayor o igual de 90 (obtuso), si todos son menores de 90 (agudo) o si alguno es igual a 90 (recto)
// Imprimir "Trubbig Triangel", "Spetsig Triangel" o "Ratvinklig Triangel" según corresponda

import java.util.Scanner;

public class TheTriangleFactory {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int angle1 = scan.nextInt();
        int angle2 = scan.nextInt();
        int angle3 = scan.nextInt();

        if (angle1 == 90 || angle2 == 90 || angle3 == 90) {
            System.out.println("Ratvinklig Triangel");
        } else if (angle1 > 90 || angle2 > 90 || angle3 > 90) {
            System.out.println("Trubbig Triangel");
        } else {
            System.out.println("Spetsig Triangel");
        }

    }
}