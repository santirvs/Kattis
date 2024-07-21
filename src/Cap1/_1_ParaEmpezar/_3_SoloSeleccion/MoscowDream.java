package Cap1._1_ParaEmpezar._3_SoloSeleccion;

import java.util.Locale;
import java.util.Scanner;

public class MoscowDream {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int n = scan.nextInt();

        if (a>0 && b>0 && c>0 && n>2 && a+b+c>=n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}