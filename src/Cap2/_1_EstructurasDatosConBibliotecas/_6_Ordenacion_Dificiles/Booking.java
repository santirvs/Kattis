package Cap2._1_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Booking {


    public static class Evento implements Comparable<Evento> {
        int tiempo;
        char tipo;

        public Evento(String fecha, String hora, int tiempoLimpieza, char tipo) {
            this.tiempo = calcularTiempo(fecha, hora, tiempoLimpieza);
            this.tipo = tipo;
        }

        private int calcularTiempo(String fecha, String hora, int tiempoLimpieza) {
            //Calcula el tiempo en minutos desde el 1-1-2013 00:00 hasta la fecha y hora indicada
            //La fecha máxima permitida es 31-12-2016 23:59
            //La fecha llega en formato AAAA-MM-DD y la hora en formato HH:MM
            int[] diasMes = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334}; //acumulado de días al inicio de cada mes
            int tiempo = tiempoLimpieza;

            String[] f = fecha.split("-");
            String[] h = hora.split(":");
            tiempo += (Integer.parseInt(f[0])-2013) * 365 * 24 * 60;
            tiempo += diasMes[Integer.parseInt(f[1])] * 24 * 60;
            tiempo += (Integer.parseInt(f[2])-1) * 24 * 60;
            tiempo += Integer.parseInt(h[0]) * 60;
            tiempo += Integer.parseInt(h[1]);
            if (f[0].equals("2016") && Integer.parseInt(f[1]) >= 3) {
                tiempo += 24 * 60; //Añadir un día por el año bisiesto
            }
            return tiempo;
        }

        @Override
        public int compareTo(Evento o) {
            if (this.tiempo==o.tiempo) {
                return o.tipo - this.tipo ;
            } else {
                return this.tiempo - o.tiempo;
            }
        }

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            int numBookings = scan.nextInt();
            int tiempoLimpieza = scan.nextInt();
            scan.nextLine();

            ArrayList<Evento> eventos = new ArrayList<>();
            for (int i = 0; i < numBookings; i++) {
                String[] booking = scan.nextLine().split(" ");
                eventos.add(new Evento(booking[1], booking[2], 0, 'E'));
                eventos.add(new Evento(booking[3], booking[4], tiempoLimpieza, 'S'));
            }

            //Ordenar los eventos de las reservas
            Collections.sort(eventos);

            //Procesar los eventos
            int numHabitaciones = 0;
            int maxHabitaciones = 0;
            for (Evento e : eventos) {
                if (e.tipo == 'E') {
                    numHabitaciones++;
                } else {
                    numHabitaciones--;
                }
                maxHabitaciones = Math.max(maxHabitaciones, numHabitaciones);
            }

            //Mostrar el resultado
            System.out.println(maxHabitaciones);

            numCasos--;
        }

    }


}