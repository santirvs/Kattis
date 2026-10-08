package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Recorrido en anchura del mapa
// Buscar la salida a la que se llega con menos puertas atravesadas

import java.util.PriorityQueue;
import java.util.Scanner;

public class LostOnCampus {

    static class Punto implements Comparable<Punto> {
        int fila;
        int columna;
        int numPuertas;

        Punto(int fila, int columna, int numPuertas) {
            this.fila = fila;
            this.columna = columna;
            this.numPuertas = numPuertas;
        }


        @Override
        public int compareTo(Punto o) {
            return Integer.compare(this.numPuertas, o.numPuertas);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numColumnas = sc.nextInt();
        int numFilas = sc.nextInt();

        char[][] mapa = new char[numFilas][numColumnas];
        boolean[][] visitado = new boolean[numFilas][numColumnas];

        PriorityQueue<Punto> pq = new PriorityQueue<>();

        //Cargar el mapa
        for (int i=0; i<numFilas; i++) {
            String cadena = sc.next();
            mapa[i] = cadena.toCharArray();

            //Buscar el "you are here"
            int pos = cadena.indexOf('*');
            if (pos != -1) {
                Punto p = new Punto(i, pos,0);
                pq.add(p);
            }
        }

        //Buscar las salidas.
        //Priorizar por mínimo número de puertas, de forma que la primera
        //salida que se alcance será la que atraviese menor número de puertas

        int numPuertas = -1;
        boolean salir = false;

        while (!salir && !pq.isEmpty()) {
            Punto p = pq.poll();

            //Marcar como visitado
            visitado[p.fila][p.columna] = true;

            //Es una casilla de salida?
            if (mapa[p.fila][p.columna] == 'E') {
                salir = true;
                numPuertas = p.numPuertas;
            }
            else {
                int[][] direcciones = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

                for (int i = 0; i < 4; i++) {
                    char casilla = mapa[p.fila + direcciones[i][0]][p.columna + direcciones[i][1]];
                    boolean yaVisitado = visitado[p.fila + direcciones[i][0]][p.columna + direcciones[i][1]];
                    if (!yaVisitado && (casilla == '.' || casilla == 'D' || casilla == 'E')) {
                        int puertas = p.numPuertas;
                        if (casilla == 'D') puertas++;
                        pq.add(new Punto(p.fila + direcciones[i][0], p.columna + direcciones[i][1], puertas));
                    }
                }
            }

        }

        if (salir) System.out.println(numPuertas);
        else System.out.println("NOT POSSIBLE");

    }
}

