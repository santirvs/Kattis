package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.Locale;
import java.util.Scanner;

public class PopularVote {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer la cantidad de casos
        int numCasos = scan.nextInt();

        //Recorrer los casos
       while (numCasos > 0) {
           numCasos--;

           //Leer la cantidad de candidatos
           int numCandidatos = scan.nextInt();

           int totalVotos = 0;
           int candidatoGanador = -1;  //-1: sin especificar
           int maxVotos = -1;
           //Leer los votos de cada candidato
           for (int i=1; i<=numCandidatos; i++) {
               int votos = scan.nextInt();
               totalVotos += votos;
               if (votos == maxVotos)
                   candidatoGanador = -2; //-2: empate
               else if (votos > maxVotos) {
                   maxVotos = votos;
                   candidatoGanador = i;
               }
           }

           //Mostrar el resultado
           if (candidatoGanador == -2)
               System.out.println("no winner");
           else {
                if (maxVotos > totalVotos / 2)
                     System.out.println("majority winner " + candidatoGanador);
                else
                     System.out.println("minority winner " + candidatoGanador);

           }
       }

    }
}
