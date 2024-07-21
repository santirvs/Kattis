package Cap1._1_ParaEmpezar._3_SoloSeleccion;

import java.util.Locale;
import java.util.Scanner;

public class JudgingMoose {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Scanner scan = new Scanner(System.in);

        int left = scan.nextInt();
        int right = scan.nextInt();

        if (left == right && left != 0) {
            System.out.println("Even " + left*2);
        } else if (left == 0 && right == 0) {
            System.out.println("Not a moose");
        } else {
            System.out.println("Odd " + Math.max(left,right)*2);
        }
    }
}