package Cap1._1_ParaEmpezar._3_SoloSeleccion;

import java.util.Locale;
import java.util.Scanner;

public class TimeTravellingTemperatures {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        float X = scan.nextFloat();
        float Y = scan.nextFloat();

        //Formula
        if (X == 0 && Y == 1) {
            System.out.println("ALL GOOD");
        } else if (Y == 1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(X / (1 - Y));
        }

    }
}