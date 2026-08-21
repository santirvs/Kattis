package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Calcular la diferencia de elevación entre el inicio y el final
 * Cada sección del tramo tiene un ángulo de inclinación y una distancia
 * Para conocer la diferencia de altura de cada tramo hay que aplicar la fórmula del CO
 * CO = Hipotenusa * sin(a)
 *
 */


import java.util.Scanner;


public class HappyTrails {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer el número de tramos
        int tramos = sc.nextInt();
        double desnivel = 0;

        //Procesar cada tramo
        while (tramos-- >0) {
            int angulo = sc.nextInt();
            int distancia = sc.nextInt();

            double altura = distancia * Math.sin(Math.toRadians(angulo));

            desnivel += altura;
        }

        //Imprimir el desnivel acumulado
        System.out.printf("%.2f", desnivel);

    }
}

