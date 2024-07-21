package Cap1._1_ParaEmpezar._5_Lineales;

import java.util.Locale;
import java.util.Scanner;

public class SpeedLimit {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            int total = 0;
            int tiempoAnterior = 0;

            while (numCasos > 0) {
                int velocidad = scan.nextInt();
                int tiempo = scan.nextInt();
                total += velocidad * (tiempo - tiempoAnterior);
                tiempoAnterior = tiempo;
                numCasos--;
            }

            System.out.println(total + " miles");

            //Siguiente caso
            numCasos = scan.nextInt();

        }
    }
}