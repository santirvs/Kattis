package Others.Easy.Puntuacion_2_0_a_2_9._2_4;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class CantinaOfBabel {

    // Listas de adyacencia para representar el grafo dirigido de personajes
    private static ArrayList<Integer>[] adj;

    // Variables auxiliares para el algoritmo de Tarjan (búsqueda de SCCs)
    private static int[] disc;      // Tiempo de descubrimiento de cada nodo
    private static int[] low;       // Menor tiempo de descubrimiento alcanzable
    private static boolean[] inStack; // Indica si un nodo está actualmente en la pila de recursión
    private static int[] stack;     // Pila manual para simular la recursión de Tarjan
    private static int stackTop;
    private static int timer;
    private static int maxSccSize;  // Tamaño de la Componente Fuertemente Conexa más grande

    // Algoritmo de Tarjan implementado mediante DFS para encontrar SCCs
    private static void tarjanDFS(int u) {
        disc[u] = low[u] = ++timer;
        stack[stackTop++] = u;
        inStack[u] = true;

        // Recorremos los vecinos (personajes a los que u puede enviar mensajes)
        ArrayList<Integer> neighbors = adj[u];
        for (int i = 0; i < neighbors.size(); i++) {
            int v = neighbors.get(i);
            if (disc[v] == -1) {
                // Si el vecino no ha sido visitado, visitamos recursivamente
                tarjanDFS(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) {
                // Si el vecino está en la pila actual, forma parte de la misma SCC
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // Si u es la raíz de una SCC
        if (low[u] == disc[u]) {
            int sccSize = 0;
            int v;
            do {
                v = stack[--stackTop];
                inStack[v] = false;
                sccSize++;
            } while (v != u);

            // Actualizamos el tamaño máximo de SCC encontrado
            if (sccSize > maxSccSize) {
                maxSccSize = sccSize;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());

        String[] characterNames = new String[n];
        String[] spokenLanguages = new String[n];

        // Mapeamos cada idioma entendido por un personaje usando HashSets para búsqueda en O(1)
        HashSet<String>[] understoodLanguages = new HashSet[n];
        HashMap<String, Integer> nameToId = new HashMap<String, Integer>();

        // 1. Lectura de datos y almacenamiento
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            characterNames[i] = st.nextToken();
            nameToId.put(characterNames[i], i);

            spokenLanguages[i] = st.nextToken();

            understoodLanguages[i] = new HashSet<String>();
            // Todos los personajes entienden por defecto el idioma que hablan
            understoodLanguages[i].add(spokenLanguages[i]);

            // Leer los idiomas adicionales que entiende
            while (st.hasMoreTokens()) {
                understoodLanguages[i].add(st.nextToken());
            }
        }

        // 2. Construcción del grafo dirigido
        // Existe una arista dirigida de i -> j si el personaje i habla un idioma que j entiende.
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                // Si el personaje j entiende el idioma que habla el personaje i, hay comunicación directa i -> j
                if (understoodLanguages[j].contains(spokenLanguages[i])) {
                    adj[i].add(j);
                }
            }
        }

        // 3. Inicialización para el algoritmo de Tarjan
        disc = new int[n];
        low = new int[n];
        inStack = new boolean[n];
        stack = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        stackTop = 0;
        timer = 0;
        maxSccSize = 0;

        // 4. Ejecutar Tarjan para hallar todas las Componentes Fuertemente Conexas (SCC)
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                tarjanDFS(i);
            }
        }

        // 5. Cálculo del resultado
        // Queremos maximizar los personajes que se quedan (que pertenecen a la SCC más grande).
        // Por lo tanto, el número de personajes que deben irse es N - tamaño de la SCC máxima.
        int minCharactersToLeave = n - maxSccSize;
        System.out.println(minCharactersToLeave);
    }
}