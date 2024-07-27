package Cap1._1_ParaEmpezar._A_Medios;

import java.util.Locale;
import java.util.Scanner;

public class BattleSimulation {

    public static boolean hayCombo(char[] entrada, int ini, int fin) {
        boolean hayR = false;
        boolean hayB = false;
        boolean hayG = false;
        if (fin < entrada.length) {
            for (int i = ini; i <= fin; i++) {
                if (entrada[i] == 'R') {
                    hayR = true;
                } else if (entrada[i] == 'B') {
                    hayB = true;
                } else {
                    hayG = true;
                }
            }
        }
        return hayR && hayB && hayG;
    }

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer la secuencia de movimientos
       char[] entrada = scan.nextLine().toCharArray();
       //Analizar la secuencia
       for (int i = 0; i < entrada.length; i++) {

           if (hayCombo(entrada, i, i+2)) {
               System.out.print("C");
               i+=2;
           }
           else {
               if (entrada[i] == 'R') {
                   System.out.print("S");
               }
               else if (entrada[i] == 'B') {
                   System.out.print("K");
               }
               else {
                   System.out.print("H");
               }
           }

       }
       System.out.println("");

   }

}

