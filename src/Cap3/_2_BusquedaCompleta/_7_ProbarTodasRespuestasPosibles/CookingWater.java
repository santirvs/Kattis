package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;

import java.util.Scanner;

// Realmente sólo hay dos posibles respuestas: Sí o No
// Lo que nos preguntan es si todos los periodos se solapan entre sí en algún momento
// Eso ocurrirá si el periodo que empieza más tarde comienza antes de que termine el periodo que termina más pronto


public class CookingWater {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de ollas
        int numOllas = sc.nextInt();
        int maxInicio = Integer.MIN_VALUE;
        int minFin = Integer.MAX_VALUE;

        for (int i = 0; i < numOllas; i++) {
            // Leer el inicio y fin de cada olla
            int inicio = sc.nextInt();
            int fin = sc.nextInt();

            // Actualizar el maximo inicio y mínimo fin
            maxInicio = Math.max(maxInicio, inicio);
            minFin = Math.min(minFin, fin);
        }

        // Si el periodo que empieza más tarde comienza antes de que termine el periodo que termina más pronto
        // entonces todos los periodos se solapan entre sí
        if (maxInicio <= minFin) {
            // Si que se solapan, Gunilla tiene razón
            System.out.println("gunilla has a point");
        } else {
            // No se solapan, edward tiene razón
            System.out.println("edward is right");
        }

    }
}
