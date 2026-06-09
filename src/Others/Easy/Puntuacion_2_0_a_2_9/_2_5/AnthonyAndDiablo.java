package Others.Easy.Puntuacion_2_0_a_2_9._2_5;


/*
  El área máxima que se puede rodear con N metros de valla es:
    N^2 / 4*Pi   --> Si se puede hacer redonda
    (N / 4)^2    --> Si debe ser cuadrada
 */

import java.util.*;

public class AnthonyAndDiablo {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        double A = sc.nextDouble();
        double N = sc.nextDouble();

        double max = (N*N) / (4*Math.PI) ;  //-- si puede ser redonda
        //double max = (N / 4) * (N / 4) ;  //-- si debe ser cuadrada

        if (A > max) System.out.println("Need more materials!");
        else System.out.println("Diablo is happy!");
    }
}
