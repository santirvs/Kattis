package Cap2._1_EstructurasDatosConBibliotecas._10_Pila;

import java.util.Locale;
import java.util.Scanner;

//Para hacer esto no es necesaria una pila...

public class ReversedBinaryNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numero = scan.nextInt();
        String numeroBin = Integer.toBinaryString(numero);
        String numeroBinInvertido = new StringBuilder(numeroBin).reverse().toString();
        int numeroInvertido = Integer.parseInt(numeroBinInvertido, 2);
        System.out.println(numeroInvertido);


    }

}
