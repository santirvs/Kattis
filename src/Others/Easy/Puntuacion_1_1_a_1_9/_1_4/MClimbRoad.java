package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la longitud de la carretera en millas
// Leer la distancia entre pistolas en pies
// 1 milla = 5280 pies
// Calcular el número de pistolas que caben
// longitud * 5280 / distancia

import java.util.Scanner;

public class MClimbRoad {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer la longitud de la carretera
        int longitud =  sc.nextInt();
        //Leer la distancia entre pistolas
        int distancia =  sc.nextInt();

        //Calcular cuantas pistolas se pueden colocar en la carretera
        System.out.println(longitud*5280/distancia);



        sc.close();
    }
}

