package Cap1._2_ProblemasAdHoc._12_Cifrado_Medios;

import java.util.Locale;
import java.util.Scanner;

public class SecretMessage {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer los datos del caso
        int numCasos = scan.nextInt();
        scan.nextLine();

        while (numCasos>0) {
            String mensaje = scan.nextLine();

            //Definir la matriz cuadrada
            int tam = mensaje.length();
            int tamCuadrado = (int) Math.ceil(Math.sqrt(tam));
            char[][] matriz = new char[tamCuadrado][tamCuadrado];

            //Rellenar la matriz
            int i=0;
            for (; i<mensaje.length(); i++) {
                matriz[i/tamCuadrado][i%tamCuadrado] = mensaje.charAt(i);
            }
            for (; i<tamCuadrado*tamCuadrado; i++) {
                matriz[i/tamCuadrado][i%tamCuadrado] = '*';
            }

            //Recorrer la matriz en orden inverso
            for (int j=0; j<tamCuadrado; j++) {
                for (int k=tamCuadrado-1; k>=0; k--) {
                    if (matriz[k][j] != '*')
                        System.out.print(matriz[k][j]);
                }
            }
            System.out.println();

            numCasos--;
        }

    }
}


