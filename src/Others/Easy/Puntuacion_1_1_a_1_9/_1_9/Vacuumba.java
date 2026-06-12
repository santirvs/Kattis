package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * El robot empieza en 0,0 y mirando hacia arriba
 * En cada movimiento, calcular su ángulo y sus nuevas coordenadas X,Y
 * aplicando trigonometria
 */

import java.util.Locale;
import java.util.Scanner;

public class Vacuumba {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        int numCasos = sc.nextInt();

        while (numCasos-- > 0) {

            double X = 0;
            double Y = 0;
            double angle = 90;  //Mirando hacia el norte

            int numInstrucciones = sc.nextInt();
            while (numInstrucciones-- > 0) {
                double rotacion = sc.nextDouble();
                double avanzar = sc.nextDouble();

                angle +=rotacion;

                X+=Math.cos(Math.toRadians(angle)) * avanzar;
                Y+=Math.sin(Math.toRadians(angle)) * avanzar;
            }

            System.out.println(X + " " + Y);

        }



        sc.close();
    }
}