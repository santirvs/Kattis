package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Transformar a segundos desde la medianoche
// Si el segundo periodo es inferior al primero --> añadir 24 horas
// Restar uno del otro

import java.util.Scanner;

public class EverySecondCounts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inicio = sc.nextLine();
        String fin = sc.nextLine();

        int segInicio = timeToSeconds(inicio);
        int segFin = timeToSeconds(fin);

        //Si pasa de medianoche, añadir 24h
        if (segFin < segInicio) segFin += 24*60*60;

        //Mostrar resultado
        System.out.println(segFin - segInicio);

    }

    private static int timeToSeconds(String instante) {
        String[] hora = instante.split(" : ");

        int horas = Integer.parseInt(hora[0]);
        int minutos = Integer.parseInt(hora[1]);
        int segundos = Integer.parseInt(hora[2]);

        return horas*60*60 + minutos*60 + segundos;
    }
}
