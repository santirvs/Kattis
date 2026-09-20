package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Superfície de la circunferencia PI * R^2
 *
 * Calcular la superfície de la pizza (radio R)
 * Calcular la superfície de la pizza con queso (radio R-C)
 *
 * Calcular el porcentaje de la pizza sin queso
 */


import java.io.IOException;
import java.util.Scanner;


public class PizzaCrust {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        double superficiePizza = Math.PI * R * R;
        double superficieQueso = Math.PI * (R-C) * (R-C);

        System.out.println((superficieQueso / superficiePizza) * 100);

        sc.close();
    }
}

