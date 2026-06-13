package Others.Easy.Puntuacion_2_0_a_2_9._2_5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Grid {

    static class Position {
        int r; // fila
        int c; // columna
        int movimientos;

        public Position(int r, int c, int movimientos) {
            this.r = r;
            this.c = c;
            this.movimientos = movimientos;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int filas = sc.nextInt();
        int columnas = sc.nextInt();

        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            String linea = sc.next();
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = linea.charAt(j) - '0';
            }
        }

        // Una sola cola estándar y una sola matriz de visitados global
        Queue<Position> queue = new ArrayDeque<>();
        boolean[][] visitados = new boolean[filas][columnas];

        // Inicializamos el inicio
        queue.add(new Position(0, 0, 0));
        visitados[0][0] = true;

        int numMovs = -1;

        while (!queue.isEmpty()) {
            Position p = queue.poll();

            // Si llegamos al destino (esquina inferior derecha)
            if (p.r == filas - 1 && p.c == columnas - 1) {
                numMovs = p.movimientos;
                break;
            }

            int mov = matriz[p.r][p.c];
            if (mov == 0) continue; // Evita bucles infinitos si la casilla tiene un 0

            // Dirección: Norte
            if (p.r - mov >= 0 && !visitados[p.r - mov][p.c]) {
                visitados[p.r - mov][p.c] = true;
                queue.add(new Position(p.r - mov, p.c, p.movimientos + 1));
            }
            // Dirección: Sur
            if (p.r + mov < filas && !visitados[p.r + mov][p.c]) {
                visitados[p.r + mov][p.c] = true;
                queue.add(new Position(p.r + mov, p.c, p.movimientos + 1));
            }
            // Dirección: Este
            if (p.c + mov < columnas && !visitados[p.r][p.c + mov]) {
                visitados[p.r][p.c + mov] = true;
                queue.add(new Position(p.r, p.c + mov, p.movimientos + 1));
            }
            // Dirección: Oeste
            if (p.c - mov >= 0 && !visitados[p.r][p.c - mov]) {
                visitados[p.r][p.c - mov] = true;
                queue.add(new Position(p.r, p.c - mov, p.movimientos + 1));
            }
        }

        System.out.println(numMovs);
    }
}