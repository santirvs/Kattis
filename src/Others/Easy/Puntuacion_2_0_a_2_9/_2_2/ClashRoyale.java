package Others.Easy.Puntuacion_2_0_a_2_9._2_2;



import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class ClashRoyale {

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);

       int numJugadores = sc.nextInt();

       int mejorJugador = 0;
       int menorNumJugadas = 1000;

       for (int i=1; i<=numJugadores; i++) {
           String jugadas = sc.next();
           int numW = 0;
           int numL = 0;
           int numJugadas = 0;
           boolean fin = false;
           for (int pos=0; pos<jugadas.length() && !fin; pos++) {
               if (jugadas.charAt(pos) == 'W') numW++;
               else if (jugadas.charAt(pos) == 'L') numL++;

               if (numL==3) {
                   numL=0;
                   numW=0;
               }
               if (numW==12) {
                   fin = true;
                   numJugadas = pos;
               }
           }
           if (fin && numJugadas < menorNumJugadas) {
               menorNumJugadas = numJugadas;
               mejorJugador = i;
           }
       }

       if (mejorJugador == 0 ) {
           System.out.println("INCOMPLETE");
       } else {
           System.out.println(mejorJugador);
       }




    }
}