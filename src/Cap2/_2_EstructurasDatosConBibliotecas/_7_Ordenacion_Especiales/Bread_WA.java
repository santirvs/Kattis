package Cap2._2_EstructurasDatosConBibliotecas._7_Ordenacion_Especiales;

import java.util.*;

/*
El problema de Bread es un problema del índice de inversión
El índice de inversión es el número de pares de elementos que deben intercambiarse en una ordenación de burbuja.

En este caso, cada vez que el panadero usa la pala, se producen dos inversiones: de ABC se pasa a CAB, por lo
sería equivalente a hacer dos intercambios en la burbuja   ABC --> ACB --> CAB

Si el índice de inversión es impar, entonces será imposible ordenar el array, ya que no se puede hacer un número impar de intercambios.

Para resolver el problema, se puede hacer un bubble sort y contar el número de inversiones que se hacen.
Si el número de inversiones es impar, entonces no se puede ordenar el array.
El problema es que con 100.000 elementos, el bubble sort es muy lento, por lo que se debe hacer una optimización.
La optimización consiste en hacer un merge sort y contar el número de inversiones que se hacen.

 */

public class Bread_WA {


    public static long merge(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        long inversiones = 0;
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                inversiones += n1 - i;
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return inversiones;
    }

    //Función que cuenta el número de inversiones
    public static long mergeSort(int[] arr, int l, int r) {
        long inversiones = 0;
        if (l+1 == r){
            if (arr[l] > arr[r]){
                int aux = arr[l];
                arr[l] = arr[r];
                arr[r] = aux;
                return 1;
            }
            return 0;
        }
        if (l == r){
            return 0;
        }

        if (l < r) {
            int m = (l + r) / 2;
            inversiones += mergeSort(arr, l, m);
            inversiones += mergeSort(arr, m + 1, r);
            inversiones += merge(arr, l, m, r);
        }
        return inversiones;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int cantidad = scan.nextInt();

        //Leer los datos
        ArrayList<Integer> datos = new ArrayList<Integer>();
        int[] ordenDeseado = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            int num= scan.nextInt();
            datos.add(num);
        }
        //Leer el orden deseado. Se renombran los elementos de la permutación original
        //para que coincidan con el orden deseado 1, 2, 3, ..., n
        for (int i = 0; i < cantidad; i++) {
            int posicion = datos.indexOf(scan.nextInt());
            ordenDeseado[i] = datos.get(posicion);
        }

        //Contar el número de inversiones
        long inversiones = mergeSort(ordenDeseado, 0, cantidad-1);

        //Imprimir el resultado
        if (inversiones % 2 == 0) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }


    }
}
