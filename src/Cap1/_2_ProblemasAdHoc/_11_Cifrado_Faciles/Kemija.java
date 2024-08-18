package Cap1._2_ProblemasAdHoc._11_Cifrado_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class Kemija {



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de los datos del caso
        String texto = scan.nextLine();

        String resultado = texto.replace("apa", "a");
        resultado = resultado.replace("epe", "e");
        resultado = resultado.replace("ipi", "i");
        resultado = resultado.replace("opo", "o");
        resultado = resultado.replace("upu", "u");

        //Mostrar el resultado
        System.out.println(resultado);

    }
}


