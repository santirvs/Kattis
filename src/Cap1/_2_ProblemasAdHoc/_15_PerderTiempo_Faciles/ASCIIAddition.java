package Cap1._2_ProblemasAdHoc._15_PerderTiempo_Faciles;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ASCIIAddition {
/*
....x.xxxxx.xxxxx.x...x.xxxxx.xxxxx.xxxxx.......xxxxx.xxxxx.xxxxx
....x.....x.....x.x...x.x.....x.........x...o...x...x.x...x.x...x
....x.....x.....x.x...x.x.....x.........x...x...x...x.x...x.x...x
....x.xxxxx.xxxxx.xxxxx.xxxxx.xxxxx.....x.xxxxx.xxxxx.xxxxx.x...x
....x.x.........x.....x.....x.x...x.....x...x...x...x.....x.x...x
....x.x.........x.....x.....x.x...x.....x...x...x...x.....x.x...x
....x.xxxxx.xxxxx.....x.xxxxx.xxxxx.....x.......xxxxx.xxxxx.xxxxx

    El 1 tiene 0,4 y no tiene 0,0
    El 2 tiene 1,4 y no tiene 4,4
    El 3 tiene 0,0; 3,0 y 6;0  pero no tiene 1,0 ni 4,0
    El 4 tiene 0,0 y 0,4 pero no tiene 0,1
    El 5 tiene 1,0  pero no tiene 1,4 ni 4,0
    El 6 tiene 4,0 pero no tiene 1,4
    El 7 tiene 0,0 y 6,4 pero no tiene 3,0
    El 8 los tienes todos!  (default)
    El 9 tiene 1,4 y 6,0 pero no tiene 4,0
    El 0 tiene 3,0 pero no 3,1
    El + tiene 1,2
    */
    public static char caracter(char[][]entrada, int posX) {
        char resultado = 'X';
        if (entrada[0][posX+4]=='x' && entrada[0][posX+0]=='.') resultado = '1';
        else if (entrada[1][posX+4]=='x' && entrada[4][posX+4]=='.') resultado = '2';
        else if (entrada[0][posX+0]=='x' && entrada[3][posX+0]=='x' && entrada[6][posX+0]=='x' &&
                 entrada[1][posX+0]=='.' && entrada[4][posX+0]=='.') resultado = '3';
        else if (entrada[0][posX+0]=='x' && entrada[0][posX+4]=='x' &&  entrada[0][posX+1]=='.') resultado = '4';
        else if (entrada[1][posX+0]=='x' && entrada[1][posX+4]=='.' && entrada[4][posX+0]=='.') resultado = '5';
        else if (entrada[4][posX+0]=='x' && entrada[1][posX+4]=='.') resultado = '6';
        else if (entrada[0][posX+0]=='x' && entrada[6][posX+4]=='x' && entrada[3][posX+0]=='.') resultado = '7';
        else if (entrada[1][posX+4]=='x' && entrada[6][posX+0]=='x' && entrada[4][posX+0]=='.') resultado = '9';
        else if (entrada[3][posX+0]=='x' && entrada[3][posX+1]=='.') resultado = '0';
        else if (entrada[1][posX+2]=='x') resultado = '+';
        else resultado = '8';

        return resultado;
    }

    public static void dibujaSectorH(char[][]tablero, int posX, int posY) {
        for (int i=0; i<5;i++) {
            tablero[posY][posX+i] = 'x';
        }
    }
    public static void dibujaSectorA(char[][]tablero, int posX) {
        dibujaSectorH(tablero, posX, 0);
    }
    public static void dibujaSectorD(char[][]tablero, int posX) {
        dibujaSectorH(tablero, posX, 3);
    }
    public static void dibujaSectorG(char[][]tablero, int posX) {
        dibujaSectorH(tablero, posX, 6);
    }
    public static void dibujaSectorV(char[][]tablero, int posX, int posY) {
        for (int i=0; i<4;i++) {
            tablero[posY+i][posX] = 'x';
        }
    }
    public static void dibujaSectorB(char[][]tablero, int posX) {
        dibujaSectorV(tablero, posX, 0);
    }
    public static void dibujaSectorC(char[][]tablero, int posX) {
        dibujaSectorV(tablero, posX+4, 0);
    }
    public static void dibujaSectorE(char[][]tablero, int posX) {
        dibujaSectorV(tablero, posX, 3);
    }
    public static void dibujaSectorF(char[][]tablero, int posX) {
        dibujaSectorV(tablero, posX+4, 3);
    }

    public static void dibujaSector(char[][]tablero, int posX, char[] sectores ) {
        for (int i=0; i<sectores.length; i++) {
            switch (sectores[i]) {
                case 'a': dibujaSectorA(tablero, posX); break;
                case 'b': dibujaSectorB(tablero, posX); break;
                case 'c': dibujaSectorC(tablero, posX); break;
                case 'd': dibujaSectorD(tablero, posX); break;
                case 'e': dibujaSectorE(tablero, posX); break;
                case 'f': dibujaSectorF(tablero, posX); break;
                case 'g': dibujaSectorG(tablero, posX); break;
            }
        }

    }

    public static void dibuja(char[][]tablero, char digit, int posX ) {
        switch (digit) {
            case '1':
                dibujaSector(tablero, posX, new char[]{'c', 'f'});
                break;
            case '2':
                dibujaSector(tablero, posX, new char[]{'a','c','d','e','g'});
                break;
            case '3':
                dibujaSector(tablero, posX, new char[]{'a','c','d','f','g'});
                break;
            case '4':
                dibujaSector(tablero, posX, new char[]{'b','c','d','f'});
                break;
            case '5':
                dibujaSector(tablero, posX,new char[]{'a','b','d','f','g'});
                break;
            case '6':
                dibujaSector(tablero, posX, new char[]{'a','b','d','e','f','g'});
                break;
            case '7':
                dibujaSector(tablero, posX, new char[]{'a','c','f'});
                break;
            case '8':
                dibujaSector(tablero, posX, new char[]{'a','b','c','d','e','f','g'});
                break;
            case '9':
                dibujaSector(tablero, posX, new char[]{'a','b','c','d','f','g'});
                break;
            case '0':
                dibujaSector(tablero, posX, new char[]{'a','b','c','e','f','g'});
                break;
        }
    }

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer los datos
        String linea1 = scan.nextLine();
        int ancho = linea1.length();
        char[][] entrada = new char[7][ancho];

        entrada[0] = linea1.toCharArray();
        for (int i=1; i<7;i++)
            entrada[i]= scan.nextLine().toCharArray();



        //Interpretar los datos
         int numero = 0;
         int total = 0;
         for (int i=0; i<((ancho/6)+1); i++) {
             char c = caracter(entrada, i*6);

             if (c != '+') numero = numero * 10 + c - '0';
             else {
                 total+=numero;
                 numero = 0;
             }

         }
         total += numero;

         //Imprimir resultado
         String sTotal = "" + total;
         int longResultado = sTotal.length();
         char resultado[][] = new char[7][longResultado*6-1];
         //Construye el tablero del resultado
         for (int j=0; j<7;j++) {
             for (int i = 0; i < longResultado * 6 - 1;i++) {
                 resultado[j][i] = '.';
             }
         }
         //Dibuja cada uno de los dígitos
         for (int i=0; i<longResultado;i++) {
             dibuja(resultado, sTotal.charAt(i), i*6);
         }

         //Mostrar el resultado
         for (int i=0; i<7;i++) {
             for (int j=0; j<resultado[0].length; j++) {
                 System.out.print(resultado[i][j]);
             }
             System.out.println();
         }
    }
}


