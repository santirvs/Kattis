package Cap1._1_ParaEmpezar._7_ArraysUnidimensionales;

import java.util.Locale;
import java.util.Scanner;

public class ACMContestScoring {

   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        final int PENALTY = 20;             //Penalización por problema fallido

       //Array de problemas donde contaremos los intentos fallidos
       int[] problemas = new int[30];      //Teóricamente son 26, pero para curarnos en salud
       int totalProblemas = 0;
       int totalTiempo = 0;
       //Leer el momento del envío
        int momento = scan.nextInt();

        //Analizar cada envío
        while (momento != -1) {
           char problema = scan.next().charAt(0);
           String resultado = scan.next();

           if (resultado.equals("wrong")) {
               problemas[problema-'A']++;
           } else if (resultado.equals("right")) {
               //Marcar el problema como resuelto
               totalProblemas++;
               totalTiempo += momento + problemas[problema-'A']*PENALTY;
           }

           //Siguiente valor
           momento = scan.nextInt();
       }

       System.out.println(totalProblemas + " " + totalTiempo);

    }
}
