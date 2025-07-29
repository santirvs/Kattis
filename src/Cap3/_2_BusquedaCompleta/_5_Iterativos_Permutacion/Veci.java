package Cap3._2_BusquedaCompleta._5_Iterativos_Permutacion;

import java.util.*;

// Generar las permutaciones de la longitud de números leídos
// Comprobar si es mayor que el número original
// Quedarnos con el más pequeño

public class Veci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] numOriginal = sc.nextLine().toCharArray(); // Leer el número original
        int valorOriginal = 0;
        for (char c : numOriginal) {
            valorOriginal = valorOriginal * 10 + (c - '0'); // Convertir el número original a entero
        }

        // Generar las permutaciones
        int[] numeros = new int[numOriginal.length];
        for (int i = 0; i < numOriginal.length; i++) {
            numeros[i] = i;
        }
        List<List<Integer>> resultado = new ArrayList<>();
        permutar(numeros, 0, resultado);

        int minValor = Integer.MAX_VALUE; // Para almacenar el valor mínimo encontrado

        // Comprobar cada una de las permutaciones
        for (List<Integer> perm : resultado) {
            int numero = 0;
            for (int i = 0; i < numOriginal.length; i++) {
                numero = numero*10 + numOriginal[perm.get(i)] - '0';
            }

            if (numero > valorOriginal) {
                minValor = Math.min(minValor, numero);
            }
        }

        // Mostrar el resultado
        if (minValor == Integer.MAX_VALUE) {
            System.out.println("0");
        } else {
            System.out.println(minValor);
        }
    }

    // Algoritmo de permutación por backtracking
    static void permutar(int[] numeros, int indice, List<List<Integer>> resultado) {
        if (indice == numeros.length) {
            List<Integer> lista = new ArrayList<>();
            for (int num : numeros) {
                lista.add(num);
            }
            resultado.add(lista);
        }

        for (int i = indice; i < numeros.length; i++) {
            intercambiar(numeros, indice, i);
            permutar(numeros, indice + 1, resultado);
            intercambiar(numeros, indice, i); // deshacer
        }
    }

    static void intercambiar(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
