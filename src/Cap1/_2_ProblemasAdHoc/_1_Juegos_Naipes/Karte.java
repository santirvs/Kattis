package Cap1._2_ProblemasAdHoc._1_Juegos_Naipes;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class Karte {

    public static final String UP = "UP";
     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Creación de la baraja
         int [][] baraja = new int[4][13];
         for (int i=0; i<4; i++)
             baraja[i] = new int[13];

         //Leer las cartas
         String cartas = scan.next();

         //Interpretar las cartas
         int index=0;

         while (index<cartas.length()) {
             char palo = cartas.charAt(index);
             String numero = cartas.substring(index+1, index+3);
             int num = Integer.parseInt(numero);
             index+=3;

             //Añadir la carta a la baraja
            switch (palo) {
                case 'P':
                    baraja[0][num-1]++;
                    break;
                case 'K':
                    baraja[1][num-1]++;
                    break;
                case 'H':
                    baraja[2][num-1]++;
                    break;
                case 'T':
                    baraja[3][num-1]++;
                    break;
            }
         }

        //Revisar si hay cartas repetidas
         for (int palo=0; palo <4; palo++) {
             for (int num=0; num<13; num++) {
                 if (baraja[palo][num]>1) {
                     System.out.println("GRESKA");
                     return;
                 }
             }
         }

         //No hay cartas repetidas, mostrar las cartas que faltan de cada palo
            for (int palo=0; palo <4; palo++) {
                int faltan = 13;
                for (int num=0; num<13; num++) {
                    if (baraja[palo][num]>0) {
                        faltan--;
                    }
                }
                if (palo > 0) System.out.print(" ");
                System.out.print(faltan);
            }

         System.out.println();

    }
}



