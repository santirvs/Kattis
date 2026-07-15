package Others.Medium.Puntuacion_3_0_a_3_9._3_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * PROBLEMA: Illumination (2-SAT)
 * ============================================================================
 * EXPLICACIÓN DEL PLANTEAMIENTO
 * ============================================================================
 * 1. MODELADO DE VARIABLES:
 * Cada lámpara 'i' (de 0 a L-1) tiene dos estados posibles mutuamente excluyentes:
 * - Ilumina su FILA (Variable lógica X_i = Verdadera)
 * - Ilumina su COLUMNA (Variable lógica X_i = Falsa, lo que equivale a NOT X_i = Verdadera)
 * * Para modelar esto en un sistema de 2-SAT con 2*L nodos lógicos:
 * - El nodo 'i' representará que la lámpara 'i' ilumina su FILA (X_i).
 * - El nodo 'i + L' representará que la lámpara 'i' ilumina su COLUMNA (NOT X_i).
 * * 2. RESTRICCIONES (CONFLICTOS):
 * El problema prohíbe que una misma casilla de la cuadrícula sea iluminada por más de
 * una lámpara en su fila o más de una lámpara en su columna.
 * * A) CONFLICTO DE FILA:
 * Si la lámpara 'i' y la lámpara 'j' están en la misma fila y a distancia <= R:
 * No pueden iluminar la fila al mismo tiempo. Es decir, NOT (X_i AND X_j).
 * En lógica de proposiciones, esto equivale a la cláusula: (NOT X_i OR NOT X_j).
 * De aquí obtenemos las implicaciones para nuestro grafo de 2-SAT:
 * - X_i => NOT X_j  (Nodo i -> Nodo j + L)
 * - X_j => NOT X_i  (Nodo j -> Nodo i + L)
 * * B) CONFLICTO DE COLUMNA:
 * Si la lámpara 'i' y la lámpara 'j' están en la misma columna y a distancia <= R:
 * No pueden iluminar la columna al mismo tiempo. Es decir, NOT (NOT X_i AND NOT X_j).
 * En lógica de proposiciones, esto equivale a la cláusula: (X_i OR X_j).
 * De aquí obtenemos las implicaciones:
 * - NOT X_i => X_j  (Nodo i + L -> Nodo j)
 * - NOT X_j => X_i  (Nodo j + L -> Nodo i)
 * * 3. COMPONENTES FUERTEMENTE CONEXAS (SCC) CON EL ALGORITMO DE TARJAN:
 * Tras construir el grafo con todas las implicaciones:
 * - Buscamos las componentes fuertemente conexas.
 * - Si una variable (X_i) y su negación (NOT X_i) terminan en la misma componente
 * fuertemente conexa, significa que X_i => ... => NOT X_i => ... => X_i, lo cual
 * es una contradicción lógica. El problema sería insatisfacible (salida: 0).
 * - Si no hay ninguna contradicción para ninguna de las L lámparas, es posible (salida: 1).
 */
public class Illumination {

    static class Lamp {
        int r, c;
        Lamp(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // Variables para el algoritmo de Tarjan
    private static List<Integer>[] adj; // Lista de adyacencia del grafo de implicaciones
    private static int[] dfn;           // Tiempo de descubrimiento de Tarjan para cada nodo
    private static int[] low;           // Enlace mínimo (lowlink) de Tarjan
    private static int[] sccId;         // Identificador de la componente conexa asignada a cada nodo
    private static boolean[] inStack;   // Control de si el nodo está actualmente en la pila de Tarjan
    private static int[] stack;         // Pila personalizada para evitar la sobrecarga de objetos en Java
    private static int stackPtr;
    private static int timer;           // Contador de tiempo global de Tarjan
    private static int sccCount;        // Contador de componentes conexas encontradas

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken()); // Tamaño del mapa (no se usa directamente en la lógica de conflictos)
        int r = Integer.parseInt(st.nextToken()); // Rango de iluminación de cada lámpara
        int l = Integer.parseInt(st.nextToken()); // Cantidad de lámparas

        Lamp[] lamps = new Lamp[l];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            lamps[i] = new Lamp(row, col);
        }

        // Inicializamos el grafo con 2 * L nodos:
        // [0, L-1]     -> Representan X_i (iluminar Fila)
        // [L, 2*L-1]   -> Representan NOT X_i (iluminar Columna)
        int numNodes = 2 * l;
        adj = new ArrayList[numNodes];
        for (int i = 0; i < numNodes; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        // DETECCIÓN DE CONFLICTOS ENTRE TODAS LAS PAREJAS DE LÁMPARAS
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                Lamp a = lamps[i];
                Lamp b = lamps[j];

                // Conflicto de Fila: Misma fila y distancia de columnas <= r
                if (a.r == b.r && Math.abs(a.c - b.c) <= r) {
                    // Clausula: (NOT X_i OR NOT X_j)
                    // Implicación 1: X_i => NOT X_j  (i -> j + L)
                    adj[i].add(j + l);
                    // Implicación 2: X_j => NOT X_i  (j -> i + L)
                    adj[j].add(i + l);
                }

                // Conflicto de Columna: Misma columna y distancia de filas <= r
                if (a.c == b.c && Math.abs(a.r - b.r) <= r) {
                    // Clausula: (X_i OR X_j)
                    // Implicación 1: NOT X_i => X_j  (i + L -> j)
                    adj[i + l].add(j);
                    // Implicación 2: NOT X_j => X_i  (j + L -> i)
                    adj[j + l].add(i);
                }
            }
        }

        // Inicialización de estructuras para el algoritmo de Tarjan
        dfn = new int[numNodes];
        low = new int[numNodes];
        sccId = new int[numNodes];
        inStack = new boolean[numNodes];
        stack = new int[numNodes];
        stackPtr = 0;
        timer = 0;
        sccCount = 0;

        // Ejecutamos Tarjan en cada nodo no visitado
        for (int i = 0; i < numNodes; i++) {
            if (dfn[i] == 0) {
                tarjan(i);
            }
        }

        // VERIFICACIÓN DE SATISFACIBILIDAD (2-SAT)
        boolean possible = true;
        for (int i = 0; i < l; i++) {
            // Si X_i y NOT X_i están en la misma componente conexa, hay contradicción
            if (sccId[i] == sccId[i + l]) {
                possible = false;
                break;
            }
        }

        // Imprime 1 si es posible configurar todas las lámparas, o 0 si hay contradicción irreconciliable
        if (possible) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    /**
     * Algoritmo de Tarjan para encontrar Componentes Fuertemente Conexas en O(V + E).
     */
    private static void tarjan(int u) {
        timer++;
        dfn[u] = timer;
        low[u] = timer;
        stack[stackPtr++] = u;
        inStack[u] = true;

        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i);
            if (dfn[v] == 0) {
                tarjan(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) {
                low[u] = Math.min(low[u], dfn[v]);
            }
        }

        // Si u es la raíz de una componente fuertemente conexa
        if (low[u] == dfn[u]) {
            sccCount++;
            while (true) {
                int v = stack[--stackPtr];
                inStack[v] = false;
                sccId[v] = sccCount;
                if (u == v) {
                    break;
                }
            }
        }
    }
}