package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

/**
 * Recorrer toda la matriz,
 * al encontrar una estrella (-), buscar las posiciones adyacentes y encolar
 * Marcar cada posición (-) como ya visitada (v) para no entrar en ciclos infinitos
 * Ir contando las estrellas que vamos encontrando
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CountingStars {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numCaso=0;
        while (sc.hasNext() ) {
            numCaso++;

            int numFilas = sc.nextInt();
            int numColumnas = sc.nextInt();

            //Leer el mapa
            char[][] mapa = new char[numFilas][numColumnas];
            for (int fila = 0; fila < numFilas; fila++) {
                String filaString = sc.next();
                mapa[fila] = filaString.toCharArray();
            }

            //Procesar el mapa
            int numEstrellas = 0;
            for (int fila = 0; fila < numFilas; fila++) {
                for (int col = 0; col < numColumnas; col++) {
                    if (mapa[fila][col] == '-') {
                        //He encontrado una estrella!!!
                        numEstrellas++;
                        Deque<Integer> cola = new ArrayDeque<>();
                        cola.add(fila);
                        cola.add(col);
                        //Marcar como visitada
                        mapa[fila][col] = 'v';

                        while (!cola.isEmpty()) {
                            int f = cola.pollFirst();
                            int c = cola.pollFirst();



                            int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

                            for (int i = 0; i < 4; i++) {
                                int ff = f + delta[i][0];
                                int cc = c + delta[i][1];
                                if (ff >= 0 && ff < numFilas &&
                                        cc >= 0 && cc < numColumnas) {
                                    if (mapa[ff][cc] == '-') {
                                        cola.add(ff);
                                        cola.add(cc);
                                        //Marcar como visitada
                                        mapa[ff][cc] = 'v';
                                    }
                                }
                            }
                        }

                    }
                }
            }

            //Mostrar el resultado
            System.out.println("Case " + numCaso + ": " + numEstrellas);
        }

    }
}
