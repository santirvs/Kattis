package Cap2._1_EstructurasDatosConBibliotecas._7_Ordenacion_Especiales;

import java.util.*;
import Utils.Kattio;

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


TLE -->TestCase#24: Uso la librería Kattio, sigue dando TLE  :-(
 */

public class Bread_TLE {

    public static long mergeSort(int arr[], int l, int r){

        if (l+1 == r){
            if (arr[l] > arr[r]){
                int aux = arr[r];
                arr[r] = arr[l];
                arr[l] = aux;
                return 1;
            }
            return 0;
        }
        if (l == r){
            return 0;
        }

        int middle = (l+r)/2;

        long inversion_index = 0;
        inversion_index += mergeSort(arr, l, middle);
        inversion_index += mergeSort(arr, middle+1, r);

        int[] temp = new int[arr.length];
        int l_i=l, r_i=middle+1;
        for (int i=l; i<=r;i++){
            if (l_i <= middle && r_i <= r){
                if (arr[l_i] <= arr[r_i]){
                    temp[i] = arr[l_i];
                    l_i++;
                }
                else{
                    temp[i] = arr[r_i];
                    r_i++;
                    inversion_index += (middle-l_i+1);
                }
            }
            else if (r_i > r){ // right empty
                temp[i] = arr[l_i];
                l_i++;
            }
            else{ // left empty
                temp[i] = arr[r_i];
                r_i++;
            }

        }
        for (int i=l; i<=r; i++){
            arr[i] = temp[i];
        }

        return inversion_index;
    }

    public static void main(String[] args) {

        //Scanner scan = new Scanner(System.in);
        //scan.useLocale(Locale.ENGLISH);

        Kattio scan = new Kattio(System.in);

        //Lectura de datos
        int n = scan.getInt();

        //Leer los datos
        int[] initial = new int[n];
        for (int i = 0; i < n; i++) {
            initial[i] = scan.getInt();
        }

        //Leer el orden deseado. Se renombran los elementos de la permutación original
        //para que coincidan con el orden deseado 1, 2, 3, ..., n
        int[] target = new int[n];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            target[i] = scan.getInt();
            m.put(target[i],i+1);
            //target[i] = i+1;  //???  -- No es necesario
        }
        for (int i=0;i<n;i++){
            initial[i] = m.get(initial[i]);
        }

        //Contar el número de inversiones
        long inversiones = mergeSort(initial, 0, n-1);

        //Imprimir el resultado
        if (inversiones % 2 == 0) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }

    }
}


/* C++ version

#include <bits/stdc++.h>
using namespace std;

map<int, int> m;
int n;
int initial[100009], target[100009];

long long merge_sort(int arr[100009], int l, int r){

    if (l+1 == r){
        if (arr[l] > arr[r]){
            swap(arr[l], arr[r]);
            return 1;
        }
        return 0;
    }
    if (l == r){
        return 0;
    }

    int middle = (l+r)/2;

    long long inversion_index = 0;
    inversion_index += merge_sort(arr, l, middle);
    inversion_index += merge_sort(arr, middle+1, r);

    // printf("L: %d, R: %d, Middle:%d\n", l, r, middle);
    //for (int i=0;i<n;i++){cout << arr[i] << " ";}
    //cout << endl;

    int temp[100009];
    int l_i=l, r_i=middle+1;
    for (int i=l; i<=r;i++){
        if (l_i <= middle && r_i <= r){
            if (arr[l_i] <= arr[r_i]){
                temp[i] = arr[l_i];
                l_i++;
            }
            else{
                temp[i] = arr[r_i];
                r_i++;
                inversion_index += (middle-l_i+1);
            }
        }
        else if (r_i > r){ // right empty
            temp[i] = arr[l_i];
            l_i++;
        }
        else{ // left empty
            temp[i] = arr[r_i];
            r_i++;
        }

    }
    for (int i=l; i<=r; i++){
        arr[i] = temp[i];
    }

    return inversion_index;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    for (int i=0;i<n;i++)cin >> initial[i];
    for (int i=0;i<n;i++){
        cin >> target[i];
        m[target[i]] = i+1;
        target[i] = i+1;
    }
    for (int i=0;i<n;i++){
        initial[i] = m[initial[i]];
    }

    long long inversion_index = merge_sort(initial, 0, n-1);


    if (inversion_index % 2 == 0){
        cout << "possible\n";
    }
    else cout << "impossible\n";

    return 0;
}
*/