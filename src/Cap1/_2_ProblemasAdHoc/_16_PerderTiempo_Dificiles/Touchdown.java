package Cap1._2_ProblemasAdHoc._16_PerderTiempo_Dificiles;

import java.util.*;

public class Touchdown {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int numJugadas = scan.nextInt();

        int posicion = 20;
        int firstDown = 30;
        int intentos = 4;

        //Leer las jugadas
        boolean fin = false;
        while (numJugadas > 0 && !fin) {
            int numYardas = scan.nextInt();
            posicion += numYardas;
            if (posicion >= 100) {
                System.out.println("Touchdown");
                fin = true;
            } if (posicion <= 0) {
                System.out.println("Safety");
                fin = true;
            }else {
                if (posicion >= firstDown) {
                    firstDown = posicion + 10;
                    intentos = 4;
                }
                else {
                    intentos--;
                    if (intentos == 0) {
                        System.out.println("Nothing");
                        fin = true;
                    }
                }
            }

            numJugadas--;
        }

        if (!fin) {
            System.out.println("Nothing");
        }

    }
}
