package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// El valor del juego Hackenbush es la operación XOR de la altura de cada una de las ramas.

import java.util.Scanner;

public class HackenbushBamboo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numRamas = sc.nextInt();

        int solucion = 0;

        for (int i=0; i<numRamas; i++) {
            solucion = solucion ^ sc.nextInt();   // ^ es XOR
        }

        System.out.println("*" + solucion);


    }
}
