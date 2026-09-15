package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// La puntuación estimada de un dado es (valor inferior + valor superior) / 2
// Sumar la puntuación estimada de los dos dados de cada jugador y compararlos
import java.util.Arrays;
import java.util.Scanner;


public class DiceGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][][] dados = new int[2][2][2];  // [jugador][dado][limite]

        //Leer los datos
        for (int j=0; j<2; j++) {
            for (int d=0; d<2; d++) {
                for (int l=0; l<2; l++) {
                    dados[j][d][l] = sc.nextInt();
                }
            }
        }

        //Estimar la puntuación de cada jugador
        double puntsJugador1 = (dados[0][0][0] + dados[0][0][1]) / 2.0 +
                (dados[0][1][0] + dados[0][1][1]) / 2.0;

        double puntsJugador2 = (dados[1][0][0] + dados[1][0][1]) / 2.0 +
                (dados[1][1][0] + dados[1][1][1]) / 2.0;

        if (puntsJugador1 > puntsJugador2) System.out.println("Gunnar");
        else if (puntsJugador1 < puntsJugador2) System.out.println("Emma");
        else System.out.println("Tie");



        sc.close();
    }
}

