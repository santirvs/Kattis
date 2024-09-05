package Cap2._1_EstructurasDatosConBibliotecas._7_Ordenacion_Especiales;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class FroshWeek {

    static int n;
    static int[] a;
    static long numInver = 0;

    public static void merge(int l, int r)
    {                            // sort a[l, r)
        if (l + 1 >= r) return;  // singleton or empty
        int m = (l + r) / 2;
        merge(l, m);
        merge(m, r);

        // merge
        int i = l, j = m;
        ArrayList<Integer> b = new ArrayList<>();
        while (i < m && j < r) {
            if (a[i] <= a[j]) {
                b.add(a[i]);
                i++;
            }
            else {
                b.add(a[j]);
                j++;
                numInver += m - i;
            }
        }
        while (i < m) {
            b.add(a[i]);
            i++;
        }
        while (j < r) {
            b.add(a[j]);
            j++;
        }
        for (int k = l; k < r; k++) {
            a[k] = b.get(k - l);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        n = scan.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        //Ordenar contando las inversiones
        merge(0, n);

        //Mostrar el resultado
        System.out.println(numInver);
    }

 }

