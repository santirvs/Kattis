package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el tamaño de la lista1 y de la lista2
// Leer las listas 1 y 2
// Para cada item de la lista 1 buscarlo en la lista2
// Si se encuentra, imprimirlo en una línea separado por espacios


import java.util.Scanner;

public class Maeting {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el tamaño de las listas 1 y 2
        int tamanyoLista1 =  sc.nextInt();
        int tamanyoLista2 =  sc.nextInt();

        // Definir los arrays 1 y 2
        int[] lista1 = new int[tamanyoLista1];
        int[] lista2 = new int[tamanyoLista2];

        // Leer las listas
        for (int i = 0; i < lista1.length; i++) {
            lista1[i] = sc.nextInt();
        }
        for (int i = 0; i < lista2.length; i++) {
            lista2[i] = sc.nextInt();
        }

        //Para cada elemento de la lista 1, buscarlo en la lista 2
        boolean primero = true;
        for (int i = 0; i < lista1.length; i++) {
            boolean encontrado = false;
            for (int j = 0; j < lista2.length && !encontrado; j++) {
                if (lista1[i] == lista2[j]) {
                    encontrado = true;
                    if (!primero)
                        System.out.print(" ");
                    else
                        primero = false;

                    System.out.print(lista1[i]);
                }
            }
        }
        System.out.println();

        sc.close();
    }
}

