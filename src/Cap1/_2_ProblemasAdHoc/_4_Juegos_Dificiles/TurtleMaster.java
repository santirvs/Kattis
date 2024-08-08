package Cap1._2_ProblemasAdHoc._4_Juegos_Dificiles;


import java.util.Locale;
import java.util.Scanner;

public class TurtleMaster {

    public static final int DERECHA = 0;
    public static final int ABAJO = 1;
    public static final int IZQUIERDA = 2;
    public static final int ARRIBA = 3;

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Definir tablero y leerlo
         char[][] tablero = new char[8][8];
         for (int i = 0; i < 8; i++) {
             String linea = scan.nextLine();
             for (int j = 0; j < 8; j++) {
                 tablero[i][j] = linea.charAt(j);
             }
         }

         //Leer los movimientos
         char[] movimientos = scan.nextLine().toCharArray();

         //Procesar los movimientos
         int x = 0;
         int y = 7;
         int direccion = DERECHA;
         boolean isBug = false;

         for (int i = 0; i < movimientos.length && !isBug; i++) {
             switch (movimientos[i]) {
                 case 'R':
                     //Giro a la derecha (sentido horario)
                     direccion = (direccion + 1) % 4;
                     break;
                 case 'L':
                     //Giro a la izquierda (sentido antihorario)
                     direccion = (direccion + 3) % 4;
                     break;
                 case 'F':
                     //Avanzar, dependiendo de la dirección
                     switch (direccion) {
                         case DERECHA:
                             x++;
                             break;
                         case ABAJO:
                             y++;
                             break;
                         case IZQUIERDA:
                             x--;
                             break;
                         case ARRIBA:
                             y--;
                             break;
                     }
                     break;
                 case 'X':
                     //Dispara un láser a la casilla que tiene frente a él
                     int nextX = x;
                     int nextY = y;
                     switch (direccion) {
                         case DERECHA:
                             nextX++;
                             break;
                         case ABAJO:
                             nextY++;
                             break;
                         case IZQUIERDA:
                             nextX--;
                             break;
                         case ARRIBA:
                             nextY--;
                             break;
                     }

                     if (nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
                         //La siguiente casilla está fuera del tablero
                         isBug = true;
                     } else if (tablero[nextY][nextX] == 'I') {
                         //La siguiente casilla es ICE
                         tablero[nextY][nextX] = '.';
                     } else {
                         //Si no es ICE, es un error
                         isBug = true;
                     }
             }
             //Controlar si se sigue dentro del tablero
             if (x < 0 || x > 7 || y < 0 || y > 7) {
                 isBug = true;
             }
             if (tablero[y][x] == 'C' || tablero[y][x] == 'I') {
                 //Si está sobre un castillo (de roca o de hielo), es incorrecto
                 isBug = true;
             }
         }

         //A la salida debe estar sobre el diamante
         if (!isBug && tablero[y][x] != 'D') {
             isBug = true;
         }

         //Mostrar el resultado
         if (isBug) {
             System.out.println("Bug!");
         } else {
             System.out.println("Diamond!");
         }

     }

}
