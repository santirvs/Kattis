package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.Locale;
import java.util.Scanner;

public class BoundingRobots {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer las dimensiones del tablero
       int ancho = scan.nextInt();
       int alto = scan.nextInt();

       //Recorrer los casos
       while (ancho!=0 || alto!=0) {
           //ATENCION: el robot empieza en 0,0 que es la esquina INFERIOR izquierda
           //No es un tablero, sino que son coordenadas cartesianas

           //Leer movimientos
           int numMovs = scan.nextInt();
           int xReal = 0;
           int yReal = 0;
           int xEst = 0;
           int yEst = 0;

           //Tratar movimientos
           for (int i=0; i<numMovs; i++) {
               //Leer el movimiento
               String mov = scan.next();
               int cant = scan.nextInt();

               //Tratar el movimiento
               switch (mov) {
                   case "u":
                       xReal += cant;
                       xEst += cant;
                       if (xReal >= alto) xReal = alto-1;
                       break;
                   case "d":
                       xReal -= cant;
                       xEst -= cant;
                       if (xReal < 0) xReal = 0;
                       break;
                   case "l":
                       yReal -= cant;
                       yEst -= cant;
                       if (yReal < 0) yReal = 0;
                       break;
                   case "r":
                       yReal += cant;
                       yEst += cant;
                       if (yReal >= ancho) yReal = ancho -1;
                       break;
               }
           }

           //Mostrar el resultado
           System.out.println("Robot thinks "+yEst+" "+xEst);
           System.out.println("Actually at "+yReal+" "+xReal);

           //Siguiente caso
           ancho = scan.nextInt();
           alto = scan.nextInt();
       }

    }
}
