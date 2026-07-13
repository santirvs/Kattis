package Others.Medium.Puntuacion_2_0_a_2_9._2_9;

/**
 * La idea fundamental para maximizar el valor es que hay que reordenar los compradores y barras de forma
 * que el que más pague se lleve la barra más pesada.
 * Sin embargo, no es posible hacer todos los intercambios, sino sólo aquellos que nos vienen indicados.
 * Si un conjunto de compradores pueden intercambiar sus barras, aplicaremos la idea fundamental a ese grupo por separado.
 * Reducimos el problema a ver cuantos grupos tenemos y para ello usaremos un Disjoint Set Union.
 * Los intercambios son conexiones entre compradores.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GoldMerchant {

    // Estructura Disjoint Set Union (DSU) para manejar las componentes conexas
    static class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i; // Al inicio, cada nodo es su propio padre
            }
        }

        // Operación Find con compresión de caminos
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        // Operación Union para conectar dos nodos
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ; // Conectamos las componentes
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Uso de BufferedReader y StringTokenizer para una lectura rápida de datos (Fast I/O)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Leer N (compradores/barras) y M (swaps)
        String line = br.readLine();
        if (line == null) return;
        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Arreglos para almacenar los pesos y los precios (indexados desde 1 para coincidir con el problema)
        long[] weights = new long[n + 1];
        long[] prices = new long[n + 1];

        // Leer los pesos de las barras de oro
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            weights[i] = Long.parseLong(st.nextToken());
        }

        // Leer los precios ofrecidos por los compradores
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        // Inicializar el DSU
        DSU dsu = new DSU(n);

        // Procesar los M swaps. Cada swap añade una arista, uniendo los conjuntos.
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dsu.union(u, v);
        }

        // Agrupar los compradores por el identificador (representante/raíz) de su componente conexa.
        // Usamos un mapa donde la clave es la raíz del DSU y el valor es la lista de índices en esa componente.
        Map<Integer, ArrayList<Integer>> components = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 1; i <= n; i++) {
            int root = dsu.find(i);
            if (!components.containsKey(root)) {
                components.put(root, new ArrayList<Integer>());
            }
            components.get(root).add(i);
        }

        long totalMaximumValue = 0;

        // Procesar cada componente conexa de manera independiente
        for (Map.Entry<Integer, ArrayList<Integer>> entry : components.entrySet()) {
            ArrayList<Integer> indices = entry.getValue();

            // Listas para extraer los pesos y precios pertenecientes exclusivamente a esta componente
            ArrayList<Long> compWeights = new ArrayList<Long>();
            ArrayList<Long> compPrices = new ArrayList<Long>();

            for (int idx : indices) {
                compWeights.add(weights[idx]);
                compPrices.add(prices[idx]);
            }

            // Aplicar Desigualdad de Reordenamiento:
            // Ordenamos ambas listas de forma ascendente. Al estar ordenadas igual, el menor peso
            // se multiplicará con el menor precio, y el mayor peso con el mayor precio, maximizando el producto.
            Collections.sort(compWeights);
            Collections.sort(compPrices);

            // Calcular el valor acumulado de esta componente
            for (int i = 0; i < compWeights.size(); i++) {
                totalMaximumValue += compWeights.get(i) * compPrices.get(i);
            }
        }

        // Imprimir el resultado final
        System.out.println(totalMaximumValue);
    }
}
