package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreakingBad {
    public static void main(String[] args) throws IOException {
        // Lector rápido para procesar la entrada de forma eficiente
        FastScanner scanner = new FastScanner();

        String firstToken = scanner.next();
        if (firstToken == null) {
            return;
        }

        int n = Integer.parseInt(firstToken);

        // Mapeo de nombre del producto -> ID entero (0 a N-1)
        HashMap<String, Integer> nameToId = new HashMap<String, Integer>();
        // Arreglo invertido para obtener el nombre original a partir de su ID
        String[] idToName = new String[n];

        for (int i = 0; i < n; i++) {
            String item = scanner.next();
            nameToId.put(item, i);
            idToName[i] = item;
        }

        int m = scanner.nextInt();

        // Construcción de la lista de adyacencia del grafo.
        // Especificamos los tipos genéricos explícitamente para compatibilidad con Java 1.7.
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            String uName = scanner.next();
            String vName = scanner.next();

            int u = nameToId.get(uName);
            int v = nameToId.get(vName);

            // Las restricciones son bidireccionales (grafo no dirigido)
            adj[u].add(v);
            adj[v].add(u);
        }

        // Arreglo para almacenar el color/grupo de cada nodo:
        // 0: Sin visitar / sin asignar
        // 1: Asignado a Walter
        // 2: Asignado a Jesse
        int[] color = new int[n];

        // Procesamos todos los componentes conexos usando BFS
        for (int i = 0; i < n; i++) {
            // Si el nodo aún no ha sido coloreado, iniciamos una búsqueda
            if (color[i] == 0) {
                color[i] = 1; // Le asignamos por defecto el grupo 1 (Walter)

                Queue<Integer> queue = new LinkedList<Integer>();
                queue.add(i);

                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    int currentColor = color[current];
                    int neighborColor = (currentColor == 1) ? 2 : 1; // Color opuesto

                    for (int j = 0; j < adj[current].size(); j++) {
                        int neighbor = adj[current].get(j);

                        if (color[neighbor] == 0) {
                            // Si no ha sido visitado, le asignamos el color opuesto y lo encolamos
                            color[neighbor] = neighborColor;
                            queue.add(neighbor);
                        } else if (color[neighbor] == currentColor) {
                            // Si ya tiene color y coincide con el actual, el grafo NO es bipartito
                            System.out.println("impossible");
                            return;
                        }
                    }
                }
            }
        }

        // Si el algoritmo termina sin conflictos, construimos las listas finales
        StringBuilder walterItems = new StringBuilder();
        StringBuilder jesseItems = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (color[i] == 1) {
                if (walterItems.length() > 0) {
                    walterItems.append(" ");
                }
                walterItems.append(idToName[i]);
            } else {
                if (jesseItems.length() > 0) {
                    jesseItems.append(" ");
                }
                jesseItems.append(idToName[i]);
            }
        }

        // Imprimimos la asignación de cada comprador
        System.out.println(walterItems.toString());
        System.out.println(jesseItems.toString());
    }

    // Clase auxiliar para entrada/salida veloz (Fast I/O)
    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        return null;
                    }
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
