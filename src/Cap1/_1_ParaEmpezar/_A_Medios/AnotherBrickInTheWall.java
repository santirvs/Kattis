package Cap1._1_ParaEmpezar._A_Medios;

import java.util.Locale;
import java.util.Scanner;

public class AnotherBrickInTheWall {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
       int altura = scan.nextInt();
       int ancho = scan.nextInt();
       int numLadrillos = scan.nextInt();

       //Leer los ladrillos
       int filasCompletas = 0;
       int posFila = 0;
       boolean posible = true;
       while (posible) {
           int ladrillo = scan.nextInt();
           if (posFila + ladrillo > ancho)
               posible = false;
           else {
               posFila += ladrillo;
               if (posFila == ancho) {
                   filasCompletas++;
                   posFila = 0;
               }
           }
           if (filasCompletas == altura) break;
       }

        if (filasCompletas == altura) {
          System.out.println("YES");
        }
        else {
          System.out.println("NO");
       }

   }

}

