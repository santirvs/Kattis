package Others.Medium.Puntuacion_2_0_a_2_9._2_9;

/**
 * Parecido al problema de los Caracoles del Pozo del JO-EL
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HopelesslyHungover {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTemas = sc.nextInt();
        int temasAprendidos = sc.nextInt();
        int temasOlvidados = sc.nextInt();
        int diaSemana = sc.nextInt();

        //Será impossible si olvidamos durante el fin de semana más temas de los que hemos aprendido durante la semana
        //y no llegamos al viernes sabiendolos todos

        int temasViernes = 5 * temasAprendidos;

        if (temasOlvidados * 2 >= temasAprendidos * 5 && temasViernes < numTemas) {
            System.out.println("impossible");
        } else {
            //Descartado que sea imposible, calcular cuantos días se tarda en aprenderse todos los temas
            var temas = 0;
            var numDias = 0;
            while (temas < numTemas) {
                numDias++;
                if (diaSemana > 5) {
                    temas -= temasOlvidados;
                    if (temas < 0) temas = 0;
                } else {
                    temas +=temasAprendidos;
                }
                diaSemana++;
                if (diaSemana == 8) diaSemana = 1;
            }

            System.out.println(numDias);
        }
    }
}
