package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Sumar tres valores y comparar si entran en el presupuesto

import java.util.Scanner;

public class Budget {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Leer los datos
        int presupuesto = scan.nextInt();

        int proyecto1 = scan.nextInt();
        int proyecto2 = scan.nextInt();
        int proyecto3 = scan.nextInt();

        if (presupuesto >= (proyecto1+proyecto2+proyecto3))
            System.out.println("Budget is sufficient.\n");
        else
            System.out.println("Budget is insufficient.");

    }
}