package Cap1._2_ProblemasAdHoc._9_Tiempo_Dificiles;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BirthdayBoy_TLE {

    public static int distanciaFechas(String fecha1, String fecha2) {
        int resultado = 0;

        if (fecha1.compareTo(fecha2) > 0) {
            resultado = distanciaFechas(fecha1, "12-31") + distanciaFechas("01-01", fecha2)+1;
        } else {
            DateFormat sdf = new SimpleDateFormat("MM-dd");
            sdf.setLenient(false);
            try {
                Date date1 = sdf.parse(fecha1);
                Date date2 = sdf.parse(fecha2);
                long diff = date2.getTime() - date1.getTime();
                resultado = (int) (diff / (1000 * 60 * 60 * 24));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return resultado;
    }

    public static String fechaAnterior(String fecha) {
        String resultado = "";
        DateFormat sdf = new SimpleDateFormat("MM-dd");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(fecha);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, -1);
            date = cal.getTime();
            resultado = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de los datos del caso
        int numColegas = scan.nextInt();

        ArrayList<String> fechas = new ArrayList<>();
        for (int i=0; i<numColegas;i++) {
            scan.next(); //Ignorar el nombre
            fechas.add (scan.next());
        }
        Collections.sort(fechas);

        int maxDistancia = 0;
        String fechaEscogida = "";
        String anteriorFecha = fechas.get(fechas.size()-1);  //Obtiene la última fecha de todas para compararla con la primera
        String fechaCandidata = "";
        for (String fecha : fechas) {
            int distancia = distanciaFechas(anteriorFecha, fecha);
            System.err.println("Distancia a " + fecha + " es " + distancia);
            if (distancia > maxDistancia) {
                fechaCandidata = fechaAnterior(fecha);
                if (!fechas.contains(fechaCandidata)) {
                    fechaEscogida = fechaCandidata;
                    maxDistancia = distancia;
                }
            } else if (distancia == maxDistancia) {
                int distancia1= distanciaFechas("10-27",fechaEscogida);
                int distancia2= distanciaFechas("10-27", fecha)-1;
                if (distancia1>distancia2 && distancia2>0) {
                    fechaCandidata = fechaAnterior(fecha);
                    if (!fechas.contains(fechaCandidata)) {
                        fechaEscogida = fechaCandidata;
                    }
                }
            }
            anteriorFecha = fecha;
        }

        //Mostrar resultados
        System.out.println(fechaEscogida);

    }
}
