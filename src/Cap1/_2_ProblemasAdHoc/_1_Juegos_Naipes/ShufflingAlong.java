package Cap1._2_ProblemasAdHoc._1_Juegos_Naipes;

import java.util.Locale;
import java.util.Scanner;

public class ShufflingAlong {


    public static boolean barajasIguales(int[] baraja, int[] barajaOriginal) {
        for (int i = 0; i < baraja.length; i++) {
            if (baraja[i] != barajaOriginal[i]) {
                return false;
            }
        }
        return true;
    }

    public static void barajar(int[]baraja, String tipo) {

        //Si la baraja tiene un número impar de cartas, la primera mitad tendrá una carta más en caso de out-shuffle
        //
        int x,y;
        if (tipo.equals("out")) {
            x = baraja.length%2;
            y = 0;
        } else {
            x = 0;
            y = baraja.length%2;
        }

        //Dividir la baraja en dos mitades
        int[] primeraMitad = new int[baraja.length/2 + x];
        int[] segundaMitad = new int[baraja.length/2 + y];

        for (int i=0; i<baraja.length; i++) {
            if (i < primeraMitad.length) {
                primeraMitad[i] = baraja[i];
            } else {
                segundaMitad[i-primeraMitad.length] = baraja[i];
            }
        }

        if (tipo.equals("out")) {
            //Barajar (out-shuffle)
            for (int i = 0; i < baraja.length; i++) {
                if (i % 2 == 0) {
                    baraja[i] = primeraMitad[i / 2];
                } else {
                    baraja[i] = segundaMitad[i / 2];
                }
            }
        }
        else {
            //Barajar (in-shuffle)
            for (int i = 0; i < baraja.length; i++) {
                if (i % 2 == 0) {
                    baraja[i] = segundaMitad[i / 2];
                } else {
                    baraja[i] = primeraMitad[i / 2];
                }
            }
        }

    }

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Datos del caso
        int cartas = scan.nextInt();
        String tipo = scan.next();

        //Simular dos barajas de cartas
         int[] barajaOriginal = new int[cartas];
         int[] baraja = new int[cartas];
         for (int i=0; i<cartas; i++) {
             baraja[i] = i;
             barajaOriginal[i] = i;
         }

         //Barajar hasta que las cartas estén en su posición original
         int numShuffles=0;
         do {
             barajar(baraja, tipo);
             numShuffles++;
         } while (!barajasIguales(baraja, barajaOriginal));

         System.out.println(numShuffles);
    }
}



