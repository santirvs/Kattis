package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SpidermansWorkout_TLE {

    static class Opcion implements Comparable<Opcion> {
        int paso;
        String secuencia;
        int alturaMax;
        int alturaActual;

        Opcion(int paso, String secuencia, int alturaMax, int alturaActual) {
            this.paso = paso;
            this.secuencia = secuencia;
            this.alturaMax = Math.max(alturaMax, alturaActual);
            this.alturaActual = alturaActual;
        }

        @Override
        public int compareTo(Opcion o) {
            return Integer.compare(this.alturaMax, o.alturaMax);
        }
    }

    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();

        while (numCasos-- > 0) {

            int numPasos = scan.nextInt();

            //Leer los pasos
            int[] pasos = new int[numPasos];
            for (int i=0; i<numPasos; i++) {
                pasos[i] = scan.nextInt();
            }

            //El primer paso siempre será hacia arriba
            PriorityQueue<Opcion> pq = new PriorityQueue<>();
            pq.add( new Opcion(1,"U", pasos[0], pasos[0]));
            String secuencia = "IMPOSSIBLE";
            int alturaMaxima = Integer.MAX_VALUE;

            while (!pq.isEmpty()) {
                //Recuperar la opcion más baja
                Opcion o = pq.poll();
                //Supera la máxima altura de la mejor solución hasta ahora?
                if (o.alturaMax >= alturaMaxima) {
                    //Ignorar la opción. No mejorará la mejor solución hasta ahora
                }
                //Es la última posición ?
                else if (o.paso == numPasos) {
                    //Se ha llegado a la altura máxima?
                    if (o.alturaActual == 0) {
                        //Se ha conseguido con una altura menor?
                        if (o.alturaMax < alturaMaxima) {
                            alturaMaxima = o.alturaMax;
                            secuencia = o.secuencia;
                        }
                    }
                } else {
                    //No estoy en la última posición,
                    //Añadir las dos posibles opciones (arriba o abajo)
                    int distancia = pasos[o.paso];
                    Opcion arriba = new Opcion(o.paso + 1, o.secuencia + "U",  o.alturaMax, o.alturaActual + distancia);
                    Opcion abajo = new Opcion(o.paso + 1, o.secuencia + "D", o.alturaMax, o.alturaActual - distancia);

                    //Limitar la solución por arriba a la máxima altura de alguna solución encontrada
                    if (arriba.alturaMax < alturaMaxima)
                        pq.add(arriba);
                    //Limitar la solución por abajo a la una altura inferior a 0
                    if (abajo.alturaActual >= 0)
                        pq.add(abajo);
                }
            }

            System.out.println(secuencia);

        }

    }
}