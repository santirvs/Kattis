package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

// Problema de IntervalCovering

public class AirConditionedMinions {

    static public class Range implements Comparable {
        int min;
        int max;

        Range(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override public int compareTo(Object o) {
            Range ro = (Range) o;
            if (this.max != ro.max)
                return this.max - ro.max;
            else
                return this.min - ro.min;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numMinions = scan.nextInt();
        int numRooms = 0;
        int maxRoom = -100;
        List<Range> rangos = new ArrayList<>();

        for (int i=0; i<numMinions; i++) {
            int min = scan.nextInt();
            int max = scan.nextInt();

            //Necesitamos los rangos ordenados!!
            rangos.add(new Range(min, max));
        }

        //Ordena la colección
        Collections.sort(rangos);

        //Recorrer los rangos ordenados
        for (Range r : rangos) {
            if (r.min > maxRoom) {
                //Se necesita una nueva habitacion
                numRooms++;
                //La nueva habitación podrá tener minions que soporten hasta r.max grados
                maxRoom = r.max;
            }
        }

        //El resultado lo tenemos en numRooms
        System.out.println(numRooms);


    }
}