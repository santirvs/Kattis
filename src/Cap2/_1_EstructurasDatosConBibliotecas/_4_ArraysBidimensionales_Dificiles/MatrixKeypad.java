package Cap2._1_EstructurasDatosConBibliotecas._4_ArraysBidimensionales_Dificiles;

import java.util.*;

public class MatrixKeypad {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);


        int numCasos = scan.nextInt();
        while (numCasos > 0) {
            numCasos--;

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
            Set<Integer> enFilas = new HashSet<Integer>();
            Set<Integer> enColumnas = new HashSet<Integer>();

            for (int i=0; i <alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    if (matriz[i][j] == '1') {
                        enFilas.add(i);
                        enColumnas.add(j);
                    }
                }
            }

            //Buscar casos imposibles
            boolean imposible = false;
            for (int i=0; i<alto && !imposible; i++) {
                for (int j=0; j<ancho && !imposible; j++) {
                    if (matriz[i][j] == '0' && enFilas.contains(i) && enColumnas.contains(j)) {
                        imposible = true;
                    }
                }
            }

            if (imposible) {
                System.out.println("impossible");
            } else {
                for (int i=0; i<alto; i++) {
                    for (int j=0; j<ancho; j++) {
                        if (matriz[i][j] == '0')
                            System.out.print('N');
                        else
                            if (enFilas.size() == 1 || enColumnas.size() == 1)
                                System.out.print('P');
                            else
                                System.out.print('I');
                    }
                    System.out.println();
                }
            }

            //Separador de casos
            System.out.println("----------");


        }

    }
}