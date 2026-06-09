package Others.Easy.Puntuacion_1_1_a_1_9._1_5;


/*
    Hacer un BFS del mapa apoyándose en una cola con prioridad
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class TouchGrass {

    private static class Posicion implements Comparable<Posicion> {
        int x;
        int y;
        int distancia;

        Posicion(int x, int y, int distancia) {
            this.x = x;
            this.y = y;
            this.distancia = distancia;
        }

        @Override
        public int compareTo(Posicion o) {
            return  this.distancia - o.distancia;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h= sc.nextInt();
        int w= sc.nextInt();
        sc.nextLine();

        char[][] mapa = new char[h][w];
        PriorityQueue<Posicion> pq = new PriorityQueue<>();
        boolean[][] visitado = new boolean[h][w];

        //Leer el mapa
        for (int i=0; i<h;i++) {
            String s = sc.nextLine();
            mapa[i] = s.toCharArray();

            if (s.contains("S")) {
                pq.add(new Posicion(s.indexOf("S"),i,0));
                visitado[i][s.indexOf("S")] = true;
            }
        }

        //Procesar el mapa
        boolean found = false;
        int distancia = 0;
        while (!pq.isEmpty()) {
            Posicion p = pq.poll();

            //Hemos llegado?
            if (mapa[p.y][p.x] == 'G') {
                found = true;
                distancia = p.distancia;
                break;
            }

            //Mirar si puedo ir en las 4 direcciones
            //Arriba?
            if (p.y > 0 && mapa[p.y-1][p.x]!='#' && !visitado[p.y-1][p.x]) {
                visitado[p.y-1][p.x] = true;
                pq.add(new Posicion(p.x, p.y-1, p.distancia+1));
            }
            //Abajo?
            if (p.y < mapa.length-1 && mapa[p.y+1][p.x]!='#' && !visitado[p.y+1][p.x]) {
                visitado[p.y+1][p.x] = true;
                pq.add(new Posicion(p.x, p.y+1, p.distancia+1));
            }
            //Izquierda?
            if (p.x > 0 && mapa[p.y][p.x-1]!='#' && !visitado[p.y][p.x-1]) {
                visitado[p.y][p.x-1] = true;
                pq.add(new Posicion(p.x-1, p.y, p.distancia+1));
            }
            //Derecha?
            if (p.x < mapa[0].length-1 && mapa[p.y][p.x+1]!='#' && !visitado[p.y][p.x+1]) {
                visitado[p.y][p.x+1] = true;
                pq.add(new Posicion(p.x+1, p.y, p.distancia+1));
            }

        }

        if (found) {
            System.out.println(distancia);
        } else {
            System.out.println("thralatlega nettengdur");
        }

    }
}
