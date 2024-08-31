package Cap2._1_EstructurasDatosConBibliotecas._5_Ordenacion_Faciles;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Mjehuric {

    public static void swap(int[] lista, int i, int j) {
        int aux=lista[i];
        lista[i]=lista[j];
        lista[j]=aux;
    }

    public static void mostrar(int[] lista) {
        for (int i=0; i<5; i++) {
            System.out.print(lista[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int lista[] = new int[5];
        //Lectura de datos
        for (int i=0; i<5; i++) {
            lista[i]=scan.nextInt();
        }

        //Ordenar la lista
        boolean ordenado=false;
        while (!ordenado) {
            ordenado=true;
            for (int i=0; i<4; i++) {
                if (lista[i]>lista[i+1]) {
                    swap(lista, i, i+1);
                    ordenado=false;
                    mostrar(lista);
                }
            }
        }


    }
}