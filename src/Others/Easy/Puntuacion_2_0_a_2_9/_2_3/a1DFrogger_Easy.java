package Others.Easy.Puntuacion_2_0_a_2_9._2_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Leer el tamaño, posición inicial y número mágico
 * Leer el contenido del tablero
 * Moverse por el tablero controlando:
 *  - si caemos en el número mágico --> magic
 *  - si salimos del tablero --> left / right
 *  - si caemos en una casilla ya visitada --> cycle
 *
 *  Para marcar una casilla como visitada --> INF  (ya que las casillas tienen valores -200..200)
 *
 *  Imprimir el número de saltos
 */
public class a1DFrogger_Easy {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int tamany = sc.nextInt();
        int posicion = sc.nextInt()-1;
        int numMagico = sc.nextInt();
        int VISITADO = Integer.MAX_VALUE;

        //Leer tablero
        int[] tablero = new int[tamany];
        for (int i=0; i<tamany; i++) {
            tablero[i] = sc.nextInt();
        }

        boolean finJuego = tablero[posicion] == numMagico;
        if (finJuego) System.out.println("magic");
        int numMovimientos = 0;
        while (!finJuego) {
            numMovimientos++;
            int nuevaPosicion = posicion + tablero[posicion];

            if (nuevaPosicion < 0) {
                System.out.println("left");
                finJuego = true;
            } else if (nuevaPosicion >= tamany) {
                System.out.println("right");
                finJuego = true;
            } else if (tablero[nuevaPosicion] == numMagico) {
                System.out.println("magic");
                finJuego = true;
            } else if (tablero[nuevaPosicion] == VISITADO) {
                System.out.println("cycle");
                finJuego = true;
            } else {
                tablero[posicion] = VISITADO;
                posicion = nuevaPosicion;
            }
        }
        System.out.println(numMovimientos);
    }
}