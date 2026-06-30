package Others.Medium.Puntuacion_2_0_a_2_9._2_9;

// Apuntar en un array de minutos la necesidad de trenes (-1) y la disponibilidad (+1)
// según el horario de salidas y llegadas (más el tiempo de turnaround)
// Necesitaré dos arrays: uno para las salidas desde A y otro para las salidas desde B
// Acumular los resultados de cada array y quedarnos con el mínimo --> ese será el número necesario de trenes
// que deben haber en cada estación para asegurarnos que podemos cumplir con los horarios

// v1: RTE  --> comprobar que no nos salgamos de los límites del día

import java.util.Scanner;

public class TrainTimetables {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();

        for (int caso=1; caso <= numCasos; caso++) {

            int numTrenesA =0;
            int numTrenesB =0;

            int turnaround = scan.nextInt();
            int numViajesAB = scan.nextInt();
            int numViajesBA = scan.nextInt();

            int[] salidasA = new int[24*60];
            int[] salidasB = new int[24*60];

            //Leer las salidas desde A
            for (int i=0;i<numViajesAB;i++) {
                int horaSalida = traduceHora(scan.next());
                int horaLlegada = traduceHora(scan.next());
                salidasA[horaSalida]--;
                if (horaLlegada+turnaround < 24*60)
                    salidasB[horaLlegada+turnaround]++;
            }

            //Leer las salidas desde B
            for (int i=0;i<numViajesBA;i++) {
                int horaSalida = traduceHora(scan.next());
                int horaLlegada = traduceHora(scan.next());
                salidasB[horaSalida]--;
                if (horaLlegada+turnaround < 24*60)
                    salidasA[horaLlegada+turnaround]++;
            }

            //Acumular los valores de A y B
            numTrenesA = salidasA[0];
            numTrenesB = salidasB[0];
            for (int i=1; i<24*60; i++) {
                salidasA[i] += salidasA[i-1];
                salidasB[i] += salidasB[i-1];
                numTrenesA = Math.min(numTrenesA, salidasA[i]);
                numTrenesB = Math.min(numTrenesB, salidasB[i]);
            }


            //Mostrar el resultado
            System.out.println("Case #" + caso + ": " + -numTrenesA + " " + -numTrenesB);
        }
    }

    private static int traduceHora(String hora) {
        int resultado = 0;

        String[] valores = hora.split(":");
        resultado = Integer.parseInt(valores[0]) * 60 + Integer.parseInt(valores[1]);

        return resultado;
    }
}
