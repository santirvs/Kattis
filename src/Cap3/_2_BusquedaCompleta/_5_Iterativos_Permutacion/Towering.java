package Cap3._2_BusquedaCompleta._5_Iterativos_Permutacion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Calcular todas las permutaciones
// Sólo hay 6 elementos a permutar, por lo que la cantidad de permutaciones es pequeña (720).
// Cada permutación debe cumplir con las siguientes condiciones:
//  - La altura de la caja superior debe ser menor que la altura de la caja inferior (para cada una de las dos torres)
//  - Las cajas deben sumar la altura esperada de la torre (para cada una de las dos torres)


public class Towering {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Altura de las cajas a permutar
        int[] alturaCajas = new int[6];

        // Leer alturas de las cajas
        for (int i = 0; i < 6; i++) {
            alturaCajas[i] = sc.nextInt();
        }

        // Leer la altura esperada de las dos torres
        int alturaEsperadaTorre1 = sc.nextInt();
        int alturaEsperadaTorre2 = sc.nextInt();

        // Generar permutaciones
        int[] perm = new int[6];
        for (int i = 0; i < 6; i++) perm[i] = i;

        do {
            //Comprobar que las dos torres cumplen con las alturas esperadas
            if ((alturaCajas[perm[0]] > alturaCajas[perm[1]] && alturaCajas[perm[1]] > alturaCajas[perm[2]] &&
                  alturaCajas[perm[0]] + alturaCajas[perm[1]] + alturaCajas[perm[2]] == alturaEsperadaTorre1)  &&
                (alturaCajas[perm[3]] > alturaCajas[perm[4]] && alturaCajas[perm[4]] > alturaCajas[perm[5]] &&
                  alturaCajas[perm[3]] + alturaCajas[perm[4]] + alturaCajas[perm[5]] == alturaEsperadaTorre2)) {
                // Se ha encontrado la permutación válida
                break;  // Sale del do-while
            }
        } while (nextPermutation(perm));


        // Imprimir la permutación encontrada
        for (int i = 0; i < 6; i++) {
            System.out.print(alturaCajas[perm[i]] + (i < 5 ? " " : ""));
        }
        System.out.println();

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
