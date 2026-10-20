package Others.Easy.Puntuacion_2_0_a_2_9._2_8;

/**
 * Guardar la posición 0 en una lista
 * Mientras la lista no esté vacía
 * - recuperar el primer elemento
 * - marcar la posición como visitada
 * - sumarle a y b mod 360
 * - si el resultado no se ha tenido ya en cuenta, añadirlo a la lista
 * Contar las posiciones visitadas
 *
 */


import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class CompassRotations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int robot1 = sc.nextInt();
        int robot2 = sc.nextInt();
        LinkedList<Integer> lista = new LinkedList<Integer>();

        lista.add(0);
        boolean[] visitados = new boolean[360];
        visitados[0] = true;
        int numVisitados = 1;

        while (!lista.isEmpty()) {
            int posicion = lista.poll();

            int nuevaPosicion = (posicion - robot1 + 360 ) % 360;
            if (!visitados[nuevaPosicion]) {
                lista.add(nuevaPosicion);
                visitados[nuevaPosicion] = true;
                numVisitados++;
            }
            nuevaPosicion = (posicion - robot2 + 360) % 360;
            if (!visitados[nuevaPosicion]) {
                lista.add(nuevaPosicion);
                visitados[nuevaPosicion] = true;
                numVisitados++;
            }
        }

        System.out.println(numVisitados);

    }
}

