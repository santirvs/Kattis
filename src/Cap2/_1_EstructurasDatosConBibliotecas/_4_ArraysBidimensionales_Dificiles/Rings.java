package Cap2._1_EstructurasDatosConBibliotecas._4_ArraysBidimensionales_Dificiles;

import java.util.Locale;
import java.util.Scanner;

public class Rings {


    public static boolean asignarAnillo(char[][] matriz, int anillo) {
        int alto = matriz.length;
        int ancho = matriz[0].length;
        boolean pendientes = false;

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (matriz[i][j] == 'T' && definirAnillo(matriz, i, j) == anillo) {
                    matriz[i][j] = (char) anillo;
                    pendientes = true;
                }
            }
        }

        return pendientes;
    }

    public static char valorAnillo(char[][] matriz, int i, int j, int alto, int ancho) {
        if (i < 0 || i >= alto || j < 0 || j >= ancho) {
            return 0;
        } else if (matriz[i][j] == ':') {
            return 0;
        } else if (matriz[i][j] == 'T') {
            return 255;
        } else {
            return matriz[i][j];
        }
    }



    public static char definirAnillo(char[][] matriz, int i, int j) {
        char anillo;
        int alto = matriz.length;
        int ancho = matriz[0].length;

        //Buscar en las 4 casillas adyacentes el menor valor del anillo
        anillo = valorAnillo(matriz, i - 1, j, alto, ancho);
        anillo = (char) Math.min(valorAnillo(matriz, i + 1, j, alto, ancho), anillo);
        anillo = (char) Math.min(valorAnillo(matriz, i, j-1, alto, ancho), anillo);
        anillo = (char) Math.min(valorAnillo(matriz, i, j+1, alto, ancho), anillo);

        return (char) (anillo+1);
    }

    public static void imprimir(char car, int numDigitos) {
        for (int i = 0; i < numDigitos; i++) {
            System.out.print(car);
        }
    }

    public static void imprimir(int num, int numDigitos) {
        String numStr = Integer.toString(num);
        int numEspacios = numDigitos - numStr.length();

        for (int i = 0; i < numEspacios; i++) {
            System.out.print('.');
        }

        System.out.print(numStr);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int alto = scan.nextInt();
        int ancho = scan.nextInt();
        scan.nextLine();

        //Definir la matriz
        char[][] matriz = new char[alto][ancho];

        //Leer el tablero
        //Reemplazar '.' por ':' para poder usar los anillos con ASCII del 1 al 50
        for (int i = 0; i < alto; i++) {
            String linea = scan.nextLine().replace('.', ':');
            matriz[i] = linea.toCharArray();
        }

        //Analizar la matriz
        int anillos = 0;
        boolean quedanPendientes;

        do {
            anillos++;
            quedanPendientes = asignarAnillo(matriz, anillos);
        } while (quedanPendientes);

        //Imprimir la matriz resultante
        int numDigitos = anillos < 10 ? 2 : 3;

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (matriz[i][j] == ':') {
                    imprimir('.',numDigitos);
                } else {
                    imprimir((int)(matriz[i][j]),numDigitos);
                }
            }
            System.out.println();
        }


    }
}