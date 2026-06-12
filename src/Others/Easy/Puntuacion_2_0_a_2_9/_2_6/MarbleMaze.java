package Others.Easy.Puntuacion_2_0_a_2_9._2_6;

/*
  Este problema no tiene mayor dificultad que moverse dentro de una matriz sin
  salirse de los límites.
  Para los balancines, cambiamos el carácter que leemos de -  a L, R y | a T, D
  de forma que cada vez que pasemos por un de ellos, se alterna tras mover a la
  canica
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MarbleMaze {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int ancho = sc.nextInt();
        int alto = sc.nextInt();
        char[][] laberinto = new char[alto][ancho];

        int numCanicas = sc.nextInt();
        int Xini = sc.nextInt();
        int Yini = sc.nextInt();

        //Leer el laberinto
        for (int i = 0; i < alto; i++) {
            laberinto[i] = sc.next().toCharArray();
        }

        //Lanzar las canicas
        for (int i = 0; i < numCanicas; i++) {
            int X = Xini;
            int Y = Yini;

            boolean fin = false;
            while (!fin) {

                switch (laberinto[Y][X]) {
                    case '<':
                        X--;
                        break;
                    case '>':
                        X++;
                        break;
                    case '^':
                        Y--;
                        break;
                    case 'v':
                        Y++;
                        break;
                    case '-':
                    case 'L':
                        laberinto[Y][X] = 'R';
                        X--;
                        break;
                    case 'R':
                        laberinto[Y][X] = 'L';
                        X++;
                        break;
                    case '|':
                    case 'U':
                        laberinto[Y][X] = 'D';
                        Y--;
                        break;
                    case 'D':
                        laberinto[Y][X] = 'U';
                        Y++;
                        break;
                    case '.':
                        fin = true;
                        break;
                }

                //Comprobar si se ha salido del tablero
                if (X < 0 || Y < 0 || X >= ancho || Y >= alto) {
                    fin = true;
                }

            }

            System.out.println(X + " " + Y);
        }

    }
}