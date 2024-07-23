package Cap1._1_ParaEmpezar._8_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class YinAndYangStones {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lee el jugador inicial
       String piedras = scan.next();

        int piedrasBlancas = 0;
        int piedrasNegras = 0;

        for (int i=0; i<piedras.length(); i++) {
            if (piedras.charAt(i) == 'W') piedrasBlancas++;
            if (piedras.charAt(i) == 'B') piedrasNegras++;
        }

        if (piedrasBlancas == piedrasNegras) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
