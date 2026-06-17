package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Debemos encontrar un "puente" en un grafo.
    Un puente es una arista (conexión) que, si se elimina, divide el grafo en dos o más partes que quedan incomunicadas (el grafo deja de ser conexo).

    Dado que los límites son lo suficientemente pequeños, podemos emplear la fuerza bruta.
    Eliminar una arista
    Para cada arista, comprobar cuantos nodos son accesibles desde el primero.
    Deberian ser todos los nodos, en caso contrario es que el grafo se ha dividido.
 */
import java.util.*;

public class BirthdayParty {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int numPersonas = sc.nextInt();
            int numConexiones = sc.nextInt();

            // Condición de parada del problema (0 0)
            if (numPersonas == 0 && numConexiones == 0) {
                break;
            }

            // Guardamos las conexiones en listas para poder iterar sobre ellas
            int[] de = new int[numConexiones];
            int[] a = new int[numConexiones];

            for (int i = 0; i < numConexiones; i++) {
                de[i] = sc.nextInt();
                a[i] = sc.nextInt();
            }

            boolean enRiesgo = false;

            // Simulamos eliminar la conexión 'i' en cada iteración
            for (int i = 0; i < numConexiones; i++) {
                // Construimos la lista de adyacencia EXCLUYENDO la conexión 'i'
                List<List<Integer>> grafo = new ArrayList<List<Integer>>();
                for (int j = 0; j < numPersonas; j++) {
                    grafo.add(new ArrayList<Integer>());
                }

                for (int j = 0; j < numConexiones; j++) {
                    if (j == i) continue; // Nos saltamos la conexión eliminada
                    grafo.get(de[j]).add(a[j]);
                    grafo.get(a[j]).add(de[j]);
                }

                // Contamos cuántas personas son alcanzables desde el nodo 0 usando BFS
                int alcanzados = contarAlcanzadosBFS(0, numPersonas, grafo);

                // Si no pudimos llegar a todos, significa que el grafo se rompió
                if (alcanzados < numPersonas) {
                    enRiesgo = true;
                    break; // No hace falta seguir probando más conexiones
                }
            }

            if (enRiesgo) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        sc.close();
    }

    /**
     * Realiza un recorrido BFS estándar para contar los nodos alcanzables desde 'inicio'
     */
    private static int contarAlcanzadosBFS(int inicio, int totalNodos, List<List<Integer>> grafo) {
        boolean[] visitados = new boolean[totalNodos];
        Queue<Integer> fila = new LinkedList<Integer>();

        fila.add(inicio);
        visitados[inicio] = true;
        int contador = 1;

        while (!fila.isEmpty()) {
            int actual = fila.poll();

            for (int k = 0; k < grafo.get(actual).size(); k++) {
                int vecino = grafo.get(actual).get(k);
                if (!visitados[vecino]) {
                    visitados[vecino] = true;
                    contador++;
                    fila.add(vecino);
                }
            }
        }

        return contador;
    }
}