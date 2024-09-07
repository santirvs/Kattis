package Cap2._1_EstructurasDatosConBibliotecas._8_ManipulacionBits;

import java.util.Locale;
import java.util.Scanner;

//Cada ocelot representa un 1 y cada zebra representa un 0
//Con ello conseguimos un número binaria de hasta 60 bits -->  2^60 necesitaremos un long
//El primer bit es el más significativo, por lo que construimos el número de izquierda a derecha


public class ZebrasAndOcelots {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        long resultado = 0;

        int longitud = scan.nextInt();
        for (int i=0; i<longitud; i++) {
            //Leemos el caracter
            String caracter = scan.next();
            //Desplazamos el número a la izquierda (multiplicar por 2)
            resultado = resultado << 1;
            if (caracter.equals("O")) {
                //Si hay un Ocelote, se añade un 1
                resultado +=1;
            }
        }
        //Imprimimos el resultado
        System.out.println(resultado);
    }

}

