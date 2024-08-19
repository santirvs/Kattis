package Cap1._2_ProblemasAdHoc._12_Cifrado_Medios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ANewAlphabet {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        ArrayList<String> alfabeto = new ArrayList<String>(Arrays.asList(
                "@", "8", "(", "|)", "3", "#", "6", "[-]", "|", "_|", "|<", "1", "[]\\/[]",
                "[]\\[]", "0", "|D", "(,)", "|Z", "$", "']['", "|_|", "\\/", "\\/\\/", "}{", "`/", "2"));

        //Leer los datos del caso
        String mensaje = scan.nextLine().toLowerCase();

        for (int i=0; i<mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            if (letra >= 'a' && letra <= 'z')
                System.out.print(alfabeto.get(letra - 'a'));
            else
                System.out.print(letra);
        }
        System.out.println();


    }
}


