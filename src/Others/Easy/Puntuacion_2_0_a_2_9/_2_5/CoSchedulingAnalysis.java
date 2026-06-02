package Others.Easy.Puntuacion_2_0_a_2_9._2_5;

import java.util.*;

public class CoSchedulingAnalysis {

    static class Rango implements Comparable {
        int tiempo;
        char tipo;

        Rango(int time, char type) {
            this.tiempo = time;
            this.tipo = type;
        }

        @Override public int compareTo(Object o) {
            Rango ro = (Rango) o;
            if (this.tiempo != ro.tiempo) {
                return this.tiempo - ro.tiempo;
            }
            return this.tipo - ro.tipo;
        }
    }

    public static void overlap(List<Rango> data) {
        int maxOverlap = 0;
        int count = 0;
        Collections.sort(data);
        for (Rango p:data) {
            if (p.tipo == 'e') count++;
            if (p.tipo == 's') count--;
            if (count > maxOverlap) maxOverlap = count;
        }

        int lastMaxOverlap = 0;
        int iniTiempoOverlap = 0;
        int finTiempoOverlap = 0;
        int totalTiempoOverlap = 0;
        int timeMax = 0;
        count = 0;
        for (Rango p:data) {
            if (p.tipo == 'e') {
                count++;
                //if (count == maxOverlap) lastMaxOverlap = p.tiempo;
                if (count == 2) iniTiempoOverlap = p.tiempo;
                if (count >= 2) finTiempoOverlap = p.tiempo;
            }
            if (p.tipo == 's') {
                //if (count == maxOverlap) timeMax += (p.tiempo - lastMaxOverlap) +1;
                count--;
                if (count >=2) finTiempoOverlap = p.tiempo;
                if (count == 1) {
                    finTiempoOverlap = p.tiempo;
                    totalTiempoOverlap += finTiempoOverlap - iniTiempoOverlap +1;
                }
            }
        }

        //System.out.println(maxOverlap + " " + timeMax);
        System.out.println(totalTiempoOverlap);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Rango> lista = new ArrayList<>();

        int numHilos = sc.nextInt();
        for (int i=0; i<numHilos; i++) {
            int numRangos = sc.nextInt();
            for (int j=0; j<numRangos; j++) {
                int inicia = sc.nextInt();
                int finaliza = sc.nextInt()-1;

                lista.add(new Rango(inicia, 'e'));
                lista.add(new Rango(finaliza, 's'));
            }
        }

        overlap(lista);

    }
}
