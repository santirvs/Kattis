package Cap1._2_ProblemasAdHoc._14_FormatoSalida;

import java.util.Locale;
import java.util.Scanner;

public class MirrorImages {

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer el numero de casos
        int numCasos = scan.nextInt();
        scan.nextLine();
        int caso = 0;

        while (caso < numCasos) {
            caso++;
            int r = scan.nextInt();
            int c = scan.nextInt();
            scan.nextLine();

            //Leer la matriz
            char[][] matriz = new char[r][c];
            for (int i=0; i<r; i++) {
                matriz[i] = scan.nextLine().toCharArray();
            }

            //Flip horizontal
            for (int i=0; i<r/2; i++) {
                for (int j=0; j<c; j++) {
                    char aux = matriz[i][j];
                    matriz[i][j]= matriz[r-1-i][j];
                    matriz[r-1-i][j] = aux;
                }
            }

            //Flip vertical
            for (int i=0; i<c/2; i++) {
                for (int j=0; j<r; j++) {
                    char aux = matriz[j][i];
                    matriz[j][i]= matriz[j][c-1-i];
                    matriz[j][c-1-i] = aux;
                }
            }

            //Mostrar el resultado
            System.out.println("Test "+ caso);
            for (int i=0; i<r; i++) {
                for (int j=0; j<c; j++) {
                    System.out.print(matriz[i][j]);
                }
                System.out.println();
            }

        }
    }
}


