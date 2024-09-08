package Cap2._1_EstructurasDatosConBibliotecas._9_BigInteger;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class ThreePowers {

      public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Calcular las 65 primeras potencias de 3
        BigInteger[] potencias = new BigInteger[65];
        potencias[0] = BigInteger.ONE;
        for (int i=1; i<65; i++) {
            potencias[i] = potencias[i-1].multiply(BigInteger.valueOf(3));
        }

        //Lectura de datos
        BigInteger numero = new BigInteger(scan.nextLine());

        while (numero.compareTo(BigInteger.ZERO) != 0) {

            //Restar 1 al número ya que la posición 1 es la que tiene valor 0 (suma de ningún elemento)
            numero = numero.subtract(BigInteger.ONE);
            //Pasamos el número a binario
            String binario = numero.toString(2);

            //Analizamos el número binario para saber qué potencias de 3 se han de sumar
            boolean primero = true;
            System.out.print("{ ");
            for (int i=binario.length()-1; i >=0; i--) {
                if (binario.charAt(i) == '1') {
                    //Imprimimos la potencia de 3 correspondiente
                    if (!primero) System.out.print(", ");
                    else primero=false;
                    System.out.print(potencias[binario.length()-1-i]);
                }
            }
            System.out.println(" }");
            numero = new BigInteger(scan.nextLine());
        }

    }

}
