package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Contar si existen: sólo l, sólo v, lv y vl o ninguna de ellas
 *
 * ninguna -> 2 operaciones
 * lv -> 0 operaciones
 * resto -> 1 operacion
 *
 */

import java.io.IOException;
import java.util.Scanner;


public class lv_able {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int longitud = sc.nextInt();
        String entrada = sc.next();

        boolean hayL = false;
        boolean hayV = false;
        boolean hayLV = false;
        char anterior = 'X';
        for (int i=0; i<longitud && !hayLV; i++) {
            char actual = entrada.charAt(i);
            if (actual == 'l') hayL=true;
            else if (actual == 'v') hayV=true;

            if (actual == 'v' && anterior == 'l') hayLV = true;

            anterior =actual;
        }
        int resultado;

        if (!hayL && !hayV) resultado = 2;
        else if (hayLV) resultado = 0;
        else resultado = 1;

        System.out.println(resultado);

    }
}

