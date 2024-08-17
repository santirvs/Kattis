package Cap1._2_ProblemasAdHoc._9_Tiempo_Dificiles;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BusySchedule {


 public static class cita implements Comparable<cita> {
        private int hora;
        private int minuto;
        String ampm;

        public int getHora() {
            if (hora==0) return 12;
            else return hora;
        }
        public int getMinuto() {
            return minuto;
        }


        cita(int hora, int minuto, String ampm) {
            this.hora = hora;
            this.minuto = minuto;
            this.ampm = ampm;
            if (hora==12) this.hora=0;
        }

        @Override
        public int compareTo(cita o) {
            if (ampm.equals(o.ampm)) {
                if (hora == o.hora) {
                    return minuto - o.minuto;
                } else {
                    return hora - o.hora;
                }
            } else {
                return (ampm.equals("p.m.") ? 1 : -1);
            }
        }
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de los datos del caso
        int numCitas = scan.nextInt();
        while (numCitas > 0) {

            //Tratar el caso
            ArrayList<cita> citas = new ArrayList<>();
            for (int i = 0; i < numCitas; i++) {
                String tiempo = scan.next();
                String ampm = scan.next();
                int hora = Integer.parseInt(tiempo.split(":")[0]);
                int minuto = Integer.parseInt(tiempo.split(":")[1]);
                citas.add(new cita(hora, minuto, ampm));
            }
            Collections.sort(citas);
            for (cita c : citas) {
                System.out.printf("%d:%02d %s\n", c.getHora(), c.getMinuto(), c.ampm);
            }
            System.out.println();


            //Siguiente caso
            numCitas = scan.nextInt();
        }

    }
}


