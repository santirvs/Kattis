package Cap3._3_DivideYVenceras._3_BusquedaTernariaYOtros;

// Estrategia de D&C. Búsqueda ternaria y otros
/*
Parece más un problema ad-hoc que uno de divide y vencerás.

Enfoque ingenuo:
    Usar una función recursiva para generar un papel A1, llamándose a sí misma dos veces
    para crear 2 papeles del siguiente tamaño más pequeño si es necesario.
    O(2^n), esto no es práctico.

Observación 1:
    Mirando el enfoque ingenuo, notamos que podemos simplemente acumular el número requerido
    de cada tamaño de papel a medida que progresamos de un papel a otro.
    Hacemos esto añadiendo un parámetro "cantidad" a nuestra función. Intentamos tomar tantos
    papeles ya hechos del tamaño objetivo como sea posible. Si no tenemos suficientes, fabricamos
    el doble de papeles del tamaño más pequeño que necesitamos del tamaño objetivo.
    De esta forma, cada nodo en el árbol de recursión solo tiene 1 hijo en lugar de 2.
    Esto resulta en complejidad lineal en lugar de exponencial.

Tiempo: O(n), Memoria: O(n)
*/

import java.io.*;
import java.util.*;

public class A1Paper {

    static int numTamanyos;
    // Como máximo tendremos 30 tamaños (A1 a A30), pero reservamos 33 para evitar problemas de índices. A0 es dummy.
    static int[] cantHojas = new int[33]; // papers[i] = número de papeles Ai disponibles, papers[0] = papers[1] = 0
    static double[] ladosLargos = new double[33];
    static boolean posible = true;

    // tamanyoObjetivo = tamaño de papel deseado, cantidad = cantidad
    static double costFor(int tamanyoObjetivo, int cantidad) {
        if (tamanyoObjetivo > numTamanyos) { // necesitamos un papel más pequeño que el mínimo que tenemos
            posible = false;
            return 0;
        }

        if (cantHojas[tamanyoObjetivo] >= cantidad) { // tomamos el papel directamente si es posible
            return 0;
        }
        if (cantHojas[tamanyoObjetivo] > 0) {
            cantidad -= cantHojas[tamanyoObjetivo]; // usamos primero todos los papeles disponibles
        }

        // si no, fabricamos el papel usando los del siguiente tamaño. El coste es el del largo del papel
        // más el coste de fabricar los papeles del siguiente tamaño (2 * cantidad porque necesitamos 2 papeles)
        return costFor(tamanyoObjetivo + 1, cantidad * 2) + cantidad * ladosLargos[tamanyoObjetivo + 1];
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        // Lectura del número de tamaños y cantidad de papeles disponibles de cada tamaño
        numTamanyos = scan.nextInt();

        // Inicializar el lado largo del papel A1
        ladosLargos[1] = 0.8408964152537146;
        final double sqrt2 = Math.sqrt(2);

        // Leer las cantidades de papeles disponibles y calcular los lados largos de cada tamaño
        for (int i = 2; i <= numTamanyos; i++) {
            cantHojas[i] = scan.nextInt();
            ladosLargos[i] = ladosLargos[i - 1] / sqrt2;
        }

        // Calcular el coste (en tira adhesiva) para fabricar un papel A1
        double cost = costFor(1, 1); // coste para fabricar un papel A1
        if (posible) {
            System.out.printf("%.10f%n", cost);
        } else {
            System.out.println("impossible");
        }
    }

}
