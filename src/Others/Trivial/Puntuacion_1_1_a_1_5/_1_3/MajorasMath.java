package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Leer un valor decimal y restarle 0.3

import java.util.Scanner;

public class MajorasMath {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        enum Ataque {
            STANDARD,
            FIRE,
            ICE,
            LIGHT
        };

        //Leer los datos
        int vida = sc.nextInt();
        int numAtaques = sc.nextInt();

        int[] danyo = new int[4];
        for (int i=0; i<4; i++) {
            danyo[i] = sc.nextInt();
        }


        for (int i=0; i<numAtaques; i++) {
            String ataque = sc.next();

            if (ataque.equals("standard")) vida-=danyo[Ataque.STANDARD.ordinal()];
            else if (ataque.equals("fire"))  vida-=danyo[Ataque.FIRE.ordinal()];
            else if (ataque.equals("ice"))  vida-=danyo[Ataque.ICE.ordinal()];
            else if (ataque.equals("light"))  vida-=danyo[Ataque.LIGHT.ordinal()];
        }

        if (vida > 0) System.out.println(vida);
        else System.out.println("dead");

    }
}