package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Calcular las áreas de la pizza grande y la pizza pequeña
// Determinar si el área de la pequeña por la cantidad es superior al área de la grande

import java.util.Scanner;

public class PizzaShortage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer los datos
        double radioGrande = sc.nextInt() / 2.0;
        double radioPequenya = sc.nextInt() / 2.0;
        int cantidad = sc.nextInt();

        double areaGrande = 2 * Math.PI * radioGrande * radioGrande;
        double areaPequenya = 2 * Math.PI * radioPequenya * radioPequenya;

        if (cantidad * areaPequenya >= areaGrande) System.out.println("Jebb");
        else System.out.println("Neibb");

    }
}

