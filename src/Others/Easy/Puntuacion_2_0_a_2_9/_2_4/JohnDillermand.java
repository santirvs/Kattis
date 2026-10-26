package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

/*
    Leer la imagen
    Empezar con la posición 0,0
    Eliminar las posiciones adyacentes mientras coincidan alternativamente
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class JohnDillermand {

    static char[][] mapa;

    static class Posicion {
        int x;
        int y;
        char c;

        Posicion (int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numFilas = sc.nextInt();
        int numColumnas = sc.nextInt();
        sc.nextLine();

        mapa = new char[numFilas][numColumnas];

        for (int fila=0; fila < numFilas; fila++) {
            mapa[fila] = sc.nextLine().toCharArray();
        }

        int[][] adyacentes = { {-1,0},{1,0},{0,1},{0,-1} };

        ArrayDeque<Posicion> cola = new ArrayDeque<>();

        cola.addLast(new Posicion(0, 0 , mapa[0][0]));
        while (!cola.isEmpty()) {
            Posicion p = cola.pop();

            if (p.c == mapa[p.x][p.y]) {
                //Coincide el caracter, seguir cambiando los adyacentes
                mapa[p.x][p.y] = '.';
                for (int i=0; i< adyacentes.length; i++) {
                    int newX = p.x+adyacentes[i][0];
                    int newY = p.y+adyacentes[i][1];
                    if (newX >=0 && newX <numColumnas  && newY>=0 && newY < numFilas) {
                        if (p.c == 'O') {
                            cola.addLast( new Posicion (newX, newY, '#'));
                        } else {
                            cola.addLast( new Posicion (newX, newY, 'O'));
                        }
                    }
                }
            }
        }


        //Imprimir la salida
        for (int i=0; i<numFilas; i++) {
            System.out.println(mapa[i]);
        }

        sc.close();
    }
}