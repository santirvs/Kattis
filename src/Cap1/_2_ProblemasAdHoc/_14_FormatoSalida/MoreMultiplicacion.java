package Cap1._2_ProblemasAdHoc._14_FormatoSalida;

import java.util.Locale;
import java.util.Scanner;

public class MoreMultiplicacion {

    public static void pintaMargenHorizontal(char[][] tablero, int fila) {
        tablero[fila][0] = '+';
        for (int i=1; i<tablero[0].length-1;i++)
            tablero[fila][i] = '-';
        tablero[fila][tablero[0].length-1] = '+';
    }

    public static void pintaMargenVertical(char[][] tablero, int fila) {
        tablero[fila][0] = '|';
        tablero[fila][tablero[0].length-1] = '|';
    }

    public static void pintaCeldas(char[][] tablero, int fila, int columnas ) {
         int posY = 2 + fila*4;
         for (int j=posY ; j< posY+5; j++) {
             for (int i = 2; i < tablero[0].length - 2; i++) {
                 char c = ' ';
                 if (((i - 2) % 4) == 0 && (j == posY || j == posY + 4)) c = '+';
                 else if (((i - 2) % 4) != 0 && (j == posY || j == posY + 4)) c = '-';
                 else if (((i - 2) % 4) == 0 && j != posY && j != posY + 4) c = '|';
                 else if ( (i-2)%4 + (j-2)%4 == 4 ) c = '/';

                 tablero[j][i] = c;
             }
         }
    }

    public static char[][] nuevoTablero(char[] num1, char[] num2) {
        int alto = 2+1+(num2.length*4)+2;
        int ancho = 2+1+(num1.length*4)+2;
        char[][] tablero = new char[alto][ancho];

        //Inicializar a espacios
            for (int i=0; i<alto;i++) {
                for (int j=0; j<ancho; j++) {
                    tablero[i][j]=' ';
                }
            }

        //Pinta el margen exterior
        pintaMargenHorizontal(tablero,0);
        for (int i=1; i<alto-1;i++)
            pintaMargenVertical(tablero, i);
        pintaMargenHorizontal(tablero, alto-1);

        //Pinta las celdas
        for (int i=0; i<num2.length; i++) {
            pintaCeldas(tablero, i, num1.length);
        }

        return tablero;
    }

    public static void colocarPrimerNumero(char[][]tablero,char[] numero) {
        for (int i=0; i<numero.length; i++) {
            tablero[1][4+4*i] = numero[i];
        }
    }

    public static void colocarSegundoNumero(char[][]tablero, char[] numero) {
        for (int i=0; i<numero.length; i++) {
            tablero[4+4*i][tablero[0].length-2] = numero[i];
        }
    }

    public static void escribirCelda(char[][]tablero, int resultado, int fila, int columna) {
        int posY = 3+fila*4;
        int posX = 3+columna*4;
        tablero[posY][posX] = (char)('0'+resultado/10);
        tablero[posY+2][posX+2] = (char)('0'+resultado%10);
    }

    public static void multiplicarCeldas(char[][]tablero, char[] num1, char[] num2) {
        for (int i=0; i<num1.length; i++) {
            for (int j=0; j<num2.length; j++) {
                int resultado = Integer.parseInt("" + num1[i]) * Integer.parseInt(""+num2[j]);
                escribirCelda(tablero, resultado, j, i);
            }
        }
    }

    public static void multiplicarValores(char[][]tablero, char[]num1, char[] num2) {

        int resultado = Integer.parseInt(new String(num1)) * Integer.parseInt(new String(num2));

        int posX = tablero[0].length-6;
        int posY = tablero.length-2;
        int deltaX = 4;
        int deltaY = 0;
        boolean blnPrimero = true;

        while (resultado > 0) {
            //Imprime la barra separadora
            if (!blnPrimero) {
                tablero[posY + deltaY / 2][posX + deltaX / 2] = '/';
            } else
                blnPrimero = false;

            //Imprime el digito
            tablero[posY][posX]= (char)('0'+resultado%10);

            //Siguiente valor y coordenadas
            resultado = resultado/10;
            if (posX == 3) {
                posX = 1;
                posY = posY +2;
                deltaX = 0;
                deltaY = 4;
            }
            posX = posX - deltaX;
            posY = posY - deltaY;

        }
    }
     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);


        String snum1 = scan.next();
        String snum2 = scan.next();

         while (!snum1.equals("0") && !snum2.equals("0")) {


             //Leer la palabra
             char[] num1 = snum1.toCharArray();
             char[] num2 = snum2.toCharArray();

             //Crear el tablero
             char[][] tablero = nuevoTablero(num1, num2);

             //Escribir los numeros
             colocarPrimerNumero(tablero, num1);
             colocarSegundoNumero(tablero, num2);

             //Multiplicar las celdas
             multiplicarCeldas(tablero, num1, num2);

             //Imprimir el resultado
             multiplicarValores(tablero, num1, num2);

             //Mostrar el tablero
             for (int i = 0; i < tablero.length; i++) {
                 for (int j = 0; j < tablero[0].length; j++) {
                     System.out.print(tablero[i][j]);
                 }
                 System.out.println();
             }


             snum1 = scan.next();
             snum2 = scan.next();

         }
    }
}


