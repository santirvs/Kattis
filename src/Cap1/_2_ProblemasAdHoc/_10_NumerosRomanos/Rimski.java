package Cap1._2_ProblemasAdHoc._10_NumerosRomanos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Rimski {



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de los datos del caso
        String numero = scan.next();

        //No se pueden intercambiar decenas y unidades ya que se forman con caracteres diferentes
        //Los únicos casos posibles son:
        //a) acaba en VI, se cambia por IV
        //b) empieza por LX y no por LXX se cambia por XL
        //c) es XI,XXI,LIX,LXXI se cambia por IX, XIX, XLI, XLIX


        if (numero.endsWith("VI")) {
            numero = numero.substring(0, numero.length()-2) + "IV";
        }
        if (numero.startsWith("LX") && !numero.startsWith("LXX")) {
            numero = "XL" + numero.substring(2);
        }
        if (numero.equals("XI")) {
            numero = "IX";
        }
        if (numero.equals("XXI")) {
            numero = "XIX";
        }
        if (numero.equals("LIX")) {
            numero = "XLI";
        }
        if (numero.equals("LXXI")) {
            numero = "XLIX";
        }



        System.out.println(numero);
    }
}


