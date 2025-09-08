package Others.Easy.Puntuacion_1_1_a_1_9;

// Leer tres números y multiplicar a*b*c
// El número máximo puede ser 500*500*500 = 125.000.000 que cabe en un int

import java.util.Scanner;

public class JackOLanternJuxtaposition {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        System.out.println(a*b*c);

    }
}