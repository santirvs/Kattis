package Cap3._2_BusquedaCompleta._4_Iterativos_3BuclesAnidadosDificiles;

// Fuerza bruta
// La cantidad de personas es relativamente pequeña (50x50 = 2500) así que una búsqueda
// completa es factible (2.500^2 = 6.250.000 iteraciones en el peor caso).
// Leer las filas y sus posiciones
// Hacer un recorrido por todas las filas
// Si hay un hueco libre, calcular a cuantas personas se podría saludar (entre 0 y 8). En el momento que se encuentre un 8 parar
// Si hay una persona, calcular a cuantas personas puede saludar y acumular.
// Finalmente, imprimir el número máximo de saludos hechos más el máximo de saludos al hueco libre encontrado.

import java.io.IOException;
import java.util.*;

public class Misa {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int filas = scan.nextInt();
        int columnas = scan.nextInt();
        scan.nextLine();

        // Matriz para almacenar el plano de la iglesia
        char[][] misa = new char[filas][columnas];
        // Leer el plano de la iglesia
        for (int i = 0; i < filas; i++) {
            String fila = scan.nextLine();
            misa[i] = fila.toCharArray();
        }

        // Variable para almacenar el máximo de saludos
        int maxSaludo = 0;
        int totalSaludos = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (misa[i][j] == 'o') {
                    // Si hay una persona, contar los saludos
                    int saludos = contarSaludos(misa, i, j, false);
                    totalSaludos += saludos;
                    misa[i][j] = 'x';  // Marcar la persona para que no pueda volver a saludar
                } else if (misa[i][j] == '.' && maxSaludo < 8) {
                    // Si hay un hueco libre, calcular los posibles saludos
                    int saludosHueco = contarSaludos(misa, i, j, true);
                    maxSaludo = Math.max(maxSaludo, saludosHueco);
                }
            }
        }

        // Imprimir el total de saludos más el máximo de saludos al hueco libre
        System.out.println((totalSaludos + maxSaludo));

    }

    private static int contarSaludos(char[][] misa, int i, int j, boolean incluirYaTradados) {
        int saludos = 0;
        // Comprobar las 8 direcciones alrededor de la posición (i, j)
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) continue; // Ignorar la posición actual
                int ni = i + di;
                int nj = j + dj;
                // Comprobar si está dentro de los límites de la matriz
                if (ni >= 0 && ni < misa.length && nj >= 0 && nj < misa[0].length) {
                    // Si hay una persona que haya saludado ya o no
                    if (misa[ni][nj] == 'o' || (misa[ni][nj] == 'x' && incluirYaTradados)) {
                        saludos++;
                    }
                }
            }
        }
        return saludos;
    }
}
