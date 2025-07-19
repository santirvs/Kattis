package Cap2._2_EstructurasDatosConBibliotecas._8_ManipulacionBits;

import java.util.Locale;
import java.util.Scanner;

//Contar la posición de un número en la secuencia de bits de Gray
//A cada bit que se añade, la longitud de la secuencia se dobla

//Caso #8: WA --> cambio a long. 60 bits es mucho mayor que 2^31 --> AC

public class Hypercube {


    public static long dist(int n, String s) {
        long res = 0;

        if (n == 0) {
            return 0;
        }
        if (s.charAt(0) == '0')
            return dist(n - 1, s.substring(1));
        if (s.charAt(0) == '1')
            //La distancia es 2^n - distancia(n-1, s[1:]) - 1
            return (long) (Math.pow(2, n)) - dist(n - 1, s.substring(1)) - 1;

        //Aquí no llegará nunca
        return 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int longitud = scan.nextInt();

        String a = scan.next();
        String b = scan.next();

        System.out.println(dist(longitud, b) - dist(longitud, a) - 1);
    }

}

