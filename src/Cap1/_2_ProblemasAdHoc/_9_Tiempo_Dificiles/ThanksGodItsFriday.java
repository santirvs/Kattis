package Cap1._2_ProblemasAdHoc._9_Tiempo_Dificiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ThanksGodItsFriday {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        ArrayList<String> dias = new ArrayList<>(Arrays.asList("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"));
        ArrayList<String> meses = new ArrayList<>(Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"));
        ArrayList<Integer> diasMes = new ArrayList<>(Arrays.asList(31,28,31,30,31,30,31,31,30,31,30,31));

        //Lectura de los datos del caso
        int dia = scan.nextInt();
        int mes = meses.indexOf(scan.next());
        int diaSemana = dias.indexOf(scan.next());

        //Calcular el dia actual dentro del año
        int diaActual = dia;
        for (int i = 0; i < mes; i++) {
            diaActual += diasMes.get(i);
        }

        //Calcular el dia de la semana
        int diaSemanaActual = (diaSemana + diaActual - 1) % 7;

        //Imprimir el resultado
        //Si es viernes y estamos en enero o febrero, podemos asegurar que es viernes
        if (diaSemanaActual == dias.indexOf("FRI") && (mes <= meses.indexOf("FEB"))) {
            System.out.println("TGIF");
        } else if (mes >= meses.indexOf("MAR") && (diaSemanaActual == dias.indexOf("FRI") || diaSemanaActual == dias.indexOf("THU"))) {
            //Si es viernes o jueves y estamos en marzo o después, podemos es posible que hoy sea viernes (depende de si el año es bisiesto)
            System.out.println("not sure");
        } else {
            //En cualquier otro caso, no es viernes
            System.out.println(":(");
        }

    }
}


