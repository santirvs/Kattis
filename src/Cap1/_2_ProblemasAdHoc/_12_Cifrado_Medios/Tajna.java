package Cap1._2_ProblemasAdHoc._12_Cifrado_Medios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Tajna {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer los datos
        String mensaje = scan.nextLine();

        //Determinar el tamaño de la matriz
        int tam = mensaje.length();
        int filas =0;
        int columnas = 0;
        for (int i = 1; i <= tam; i++) {
            if (tam % i == 0 && i <= tam / i) {
                filas = i;
                columnas = tam / i;
            }
        }

        //Rellenar la matriz.
        //El mensaje encriptado se obtuvo recorriendo la matriz por columnas
        char[][] matriz = new char[filas][columnas];

        //Recorrer la matriz por columnas
        for (int j=0; j<columnas; j++) {
            for (int k=0; k<filas; k++) {
                matriz[k][j] = mensaje.charAt(j*filas + k);
            }
        }

        //Mostrar el mensaje desencriptado
        //Recorrer la matriz por filas
        for (int j=0; j<filas; j++) {
            for (int k=0; k<columnas; k++) {
                System.out.print(matriz[j][k]);
            }
        }
        System.out.println();


    }
}


