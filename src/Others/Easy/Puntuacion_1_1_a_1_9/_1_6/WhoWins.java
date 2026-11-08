package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

import java.util.Scanner;

public class WhoWins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int manoDealer = leerMano(sc);
        int manoJugador = leerMano(sc);

        if (manoDealer == manoJugador || (manoDealer > 21 && manoJugador > 21)) {
            System.out.println("Push");
        } else if ((manoDealer<=21 && manoDealer > manoJugador) || manoJugador > 21) {
            System.out.println("Dealer");
        } else {
            System.out.println("Player");
        }


    }

    private static int leerMano(Scanner sc) {
        int numCartas = sc.nextInt();
        int puntos = 0;
        int numAces = 0;

        for (int i = 0; i < numCartas; i++) {
            String carta = sc.next();
            if (carta.equals("A")) {
                numAces++;
                puntos += 1; // El As vale 1 por defecto inicialmente
            } else if (carta.equals("J") || carta.equals("Q") || carta.equals("K")) {
                puntos += 10;
            } else {
                puntos += Integer.parseInt(carta);
            }
        }

        // Por cada As que tengamos, podemos sumarle 10 puntos extra (es decir, pasa de valer 1 a valer 11)
        // siempre y cuando al hacerlo el total no supere 21.
        while (numAces > 0 && puntos + 10 <= 21) {
            puntos += 10;
            numAces--;
        }

        return puntos;
    }
}