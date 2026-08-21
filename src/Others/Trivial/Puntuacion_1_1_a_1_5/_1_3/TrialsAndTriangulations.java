package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Aplicar la fórmula de Heron para calcular el área de un triángulo

import java.util.Scanner;

public class TrialsAndTriangulations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Lectura de los 3 lados del triángulo
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        //Calcular s
        double s = (a+b+c)/2.0;

        //Aplicar la fórmula
        double area = Math.sqrt( s * (s-a) * (s-b) * (s-c));

        //Mostrar el resultado
        System.out.println(area);


        sc.close();
    }
}

