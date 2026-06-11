package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Guardar las tiradas de cada jugador en un array
 * y comparar posición por posición
 * Mostrar la puntuación de cada jugador
 */

import java.util.Scanner;

public class RockPaperScissors {

    public static int gana(char p1, char p2) {
        int result = 0;

        if (p1 != p2) {
            if (p1=='S' && p2=='P' || p1=='R' && p2=='S' || p1=='P' && p2=='R') {
                result = -1;
            }
            else
                result = 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String jugador1 = sc.next();
        String jugador2 = sc.next();

        while (! (jugador1.equals("E") && jugador2.equals("E")) ) {
            int puntsJugador1 = 0;
            int puntsJugador2 = 0;
            for (int i=0; i<jugador1.length(); i++) {
                int resultado = gana(jugador1.charAt(i), jugador2.charAt(i));
                if (resultado < 0) puntsJugador1++;
                if (resultado > 0) puntsJugador2++;
            }

            System.out.println("P1: " + puntsJugador1);
            System.out.println("P2: " + puntsJugador2);

            //Siguiente partida
            jugador1 = sc.next();
            jugador2 = sc.next();
        }

        sc.close();
    }
}