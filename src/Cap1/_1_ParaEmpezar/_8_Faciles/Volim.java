package Cap1._1_ParaEmpezar._8_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class Volim {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lee el jugador inicial
       int jugador = scan.nextInt();

       //Lee la cantidad de preguntas
       int numPreguntas = scan.nextInt();
       int tiempo = 0;
       boolean explosion = false;

       while (numPreguntas>0 && !explosion) {
           int numSegundos = scan.nextInt();
           char respuesta = scan.next().charAt(0);

           //Respuesta dentro de tiempo
           if (tiempo + numSegundos < 210) {
               tiempo += numSegundos;
               //Respuesta correcta, pasa al siguiente jugador
               if (respuesta == 'T') {
                   jugador = (jugador+1)%9;
                   if (jugador == 0) jugador = 1;
               }
               //Respuesta incorrecta o paso, no hay cambio de jugador
           }
           //Respuesta fuera de tiempo. Explotó la caja
           else {
               explosion = true;
           }

       }

       //Mostrar el jugador que tiene la caja
       System.out.println(jugador);
    }
}
