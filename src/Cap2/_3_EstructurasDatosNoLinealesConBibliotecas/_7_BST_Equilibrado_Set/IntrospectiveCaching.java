package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.IOException;
import java.util.*;

// Adaptado de: https://github.com/RussellDash332/kattis/blob/main/src/Introspective%20Caching/Caching.java

class Pair implements Comparable<Pair>{
    int first;
    int second;

    Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.first == o.first) {
            return this.second - o.second;
        }
        return o.first - this.first;
    }

}

public class IntrospectiveCaching {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int capacidadCache = scan.nextInt();
        int numObjetos = scan.nextInt();
        int numAccesos = scan.nextInt();

        //Cola de prioridad para saber qué objeto sacar de la caché
        //El que más tarde en ser accedido
        PriorityQueue<Pair> colaPrioridad = new PriorityQueue<>();

        //Array para saber cada uno de los objetos está activo o no
        boolean[] active = new boolean[numObjetos];

        //Inicializar la lista de colas para cada uno de los objetos del sistema
        List<Queue<Pair>> listaColas = new ArrayList<>();
        for (int i = 0; i < numObjetos; i++) {
            listaColas.add(new LinkedList<>());
        }

        //Leer cada uno de los accesos y añadirlos al sistema
        int[] accesos = new int[numAccesos];
        for (int i = 0; i < numAccesos; i++) {
            //Leer el elemento al que se accede
            int objeto = scan.nextInt();
            accesos[i] = objeto;
            //Añadir el acceso a la cola de cada elemento
            //Se añade un par con el número de acceso y el número de objeto
            listaColas.get(objeto).add(new Pair(i, objeto));
        }

        //Resolver el problema
        int respuesta = 0;
        int numUsados = 0;
        //Recorrer cada uno de los accesos que hemos cargado previamente en el array accesos
        for (int i = 0; i < numAccesos; i++) {
            //Si el objeto no está activo, se activa (activo == en la caché)
            int objetoActual = accesos[i];
            if (!active[objetoActual]) {
                active[objetoActual] = true;
                //Se carga el objeto en la caché
                respuesta++;
                if (numUsados < capacidadCache) {
                    numUsados++;
                } else {
                    //Sacar un objeto de la caché, según indique la cola de prioridad
                    Pair evict = colaPrioridad.poll();
                    //Marco el objeto como inactivo (sacado de la caché)
                    active[evict.second] = false;
                }
            }
            //Eliminar el acceso de la cola de accesos del objeto actual
            listaColas.get(objetoActual).poll();
            //Mira cuál es el siguiente acceso a ese objeto y, si existe, lo añade a la cola de prioridad
            Pair next = listaColas.get(objetoActual).peek();
            if (next == null)
               next = new Pair(numAccesos, objetoActual);  //Si no hay más accesos, se añade uno con un número muy grande  (prioriddad mínima
            colaPrioridad.add(next);
        }

        System.out.println(respuesta);
    }
}