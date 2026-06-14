package Others.Medium.Puntuacion_3_0_a_3_9._3_1;

/*
    v1. Supongo que el tiempo de los ladridos llega ordenado
     Los apunto en una cola.
     Al llegar un ladrido miro si el primer perro de la lista ya ha terminado de respirar
     si ha respirado, lo saco y vuelvo a poner en la cola con tiempo k+instante
     sino, necesito un nuevo perro que pondré en la cola con tiempo k+instante
     Al final, el tamaño de la cola es el número de perros necesarios
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Voff {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numLadridos = scan.nextInt();
        int k = scan.nextInt();
        LinkedList<Integer> cola = new LinkedList<>();


        while (numLadridos-- > 0) {
            int instante = scan.nextInt();
            if (!cola.isEmpty() && cola.peek() <= instante) {
                cola.pop();
            }
            cola.addLast(instante + k);
        }

        //El resultado es el tamaño de la cola
        System.out.println(cola.size());

        scan.close();
    }
}