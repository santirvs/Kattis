package Others.Easy.Puntuacion_2_0_a_2_9._2_7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Brexit {
    public static void main(String[] args) throws IOException {
        // Uso de BufferedReader para una lectura eficiente de datos de entrada
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        int C = Integer.parseInt(st.nextToken()); // Número total de países
        int P = Integer.parseInt(st.nextToken()); // Número de asociaciones comerciales
        int X = Integer.parseInt(st.nextToken()); // Nuestro país de origen
        int L = Integer.parseInt(st.nextToken()); // Primer país en abandonar la unión

        // Si nuestro país de origen es el primero en irse, se va inmediatamente
        if (X == L) {
            System.out.println("leave");
            return;
        }

        // Representación del grafo mediante listas de adyacencia
        // Usamos una lista de listas compatible con Java 1.7
        List<Integer>[] adj = new ArrayList[C + 1];
        for (int i = 1; i <= C; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        // Grados iniciales y actuales para controlar cuántos socios le quedan a cada país
        int[] initialDeg = new int[C + 1];
        int[] currentDeg = new int[C + 1];

        // Lectura de las P aristas del grafo
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // Conexión bidireccional entre u y v
            adj[u].add(v);
            adj[v].add(u);

            // Incremento en el grado inicial de ambos países
            initialDeg[u]++;
            initialDeg[v]++;
        }

        // Inicializamos el grado actual con el grado inicial
        for (int i = 1; i <= C; i++) {
            currentDeg[i] = initialDeg[i];
        }

        // Arreglo booleano para registrar los países que han abandonado la unión
        boolean[] left = new boolean[C + 1];

        // Cola BFS para simular el efecto dominó de países abandonando la unión
        Queue<Integer> queue = new LinkedList<Integer>();

        // El país L abandona la unión en t = 0
        left[L] = true;
        queue.add(L);

        // Bucle principal de simulación
        while (!queue.isEmpty()) {
            int u = queue.poll();

            // Recorremos todos los socios comerciales del país 'u'
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);

                // Si el país vecino 'v' aún no ha abandonado la unión
                if (!left[v]) {
                    // El país 'v' pierde a su socio 'u'
                    currentDeg[v]--;

                    // Condición: Si conserva la mitad o menos de sus socios iniciales
                    // (Equivalente a: currentDeg[v] <= initialDeg[v] / 2)
                    if (currentDeg[v] <= initialDeg[v] / 2) {
                        left[v] = true;

                        // Si el país que acaba de abandonar es nuestro país X,
                        // finalizamos tempranamente ya que conocemos el resultado.
                        if (v == X) {
                            System.out.println("leave");
                            return;
                        }

                        // Agregamos 'v' a la cola para propagar la salida a sus vecinos
                        queue.add(v);
                    }
                }
            }
        }

        // Si la simulación concluye y el país X no abandonó la unión, permanece
        if (left[X]) {
            System.out.println("leave");
        } else {
            System.out.println("stay");
        }
    }
}