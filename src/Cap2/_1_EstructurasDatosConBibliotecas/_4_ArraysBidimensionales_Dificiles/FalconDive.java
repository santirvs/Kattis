package Cap2._1_EstructurasDatosConBibliotecas._4_ArraysBidimensionales_Dificiles;

import java.util.Locale;
import java.util.Scanner;

public class FalconDive {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int alto = scan.nextInt();
        int ancho = scan.nextInt();
        String caracter = scan.nextLine().trim();
        char halcon = caracter.charAt(1);

        //Definir las matrices
        char[][] imagen1 = new char[alto][ancho];
        char[][] imagen2 = new char[alto][ancho];
        char[][] fondo = new char[alto][ancho];
        char[][] silueta1 = new char[alto][ancho];
        char[][] silueta2 = new char[alto][ancho];


        //Leer las dos imagenes
        for (int i = 0; i < alto; i++) {
            imagen1[i] = scan.nextLine().toCharArray();
        }
        scan.nextLine();
        for (int i = 0; i < alto; i++) {
            imagen2[i] = scan.nextLine().toCharArray();
        }

        //Analizar la imagen1, construir el fondo y la silueta1
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (imagen1[i][j] == halcon) {
                    silueta1[i][j] = halcon;
                } else {
                    fondo[i][j] = imagen1[i][j];
                }
            }
        }

        //Analizar la imagen2, construir la silueta2
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (imagen2[i][j] == halcon) {
                    silueta2[i][j] = halcon;
                } else {
                    fondo[i][j] = imagen2[i][j];
                }
            }
        }

        //Analizar las dos siluetas del halcon
        //Ambas estan completas. Bastará con buscar la primera posición en la silueta1 y en la silueta 2
        // y calcular la diferencia de posiciones.
        int i1 = 0;
        int j1 = 0;
        int i2 = 0;
        int j2 = 0;
        boolean encontrado = false;

        for (int i = 0; i < alto && !encontrado; i++) {
            for (int j = 0; j < ancho && !encontrado; j++) {
                if (silueta1[i][j] == halcon) {
                    i1 = i;
                    j1 = j;
                    encontrado = true;
                }
            }
        }

        encontrado = false;

        for (int i = 0; i < alto && !encontrado; i++) {
            for (int j = 0; j < ancho && !encontrado; j++) {
                if (silueta2[i][j] == halcon) {
                    i2 = i;
                    j2 = j;
                    encontrado = true;
                }
            }
        }

        //Calcular la diferencia de posiciones
        int difI = i2 - i1;
        int difJ = j2 - j1;

        //Dibujar la silueta2 desplazada sobre el fondo
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (silueta2[i][j] == halcon) {
                    if (i + difI >= 0 && i + difI < alto && j + difJ >= 0 && j + difJ < ancho) {
                        fondo[i + difI][j + difJ] = halcon;
                    }
                }
            }
        }

        //Imprimir el resultado
        for (int i = 0; i < alto; i++) {
            System.out.println(fondo[i]);
        }

    }
}