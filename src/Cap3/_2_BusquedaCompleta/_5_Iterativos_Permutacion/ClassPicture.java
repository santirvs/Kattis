package Cap3._2_BusquedaCompleta._5_Iterativos_Permutacion;

import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

// Calcular todas las permutaciones
// Aquí deberíamos usar un enfoque de todas las permutaciones, limitado a 10 personas.
// Usaremos DP con bitmask para optimizar el proceso O(n * 2^n) donde n es el número de personas
// Para cada persona, calcular si se puede poner adyacente a la anterior
// Pero aquí nos piden el orden de las personas y eso el DP con bitmask no lo hace directamente.

// Por lo tanto, usaremos un enfoque de búsqueda completa iterativa para generar todas las permutaciones
// y comprobar si se pueden poner adyacentes, ya que el número de personas es pequeño (máximo 10).
// No genera todas las permutaciones, sino que las va generando en orden lexicográfico


public class ClassPicture {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            // Leer número de personas
            int numPersonas = sc.nextInt();
            String[] nombres = new String[numPersonas];
            for (int i = 0; i < numPersonas; i++) {
                nombres[i] = sc.next();
            }

            // Ordenar lexicográficamente
            Arrays.sort(nombres);

            // Mapear nombre a índice ya que buscaremos la primera solución en orden lexicográfico
            Map<String, Integer> nombresToIndice = new HashMap<>();
            for (int i = 0; i < numPersonas; i++) {
                nombresToIndice.put(nombres[i], i);
            }

            // Leer relaciones de incompatibilidad
            int numIncompatibilidades = sc.nextInt();
            boolean[][] incompatibles = new boolean[numPersonas][numPersonas];
            for (int i = 0; i < numIncompatibilidades; i++) {
                //Leer los nombres
                String n1 = sc.next();
                String n2 = sc.next();
                //Recuperar los índices de los nombres
                int u = nombresToIndice.get(n1);
                int v = nombresToIndice.get(n2);
                // Marcar como mutuamente incompatibles
                incompatibles[u][v] = true;
                incompatibles[v][u] = true;
            }

            // Generar permutaciones
            int[] perm = new int[numPersonas];
            for (int i = 0; i < numPersonas; i++) perm[i] = i;

            boolean ok = false;
            do {
                //Suponemos que la permutación es válida
                ok = true;
                //Recorrer todas las personas en la permutación
                for (int i = 0; i < numPersonas - 1; i++) {
                    //Comprobar que son compatibles con la siguiente
                    if (incompatibles[perm[i]][perm[i + 1]]) {
                        //Si no son compatibles, marcamos como no válida
                        ok = false;
                        break;  // Sale del for
                    }
                }
                if (ok) break;  // Sale del do-while si encontramos una permutación válida
            } while (nextPermutation(perm));

            if (ok) {
                // Si encontramos una permutación válida, imprimirla
                for (int i = 0; i < numPersonas; i++) {
                    System.out.print(nombres[perm[i]] + " ");
                }
                System.out.println();
            } else {
                // Si no encontramos ninguna permutación válida, imprimir el mensaje correspondiente
                System.out.println("You all need therapy.");
            }
        }

        sc.close();
    }

    // next_permutation para array de enteros
    public static boolean nextPermutation(int[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false;

        int j = a.length - 1;
        while (a[j] <= a[i]) j--;

        // Swap
        int temp = a[i]; a[i] = a[j]; a[j] = temp;

        // Reverse suffix
        for (int l = i + 1, r = a.length - 1; l < r; l++, r--) {
            temp = a[l]; a[l] = a[r]; a[r] = temp;
        }
        return true;
    }
}
