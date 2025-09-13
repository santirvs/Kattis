package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer las coordenadas de los tres puntos
// EL punto que falta es el que tiene una coordenada x o y que no se repite
// Mostrar las coordenadas del punto que falta

import java.util.Scanner;

public class Cetvrta {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        int x3 = scan.nextInt();
        int y3 = scan.nextInt();
        int x4, y4;

        //Calcular las coordenadas del punto que falta
        if (x1 == x2) {
            x4 = x3;
        } else if (x1 == x3) {
            x4 = x2;
        } else {
            x4 = x1;
        }
        if (y1 == y2) {
            y4 = y3;
        } else if (y1 == y3) {
            y4 = y2;
        } else {
            y4 = y1;
        }

        //Mostrar el resultado
        System.out.println(x4 + " " + y4);



    }
}