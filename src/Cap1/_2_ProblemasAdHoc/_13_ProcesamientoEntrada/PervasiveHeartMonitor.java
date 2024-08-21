package Cap1._2_ProblemasAdHoc._13_ProcesamientoEntrada;

import java.util.Locale;
import java.util.Scanner;

public class PervasiveHeartMonitor {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Mientras hayan datos en la entrada
        while (scan.hasNext()) {
            String linea = scan.nextLine();
            String[] palabras = linea.split(" ");

            //Separar las palabras en nombre y frecuencias
            String nombre = "";
            double sumaFrecuencias = 0;
            int totalMuestras = 0;
            for (String palabra : palabras) {
                if (palabra.matches("[a-zA-Z]+")) {
                    if (!nombre.equals("")) nombre += " ";
                    nombre += palabra;
                } else {
                    sumaFrecuencias += Double.parseDouble(palabra);
                    totalMuestras++;
                }
            }

            //Imprimir los nombres y las frecuencias
            System.out.println(sumaFrecuencias/totalMuestras + " " + nombre);
        }

    }
}


