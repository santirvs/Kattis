package Cap2._2_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class LongSwaps {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        String palabra = scan.next();
        int k = scan.nextInt();

        //HINT: observation: if k ≤ n/2, output 'Yes'; otherwise the middle chars at s[n-k..k-1] cannot move; sort s and compare the ...
        int n = palabra.length();
        if (k <= n/2) {
            System.out.println("Yes");
        } else {
            //Ordenar la palabra
            char[] s = palabra.toCharArray();
            Arrays.sort(s);
            //Comprobar si el rango [n-k..k-1] de la palabra es igual a la palabra ordenada
            boolean ok = true;
            for (int i = n-k; i <= k-1 && ok; i++) {
                if (palabra.charAt(i) != s[i]) {
                    ok = false;
                }
            }
            if (ok) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }


}