package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el tamaño de la matriz
// Leer el mapa (C=Cloud, L=Land, W=Water)
// Recorrer la matriz buscando islas (L) no visitadas
// Por cada isla encontrada, hacer una búsqueda en profundidad (DFS) para marcar todas las celdas conectadas como visitadas
// Una isla se puede recorrer en 4 direcciones y a través de celdas C (Cloud) y L (Land), pero no W (Water)
// Contar el número de islas encontradas e imprimir

import java.util.Scanner;

public class Islands {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el tamaño de la matriz
        int filas = sc.nextInt();
        int columnas = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea pendiente
        char[][] mapa = new char[filas][columnas];

        //Leer el mapa
        for (int i = 0; i < filas; i++) {
            String linea = sc.nextLine();
            mapa[i] = linea.toCharArray();
        }

        // Recorrer la matriz buscando islas
        int numIslas = 0;
        for (int fila = 0; fila < mapa.length; fila++) {
            for (int columna = 0; columna < mapa[0].length; columna++) {
                if (mapa[fila][columna] == 'L') {
                    numIslas++;
                    // Encontrada una isla no visitada
                    contarIsla(mapa, fila, columna);
                }
            }
        }

        // Mostrar resultado
        System.out.println(numIslas);

        sc.close();
    }

    // Función para marcar todas las celdas conectadas de una isla como visitadas
    public static void contarIsla(char[][] mapa, int fila, int columna) {
        // Verificar límites
        if (fila < 0 || fila >= mapa.length || columna < 0 || columna >= mapa[0].length) {
            return;
        }
        // Verificar si es agua o ya visitado
        if (mapa[fila][columna] == 'W' || mapa[fila][columna] == 'V') {
            return;
        }
        // Marcar como visitado
        mapa[fila][columna] = 'V';
        // Explorar en las 4 direcciones
        contarIsla(mapa, fila + 1, columna); // Abajo
        contarIsla(mapa, fila - 1, columna); // Arriba
        contarIsla(mapa, fila, columna + 1); // Derecha
        contarIsla(mapa, fila, columna - 1); // Izquierda
    }
}

