package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Hacer un mapa de conexiones entre películas
    Aplicar un BFS desde los nodos de la lista negra.
    Éstos se inicializan a 0 y propagan su distancia al resto de nodos a los que están conectados
    Finalmente, recorrer la distancia desde los nodos y quedarnos con el de mayor distancia, pero menor ID
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HorrorList {

    static class FR_Int {
        private InputStream in = System.in;
        private byte[] buffer = new byte[1 << 16];
        private int head = 0;
        private int tail = 0;

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }


        public int nextInt() throws IOException {
            int c = read();
            while (c!= -1 && c<=32) { c=read(); }
            if (c==-1) return -1;
            int res = 0;
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res;
        }
    }


    public static void main(String[] args) throws IOException {
        FR_Int fr = new FR_Int();

        int numPeliculas = fr.nextInt();
        int numPeliculasHL = fr.nextInt();
        int numSimilitudes = fr.nextInt();

        //Definir la lista de películas
        int[] peliculas = new int[numPeliculas];
        //Inicializar a infinito
        Arrays.fill(peliculas, Integer.MAX_VALUE);
        Queue<Integer> cola = new LinkedList<>();

        //Leer las películas de la "lista negra", asignarles un HL de 0 y añadirlas a la cola
        for (int i=0; i<numPeliculasHL;i++) {
            int pelicula = fr.nextInt();
            peliculas[pelicula] = 0;
            cola.add(pelicula);
        }

        // Construcción del Grafo (Lista de adyacencia usando ArrayList de Java)
        ArrayList<Integer>[] grafo = new ArrayList[numPeliculas];
        for (int i = 0; i < numPeliculas; i++) {
            grafo[i] = new ArrayList<Integer>();
        }

        // Leer las similitudes (Aristas del grafo no dirigido)
        for (int i = 0; i < numSimilitudes; i++) {
            int u = fr.nextInt();
            int v = fr.nextInt();
            grafo[u].add(v);
            grafo[v].add(u);
        }

        // Ejecución del BFS Multi-Fuente
        while (!cola.isEmpty()) {
            int actual = cola.poll();

            for (int vecino : grafo[actual]) {
                // Si encontramos un camino más corto hacia el vecino, actualizamos su HI (horror index)
                if (peliculas[actual] + 1 < peliculas[vecino]) {
                    peliculas[vecino] = peliculas[actual] + 1;
                    cola.add(vecino); // Se añade a la cola para propagar el HI
                }
            }
        }

        // Selección del resultado óptimo (Mayor Horror Index, menor ID en caso de empate)
        int mejorPeliculaID = 0;
        int maxHorrorIndex = -1;

        for (int i = 0; i < numPeliculas; i++) {
            if (peliculas[i] > maxHorrorIndex) {
                maxHorrorIndex = peliculas[i];
                mejorPeliculaID = i;
            }
        }

        // Imprimir el ID de la película ganadora
        System.out.println(mejorPeliculaID);
    }



}
