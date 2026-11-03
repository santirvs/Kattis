package Others.Easy.Puntuacion_2_0_a_2_9._2_1;


import java.util.Arrays;
import java.util.Scanner;

public class BirdsOnAWire {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int longitud = sc.nextInt();
        int distancia = sc.nextInt();
        int numPajaros = sc.nextInt();

        int[] posPajaros = new int[numPajaros];
        for (int i = 0; i < numPajaros; i++) {
            posPajaros[i] = sc.nextInt();
        }
        Arrays.sort(posPajaros);
        int indexPajaro = 0;
        int numPajarosAdicionales = 0;

        //Desde el inicio hasta el primer pájaro
        if (indexPajaro < numPajaros && 6 < posPajaros[0]) {
            numPajarosAdicionales = (posPajaros[0] - 6) / distancia;
            //System.out.println("Entre el poste y el primer pájaro caben: " + numPajarosAdicionales);
        }

        //Entre dos pájaros consecutivos
        while (indexPajaro < numPajaros - 1) {
            int p = (posPajaros[indexPajaro + 1] - posPajaros[indexPajaro]) / distancia -1;
            numPajarosAdicionales += p;
            //System.out.println("Entre el pájaro " + indexPajaro + " y el siguiente caben: " + p);
            indexPajaro++;
        }

        //Desde el último pájaro
        int posUltimoPajaro = 0;
        if (numPajaros > 0)
            posUltimoPajaro = posPajaros[numPajaros - 1];
        else {
            posUltimoPajaro = 6;
            numPajarosAdicionales = 1;
        }

        //Calcular la cantidad de pájaros hasta el poste
        int p = (longitud - 6 - posUltimoPajaro) / distancia;
        numPajarosAdicionales += p;
        //System.out.println("Entre el último pájaro y el poste caben: " + p);


        //Mostrar el resultado
        System.out.println(numPajarosAdicionales);


    }
}
