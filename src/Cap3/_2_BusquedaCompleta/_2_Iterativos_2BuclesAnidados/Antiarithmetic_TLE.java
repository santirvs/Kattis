package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Leer cada una de las líneas
// ojo que pueden ser hasta 10.000 números -> Fast Input?
// En cada línea, hacer un triple bucle anidado para comprobar si las parejas i,j y j,k tienen la misma diferencia
// En el momento que encuentre esa subsecuencia imprimir "no" y finalizar el caso
// Si se llega al final sin haber encontrado ninguna subsecuencia, imprimir "yes"
// Ojo, que son 3 bucles de 10.000  --> O(n^3) = 10.000^3 = 10^12 iteraciones ---> Esto dará TLE!

// v1. TLE en caso #2, como ya me temía...

import java.util.HashSet;
import java.util.Scanner;

public class Antiarithmetic_TLE {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String cantidad = scan.next(); // Número de elementos
        cantidad = cantidad.replace(":", ""); // Eliminar los dos puntos
        int n = Integer.parseInt(cantidad); // Convertir a entero
        // Finalizar si n=0
        while (n > 0) {
            int[] secuencia = new int[n];
            for (int i = 0; i < n; i++) {
                secuencia[i] = scan.nextInt(); // Leer los números de la secuencia
            }

            boolean antiarithmetic = true; // Suponemos que es antiarithmetic

            // Comprobar todas las parejas i,j y j,k
            for (int i = 0; i < n - 1 && antiarithmetic; i++) {
                HashSet<Integer> diferencias = new HashSet<>();
                for (int j = i + 1; j < n && antiarithmetic; j++) {
                    int diferencia = secuencia[j] - secuencia[i];
                    if (diferencias.contains(diferencia)) {
                        antiarithmetic = false;
                    }
                    else {
                        diferencias.add(diferencia);
                    }
                }
            }

            //Mostrar el resultado
            if (antiarithmetic) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }


            cantidad = scan.next(); // Número de elementos
            cantidad = cantidad.replace(":", ""); // Eliminar los dos puntos
            n = Integer.parseInt(cantidad); // Convertir a entero
        }

    }
}