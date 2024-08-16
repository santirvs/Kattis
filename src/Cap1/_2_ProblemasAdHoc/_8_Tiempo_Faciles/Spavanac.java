package Cap1._2_ProblemasAdHoc._8_Tiempo_Faciles;


import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Spavanac {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int hora = scan.nextInt();
        int minutos = scan.nextInt();

        //Restar 45 minutos
        minutos -= 45;
        if (minutos < 0) {
            minutos += 60;
            hora--;
        }
        if (hora < 0) {
            hora = 23;
        }

        //Mostrar el resultado
        System.out.println(hora + " " + minutos);

    }
}


