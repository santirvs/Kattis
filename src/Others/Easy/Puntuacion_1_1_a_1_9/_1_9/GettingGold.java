package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Recorrido en anchura
 * 4 posiciones de movimiento
 * si alrededor de una celda hay una trampa, no explorar más esa rama
 */


import java.io.IOException;
import java.util.*;

public class GettingGold {

    public static int[][] direcciones = { {-1,0}, {1,0}, {0,-1}, {0,1} };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int ancho = sc.nextInt();
        int alto = sc.nextInt();
        sc.nextLine();

        char[][] mapa = new char[alto][ancho];
        int posX = -1;
        int posY = -1;

        //Leer el mapa
        for (int i=0; i<alto; i++) {
            String linea = sc.nextLine();
            mapa[i] = linea.toCharArray();
            if (linea.contains("P")) {
                posX = linea.indexOf('P');
                posY = i;
            }
        }

        //Lista de casillas por visitar
        Deque<Integer> lista = new LinkedList<>();
        lista.addLast(posX);
        lista.addLast(posY);
        int cantidadOro = 0;

        while (!lista.isEmpty()) {
            int columna = lista.removeFirst();
            int fila = lista.removeFirst();
            char casilla = mapa[fila][columna];

            //La casilla es de oro?
            if (casilla == 'G') {
                cantidadOro++;
            }

            //La casilla es un muro o ya se ha visitado?
            if (casilla == '#' || casilla == 'V') {
                continue;
            }

            //marcar la casilla como visitada
            mapa[fila][columna] = 'V';

            //Si no se ha activado el sensor de trampas
            if (!sensorTrampas(fila, columna, mapa)) {
                //Añadir las 4 casillas adyacentes para visitar
                for (int i=0; i< direcciones.length; i++) {
                    lista.addLast(columna + direcciones[i][0]);
                    lista.addLast(fila + direcciones[i][1]);
                }
            }
        }

        System.out.println(cantidadOro);

    }

    private static boolean sensorTrampas(int fila, int columna, char[][] mapa) {
        boolean hayTrampa = false;

        for (int i=0; i< direcciones.length; i++) {
            if (mapa[fila+direcciones[i][0]][columna+direcciones[i][1]] == 'T') {
                hayTrampa = true;
            }
        }

        return hayTrampa;
    }
}