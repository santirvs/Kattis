package Cap1._2_ProblemasAdHoc._6_VidaReal_Medios;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Score {

        public static int tiempoASegundos(String tiempo) {
            String[] partes = tiempo.split(":");
            int segundos = Integer.parseInt(partes[0])*60 + Integer.parseInt(partes[1]);
            return segundos;
        }

        public static String segundosATiempo(int segundos) {
            int minutos = segundos / 60;
            int seg = segundos % 60;
            if (seg < 10)
                return minutos + ":0" + seg;
            else
                return minutos + ":" + seg;
        }

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            scan.useLocale(Locale.ENGLISH);

            //Leer los datos del caso
            int numBaskets = scan.nextInt();
            int tiempoAnterior = 0;
            int puntosHome = 0;
            int puntosAway = 0;
            int tiempoHome = 0;
            int tiempoAway = 0;

            for (int i = 0; i < numBaskets; i++) {
                //Leer los datos de cada basket
                String equipo = scan.next();
                int puntos = scan.nextInt();
                String tiempo = scan.next();
                int tiempoSegundos = tiempoASegundos(tiempo);

                //Mirar el tiempo que ha ido ganando cada equipo
                if (puntosHome > puntosAway) {
                    tiempoHome += tiempoSegundos - tiempoAnterior;
                } else if (puntosAway > puntosHome) {
                    tiempoAway += tiempoSegundos - tiempoAnterior;
                }
                tiempoAnterior = tiempoSegundos;

                //Actualizar la puntuación
                if (equipo.equals("H")) {
                    puntosHome += puntos;
                } else {
                    puntosAway += puntos;
                }

            }

            //Añadir el tiempo restante hasta el final del partido
            int tiempo = tiempoASegundos("32:00");
            if (puntosHome > puntosAway) {
                tiempoHome += tiempo - tiempoAnterior;
            } else if (puntosAway > puntosHome) {
                tiempoAway += tiempo - tiempoAnterior;
            }

            //Mostrar el resultado
            if (puntosHome > puntosAway) {
                System.out.print("H ");
            } else if (puntosAway > puntosHome) {
                System.out.print("A ");
            }
            System.out.println(segundosATiempo(tiempoHome) + " " + segundosATiempo(tiempoAway));


     }

}
