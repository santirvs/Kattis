package Cap2._1_EstructurasDatosConBibliotecas._3_ArraysBidimensionales_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class EpigDanceOff {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int filas = scan.nextInt();
        int columnas = scan.nextInt();
        scan.nextLine();

        //Leer la grabación
        char[][] grabacion = new char[filas][columnas];
        for (int f=0; f<filas; f++) {
            grabacion[f] = scan.nextLine().toCharArray();
        }

        //Analizar la grabación
        //Contar el número de columnas vacías + 1
        int numColumnasVacias=1;
        for (int c = 0; c < columnas; c++) {
            boolean vacia = true;
            for (int f=0; f<filas && vacia; f++) {
                if (grabacion[f][c]=='$') vacia = false;
            }
            if (vacia) numColumnasVacias++;
        }

        //Mostrar el resultado
        System.out.println(numColumnasVacias);

  }
}
