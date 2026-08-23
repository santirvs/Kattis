package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

/**
 * Contar los tiempos muertos entre clases
 * Mostrar el mínimo
 */

import java.util.Scanner;

public class BreakingIsBad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numHorarios = sc.nextInt();
        sc.nextLine();

        int minTiempo = Integer.MAX_VALUE;

        for (int i=0; i<numHorarios; i++) {
            String[] horas = sc.nextLine().split(" ");
            int tiempoMuerto=0;

            for (int j=1; j<horas.length; j++) {
                String horaInicio = horas[j].split("-")[0];
                String horaFinal = horas[j-1].split("-")[1];

                int minutoInicio = minuto(horaInicio);
                int minutoFin = minuto(horaFinal);

                tiempoMuerto += minutoInicio - minutoFin;
            }

            minTiempo = Math.min(minTiempo, tiempoMuerto);
        }

        System.out.println(minTiempo);
    }

    private static int minuto(String horaInicio) {
        int hora = Integer.parseInt(horaInicio.split(":")[0]);
        int min = Integer.parseInt(horaInicio.split(":")[1]);

        return hora*60 + min;
    }
}
