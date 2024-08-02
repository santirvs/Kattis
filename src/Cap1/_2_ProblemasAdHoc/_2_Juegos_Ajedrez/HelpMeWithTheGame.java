package Cap1._2_ProblemasAdHoc._2_Juegos_Ajedrez;

import java.util.Collections;
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

        private int tipoToNum(char tipo) {
            switch (tipo) {
                case 'K','k':
                    return 0;
                case 'Q','q':
                    return 1;
                case 'R','r':
                    return 2;
                case 'B','b':
                    return 3;
                case 'N','n':
                    return 4;
                case 'P','p':
                    return 5;
                default:
                    return -1;
            }
        }

        private boolean esBlanca(char tipo) {
            return tipo >= 'A' && tipo <= 'Z';
        }

        public String coordY() {
            return "" + (char)('a' + y - 1);
        }

        public String nomPieza() {
            switch (tipo) {
                case 'K','k':
                    return "K";
                case 'Q','q':
                    return "Q";
                case 'R','r':
                    return "R";
                case 'B','b':
                    return "B";
                case 'N','n':
                    return "N";
                default:
                    return "";
            }
        }
        @Override
        public int compareTo(Pieza o) {
            if (this.tipo != o.tipo) {
                //Orden según el tipo de pieza: K, Q, R, B, N, P
                int tipo1 = tipoToNum(this.tipo);
                int tipo2 = tipoToNum(o.tipo);
                return tipo1 - tipo2;
            } else {
                if (this.y != o.y) {
                    //Orden según la fila (menor a mayor si son blancas y mayor a menor si son negras)
                    if (esBlanca(this.tipo))
                        return this.x - o.x;
                    else
                        return o.x - this.x;
                } else {
                    //Orden según la columna (menor a mayor)
                    if (esBlanca(this.tipo))
                        return this.x - o.x;
                    else
                        return o.x - this.x;
                }
            }

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
             for (int j = 0; j < 8; j++) {
                 char c = linea.charAt(4 * j + 2);
                 switch (c) {
                     case 'K':
                         blancas.add(new Pieza(i, j+1, 'K'));
                         break;
                     case 'Q':
                         blancas.add(new Pieza(i, j+1, 'Q'));
                         break;
                     case 'R':
                         blancas.add(new Pieza(i, j+1, 'R'));
                         break;
                     case 'B':
                         blancas.add(new Pieza(i, j+1, 'B'));
                         break;
                     case 'N':
                         blancas.add(new Pieza(i, j+1, 'N'));
                         break;
                     case 'P':
                         blancas.add(new Pieza(i, j+1, 'P'));
                         break;
                     case 'k':
                         negras.add(new Pieza(i, j+1, 'k'));
                         break;
                     case 'q':
                         negras.add(new Pieza(i, j+1, 'q'));
                         break;
                     case 'r':
                         negras.add(new Pieza(i, j+1, 'r'));
                         break;
                     case 'b':
                         negras.add(new Pieza(i, j+1, 'b'));
                         break;
                     case 'n':
                         negras.add(new Pieza(i, j+1, 'n'));
                         break;
                     case 'p':
                         negras.add(new Pieza(i, j+1, 'p'));
                         break;
                 }
             }

         }

         //Mostrar las piezas
         Collections.sort(blancas);
         Collections.sort(negras);

         System.out.print("White: ");
         for (Pieza p : blancas) {
             if (p != blancas.get(0))
                 System.out.print(",");
             System.out.print("" + p.nomPieza() + p.coordY() + p.x);
         }
         System.out.println();
         System.out.print("Black: ");
         for (Pieza p : negras) {
             if (p != negras.get(0))
                 System.out.print(",");
             System.out.print(p.nomPieza() + p.coordY() + p.x);
         }
         System.out.println();
     }


}



