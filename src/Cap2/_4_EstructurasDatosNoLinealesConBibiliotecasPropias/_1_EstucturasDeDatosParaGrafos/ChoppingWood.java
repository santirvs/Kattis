package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._1_EstucturasDeDatosParaGrafos;

import Utils.Kattio;
import java.util.PriorityQueue;


// Seguir las instrucciones de la secuencia de Prüfer
// https://es.wikipedia.org/wiki/Secuencia_de_Pr%C3%BCfer
// Usar Kattio de entrada y salida estándar

// Caso #3: TLE -> Agilizar la búsqueda del nodo con grado 1 más pequeño con priorityQueue -> AC



public class ChoppingWood {
    public static class Nodo implements Comparable<Nodo> {
        int id;
        int grado;

        public Nodo(int id, int grado) {
            this.id = id;
            this.grado = grado;
        }

        @Override
        public int compareTo(Nodo o) {
            int result =  this.grado - o.grado;
            if (result == 0) {
                result = this.id - o.id;
            }

            return result;

        }
    }

    public static void main(String[] args) {
        Kattio scan = new Kattio(System.in, System.out);

        int n = scan.getInt();
        PriorityQueue<Nodo> pq_grados = new PriorityQueue<>();
        Nodo[] grados = new Nodo[n + 2];  //Descartar la posición 0 y leer hasta n+1
        //Inicializar los grados de todos los nodos a 1
        for (int i = 1; i <= n+1; i++) {
            grados[i] = new Nodo(i,1);
        }

        //Array para almacenar la secuencia leída
        int[] secuencia = new int[n+1];  //Descartar la posición 0 y leer hasta n

        //Leer la secuencia de Prüfer
        for (int i = 1; i <= n ; i++) {
            int v = scan.getInt();
            grados[v].grado++;
            secuencia[i] = v;
        }

        //Construir una cola con prioridad para los nodos de grado 1
        for (int i = 1; i <= n+1; i++) {
            if (grados[i].grado == 1)
                pq_grados.add(grados[i]);
        }

        //Reconstruir el árbol
        //Para cada nodo de la secuencia
        //Buscar el nodo con grado 1 más pequeño y asignarle el nodo de la secuencia
        //Decrementar el grado de ambos nodos
        int[] hojas = new int[n + 2];
        for (int i=1; i <= n; i++) {
            Nodo menorNodoGrado1 = pq_grados.poll();
            int v = secuencia[i];
            grados[v].grado--;
            hojas[i] = menorNodoGrado1.id;
            menorNodoGrado1.grado--;
            //El menorNodoGrado1 ahora tiene grado 0, ya no se añade a la cola
            //Pero si el nodo v tiene grado 1, éste sí se añade a la cola
            if (grados[v].grado == 1) {
                pq_grados.add(grados[v]);
            }
        }

        //Si todos los grados son 0, excepto el último que es un 1, entonces es un árbol
        grados[n+1].grado--;
        boolean esArbol = true;
        for (int i = 1; i <= n+1; i++) {
            if (grados[i].grado != 0) {
                esArbol = false;
                break;
            }
        }

        if (esArbol) {
            for (int i = 1; i <= n; i++) {
                scan.println(hojas[i]);
            }
        } else {
            scan.println("Error");
        }

        //Vaciar buffer
        scan.flush();
        scan.close();

    }

}