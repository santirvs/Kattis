package Cap1._2_ProblemasAdHoc._13_ProcesamientoEntrada;

import java.util.Locale;
import java.util.Scanner;

public class TripleTexting {

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        String mensaje = scan.nextLine();
        int longitud = mensaje.length()/3;

        for (int i=0; i < longitud; i++) {
            //Se necesitan dos caracteres iguales para asegurar el caracter correcto
            if (mensaje.charAt(i) == mensaje.charAt(i + longitud) || mensaje.charAt(i) == mensaje.charAt(i + longitud * 2)) {
                System.out.print(mensaje.charAt(i));
            } else
                //Solo puede ser que el segundo sea igual al tercero
                System.out.print(mensaje.charAt(i + longitud));
        }

    }
}


