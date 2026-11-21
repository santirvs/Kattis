package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Gestionar las raciones con una lista de prioridad
 * Cada vez que coma se comerá la más antigua, excepto si está caducada
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class OvernightOats {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> frigorifico = new PriorityQueue<>();

        int numDias = sc.nextInt();
        int caducidad = sc.nextInt();
        boolean comidaCaducada = false;

        for (int i=0; i<numDias; i++) {
            String accion = sc.next();
            if (accion.equals("ADD")) {
                frigorifico.add(i+caducidad);
            } else if (accion.equals("EAT")) {
                int racion = frigorifico.poll();
                if (racion < i) {
                    comidaCaducada = true;
                }
            }
        }

        if (comidaCaducada) {
            System.out.println("ono..");
        } else {
            System.out.println("yay!");
        }

    }
}