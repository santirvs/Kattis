package Cap1._2_ProblemasAdHoc._11_Cifrado_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class EncodedMessage {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de los datos del caso
        int numCasos = scan.nextInt();

        while(numCasos > 0) {

            String texto = scan.next();
            int tam = (int) Math.sqrt(texto.length());
            char[][] matriz = new char[tam][tam];
            int cont = 0;

            //Llenar la matriz con el contenido del mensaje
            for (int i=0; i<tam; i++) {
                for (int j=0; j<tam; j++) {
                    matriz[i][j] = texto.charAt(cont);
                    cont++;
                }
            }

            //Imprimir la matriz, rotada 90 grados en sentido antihorario
            for (int i=tam-1; i>=0; i--) {
                for (int j=0; j<tam; j++) {
                    System.out.print(matriz[j][i]);
                }
            }
            System.out.println("");

            numCasos--;
        }
    }
}


