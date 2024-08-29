package Cap2._1_EstructurasDatosConBibliotecas._3_ArraysBidimensionales_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class BestCompromise {

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCasos = scan.nextInt();

        while (numCasos>0) {
            int numVectores = scan.nextInt();
            int longVector = scan.nextInt();

            char[][] matriz = new char[numVectores][longVector];

            //Leer los vectores
            for (int f=0; f<numVectores; f++) {
                matriz[f] = scan.next().toCharArray();
            }

            //Analizar la matriz
            char[] resultado = new char[longVector];
            for (int c=0; c<longVector; c++) {
                int numZeros=0;
                int numUnos=0;
                for (int f=0; f<numVectores; f++) {
                    if (matriz[f][c]=='0') numZeros++;
                    else numUnos++;
                }
                if (numZeros>numUnos) resultado[c]='0';
                else resultado[c]='1';
            }


            //Imprimir resultado
            System.out.println(new String(resultado));

            //siguiente caso
            numCasos--;
        }
  }
}