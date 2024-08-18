package Cap1._2_ProblemasAdHoc._10_NumerosRomanos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

 // Pasa 10 de los 13 casos.
 // Casos límite:
/*
2000 -> 1890
1000 -> 945
1005 -> -108
2038 -> -109
2005 -> -162
2038 -> -109
5 -> -54
38 ->  -1
1038 ->  -55
1005 ->  -108
2038 ->   -109
2005 -> -162
3038 -> -163
3005 -> -216
4038 -> -217
4005 ->  -270
1000 ->  945
1001 ->  1846
1100 -> 946
2000 -> 1890
2100 -> 1891
3000 -> 2835
3100 -> 2836
 */

public class RomanHolidays_WA {

    public static String decimalToRoman(int n) {
        String[] roman = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] decimal = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String res = "";
        for (int i = 12; i >= 0; i--) {
            while (n >= decimal[i]) {
                res += roman[i];
                n -= decimal[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Preparar un array con los números romanos del 1 al 1000 y ordenarlos
        ArrayList<String> romanos = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            romanos.add(decimalToRoman(i));
        }
        Collections.sort(romanos);


        //Leer el número de casos
        int numCasos = scan.nextInt();

        for (int i = 0; i < numCasos; i++) {
            int numero = scan.nextInt();
            String numeroRomano = decimalToRoman(numero);
            int numMs = numero / 1000;

            numeroRomano = numeroRomano.substring(numMs);
            int pos = romanos.indexOf(numeroRomano);
            int posM = romanos.indexOf("M");

            if (numeroRomano.startsWith("X") || numeroRomano.startsWith("V")) {
                //Posición relativa al final
                pos = (pos-1) - 1000;
            }

            //Añadir los milenios
            if (numMs>0 && pos>=-1) {
                pos += (numMs) * posM;
            }
            else if (numMs>0) {
                pos -= (numMs) * (1000-(posM+1));
            }

            System.out.println(pos + 1);
        }
    }
}


