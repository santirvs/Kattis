package Cap2._1_EstructurasDatosConBibliotecas._8_ManipulacionBits;

import java.util.*;

//Los snappers se activan de la misma forma que la numeración binaria
//La bombilla se encenderá sólo si todos los snappers están activados

public class SnapperChainHard {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCasos = scan.nextInt();
        int caso = 0;

        while (caso < numCasos) {
            caso ++;

            int snappers = scan.nextInt();
            int palmadas = scan.nextInt();

            //Cuando superemos el 2^snappers, se repite el ciclo
            palmadas = palmadas % (1 << snappers);
            //Si el número de palmadas ha activado todos los snappers, la bombilla se enciende
            if (palmadas  == ((1 << snappers) - 1)) {
                System.out.println("Case #" + caso + ": ON");
            } else {
                System.out.println("Case #" + caso + ": OFF");
            }
        }

    }

}
