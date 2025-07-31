package Cap3._2_BusquedaCompleta._5_Iterativos_Permutacion;


// El enunciado es una flipada, pero si te paras a pensarlo un poco
// es un problema de permutaciones con restricciones.
// Preprocesar una matriz de sinergias para determinar la sinergia entre dos jugadores
// Probar las 10! permutaciones entre jugadores y verificar que la sinergia de cada nodo es >= a su grado.
//


import java.util.*;

public class VictoryThroughSynergy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Construir la lista de adyacencias entre nodos (jugadores)
        List<Integer>[] adjlist = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            adjlist[i] = new ArrayList<>();
        }

        // Leer las conexiones (adyacencias)
        int numAdyacencias = sc.nextInt();
        for (int i = 0; i < numAdyacencias; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // Al no ser dirigido, se añaden ambas direcciones
            adjlist[u].add(v);
            adjlist[v].add(u);
        }

        // Leer información de los jugadores
        String[][] jugadores = new String[10][3]; // [pais , liga, equipo]
        for (int i = 0; i < 10; i++) {
            String name = sc.next();  // ignoramos el nombre
            jugadores[i][0] = sc.next(); // country
            jugadores[i][1] = sc.next(); // league
            jugadores[i][2] = sc.next(); // team
        }

        // Construir la matriz de sinergia
        int[][] synergy = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Un jugador no puede tener sinergia consigo mismo
                if (i == j) continue;

                if (jugadores[i][2].equals(jugadores[j][2])) {
                    // Mismo equipo -> 2 puntos
                    synergy[i][j] += 2;
                    if (jugadores[i][0].equals(jugadores[j][0])) {
                        // Mismo país: 1 punto extra
                        synergy[i][j] += 1;
                    }
                } else if (jugadores[i][1].equals(jugadores[j][1])) {
                    // Misma liga -> 1 punto
                    synergy[i][j] += 1;
                    if (jugadores[i][0].equals(jugadores[j][0])) {
                        // Mismo país: 1 punto extra
                        synergy[i][j] += 1;
                    }
                } else if (jugadores[i][0].equals(jugadores[j][0])) {
                    // Sólo mismo país: 1 punto
                    synergy[i][j] += 1;
                }
            }
        }

        // Generar permutaciones y verificar
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < 10; i++) indices.add(i);

        boolean found = false;
        permute(indices, 0, synergy, adjlist);

        // Si no se encontró ninguna permutación válida, imprimir "no"
        System.out.println("no");
    }

    // Permutaciones con backtracking
    static void permute(List<Integer> perm, int l, int[][] synergy, List<Integer>[] adjlist) {
        if (l == perm.size()) {
            if (isValid(perm, synergy, adjlist)) {
                System.out.println("yes");
                System.exit(0);
            }
            return;
        }

        for (int i = l; i < perm.size(); i++) {
            Collections.swap(perm, l, i);
            permute(perm, l + 1, synergy, adjlist);
            Collections.swap(perm, l, i);
        }
    }

    static boolean isValid(List<Integer> perm, int[][] synergy, List<Integer>[] adjlist) {

        // Verifica que la sinergia de cada jugador es al menos igual a su grado
        for (int pos = 0; pos < 10; pos++) {
            int degree = adjlist[pos].size();
            int player = perm.get(pos);
            int synergySum = 0;
            for (int adj : adjlist[pos]) {
                int adjPlayer = perm.get(adj);
                synergySum += synergy[player][adjPlayer];
            }
            if (synergySum < degree) {
                return false;
            }
        }
        return true;
    }
}
