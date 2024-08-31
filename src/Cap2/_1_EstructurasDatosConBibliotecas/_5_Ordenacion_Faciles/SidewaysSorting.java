package Cap2._1_EstructurasDatosConBibliotecas._5_Ordenacion_Faciles;

import java.util.*;

public class SidewaysSorting {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int filas = scan.nextInt();
        int columnas = scan.nextInt();


        //Leer casos
        boolean primero = true;
        while(filas > 0 && columnas > 0) {
            scan.nextLine();
            if (primero) primero = false;
            else System.out.println();

            //Leer la matriz
            char[][] matriz = new char[filas][columnas];
            for (int i = 0; i < filas; i++) {
                matriz[i] = scan.nextLine().toCharArray();
            }

            //Ordenar la matriz por columnas
            ArrayList<String> columnasOrdenadas = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                char[] columna = new char[filas];
                for (int i = 0; i < filas; i++) {
                    columna[i] += matriz[i][j];
                }
                columnasOrdenadas.add(new String(columna));
            }
            Collections.sort(columnasOrdenadas, String.CASE_INSENSITIVE_ORDER);

            //Construir la matriz una vez ordenadas las columnas
            char[][] matrizOrdenada = new char[filas][columnas];
            for (int j = 0; j < columnas; j++) {
                String columna = columnasOrdenadas.get(j);
                for (int i = 0; i < filas; i++) {
                    matrizOrdenada[i][j] = columna.charAt(i);
                }
            }

            //Mostrar la matriz ordenada
            for (int i = 0; i < filas; i++) {
                System.out.println(matrizOrdenada[i]);
            }

            //Leer el siguiente caso
            filas = scan.nextInt();
            columnas = scan.nextInt();

        }

    }
}