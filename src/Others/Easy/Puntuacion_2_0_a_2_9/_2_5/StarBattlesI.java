package Others.Easy.Puntuacion_2_0_a_2_9._2_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class StarBattlesI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 10; // El tablero siempre es de 10x10 según el problema
        char[][] regions = new char[n][n];
        char[][] grid = new char[n][n];

        // PASO 1: Leer el mapa de las 10 regiones
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line == null) return;
            line = line.trim();
            for (int j = 0; j < n; j++) {
                regions[i][j] = line.charAt(j);
            }
        }

        // PASO 2: Leer la solución candidata
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line == null) return;
            line = line.trim();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        // Arreglos de conteo para validar las reglas cuantitativas
        int[] rowCount = new int[n];        // Estrellas por fila
        int[] colCount = new int[n];        // Estrellas por columna
        int[] regionCount = new int[10];    // Estrellas por región (dígitos '0' a '9')

        boolean isValid = true;

        // PASO 3: Contar estrellas y verificar restricciones básicas
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '*') {
                    rowCount[r]++;
                    colCount[c]++;

                    // Convertimos el carácter de la región ('0'-'9') a un índice entero (0-9)
                    int regId = regions[r][c] - '0';
                    regionCount[regId]++;
                }
            }
        }

        // Comprobar que cada fila, columna y región tenga exactamente 2 estrellas
        for (int i = 0; i < n; i++) {
            if (rowCount[i] != 2 || colCount[i] != 2 || regionCount[i] != 2) {
                isValid = false;
                break;
            }
        }

        // PASO 4: Verificar la condición de adyacencia (ninguna estrella toca a otra, ni en diagonal)
        if (isValid) {
            // Desplazamientos para los 8 vecinos posibles (arriba, abajo, izq, der y las 4 diagonales)
            int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (int r = 0; r < n && isValid; r++) {
                for (int c = 0; c < n; c++) {
                    // Si encontramos una estrella, revisamos sus 8 vecinos
                    if (grid[r][c] == '*') {
                        for (int k = 0; k < 8; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];

                            // Validar que el vecino esté dentro de los límites del tablero
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                if (grid[nr][nc] == '*') {
                                    isValid = false; // Hay dos estrellas adyacentes
                                    break;
                                }
                            }
                        }
                    }
                    if (!isValid) break;
                }
            }
        }

        // PASO 5: Imprimir el resultado final basado en la validación
        if (isValid) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }
}