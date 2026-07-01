package Others.Easy.Puntuacion_1_1_a_1_9._1_5;


/*
    puntos en circulo / puntos total   equivalente a    area circulo / area cuadrado

    area circulo = PI * r^2
    area cuadrado = Lado * Lado =  2r * 2r = 4r^2

    area estimada circulo =  area cuadrado * relacion puntos
 */

import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Scanner;

public class EstimatingTheAreaOfACircle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        double radio = sc.nextDouble();
        double puntos = sc.nextInt();
        double dentro = sc.nextInt();

        while (radio!=0 || puntos!=0 || dentro!=0) {

            double areaCuadrado = 4 * radio * radio;
            double areaCirculo = Math.PI * radio * radio;
            double relacionPuntos = dentro / puntos;

            double areaEstimadaCirculo = areaCuadrado * relacionPuntos;

            //Imprimir resultado
            System.out.printf("%.6f %.6f\n", areaCirculo, areaEstimadaCirculo);


            //Siguiente caso
            radio = sc.nextDouble();
            puntos = sc.nextInt();
            dentro = sc.nextInt();
        }

    }
}
