package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Crear un array de 10 inicializado a 10
 * Restar una unidad a la celda del array segun el numero%10
 * Si la celda llega a 0, resta uno a la cantidad de jugadores
 * Si la cantidad de jugadores llega a 0, mostrar el número de jugador
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TenPlayerBingo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] jugador = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int numJugadores = 10;

        while (numJugadores > 0) {
            int numero = sc.nextInt();
            int numJugador = numero %10;

            //El jugador tacha el número de su carton
            jugador[numJugador]--;

            //Ha cantado bingo el jugador
            if (jugador[numJugador] == 0) {
                numJugadores--;
                //Ha sido el último jugador?
                if (numJugadores == 0) {
                    int ultimoJugador = numJugador;
                    //Ajustar el jugador 0 a jugador 10
                    if (ultimoJugador == 0) ultimoJugador = 10;
                    System.out.println(ultimoJugador);

                }
            }
        }

    }
}