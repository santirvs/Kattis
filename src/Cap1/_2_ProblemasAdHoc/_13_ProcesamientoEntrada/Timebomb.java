package Cap1._2_ProblemasAdHoc._13_ProcesamientoEntrada;

import java.util.Locale;
import java.util.Scanner;

public class Timebomb {

    public static int obtenerDigito(String[] lineas, int pos) {
        int resultado = -1;
        int potencia = 1;

        String[] linea = new String[5];

        for (int i=0; i<5; i++) {
            linea[i] = lineas[i].substring(pos, pos+3);
            }

        if (linea[0].equals("***") &&
            linea[1].equals("* *") &&
            linea[2].equals("* *") &&
            linea[3].equals("* *") &&
            linea[4].equals("***")) {
            resultado = 0;
        } else if (linea[0].equals("  *") &&
                   linea[1].equals("  *") &&
                   linea[2].equals("  *") &&
                   linea[3].equals("  *") &&
                   linea[4].equals("  *")) {
            resultado = 1;
        } else if (linea[0].equals("***") &&
                   linea[1].equals("  *") &&
                   linea[2].equals("***") &&
                   linea[3].equals("*  ") &&
                   linea[4].equals("***")) {
            resultado = 2;
        } else if (linea[0].equals("***") &&
                   linea[1].equals("  *") &&
                   linea[2].equals("***") &&
                   linea[3].equals("  *") &&
                   linea[4].equals("***")) {
            resultado = 3;
        } else if (linea[0].equals("* *") &&
                   linea[1].equals("* *") &&
                   linea[2].equals("***") &&
                   linea[3].equals("  *") &&
                   linea[4].equals("  *")) {
            resultado = 4;
        } else if (linea[0].equals("***") &&
                   linea[1].equals("*  ") &&
                   linea[2].equals("***") &&
                   linea[3].equals("  *") &&
                   linea[4].equals("***")) {
            resultado = 5;
        } else if (linea[0].equals("***") &&
                   linea[1].equals("*  ") &&
                   linea[2].equals("***") &&
                   linea[3].equals("* *") &&
                   linea[4].equals("***")) {
            resultado = 6;
        } else if (linea[0].equals("***") &&
                   linea[1].equals("  *") &&
                   linea[2].equals("  *") &&
                   linea[3].equals("  *") &&
                   linea[4].equals("  *")) {
            resultado = 7;
        } else if (linea[0].equals("***") &&
                   linea[1].equals("* *") &&
                   linea[2].equals("***") &&
                   linea[3].equals("* *") &&
                   linea[4].equals("***")) {
            resultado = 8;
        } else if (linea[0].equals("***") &&
                   linea[1].equals("* *") &&
                   linea[2].equals("***") &&
                   linea[3].equals("  *") &&
                   linea[4].equals("***")) {
            resultado = 9;
        }
        return resultado;
    }

    public static int obtenerDigitos(String[] lineas) {
        int resultado = 0;

        for (int i=0; i<lineas[0].length(); i+=4) {
            int digito = obtenerDigito(lineas, i);
            resultado = resultado*10+digito;
            if (digito == -1) {
                return -1;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        String[] lineas = new String[5];
        for (int i=0; i<5; i++) {
            lineas[i] = scan.nextLine();
        }

        //Obtener los dígitos
        int numero = obtenerDigitos(lineas);

        //Mostrar el resultado
        if (numero%6==0)
            System.out.println("BEER!!");
        else
            System.out.println("BOOM!!");

    }
}


