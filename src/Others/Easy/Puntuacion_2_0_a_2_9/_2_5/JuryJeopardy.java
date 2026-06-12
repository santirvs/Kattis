package Others.Easy.Puntuacion_2_0_a_2_9._2_5;


/*
  El laberinto será de un tamanyo 3..100 x 3..100
  No sabemos la altura exacta, solo sabemos que se entra/sale por un único punto
  y que este se encuentra en la columna 0

  Por lo tanto, crearemos una matriz de tamaño 201 x 100 y entraremos por el punto 0,100
  para asegurarnos que no nos salimos del tablero.

  Nos iremos guardando las Xmax, Xmin, Ymax, Ymin de las posiciones exploradas para determinar
  el tamaño del tablero. Después habrá que rodear el tablero con # así como cualquier casilla
  no alcanzada.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class JuryJeopardy {
    public enum Direction {
        EAST,
        NORTH,
        WEST,
        SOUTH
    }

    static char[][] laberinto = new char[201][100];
    static int x = 0;
    static int y = 100;
    static Direction orientacion = Direction.EAST;


    private static void girar_derecha() {
        switch (orientacion) {
            case EAST:
                orientacion = Direction.SOUTH;
                y++;
                break;
            case SOUTH:
                orientacion = Direction.WEST;
                x--;
                break;
            case WEST:
                orientacion = Direction.NORTH;
                y--;
                break;
            case NORTH:
                orientacion = Direction.EAST;
                x++;
                break;
        }
    }

    private static void girar_izquierda() {
        switch (orientacion) {
            case EAST:
                orientacion = Direction.NORTH;
                y--;
                break;
            case SOUTH:
                orientacion = Direction.EAST;
                x++;
                break;
            case WEST:
                orientacion = Direction.SOUTH;
                y++;
                break;
            case NORTH:
                orientacion = Direction.WEST;
                x--;
                break;
        }
    }

    private static void girar_180() {
        switch (orientacion) {
            case EAST:
                orientacion = Direction.WEST;
                x--;
                break;
            case SOUTH:
                orientacion = Direction.NORTH;
                y--;
                break;
            case WEST:
                orientacion = Direction.EAST;
                x++;
                break;
            case NORTH:
                orientacion = Direction.SOUTH;
                y++;
                break;
        }
    }

    private static void marcar_muro_derecha() {
        switch (orientacion) {
            case EAST:
                laberinto[y+1][x] = '#';
                break;
            case SOUTH:
                laberinto[y][x-1] = '#';
                break;
            case WEST:
                laberinto[y-1][x] = '#';
                break;
            case NORTH:
                laberinto[y][x+1] = '#';
                break;
        }
    }

    private static void marcar_muro_izquierda() {
        switch (orientacion) {
            case EAST:
                laberinto[y-1][x] = '#';
                break;
            case SOUTH:
                laberinto[y][x+1] = '#';
                break;
            case WEST:
                laberinto[y+1][x] = '#';
                break;
            case NORTH:
                laberinto[y][x-1] = '#';
                break;
        }
    }

    private static void marcar_muro_delante() {
        switch (orientacion) {
            case EAST:
                laberinto[y][x+1] = '#';
                break;
            case SOUTH:
                laberinto[y+1][x] = '#';
                break;
            case WEST:
                laberinto[y][x-1] = '#';
                break;
            case NORTH:
                laberinto[y-1][x] = '#';
                break;
        }
    }

    private static void avanzar() {
        switch (orientacion) {
            case EAST:
                x++;
                break;
            case SOUTH:
                y++;
                break;
            case WEST:
                x--;
                break;
            case NORTH:
                y--;
                break;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder(); // Para acumular toda la salida de golpe

        String line = br.readLine();
        if (line == null) return;

        int numCasos = Integer.parseInt(line.trim());
        System.out.println(numCasos);

        while (numCasos-- > 0) {
            String movimientos = br.readLine();
            if (movimientos == null) break;
            movimientos = movimientos.trim();

            //Inicializar
            x = 0;
            y = 100;
            orientacion = Direction.EAST;
            laberinto = new char[201][100];

            int maxX = 0;  //minX siempre será 0
            int maxY = 100;
            int minY = 100;
            int pos = 0;

            do {
                laberinto[y][x]='.';

                char mov = movimientos.charAt(pos++);

                if (mov=='R') {
                    //Gira a la derecha y avanza
                    girar_derecha();
                }
                else if (mov=='F') {
                    //Si se mueve hacia adelante es que a la derecha había un muro
                    //marcar_muro_derecha();
                    avanzar();
                }
                else if (mov=='L') {
                    //Si se mueve hacia la izquierda es que a la derecha y delante tiene un muro
                    //marcar_muro_derecha();
                    //marcar_muro_delante();
                    girar_izquierda();
                } else if (mov=='B') {
                    //marcar_muro_derecha();
                    //marcar_muro_delante();
                    //marcar_muro_izquierda();
                    girar_180();
                }

                //actualiza máximos y minimos
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);

            } while (pos<movimientos.length());   //Mientras no se vuelva a la casilla inicial


            //Imprimir el tamaño del laberinto
            int altura = maxY-minY+3;
            int anchura = maxX+2;

            System.out.println(altura + " " + anchura);

            for (int i=minY-1;  i<=maxY+1; i++) {
                for (int j=0; j<=maxX+1; j++) {
                    if (laberinto[i][j]==0) System.out.print("#");
                    else System.out.print(laberinto[i][j]);
                }
                System.out.println();
            }

        }
    }



}
