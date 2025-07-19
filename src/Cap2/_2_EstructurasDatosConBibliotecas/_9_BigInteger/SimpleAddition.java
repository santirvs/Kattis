package Cap2._2_EstructurasDatosConBibliotecas._9_BigInteger;

import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;

public class SimpleAddition {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        String num1 = scan.next();
        String num2 = scan.next();

        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger(num2);
        BigInteger result;

        //Hacer la suma
        result = b1.add(b2);

        //Mostrar el resultado
        System.out.println(result);
    }

}
