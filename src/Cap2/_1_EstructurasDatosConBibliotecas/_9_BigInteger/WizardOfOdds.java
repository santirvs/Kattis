package Cap2._1_EstructurasDatosConBibliotecas._9_BigInteger;

import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;

public class WizardOfOdds {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        String num1 = scan.next();
        String num2 = scan.next();

        BigInteger n = new BigInteger(num1);
        BigInteger k = new BigInteger(num2);

        //Hay que realizar una búsqueda binaria y no es necesario simularla sino
        //unicamente calcular su coste: log2 n

        //2^350 > MAX_N  (10^101)
        if (k.compareTo(BigInteger.valueOf(350)) > 0) {
            //tenemos más intentos de los que necesitaríamos para el número más grande posible
            System.out.println("Your wish is granted!");
        } else if (BigInteger.valueOf(2).pow(k.intValue()).compareTo(n) >= 0) {
            //tenemos más intentos de los necesarios haciendo una búsqueda binaria
            System.out.println("Your wish is granted!");
        } else {
            //No tenemos suficientes intentos
            System.out.println("You will become a flying monkey!");
        }
    }

}
