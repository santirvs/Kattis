package Cap1._2_ProblemasAdHoc._11_Cifrado_Faciles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ReverseRot {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        ArrayList<Character> alfabeto =  new ArrayList<Character>( Arrays.asList(
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z', '_', '.') );

        //Lectura de los datos del caso
        int rot = scan.nextInt();

        while (rot > 0) {
            String mensaje = scan.next();
            String resultado = "";

            for(int i = 0; i < mensaje.length(); i++) {
                char letra = mensaje.charAt(i);
                int pos = alfabeto.indexOf(letra);
                pos = (pos + rot) % alfabeto.size();
                resultado += alfabeto.get(pos);
            }

            //Mostrar el resultado
            System.out.println(new StringBuilder(resultado).reverse().toString());

            //Siguiente caso
            rot = scan.nextInt();
        }

    }
}


