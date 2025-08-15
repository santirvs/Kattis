package Cap3._2_BusquedaCompleta._11_BacktrackingFaciles;

import java.util.*;

public class Paintings {
    // Número de soluciones encontradas
    static int respuestas;
    // Primera solución encontrada (la "preferida")
    static String solPreferida;
    // Lista de colores (para reconstruir nombres a partir de índices)
    static String[] colores;
    // disponible[i] = true si el color i aún no ha sido usado
    static boolean[] disponible;
    // paresHorribles[i][j] = true si el color i no puede ir junto al color j
    static boolean[][] paresHorribles;
    // Lista temporal para construir soluciones durante el backtracking
    static List<String> solucion;
    // Número de colores
    static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();

        for (int caso = 0; caso < numCasos; caso++) {
            // Leer número de colores
            n = scan.nextInt();
            scan.nextLine(); // Consumir el salto de línea
            colores = scan.nextLine().split(" ");

            // Crear mapa de índice rápido para cada color
            Map<String, Integer> indiceColor = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indiceColor.put(colores[i], i);
            }

            // Inicializar máscara de colores (todos disponibles al inicio)
            disponible = new boolean[n];
            Arrays.fill(disponible, true);

            // Leer los pares de colores horribles
            int numHorribles = scan.nextInt();
            scan.nextLine();
            paresHorribles = new boolean[n][n];

            for (int i = 0; i < numHorribles; i++) {
                String[] ab = scan.nextLine().split(" ");
                int ia = indiceColor.get(ab[0]);
                int ib = indiceColor.get(ab[1]);
                paresHorribles[ia][ib] = true;
                paresHorribles[ib][ia] = true;
            }

            // Preparar para la búsqueda
            respuestas = 0;
            solPreferida = "";
            solucion = new ArrayList<>();

            // Iniciar el backtracking
            // prevIdx = -1 significa que no hay color previo
            backtrack(-1, n);

            // Imprimir resultados
            System.out.println(respuestas);
            System.out.println(solPreferida);
        }

        scan.close();
    }

    /**
     * Backtracking optimizado para probar todas las combinaciones de colores
     * y saltar aquellas que no sean válidas.
     *
     * @param prevIdx índice del color previo en la solución (-1 si no hay)
     * @param restantes número de colores que faltan por colocar
     */
    static void backtrack(int prevIdx, int restantes) {
        // Caso base: no quedan colores disponibles
        if (restantes == 0) {
            respuestas++;
            if (respuestas == 1) {
                // Guardar la primera solución encontrada como preferida
                solPreferida = String.join(" ", solucion);
            }
            return;
        }

        // Intentar colocar cada color disponible
        for (int i = 0; i < n; i++) {
            if (!disponible[i]) continue; // Color ya usado
            if (prevIdx != -1 && paresHorribles[prevIdx][i]) continue; // Incompatible con el anterior

            // Usar este color
            disponible[i] = false;
            solucion.add(colores[i]);

            // Llamada recursiva con un color menos por colocar
            backtrack(i, restantes - 1);

            // Deshacer paso (backtracking)
            solucion.remove(solucion.size() - 1);
            disponible[i] = true;
        }
    }
}
