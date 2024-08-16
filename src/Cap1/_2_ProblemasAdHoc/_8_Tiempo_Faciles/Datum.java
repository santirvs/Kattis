package Cap1._2_ProblemasAdHoc._8_Tiempo_Faciles;


import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Datum {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        String[] dias = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        int dia = scan.nextInt();
        int mes = scan.nextInt();

        GregorianCalendar cal = new GregorianCalendar(2009, mes - 1, dia);
        System.out.println(dias[cal.get(GregorianCalendar.DAY_OF_WEEK)-1]);

    }
}


