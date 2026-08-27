package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Aplicar BFS para determinar si es posible escapar
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DragonsInADungeon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer el mapa
        int numFilas = sc.nextInt();
        int numColumnas = sc.nextInt();

        char[][] mapa = new char[numFilas][numColumnas];
        for (int r = 0; r < numFilas; r++) {
            mapa[r] = sc.next().toCharArray();
        }

        //Buscar donde se encuentra Greg
        int fG = 0;
        int cG = 0;
        for (int r = 0; r < numFilas; r++) {
            for (int c = 0; c < numColumnas; c++) {
                if (mapa[r][c] == 'G') {
                    fG = r;
                    cG = c;
                }
            }
        }

        boolean[][] visitados = new boolean[numFilas][numColumnas];
        LinkedList<Integer> pendientes = new LinkedList<>();
        boolean salidaEncontrada = false;

        pendientes.addLast(cG);
        pendientes.addLast(fG);

        int[][] movimientos = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        //Empezar a buscar
        while (!salidaEncontrada && !pendientes.isEmpty()) {
            int posX = pendientes.pollFirst();
            int posY = pendientes.pollFirst();

            //Marcar la casilla como visitada
            visitados[posY][posX] = true;

            //Explorar las casillas adyacentes
            for (int i = 0; i < movimientos.length; i++) {
                int destinoX = posX + movimientos[i][0];
                int destinoY = posY + movimientos[i][1];

                if (destinoX >= 0 && destinoX < numColumnas && destinoY >= 0 && destinoY < numFilas) {
                    if (visitados[destinoY][destinoX]) {
                        //Ignorar una casilla ya visitada
                    } else if (mapa[destinoY][destinoX] == '.') {
                        //Casilla por explorar
                        pendientes.addLast(destinoX);
                        pendientes.addLast(destinoY);
                    } else if (mapa[destinoY][destinoX] == 'E') {
                        //Se ha encontrado la salida
                        salidaEncontrada = true;
                    }
                }
            }
        }

        //Mostrar el resultado
        if (salidaEncontrada) System.out.println("YES");
        else System.out.println("NO");

    }
}