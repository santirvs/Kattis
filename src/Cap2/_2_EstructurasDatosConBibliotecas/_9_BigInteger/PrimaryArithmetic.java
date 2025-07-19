package Cap2._2_EstructurasDatosConBibliotecas._9_BigInteger;

import java.util.Locale;
import java.util.Scanner;

//No veo por donde usar los BigInteger...
//La idea es alinear los números a la derecha y sumar uno por uno contando los que sumen más de 10
//Es necesario tener en cuenta el acarreo ya que 5+4+1 cambia el acarreo de 5+4

public class PrimaryArithmetic {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        while (true) {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();

            if (num1==0 && num2==0) break;
            int acarreos = 0;
            boolean carry = false;

            while (num1 > 0 || num2 > 0) {
                //Sumamos los dígitos más el carry
                int suma = num1%10 + num2%10 + (carry?1:0);
                //Si la suma es mayor o igual a 10, hay acarreo
                if (suma >= 10) {
                    //Aumentamos el contador de acarreos
                    acarreos++;
                    carry = true;
                }
                else carry = false;

                num1 = num1/10;
                num2 = num2/10;
            }
            //Imprimir el resultado
            if (acarreos == 0) System.out.println("No carry operation.");
            else if (acarreos == 1) System.out.println("1 carry operation.");
            else System.out.println(acarreos + " carry operations.");
        }

    }

}
