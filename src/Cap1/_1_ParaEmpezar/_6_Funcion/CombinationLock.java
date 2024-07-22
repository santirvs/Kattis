package Cap1._1_ParaEmpezar._6_Funcion;

import java.util.*;

public class CombinationLock {

   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int posInicial = scan.nextInt();
        int pos1 = scan.nextInt();
        int pos2 = scan.nextInt();
        int pos3 = scan.nextInt();

        while (posInicial!=0 || pos1!=0 || pos2!=0 || pos3!=0) {

            int numGrados = 720; //2 vueltas
            int numGradosGiro = 0;
            int gradosPorDigito = 9;

            //Girar a la primera posición
            numGradosGiro = (pos1 - posInicial + 40) % 40 * gradosPorDigito;
            numGrados += numGradosGiro;

            //Girar a la segunda posición
            numGradosGiro = (pos2 - pos1 + 40) % 40 * gradosPorDigito;
            numGrados += numGradosGiro;

            //Girar a la tercera posición
            numGradosGiro = (pos3 - pos2 + 40) % 40 * gradosPorDigito;
            numGrados += numGradosGiro;

            System.out.println(numGrados);

            //Siguiente caso
            posInicial = scan.nextInt();
            pos1 = scan.nextInt();
            pos2 = scan.nextInt();
            pos3 = scan.nextInt();

        }

    }
}
