package Cap1._1_ParaEmpezar._5_Lineales;

import java.util.Locale;
import java.util.Scanner;

public class JobExpenses {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();
        int totalGastos =0 ;
        for (int i=0; i<numCasos; i++) {
            int valor = scan.nextInt();
            if (valor < 0) {
                totalGastos -= valor;
            }
        }
        System.out.println(totalGastos);

    }
}