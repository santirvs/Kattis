package Cap2._1_EstructurasDatosConBibliotecas._8_ManipulacionBits;

import java.util.Locale;
import java.util.Scanner;

//Cada byte son 8 bits, por lo que al final de cada caracter o los dos botones están pulsados o los dos estan liberados
//Basta con contar los 1s de cada caracter y si es par, se imprime free, si es impar, se imprime trapped

//Caso 2: WA --> El planteamiento anterior no es correcto!!
//               Está contemplando sólo el ASCII de 7 bits!, con lo que deben contarse 0s y 1s y comprobar que ambos sean pares
//           --> AC


public class iBoard {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        while (scan.hasNext()) {
            char[] frase = scan.nextLine().trim().toCharArray();

            //Contar los bits a 1
            int bits1 = 0;
            int bits0 = 0;
            for (int i = 0; i < frase.length; i++) {
                bits1 += Integer.bitCount(frase[i]);
                bits0 += 7 - Integer.bitCount(frase[i]);
            }

            //Mostrar el resultado
            if (bits1 % 2 == 0 && bits0 %2 == 0) {
                System.out.println("free");
            } else {
                System.out.println("trapped");
            }
        }
    }

}

