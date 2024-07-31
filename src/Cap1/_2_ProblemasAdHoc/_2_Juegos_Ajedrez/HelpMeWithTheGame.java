package Cap1._2_ProblemasAdHoc._2_Juegos_Ajedrez;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class HelpMeWithTheGame {

    static class Pieza implements Comparable<Pieza> {
        int x;
        int y;
        char tipo;

        public Pieza(int x, int y, char tipo) {
            this.x = x;
            this.y = y;
            this.tipo = tipo;
        }

        @Override
        public int compareTo(Pieza o) {

        }
    }
     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         ArrayList<Pieza> blancas = new ArrayList<>();
         ArrayList<Pieza> negras = new ArrayList<>();

         //Leer el tablero
         for (int i = 8; i >= 1; i--) {
             scan.nextLine(); //Descartar el marco
             String linea = scan.nextLine();

             //Procesar la linea
             for (int j = 0; j <= 8; j++) {
                 char c = linea.charAt(5 * j + 2);
                 switch (c) {
                     case 'K':
                         blancas.add(new Pieza(i, j, 'K'));
                         break;
                     case 'Q':
                         blancas.add(new Pieza(i, j, 'Q'));
                         break;
                     case 'R':
                         blancas.add(new Pieza(i, j, 'R'));
                         break;
                     case 'B':
                         blancas.add(new Pieza(i, j, 'B'));
                         break;
                     case 'N':
                         blancas.add(new Pieza(i, j, 'N'));
                         break;
                     case 'P':
                         blancas.add(new Pieza(i, j, 'P'));
                         break;
                     case 'k':
                         negras.add(new Pieza(i, j, 'k'));
                         break;
                     case 'q':
                         negras.add(new Pieza(i, j, 'q'));
                         break;
                     case 'r':
                         negras.add(new Pieza(i, j, 'r'));
                         break;
                     case 'b':
                         negras.add(new Pieza(i, j, 'b'));
                         break;
                     case 'n':
                         negras.add(new Pieza(i, j, 'n'));
                         break;
                     case 'p':
                         negras.add(new Pieza(i, j, 'p'));
                         break;
                 }
             }

         }

         //Mostrar las piezas
         blancas.sort();

         //FALTA TENER EN CUENTA EL ORDEN!!!!
         System.out.println("White: ");
         for (Pieza p : blancas) {
             System.out.println(p.tipo + " " + p.x + " " + p.y);
         }
         System.out.println("Black: ");
         for (Pieza p : negras) {
             System.out.println(p.tipo + " " + p.x + " " + p.y);
         }
     }


}



