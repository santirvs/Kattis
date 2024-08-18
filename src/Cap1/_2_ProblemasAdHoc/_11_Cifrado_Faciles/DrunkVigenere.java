package Cap1._2_ProblemasAdHoc._11_Cifrado_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class DrunkVigenere {



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de los datos del caso
        String texto = scan.nextLine();
        String clave = scan.nextLine();

        String resultado = "";
        for (int i=0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            char letraClave = clave.charAt(i % clave.length());
            int nuevaPos = 0;
            if (i%2==0)
                nuevaPos = ((letra - 'A') - (letraClave - 'A'));
            else
                nuevaPos = ((letra - 'A' + (letraClave - 'A')));

            if (nuevaPos < 0)
                nuevaPos += 26;
            nuevaPos = nuevaPos % 26;

            resultado += (char) ('A' + nuevaPos);
        }

        //Mostrar el resultado
        System.out.println(resultado);

    }
}


