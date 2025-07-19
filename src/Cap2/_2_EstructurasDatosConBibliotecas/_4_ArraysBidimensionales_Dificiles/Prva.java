package Cap2._2_EstructurasDatosConBibliotecas._4_ArraysBidimensionales_Dificiles;

import java.util.*;

public class Prva {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);


        //Lectura de datos
        int alto = scan.nextInt();
        int ancho = scan.nextInt();
        scan.nextLine();

        //Definir la matriz
        char[][] matriz = new char[alto][ancho];

        //Leer la matriz
        for (int i = 0; i < alto; i++) {
            matriz[i] = scan.nextLine().toCharArray();
        }

        //Analizar la matriz
        ArrayList<String> palabras = new ArrayList<String>();
        //Horizontales
        for (int i=0; i <alto; i++) {
            String palabra = "";
            for (int j = 0; j < ancho; j++) {
                if (matriz[i][j] == '#') {
                    if (palabra.length() > 1) {
                        palabras.add(palabra);
                    }
                    palabra = "";
                } else {
                    palabra += matriz[i][j];
                }
            }
            if (palabra.length() > 1) {
                palabras.add(palabra);
            }
        }
        //Verticales
        for (int j=0; j<ancho; j++) {
            String palabra = "";
            for (int i = 0; i < alto; i++) {
                if (matriz[i][j] == '#') {
                    if (palabra.length() > 1) {
                        palabras.add(palabra);
                    }
                    palabra = "";
                } else {
                    palabra += matriz[i][j];
                }
            }
            if (palabra.length() > 1) {
                palabras.add(palabra);
            }
        }

        //Ordenar las palabras
        Collections.sort(palabras);

        //Imprimir la 1a palabra
        System.out.println(palabras.get(0));

    }
}