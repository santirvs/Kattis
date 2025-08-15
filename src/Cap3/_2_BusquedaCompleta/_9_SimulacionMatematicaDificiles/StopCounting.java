package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;
import java.util.*;
import java.io.*;

// Este problema consiste en encontrar el máximo promedio de una secuencia de números
// al excluir un intervalo de la secuencia. Se puede lograr recorriendo la secuencia
// de izquierda a derecha para considerar prefijos y de derecha a izquierda para considerar
// sufijos, calculando el promedio de los elementos restantes en cada caso.
// CLAVE:: Si quitar un bloque interno pudiera mejorarnos un mejor resultado, ese resultado ya aparecería
// cuando evaluamos todos los prefijos y todos los sufijos

public class StopCounting {
    public static void main(String[] args) throws IOException {
        // Lectura rápida desde la entrada estándar
        Scanner scan = new Scanner(System.in);

        // Cantidad de elementos en la secuencia
        int numElementos = scan.nextInt();

        // Lectura de la secuencia
        int[] arr = new int[numElementos];
        for (int i = 0; i < numElementos; i++) {
            arr[i] = scan.nextInt();
        }

        double maximoPago = 0.0; // Guarda el máximo promedio encontrado
        long longSecuencia = 0;           // Acumulador de la suma de elementos

        // ================================
        // 1. Recorremos de izquierda a derecha (prefijos)
        // ================================
        // Evaluamos promedios tomando desde el primer elemento hasta i
        // Esto simula excluir un intervalo al final (tomamos un prefijo)
        for (int i = 0; i < numElementos; i++) {
            longSecuencia += arr[i];
            maximoPago = Math.max(maximoPago, longSecuencia / (double) (i + 1));
        }

        // ================================
        // 2. Recorremos de derecha a izquierda (sufijos)
        // ================================
        // Evaluamos promedios tomando desde el último elemento hacia atrás
        // Esto simula excluir un intervalo al principio (tomamos un sufijo)
        longSecuencia = 0;
        for (int i = numElementos - 1; i >= 0; i--) {
            longSecuencia += arr[i];
            maximoPago = Math.max(maximoPago, longSecuencia / (double) (numElementos - i));
        }

        // ================================
        // Imprimimos el máximo promedio encontrado, con 9 decimales
        // ================================
        System.out.println(String.format("%.9f",maximoPago));
    }
}
