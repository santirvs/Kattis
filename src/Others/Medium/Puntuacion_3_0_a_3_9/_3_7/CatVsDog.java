package Others.Medium.Puntuacion_3_0_a_3_9._3_7;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problema: Cat vs. Dog (Grafo Bipartito - Máximo Conjunto Independiente)
 *
 * PLANTEAMIENTO GENERAL:
 * ----------------------
 * 1. Modelado del Grafo:
 *    - Cada espectador es un nodo en un grafo.
 *    - Existen dos tipos de espectadores:
 *        a) Amantes de los gatos (quieren mantener un gato 'C...' y expulsar un perro 'D...').
 *        b) Amantes de los perros (quieren mantener un perro 'D...' y expulsar un gato 'C...').
 *    - Dos espectadores están en conflicto (incompatibles) si:
 *        - El espectador A quiere mantener el animal que el espectador B quiere expulsar, O
 *        - El espectador A quiere expulsar el animal que el espectador B quiere mantener.
 *    - Los conflictos SOLO ocurren entre un amante de gatos y un amante de perros. Nunca habrá
 *      conflicto interno dentro del mismo grupo ya que ambos grupos tienen posturas opuestas respecto
 *      a la especie a mantener/expulsar.
 *
 * 2. Reducción a Máximo Conjunto Independiente (MIS):
 *    - Queremos seleccionar el mayor número posible de espectadores de forma que no haya
 *      ningún conflicto entre los seleccionados.
 *    - En teoría de grafos, un subconjunto de vértices sin aristas entre ellos se denomina
 *      "Conjunto Independiente" (Independent Set).
 *    - Por el Teorema de König para grafos bipartitos:
 *          |Máximo Conjunto Independiente| = |Vértex Total| - |Emparejamiento Máximo|
 *      donde |Vértex Total| es el número total de espectadores (v) y |Emparejamiento Máximo|
 *      es el tamaño del Maximum Bipartite Matching entre amantes de gatos y amantes de perros.
 *
 * 3. Algoritmo de Emparejamiento (Augmenting Paths por DFS):
 *    - Usamos un algoritmo clásico de búsqueda de caminos de aumento mediante DFS.
 *    - Complejidad temporal por caso de prueba: O(V * E), totalmente óptimo para V <= 500.
 *
 * Compatibilidad: Java 1.7 (sin lambdas, sin streams, I/O rápida mediante lecturas de bytes).
 */
public class CatVsDog {

    // Estrategia/Estructura para representar a cada espectador (voto)
    static class Voter {
        int id;
        String keep;
        String throwOut;

        public Voter(int id, String keep, String throwOut) {
            this.id = id;
            this.keep = keep;
            this.throwOut = throwOut;
        }

        /**
         * Determina si este espectador entra en conflicto directo con otro.
         */
        public boolean conflictsWith(Voter other) {
            return this.keep.equals(other.throwOut) || this.throwOut.equals(other.keep);
        }
    }

    // Lista de adyacencia para el grafo bipartito:
    // Mapea el índice de un amante de gatos (0 a catVoters.size()-1)
    // a la lista de índices de amantes de perros con los que colisiona.
    static List<Integer>[] adj;
    static int[] match;
    static boolean[] visited;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);

        Integer testCasesObj = scanner.nextInt();
        if (testCasesObj == null) {
            return;
        }
        int testCases = testCasesObj.intValue();

        for (int t = 0; t < testCases; t++) {
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int v = scanner.nextInt();

            List<Voter> catLovers = new ArrayList<Voter>();
            List<Voter> dogLovers = new ArrayList<Voter>();

            // Lectura y clasificación de votantes en dos conjuntos disjuntos
            for (int i = 0; i < v; i++) {
                String keep = scanner.next();
                String throwOut = scanner.next();
                Voter voter = new Voter(i, keep, throwOut);

                if (keep.startsWith("C")) {
                    catLovers.add(voter);
                } else {
                    dogLovers.add(voter);
                }
            }

            int nCat = catLovers.size();
            int nDog = dogLovers.size();

            // Inicialización del grafo de conflictos
            adj = new List[nCat];
            for (int i = 0; i < nCat; i++) {
                adj[i] = new ArrayList<Integer>();
            }

            // Construcción de aristas de conflicto entre amantes de gatos y amantes de perros
            for (int i = 0; i < nCat; i++) {
                Voter catVoter = catLovers.get(i);
                for (int j = 0; j < nDog; j++) {
                    Voter dogVoter = dogLovers.get(j);
                    if (catVoter.conflictsWith(dogVoter)) {
                        adj[i].add(j); // Arista desde amante de gato 'i' hacia amante de perro 'j'
                    }
                }
            }

            // Algoritmo de Emparejamiento Máximo Bipartito (Matching)
            match = new int[nDog];
            Arrays.fill(match, -1);
            int maxMatching = 0;

            for (int i = 0; i < nCat; i++) {
                visited = new boolean[nDog];
                if (dfs(i)) {
                    maxMatching++;
                }
            }

            // Teorema de König: MIS = V - Maximum Matching
            int maxSatisfied = v - maxMatching;
            System.out.println(maxSatisfied);
        }
    }

    /**
     * Búsqueda en profundidad (DFS) para encontrar un camino de aumento (Augmenting Path).
     *
     * @param u Índice del amante de gato actual en la partición izquierda
     * @return true si se logró emparejar a 'u', false en caso contrario
     */
    private static boolean dfs(int u) {
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i); // Amante de perro vecino

            if (!visited[v]) {
                visited[v] = true;

                // Si 'v' no está emparejado o su pareja actual puede reubicarse
                if (match[v] < 0 || dfs(match[v])) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Lector rápido de entrada (Fast I/O) compatible con Java 1.7.
     * Optimiza el tiempo de entrada/salida leyendo directamente bytes desde la consola.
     */
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[32768];
        private int head = 0;
        private int tail = 0;

        public FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() {
            if (head >= tail) {
                head = 0;
                try {
                    tail = in.read(buffer, 0, buffer.length);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (tail <= 0) {
                    return -1;
                }
            }
            return buffer[head++];
        }

        public Integer nextInt() {
            int c = read();
            while (c <= 32 && c != -1) {
                c = read();
            }
            if (c == -1) {
                return null;
            }
            int res = 0;
            while (c > 32) {
                if (c < '0' || c > '9') {
                    throw new RuntimeException("Número entero no válido");
                }
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }

        public String next() {
            int c = read();
            while (c <= 32 && c != -1) {
                c = read();
            }
            if (c == -1) {
                return null;
            }
            StringBuilder builder = new StringBuilder();
            while (c > 32) {
                builder.append((char) c);
                c = read();
            }
            return builder.toString();
        }
    }
}