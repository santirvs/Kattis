package Others.Medium.Puntuacion_3_0_a_3_9._3_5;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 1000 entradas, no es necesario FastReader
 *
 * Usar una cola de prioridad, donde usaremos el tiempo en el que termina.
 * Usaremos siempre el USB que termine antes.
 */


public class ComputerImaging {

    static class Flash implements Comparable<Flash> {
        int duracion;
        int instanteFinal;

        Flash(int duracion) {
            this.duracion = duracion;
            this.instanteFinal = duracion;
        }

        @Override
        public int compareTo(Flash o) {
            int result = Integer.compare(this.instanteFinal, o.instanteFinal);

            if (result==0) {
                result = Integer.compare(this.duracion, o.duracion);
            }

            return result;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Declarar la cola con prioridad
        PriorityQueue<Flash> pq = new PriorityQueue<>();

        //Leer los datos
        int numOrdenadores = sc.nextInt();
        int numUSBs = sc.nextInt();

        //Leer las duraciones, crear los USBs y añadirlos a la cola
        for (int i=0; i<numUSBs; i++) {
            int duracion = sc.nextInt();
            pq.add(new Flash(duracion));
        }

        //Usar numOrdenadores USBs (uno para clonar cada ordenador)
        //El USB que usemos lo volvemos a insertar en la cola
        int tiempoTotal = 0;
        for (int i=0; i<numOrdenadores; i++) {
            Flash f = pq.poll();
            tiempoTotal = f.instanteFinal;
            f.instanteFinal += f.duracion;
            pq.add(f);
        }

        //Mostrar el resultado
        System.out.println(tiempoTotal);

    }
}
