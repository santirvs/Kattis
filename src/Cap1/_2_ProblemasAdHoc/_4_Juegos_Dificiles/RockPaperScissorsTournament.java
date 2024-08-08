package Cap1._2_ProblemasAdHoc._4_Juegos_Dificiles;

import java.util.Locale;
import java.util.Scanner;


/**
 *
 * Este problema requiere del uso de un fast input en Java para evitar el TLE.
 * Se usa la clase Kattio para ello.
 *
 * */
public class RockPaperScissorsTournament {

    public static boolean gana(String jugada1, String jugada2) {
        return jugada1.equals("rock") && jugada2.equals("scissors") ||
                jugada1.equals("scissors") && jugada2.equals("paper") ||
                jugada1.equals("paper") && jugada2.equals("rock");
    }

     public static void main(String[] args) {

         Kattio scan = new Kattio(System.in);
         //scan.useLocale(Locale.ENGLISH);

         int numJugadores = scan.getInt();

         while (numJugadores>0) {
             int k = scan.getInt();
             int numPartidas = k*numJugadores*(numJugadores-1)/2;

             int[][] partidas = new int[numJugadores][2];

             for (int i=0; i<numPartidas; i++) {
                 int numJugador1 = scan.getInt()-1;
                 String jugada1 = scan.getWord();
                 int numJugador2 = scan.getInt()-1;
                 String jugada2 = scan.getWord();

                 if (jugada1.equals(jugada2)) {
                     //Empate, no se hace nada
                 }
                 else {
                     if (gana(jugada1, jugada2)) {
                         //gana el jugador 1 y pierde el jugador 2
                         partidas[numJugador1][0]++;
                         partidas[numJugador2][1]++;
                     } else {
                         //gana el jugador 2 y pierde el jugador 1
                         partidas[numJugador2][0]++;
                         partidas[numJugador1][1]++;
                     }
                 }
             }

             for (int i=0; i<numJugadores; i++) {
                 if (partidas[i][1]==0 && partidas[i][0]==0) {
                     System.out.println("-");
                 } else {
                     double porcentaje = (double)partidas[i][0]/(partidas[i][0]+partidas[i][1]);
                     System.out.printf("%.3f\n", porcentaje);
                 }
             }

             numJugadores = scan.getInt();
             //Salto de linea entre casos
             if (numJugadores>0) System.out.println();
         }

     }

}
