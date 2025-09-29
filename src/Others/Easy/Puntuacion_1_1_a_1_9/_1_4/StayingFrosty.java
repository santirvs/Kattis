package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el tamaño del lago
// Leer el número de pócimas
// Calcular si puede cruzar el lago con el número de pócimas
// si cada pócima dura 180seg y se avanza a 2 bloques por segundo

import java.util.Scanner;

public class StayingFrosty {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el tamaño del lago
        int tamano = sc.nextInt();
        // Leer el número de pócimas
        int pocimas = sc.nextInt();

        // Calcular la distancia que puede recorrer
        int distancia = 180 * pocimas * 2;

        if (tamano > distancia) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }


        sc.close();
    }
}

