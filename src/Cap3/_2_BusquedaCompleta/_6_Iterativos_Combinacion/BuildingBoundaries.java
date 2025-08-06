package Cap3._2_BusquedaCompleta._6_Iterativos_Combinacion;

import java.util.*;

// Probar las diferentes combinaciones de orientación y disposición de los rectángulos
// para encontrar la mínima área que cubre todos los rectángulos.
// Básicamente hay dos disposiciones posibles:
// 1. Todos los rectángulos en una fila (horizontalmente)
// 2. Un rectángulo encima de los otros dos
// Los rectángulos pueden ser rotados y para el caso 2, se ajustarán a la izquierda y abajo

// v1-> WA --> Ojo a las dimensiones límites de los rectángulos: al sumar las dimensiones o
// al calcular el área, se pueden producir desbordamientos de enteros. Usar long! --> AC

public class BuildingBoundaries {

    // Clase para representar un rectángulo con sus dimensiones
    static class Rect {
        long h, w;
        Rect(long h, long w) {
            this.h = h;
            this.w = w;
        }

        Rect rotated() {
            return new Rect(w, h);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer el número de casos de prueba
        int numCasos = sc.nextInt();

        // Procesar cada caso de prueba
        while (numCasos-- > 0) {
            // Array de 3 rectángulos
            Rect[] rects = new Rect[3];

            // Leer las dimensiones de los 3 rectángulos
            for (int i = 0; i < 3; i++) {
                int a = sc.nextInt(), b = sc.nextInt();
                rects[i] = new Rect(a, b);
            }

            // Inicializar el área mínima como el máximo posible
            long ans =Long.MAX_VALUE;

            // Caso 1: Tres rectángulos en una fila, probar las 2^3 combinaciones de orientación
            for (int i = 0; i < (1<<3); i++) {
                long alto = 0, ancho = 0;
                for (int j = 0; j < 3; j++) {
                    // Si el bit j está activo, rotar el rectángulo, sino dejarlo como está
                    Rect r = ((i & (1 << j)) != 0) ? rects[j].rotated() : rects[j];
                    // Máximo alto
                    alto = Math.max(alto, r.h);
                    // Suma de anchos
                    ancho += r.w;
                }
                // Actualizar el área mínima
                ans = Math.min(ans, alto * ancho);
            }

            // Caso 2: Uno (top) encima de los otros 2 (left y right)
            // Probar las 3! = 6 combinaciones de orden de los rectángulos
            // y las 2^3 combinaciones de orientación
            // Permutación inicial de los índices de los rectángulos
            int[] perm = {0, 1, 2};
            do {
                // Probar las 2^3 combinaciones de orientación
                // Si el bit j está activo, rotar el rectángulo, sino dejarlo como está
                for (int mask = 0; mask < 8; mask++) {

                    Rect top = ((mask & 1) != 0) ? rects[perm[0]].rotated() : rects[perm[0]];
                    Rect left = ((mask & 2) != 0) ? rects[perm[1]].rotated() : rects[perm[1]];
                    Rect right = ((mask & 4) != 0) ? rects[perm[2]].rotated() : rects[perm[2]];

                    // Comprobar solapamiento
                    // Si el bloque derecho es más alto que el izquierdo
                    // Y el bloque de arriba es más ancho que el izquierdo, esta disposición no es válida.
                    if (right.h > left.h && top.w > left.w) continue;

                    long alto = Math.max(top.h + left.h, right.h);
                    long ancho = Math.max(top.w, left.w + right.w);

                    ans = Math.min(ans, alto * ancho);
                }
            } while (nextPermutation(perm));

            // Imprimir el área mínima encontrada
            System.out.println(ans);
        }
    }

    // next_permutation para array de enteros
    // a partir de un array de enteros creciente
    static boolean nextPermutation(int[] p) {
        int n = p.length;
        int i = n - 2;
        while (i >= 0 && p[i] >= p[i + 1]) i--;
        if (i < 0) return false;
        int j = n - 1;
        while (p[j] <= p[i]) j--;
        int tmp = p[i]; p[i] = p[j]; p[j] = tmp;
        for (int a = i + 1, b = n - 1; a < b; a++, b--) {
            tmp = p[a]; p[a] = p[b]; p[b] = tmp;
        }
        return true;
    }

}
