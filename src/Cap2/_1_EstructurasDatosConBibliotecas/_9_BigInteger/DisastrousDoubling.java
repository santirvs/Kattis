package Cap2._1_EstructurasDatosConBibliotecas._9_BigInteger;

import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;

public class DisastrousDoubling {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numExperimentos = scan.nextInt();
        BigInteger bacterias = new BigInteger("1");
        while (numExperimentos > 0) {
            numExperimentos--;

            //Se duplican las bacterias
            bacterias = bacterias.multiply(BigInteger.valueOf(2));

            //Leemos el número de bacterias necesarias para el experimento
            //y las restamos al número de bacterias existentes
            String numero = scan.next();
            BigInteger numeroB = new BigInteger(numero);
            bacterias = bacterias.subtract(numeroB);

            //Si el número de bacterias es negativo, el experimento ha fallado
            if (bacterias.compareTo(BigInteger.ZERO) < 0) {
                System.out.println("error");
                return;
            }

        }
        //Imprimimos el número de bacterias
        System.out.println(bacterias.mod(BigInteger.valueOf(1_000_000_007)));
    }

}
