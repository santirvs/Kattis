package Cap1._2_ProblemasAdHoc._8_Tiempo_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class JustAMinute {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            scan.useLocale(Locale.ENGLISH);

            //Lectura de los datos del caso
            int numCasos = scan.nextInt();

            int totalMinutos = 0;
            double  totalSegundos = 0;

            for (int i = 0; i < numCasos; i++) {
               int numMinutos = scan.nextInt();
               int numSegundos = scan.nextInt();
               totalMinutos += numMinutos;
               totalSegundos += numSegundos;
            }

            double minutosReales = totalSegundos / 60.0;
            double media = minutosReales / totalMinutos;

            if (media <= 1) {
                System.out.println("measurement error");
            } else {
                System.out.printf("%.9f\n",media);
            }
        }

}
