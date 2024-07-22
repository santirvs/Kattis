package Cap1._1_ParaEmpezar._6_Funcion;

import java.util.Locale;
import java.util.Scanner;

public class Filip {

   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int a = scan.nextInt();
        int b = scan.nextInt();

        int aInvertido = Integer.parseInt(new StringBuilder().append(a).reverse().toString());
        int bInvertido = Integer.parseInt(new StringBuilder().append(b).reverse().toString());

        if (aInvertido > bInvertido) {
            System.out.println(aInvertido);
        }
        else {
            System.out.println(bInvertido);
        }


    }
}
