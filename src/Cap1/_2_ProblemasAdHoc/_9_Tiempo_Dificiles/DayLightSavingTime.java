package Cap1._2_ProblemasAdHoc._9_Tiempo_Dificiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class DayLightSavingTime {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de los datos del caso
        int numCasos = scan.nextInt();
        while (numCasos > 0) {

            //Tratar el caso
            char direccion = scan.next().charAt(0);
            int cantidad = scan.nextInt();
            int hora = scan.nextInt();
            int minuto = scan.nextInt();

            if (direccion == 'F') {
               minuto+=cantidad;
               if (minuto >= 60) {
                   hora += minuto/60;
                   minuto = minuto%60;
               }
               if (hora >= 24) {
                   hora = hora%24;
               }
            } else {
                minuto-=cantidad;
                if (minuto < 0) {
                    if (minuto%60!=0) hora--;
                    hora -= (minuto/-60);
                    minuto = (minuto%-60);
                    if (minuto<0) {
                        minuto = 60+minuto;
                    }
                }
                if (hora < 0) {
                    hora = 24+(hora%24);
                }
            }

            System.out.println(hora + " " + minuto);

            numCasos--;
        }

    }
}


