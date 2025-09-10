package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer los datos y aplicar la fórmula
//  d = vt + 1/2 at^2

import java.util.Scanner;

public class Bladra {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        double v = scan.nextInt();
        double a = scan.nextInt();
        double t = scan.nextInt();

        //Aplicar la fórmula
        double d = v * t + 0.5 * a * t * t;

        //Mostrar el resultado con 5 decimales
        System.out.printf("%.5f\n", d);


    }
}