package Cap1._1_ParaEmpezar._6_Funcion;

import java.util.Locale;
import java.util.Scanner;

public class Mia {

    public static int puntos(int dado1, int dado2) {
        int d1 = Math.max(dado1, dado2);
        int d2 = Math.min(dado1, dado2);
        int resultado;

        //MAXIMA PUNTUACION
        if (d1 == 2 && d2 == 1) {
            resultado = Integer.MAX_VALUE;
        }
        else if (d1 == d2) {
            //SEGUNDO NIVEL DE PUNTUACION
            resultado = d1 * 1_000;
        }
        else
            //TERCER NIVEL DE PUNTUACION
            resultado = d1*10 + d2;

        return resultado;
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int jug1Dado1 = scan.nextInt();
        int jug1Dado2 = scan.nextInt();
        int jug2Dado1 = scan.nextInt();
        int jug2Dado2 = scan.nextInt();
        while (jug1Dado1 > 0) {

            int puntosJug1 = puntos(jug1Dado1, jug1Dado2);
            int puntosJug2 = puntos(jug2Dado1, jug2Dado2);

            if (puntosJug1 > puntosJug2) {
                System.out.println("Player 1 wins.");
            }
            else if (puntosJug1 < puntosJug2) {
                System.out.println("Player 2 wins.");
            }
            else {
                System.out.println("Tie.");
            }

            jug1Dado1 = scan.nextInt();
            jug1Dado2 = scan.nextInt();
            jug2Dado1 = scan.nextInt();
            jug2Dado2 = scan.nextInt();

        }

    }
}