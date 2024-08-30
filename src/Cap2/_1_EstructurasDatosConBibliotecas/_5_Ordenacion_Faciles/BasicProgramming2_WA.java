package Cap2._1_EstructurasDatosConBibliotecas._5_Ordenacion_Faciles;

import java.util.*;

public class BasicProgramming2_WA {


    public static void accion_1(int[] lista, int cantidad) {
        //Buscar el elemento menor de 7777
        int posicion = Arrays.binarySearch(lista, 7777);
        if (posicion < 0) posicion = -posicion - 1;
        if (posicion == cantidad) posicion = cantidad - 1;

        //Buscar dos elementos que sumen 7777
        int left = 0;
        int right = posicion;
        while (left < right) {
            if (lista[left] + lista[right] == 7777) {
                System.out.println("Yes");
                return;
            }
            else if (lista[left] + lista[right] < 7777) {
                left++;
            }
            else {
                right--;
            }
        }

        System.out.println("No");
    }

    public static void accion_2(int[] lista, int cantidad) {
        for (int i = 0; i < cantidad-1; i++) {
            if (lista[i] == lista[i+1]) {
                System.out.println("Contains duplicate");
                return;
            }
        }
        System.out.println("Unique");
    }

    public static void accion_3(int[] lista, int cantidad) {
        //Si aparece más de n/2 veces, debe estar en la mitad
        int mitad = cantidad/2;
        int valorMitad = lista[mitad];
        int posicionSuperior = Arrays.binarySearch(lista, valorMitad+1);
        int posicionInferior = Arrays.binarySearch(lista, valorMitad-1);
        if (posicionSuperior < 0) posicionSuperior = -posicionSuperior - 1;
        if (posicionInferior < 0) posicionInferior = -posicionInferior - 1;
        if (posicionSuperior-1 - posicionInferior > mitad) {
            System.out.println(valorMitad);
            return;
        }

        System.out.println("-1");
    }

    public static void accion_4(int[] lista, int cantidad) {

        if (cantidad%2 == 1) {
            System.out.println(lista[cantidad/2]);
            return;
        }
        else {
            System.out.println(lista[cantidad/2-1] + " " + lista[cantidad/2]);
        }
    }

    public static void accion_5(int[] lista, int cantidad) {
        //Los casos 22 a 25 dan WA!!!
        //No encuentro el error.... :-(
        StringBuilder s = new StringBuilder();

        int i=Arrays.binarySearch(lista, 100);
        if (i < 0) i = -i - 1;

        for ( ; i < cantidad && lista[i]<100; i++) {
        }
        boolean primero = true;
        for ( ; i < cantidad && lista[i]<=999; i++) {
            if (!primero) {
                s.append(" ");
            }
            else {
                primero = false;
            }
            s.append(lista[i]);
        }
        System.out.println(s.toString());
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int cantidad = scan.nextInt();
        int accion = scan.nextInt();

        //Definir la matriz
        int[] lista = new int[cantidad];

        //Leer los valores
        for (int i = 0; i < cantidad; i++) {
            lista[i]=scan.nextInt();
        }

        //Ordenar la lista
        Arrays.sort(lista);

        //Realizar la accion
        switch (accion) {
            case 1: accion_1(lista, cantidad); break;
            case 2: accion_2(lista, cantidad); break;
            case 3: accion_3(lista, cantidad); break;
            case 4: accion_4(lista, cantidad); break;
            case 5: accion_5(lista, cantidad); break;
        }

    }
}

/*
#https://github.com/JonSteinn/Kattis-Solutions/blob/master/src/Basic%20Programming%202/Python%203/main.py
from collections import Counter

def t1(n,arr):
    s=set(arr)
    for i in range(1,7777):
        if i in s and 7777-i in s:
            return ('Yes',)
    return ('No',)

def t2(n,arr):
    return ('Unique',) if len(set(arr))==n else ('Contains duplicate',)

def t3(n,arr):
    a,b = Counter(arr).most_common(1)[0]
    return (a,) if b > n/2 else (-1,)

def t4(n,arr):
    s = sorted(arr)
    if len(s)%2 == 1:
        return (s[len(s)//2],)
    else:
        return s[len(s)//2 - 1: len(s)//2 + 1]

def t5(n,arr):
    return sorted(filter(lambda z: 99 < z < 1000, arr))

def action(n,t,arr):
    return [t1,t2,t3,t4,t5][t-1](n,arr)

def main():
    print(*action(*map(int,input().split()),map(int,input().split())))

if __name__ == "__main__":
    main()
 */