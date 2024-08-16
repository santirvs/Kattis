package Cap1._2_ProblemasAdHoc._9_Tiempo_Dificiles;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class BestBefore {


    public static boolean isValid(String dateStr, String format) {
        DateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de los datos del caso
        String[] fecha = scan.next().split("/");

        //Obtener todas las permutaciones de la fecha
        ArrayList<String> permutaciones = new ArrayList<>();
        int piezaA = Integer.parseInt(fecha[0]);
        int piezaB = Integer.parseInt(fecha[1]);
        int piezaC = Integer.parseInt(fecha[2]);

        permutaciones.add(String.format("%02d/%02d/%04d", piezaA, piezaB, piezaC<2000?2000+piezaC:piezaC));
        permutaciones.add(String.format("%02d/%02d/%04d", piezaA, piezaC, piezaB<2000?2000+piezaB:piezaB));
        permutaciones.add(String.format("%02d/%02d/%04d", piezaB, piezaA, piezaC<2000?2000+piezaC:piezaC));
        permutaciones.add(String.format("%02d/%02d/%04d", piezaB, piezaC, piezaA<2000?2000+piezaA:piezaA));
        permutaciones.add(String.format("%02d/%02d/%04d", piezaC, piezaA, piezaB<2000?2000+piezaB:piezaB));
        permutaciones.add(String.format("%02d/%02d/%04d", piezaC, piezaB, piezaA<2000?2000+piezaA:piezaA));

        //Probar las permutaciones válidas y quedarme con la menor
        Calendar cal = Calendar.getInstance();
        cal.set(9999,Calendar.DECEMBER,31);
        Date earlyDate = cal.getTime();
        for (String permutacion : permutaciones) {
            if (isValid(permutacion, "dd/MM/yyyy")) {
                int year = Integer.parseInt(permutacion.split("/")[2]);
                int month= Integer.parseInt(permutacion.split("/")[1]);
                int day= Integer.parseInt(permutacion.split("/")[0]);
                cal.set(year, month-1, day);
                Date date = cal.getTime();
                if (date.before(earlyDate)) {
                    earlyDate = date;
                }
            }
        }
        cal.setTime(earlyDate);
        if (cal.get(Calendar.YEAR) < 9999) {
            System.out.printf("%04d-%02d-%02d\n", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
        } else {
            System.out.println(fecha[0] + "/" + fecha[1] + "/" + fecha[2] + " is illegal");
        }


    }
}


