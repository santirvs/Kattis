package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Leer cada una de las líneas
// ojo que pueden ser hasta 10.000 números -> Fast Input?
// En cada línea, hacer un triple bucle anidado para comprobar si las parejas i,j y j,k tienen la misma diferencia
// En el momento que encuentre esa subsecuencia imprimir "no" y finalizar el caso
// Si se llega al final sin haber encontrado ninguna subsecuencia, imprimir "yes"
// Ojo, que son 3 bucles de 10.000  --> O(n^3) = 10.000^3 = 10^12 iteraciones ---> Esto dará TLE!

// v1. TLE en caso #2, como ya me temía...
// v2. Solución optimizada con un único bucle anidado y un array de posiciones  -> AC

import java.util.*;

public class Antiarithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array de inversos (reverse), que guarda el índice de cada número en la secuencia
        int[] rev = new int[10000];
        Arrays.fill(rev, -1);

        while (sc.hasNextLine()) {
            // Leer la línea y eliminar los dos puntos
            String line = sc.nextLine().replace(":", "");
            if (line.trim().isEmpty()) continue;
            //Dividir la linea en partes. Si el primer número es 0, finalizar
            String[] parts = line.trim().split("\\s+");
            int n = Integer.parseInt(parts[0]);
            if (n == 0) break;

            // Array de tamaño n+1 para almacenar los números
            int[] nums = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }

            // Inicializar el array de posiciones con la posición de cada número
            boolean have = false;
            for (int i = 1; i <= n; i++) {
                rev[nums[i]] = i - 1;
            }

            // i es la distancia fija entre los elementos a comparar
            for (int i = 1; i < n && !have; i++) {
                // j es el índice del primer elemento de la subsecuencia
                // Por lo tanto, j, j+1 forman la primera pareja y // j+i, j+2*i forman la segunda pareja
                // Estamos hablando de posiciones y no de números!!!
                // rev[x] es el que contiene el número
                for (int j = 0; j < n - 2 * i && !have; j++) {
                    // ^ es XOR: condición de inconsistencia : si una es cierta y la otra es falsa
                    boolean cond = (rev[j] < rev[j + i]) ^ (rev[j + i] > rev[j + 2 * i]);
                    if (cond) {
                        have = true;
                    }
                }
            }

            System.out.println(have ? "no" : "yes");
        }
    }
}
