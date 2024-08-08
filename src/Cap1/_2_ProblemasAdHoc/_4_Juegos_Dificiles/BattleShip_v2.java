package Cap1._2_ProblemasAdHoc._4_Juegos_Dificiles;


import java.util.Locale;
import java.util.Scanner;


/**
 * Atención a las coordenadas: la posición 0,0 es la esquina inferior izquierda
 */
public class BattleShip_v2 {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         int numCasos = scan.nextInt();

         while (numCasos>0) {
             numCasos--;

             int ancho, alto, numDisparos;
             ancho = scan.nextInt();
             alto = scan.nextInt();
             numDisparos = scan.nextInt();
             scan.nextLine();

             //Leer los tableros
             char[][][] tablero = new char[2][30][30];
             int[] barcos = new int[2];
             barcos[0] = 0;
             barcos[1] = 0;
             for (int jugador = 0; jugador < 2; ++jugador) {
                 for (int y = alto - 1; y >= 0; --y) {
                     String linea = scan.nextLine();
                     for (int x = 0; x < ancho; ++x) {
                         char ch = linea.charAt(x);
                         tablero[jugador][x][y] = ch;
                         if (ch == '#') barcos[jugador]++;
                     }
                 }
             }

             //Leer los disparos
             boolean end = false;
             int turn = 0;  // 0 -> Jugador1, 1 -> Jugador2
             while (numDisparos > 0 && !end) {
                 numDisparos--;
                 int x, y;
                 x = scan.nextInt();
                 y = scan.nextInt();

                 if (tablero[1-turn][x][y] == '#') {
                     tablero[1-turn][x][y] = ' ';
                     barcos[1-turn]--;
                     if (barcos[1-turn]==0) {
                         //Si no quedan barcos, se cambia de turno
                         turn = 1 - turn;
                         //Si el turno pasa al jugaador 1, se finaliza la partida
                         if (turn == 0) end = true;
                     }
                 } else {
                     //Fallo: cambio de turno
                     turn = 1 - turn;
                     //Si el turno es del jugador 1 y alguien no tiene barcos, finaliza la partida
                     if (turn == 0 && barcos[0]*barcos[1] == 0)
                         end = true;
                 }
             }

             //Mostrar resultados
             if (barcos[0] == 0 && barcos[1] > 0)
                 System.out.println("player two wins\n");
             else if (barcos[0] > 0  && barcos[1] == 0)
                 System.out.println("player one wins\n");
             else System.out.println("draw\n");

             //Leer los disparos restantes
             while (numDisparos>0) {
                 numDisparos--;
                 scan.nextInt();
                 scan.nextInt();
             }

         }

     }

}

