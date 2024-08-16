package Cap1._2_ProblemasAdHoc._8_Tiempo_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class SavingDayLight {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            scan.useLocale(Locale.ENGLISH);

            //Mientras hayan datos
            while (scan.hasNext()) {
                String[] entrada = scan.nextLine().split(" ");
                String mes = entrada[0];
                int dia = Integer.parseInt(entrada[1]);
                int anyo = Integer.parseInt(entrada[2]);
                String[] horaSalida = entrada[3].split(":");
                String[] horaPuesta = entrada[4].split(":");
                int horaSalidaInt = Integer.parseInt(horaSalida[0]);
                int minutoSalidaInt = Integer.parseInt(horaSalida[1]);
                int horaPuestaInt = Integer.parseInt(horaPuesta[0]);
                int minutoPuestaInt = Integer.parseInt(horaPuesta[1]);

                //Calcular la diferencia de tiempo
                int minutosSalida = horaSalidaInt * 60 + minutoSalidaInt;
                int minutosPuesta = horaPuestaInt * 60 + minutoPuestaInt;
                int diferencia = minutosPuesta - minutosSalida;

                //Calcular la cantidad de horas y minutos
                int horas = diferencia / 60;
                int minutos = diferencia % 60;

                //Mostrar el resultado
                System.out.printf("%s %d %d %d hours %d minutes\n", mes, dia, anyo, horas, minutos);

            }
        }

}
