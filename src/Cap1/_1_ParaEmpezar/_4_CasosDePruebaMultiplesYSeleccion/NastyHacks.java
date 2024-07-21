package Cap1._1_ParaEmpezar._4_CasosDePruebaMultiplesYSeleccion;

import java.util.Locale;
import java.util.Scanner;

public class NastyHacks {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            float ingresosSinPublicidad = scan.nextFloat();
            float ingresosConPublicidad = scan.nextFloat();
            float costePublicidad = scan.nextFloat();

            if (ingresosSinPublicidad == (ingresosConPublicidad - costePublicidad))
                System.out.println("does not matter");
            else if (ingresosSinPublicidad > (ingresosConPublicidad - costePublicidad))
                System.out.println("do not advertise");
            else
                System.out.println("advertise");

            numCasos--;
        }




    }
}