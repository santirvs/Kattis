package Cap1._2_ProblemasAdHoc._11_Cifrado_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class CryptographersConundrum {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        String per = "PER";

        //Lectura de los datos del caso
        String texto = scan.next();
        int numDias = 0;

        //Recorre el texto buscando qué letras no coinciden con la palabra PER
        //Cada vez que no coincida, se incrementa el número de días
        for (int i=0; i<texto.length(); i++) {
            if (texto.charAt(i) != per.charAt(i%3)) {
                numDias++;
            }
        }

        //Mostrar el resultado
        System.out.println(numDias);

    }
}


