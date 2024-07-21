package Cap1._1_ParaEmpezar._3_SoloSeleccion;

import java.util.Locale;
import java.util.Scanner;

public class QuadrantSelection {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int x = scan.nextInt();
        int y = scan.nextInt();
        int quadrant = 0;

        if (x>0 && y>0) quadrant = 1;
        else if (x<0 && y>0) quadrant = 2;
        else if (x<0 && y<0) quadrant = 3;
        else quadrant = 4;

        System.out.println(quadrant);
    }
}