package Others.Easy.Puntuacion_2_0_a_2_9._2_5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UncertainTopography {

    private static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) {
            return;
        }
        s = s.trim();
        if (s.isEmpty()) {
            System.out.println();
            return;
        }

        int n = s.length();
        boolean[] present = new boolean[ALPHABET_SIZE];

        // Grafo de adyacencia entre letras distintas que aparecen consecutivas en S.
        // Dos letras consecutivas distintas (u, v) deben diferir en 1 unidad (500').
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        // Matriz de adyacencia para evitar añadir aristas duplicadas entre el mismo par.
        boolean[][] edgeAdded = new boolean[ALPHABET_SIZE][ALPHABET_SIZE];

        for (int i = 0; i < n; i++) {
            present[s.charAt(i) - 'A'] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            int u = s.charAt(i) - 'A';
            int v = s.charAt(i + 1) - 'A';
            if (u != v && !edgeAdded[u][v]) {
                edgeAdded[u][v] = true;
                edgeAdded[v][u] = true;
                adj[u].add(v);
                adj[v].add(u);
            }
        }

        StringBuilder answer = new StringBuilder();

        // Probamos cada letra 'M' presente en la cadena como posible maxima elevacion.
        for (int candidateMax = 0; candidateMax < ALPHABET_SIZE; candidateMax++) {
            if (!present[candidateMax]) {
                continue;
            }

            if (canBeMaximum(candidateMax, present, adj)) {
                answer.append((char) ('A' + candidateMax));
            }
        }

        System.out.println(answer.toString());
    }

    /**
     * Comprueba si es posible asignar elevaciones relativas (en unidades de 500')
     * a las letras presentes en S de forma que:
     * 1. Cada arista (u, v) cumpla |h[u] - h[v]| == 1.
     * 2. Dos letras distintas nunca tengan la misma elevacion (h[u] != h[v]).
     * 3. 'candidateMax' sea mayor o igual que la elevacion de cualquier otra letra presente.
     */
    private static boolean canBeMaximum(int candidateMax, boolean[] present, List<Integer>[] adj) {
        int[] height = new int[ALPHABET_SIZE];
        boolean[] visited = new boolean[ALPHABET_SIZE];

        // Fijamos la elevacion relativa de la letra candidata en 0.
        height[candidateMax] = 0;
        visited[candidateMax] = true;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(candidateMax);

        // Propagamos alturas en la componente conectada de candidateMax.
        // Si 'candidateMax' es el maximo, cualquier vecino conectado debe tener
        // una altura menor o igual (por ejemplo, h[v] = h[u] - 1 cuando es posible).
        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adj[u]) {
                if (!visited[v]) {
                    // Elegimos bajar 1 unidad respecto a 'u' para favorecer que 'candidateMax'
                    // se mantenga como el punto mas alto.
                    height[v] = height[u] - 1;
                    visited[v] = true;
                    queue.add(v);
                } else {
                    // Si 'v' ya fue visitado, verificamos consistencia de diferencia de 1.
                    if (Math.abs(height[u] - height[v]) != 1) {
                        return false;
                    }
                }
            }
        }

        // Si existen letras presentes en S que pertenecen a otras componentes conexas
        // (no alcanzables desde candidateMax), les asignamos alturas que no superen
        // la de candidateMax (0) y no colisionen entre si.
        // Usamos un conjunto de alturas ya ocupadas para mantener letras distintas a distintas alturas.
        List<Integer> usedHeights = new ArrayList<Integer>();
        for (int c = 0; c < ALPHABET_SIZE; c++) {
            if (visited[c]) {
                usedHeights.add(height[c]);
            }
        }

        // Verificamos que entre las letras visitadas no haya dos con la misma altura.
        for (int i = 0; i < usedHeights.size(); i++) {
            for (int j = i + 1; j < usedHeights.size(); j++) {
                if (usedHeights.get(i).equals(usedHeights.get(j))) {
                    return false;
                }
            }
        }

        // Para cualquier letra presente que no fue visitada (otra componente conexa):
        // asignamos una altura <= height[candidateMax] (que es 0) y distinta de las ya usadas.
        int nextFreeHeight = height[candidateMax] - 1;
        for (int c = 0; c < ALPHABET_SIZE; c++) {
            if (present[c] && !visited[c]) {
                while (usedHeights.contains(nextFreeHeight)) {
                    nextFreeHeight--;
                }
                height[c] = nextFreeHeight;
                usedHeights.add(nextFreeHeight);
                visited[c] = true;
            }
        }

        // Comprobamos que ninguna letra presente en S tenga elevacion estrictamente mayor
        // que la de 'candidateMax'.
        int maxAllowed = height[candidateMax];
        for (int c = 0; c < ALPHABET_SIZE; c++) {
            if (present[c] && height[c] > maxAllowed) {
                return false;
            }
        }

        return true;
    }
}