package Cap1._2_ProblemasAdHoc._13_ProcesamientoEntrada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Autori {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos de entrada
        String autores = scan.nextLine();

        //Separar los nombres de los autores
        String[] nombres = autores.split("-");

        //Imprimir las iniciales de los nombres
        for (String nombre : nombres) {
            System.out.print(nombre.charAt(0));
        }

        System.out.println();

    }
}


