package Others.Easy.Puntuacion_2_0_a_2_9._2_3;

import java.util.Scanner;

public class BestCompressionEver {
    public static void main(String[] args) {
        // Inicializamos el escaner para leer la entrada estándar
        Scanner sc = new Scanner(System.in);

        // Leemos n (número de archivos) y b (tamaño máximo en bits tras la compresión)
        if (sc.hasNextLong()) {
            long n = sc.nextLong();
            long b = sc.nextLong();

            /*
             * CÁLCULO DE LA CAPACIDAD MÁXIMA:
             * La cantidad de cadenas distintas de bits que se pueden representar
             * con longitudes desde 0 hasta b bits es la suma de una serie geométrica:
             * Suma(k=0 hasta b) 2^k = 2^(b + 1) - 1
             *
             * OPERACIÓN DE BITS EN JAVA:
             * Para calcular 2^(b + 1) de forma eficiente usamos el desplazamiento a la izquierda (shift):
             * 1L << (b + 1)
             * Usamos el sufijo 'L' en 1L para forzar a que la operación se realice a nivel de 64 bits (long).
             * Si usáramos '1 << (b + 1)', se calcularía a nivel de 32 bits (int) causando desbordamiento.
             */
            long capacidadMaxima = (1L << (b + 1)) - 1;

            /*
             * VERIFICACIÓN (Principio del palomar):
             * Si el número de archivos 'n' es menor o igual a la cantidad total de cadenas
             * únicas disponibles ('capacidadMaxima'), es teóricamente posible asignar a cada
             * archivo una cadena comprimida distinta.
             */
            if (n <= capacidadMaxima) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        sc.close();
    }
}