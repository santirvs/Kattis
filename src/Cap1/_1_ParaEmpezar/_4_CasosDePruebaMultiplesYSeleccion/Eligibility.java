package Cap1._1_ParaEmpezar._4_CasosDePruebaMultiplesYSeleccion;

import java.util.Locale;
import java.util.Scanner;

public class Eligibility {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            String nombre = scan.next();
            int anyoInicio = Integer.parseInt(scan.next().split("/")[0]);
            int anyoNacimiento = Integer.parseInt(scan.next().split("/")[0]);
            int cursos = scan.nextInt(); scan.nextLine();

            if (anyoInicio >= 2010 || anyoNacimiento >= 1991)
                System.out.println(nombre + " eligible");
            else if (cursos > 40)
                System.out.println(nombre + " ineligible");
            else
                System.out.println(nombre + " coach petitions");

            numCasos--;
        }


    }
}