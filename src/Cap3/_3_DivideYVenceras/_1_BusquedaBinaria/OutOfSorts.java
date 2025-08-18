package Cap3._3_DivideYVenceras._1_BusquedaBinaria;

// Implementar una búsqueda binaria, pero sobre un array no ordenado
// Generar la secuencia de números de forma aleatoria, añadirlos a una lista
// y posteriormente buscarlos por el méthodo de búsqueda binaria en la propia lista desordenada
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OutOfSorts {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Leer la entrada
        int n = scan.nextInt();
        int m = scan.nextInt();
        int a = scan.nextInt();
        int c = scan.nextInt();
        long xAnt = scan.nextInt();

        // Generar la secuencia de números
        int[] numeros = new int[n];
        for (int i = 0; i < n; i++) {
            xAnt = (a * xAnt + c) % m;
            numeros[i] = (int) xAnt;
        }

        // Consultar cada uno de los números
        int numEncontrados = 0;
        for (int i = 0; i < n; i++) {
            int x = numeros[i];
            if (busquedaBinaria_manual(numeros, x)) {
                numEncontrados++;
            }
        }

        // Imprimir el resultado
        System.out.println(numEncontrados);
        scan.close();
    }

    private static boolean busquedaBinaria_manual(int[] a, int x) {
        int izquierda = 0;
        int derecha = a.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (a[medio] == x) {
                return true; // Encontrado
            } else if (a[medio] < x) {
                izquierda = medio + 1; // Buscar en la mitad derecha
            } else {
                derecha = medio - 1; // Buscar en la mitad izquierda
            }
        }
        return false; // No encontrado

    }

    private static boolean busquedaBinaria(int[] a, int x) {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int num : a) {
            numeros.add(num);
        }
        return Collections.binarySearch(numeros, x) >= 0;
    }
}
