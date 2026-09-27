package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Recorrer desde la posición 1 hasta la salida
 * en sentido horario y antihorario
 * Contar las cajas que encontramos en cada camino
 * Quedarnos con el itinerario con menos cajas
 */

import java.util.Scanner;

public class Breakout {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numHabitaciones = sc.nextInt();
        int salida = sc.nextInt();
        int numCajas = sc.nextInt();

        //cajas[x] contiene el número de cajas que entre la habitacion x y la x+1
        int[] cajas = new int[numHabitaciones];
        for (int i=0; i<numCajas; i++) {
            cajas[sc.nextInt()-1]++;
        }

        //Recorrido en sentido de las agujas del reloj
        int pos = 1;
        int cajasHorario = 0;
        while (pos != salida) {
            cajasHorario += cajas[pos-1];
            pos++;
        }

        //Recorrido en sentido contrario de las agujas del reloj
        pos = 1;
        int cajasAntiHorario = 0;
        while (pos != salida) {
            pos--;
            if (pos==0) pos = numHabitaciones;
            cajasAntiHorario += cajas[pos-1];
        }

        if (cajasHorario <= cajasAntiHorario) System.out.println(cajasHorario);
        else System.out.println(cajasAntiHorario);


        sc.close();
    }
}