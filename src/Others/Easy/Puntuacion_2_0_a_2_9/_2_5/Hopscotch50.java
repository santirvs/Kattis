package Others.Easy.Puntuacion_2_0_a_2_9._2_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Hopscotch50 {

    // Estructura simple para almacenar las coordenadas (fila, columna) de cada celda
    static class Cell {
        int r, c;

        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        // Uso de BufferedReader para una lectura rápida de la entrada estándar
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // Arreglo de listas para agrupar las posiciones por su valor (de 1 a K)
        // Usamos la sintaxis explícita de genéricos compatible con Java 1.7+
        @SuppressWarnings("unchecked")
        List<Cell>[] valPositions = new ArrayList[k + 1];
        for (int i = 1; i <= k; i++) {
            valPositions[i] = new ArrayList<Cell>();
        }

        // Lectura del tablero de N x N
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                int val = Integer.parseInt(st.nextToken());
                if (val >= 1 && val <= k) {
                    valPositions[val].add(new Cell(r, c));
                }
            }
        }

        // VALIDACIÓN: Si falta algún número entre 1 y K, es imposible completar el juego
        for (int i = 1; i <= k; i++) {
            if (valPositions[i].isEmpty()) {
                System.out.println("-1");
                return;
            }
        }

        // Matriz DP: dist[r][c] guardará la menor distancia desde algún '1' hasta la celda (r, c)
        int[][] dist = new int[n][n];
        int INF = 1000000000; // Valor de infinitud para inicializar la matriz

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        // PASO BASE: Las celdas con valor 1 tienen costo 0 de llegada
        for (Cell cell : valPositions[1]) {
            dist[cell.r][cell.c] = 0;
        }

        // PROGRAMACIÓN DINÁMICA: Transición capa a capa (de v-1 a v)
        for (int v = 2; v <= k; v++) {
            List<Cell> currentCells = valPositions[v];
            List<Cell> prevCells = valPositions[v - 1];

            for (Cell curr : currentCells) {
                int minCost = INF;

                // Transición: probamos todas las celdas de la capa previa (v - 1)
                for (Cell prev : prevCells) {
                    // Distancia Manhattan entre la celda previa y la actual
                    int manhattanDist = Math.abs(curr.r - prev.r) + Math.abs(curr.c - prev.c);

                    // Calculamos el costo total viniendo desde la celda previa
                    int totalCost = dist[prev.r][prev.c] + manhattanDist;

                    if (totalCost < minCost) {
                        minCost = totalCost;
                    }
                }

                // Guardamos el costo óptimo para la celda actual
                dist[curr.r][curr.c] = minCost;
            }
        }

        // RESULTADO: Buscamos el mínimo costo entre todas las celdas con valor K
        int ans = INF;
        for (Cell cell : valPositions[k]) {
            if (dist[cell.r][cell.c] < ans) {
                ans = dist[cell.r][cell.c];
            }
        }

        // Si por alguna razón el camino mínimo sigue siendo infinito (improbable si existen todos), imprima -1
        if (ans >= INF) {
            System.out.println("-1");
        } else {
            System.out.println(ans);
        }
    }
}