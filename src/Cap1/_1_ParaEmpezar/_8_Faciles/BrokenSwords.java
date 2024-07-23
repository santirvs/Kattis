package Cap1._1_ParaEmpezar._8_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class BrokenSwords {

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       // Leer el número de espadas
       int numEspadas = scan.nextInt();
       int listonesTB = 0;
       int listonesLR = 0;

       //Leer cada espada y procesarla
       while (numEspadas > 0) {
           //Orden TBLR
           char[] espada = scan.next().toCharArray();

           if (espada[0] == '0') listonesTB++;
           if (espada[1] == '0') listonesTB++;
           if (espada[2] == '0') listonesLR++;
           if (espada[3] == '0') listonesLR++;

            numEspadas--;
       }

       //Resultado
       //El número de espadas que se pueden construir es la mitad del mínimo de listones TB y LR
       int numEspadasPosibles = Math.min(listonesTB, listonesLR) / 2;
       //El número de listones sobrantes es la suma de los listones TB y LR menos el doble del número de espadas posibles
       int listonesSobrantesTB = listonesTB - 2*numEspadasPosibles;
       int listonesSobrantesLR = listonesLR - 2*numEspadasPosibles;

       System.out.println(numEspadasPosibles + " " + listonesSobrantesTB + " " + listonesSobrantesLR);

    }
}
