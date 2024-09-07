package Cap2._1_EstructurasDatosConBibliotecas._8_ManipulacionBits;

import java.util.Locale;
import java.util.Scanner;

//Contar el valor de bits a 1 de un número que se va escribiendo de izquierda a derecha

public class Bits {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            numCasos--;

            //Leemos el número
            int numero = scan.nextInt();
            int maxBits = 0;
            int cantidadCifras = (int)Math.log10(numero)+1;
            for (int i=1; i<=cantidadCifras;i++) {
                //Me quedo con las i primeras cifras
                int numeroAux = numero / (int) Math.pow(10,cantidadCifras-i);
                //Contamos los bits a 1 del número
                maxBits = Math.max(maxBits, Integer.bitCount(numeroAux));
            }
            //Imprimir el resultado
            System.out.println(maxBits);
        }

    }

}
