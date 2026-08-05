package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Calcular la distancia euclidiana entre dos puntos

import java.util.Scanner;


public class ComputerCompute {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        double x2x1 = x2 - x1;
        double y2y1 = y2 - y1;

        double solucion = Math.sqrt( x2x1*x2x1 + y2y1*y2y1);

        System.out.println(solucion);
    }
}

