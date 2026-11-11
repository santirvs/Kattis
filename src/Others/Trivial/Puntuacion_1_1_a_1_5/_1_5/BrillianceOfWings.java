package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BrillianceOfWings {
    public static void main(String[] args) throws IOException {
        // BufferedReader y StringTokenizer para lectura rápida de datos (esencial en programación competitiva)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // Leer la primera línea para obtener N (número de vértices)
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());

        // HashSet para almacenar de forma eficiente las aristas del primer árbol (T1).
        // Dado que las aristas no son dirigidas, normalizamos cada arista guardándola como "menor mayor"
        // para evitar duplicados por orden de vértices (por ejemplo, ver a (1, 2) igual que (2, 1)).
        HashSet<String> t1Edges = new HashSet<String>();

        // Leer las N-1 aristas correspondientes al primer árbol
        for (int i = 0; i < n - 1; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // Normalización de la arista (vértice menor primero)
            int min = Math.min(u, v);
            int max = Math.max(u, v);
            t1Edges.add(min + " " + max);
        }

        // Contador para llevar la cuenta de cuántas aristas coinciden en ambos árboles (E1 ∩ E2)
        int commonEdges = 0;

        // Leer las N-1 aristas correspondientes al segundo árbol (T2)
        for (int i = 0; i < n - 1; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // Normalizamos la arista del segundo árbol de la misma manera
            int min = Math.min(u, v);
            int max = Math.max(u, v);
            String edgeKey = min + " " + max;

            // Si esta arista ya existe en T1, significa que forma parte de la intersección
            // y por lo tanto no necesitamos eliminarla ni modificarla.
            if (t1Edges.contains(edgeKey)) {
                commonEdges++;
            }
        }

        // Planteamiento final:
        // El número total de aristas en cualquier árbol de N vértices es (N - 1).
        // Las aristas que ya son comunes no se tocan. Las operaciones mínimas requeridas
        // equivalen exactamente a cambiar las aristas de T1 que NO están en T2.
        int minOperations = (n - 1) - commonEdges;

        // Imprimir el resultado del número mínimo de operaciones
        System.out.println(minOperations);
    }
}


