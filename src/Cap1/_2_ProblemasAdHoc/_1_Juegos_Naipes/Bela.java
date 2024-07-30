package Cap1._2_ProblemasAdHoc._1_Juegos_Naipes;

import java.util.Locale;
import java.util.Scanner;

public class Bela {

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Datos del caso
        int manos = scan.nextInt() * 4;  //Hay 4 jugadores
        char paloDominante = scan.next().charAt(0);
        int totalPuntos = 0;

        //Leer las manos
         for (int i=0; i<manos;i++) {
            String mano = scan.next();
            switch (mano.charAt(0)) {
                case 'A':
                    totalPuntos += 11;
                    break;
                case 'K':
                    totalPuntos += 4;
                    break;
                case 'Q':
                    totalPuntos += 3;
                    break;
                case 'T':
                    totalPuntos += 10;
                    break;
                case 'J':  //Si es la carta dominante
                    if (mano.charAt(1) == paloDominante) {
                        totalPuntos += 20;
                    } else {
                        totalPuntos += 2;
                    }
                    break;
                case '9':  //Si es la carta dominante
                    if (mano.charAt(1) == paloDominante) {
                        totalPuntos += 14;
                    }
                    break;
            }

         }

         //Mostrar el resultado
         System.out.println(totalPuntos);

    }
}



