package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

/**
 * C = (F-32) * 5/9
 */

import java.util.Scanner;

public class LasagneInTheOven {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Leer los datos
        int F = sc.nextInt();

        //Calcular los grados
        double C = (F-32) / (9.0/5.0);

        int result = (int) Math.round(C);

        System.out.println(result);

    }
}