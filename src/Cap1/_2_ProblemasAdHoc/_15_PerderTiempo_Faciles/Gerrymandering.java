package Cap1._2_ProblemasAdHoc._15_PerderTiempo_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class Gerrymandering {

    public static class Distrito {
        int votosA;
        int votosB;

        public Distrito(int votosA, int votosB) {
            this.votosA = votosA;
            this.votosB = votosB;
        }

        public char winner() {
            return votosA > votosB ? 'A' : 'B';
        }
    }

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Leer la entrada
         int recintos = scan.nextInt();  //Numero de recintos (Precints)
         int distritos = scan.nextInt();   //Número de distritos (Districts)

         Distrito[] listDistritos = new Distrito[distritos];
         int totalVotos = 0;

         //Leer los recintos
         for (int i = 0; i < recintos; i++) {
             int distrito = scan.nextInt();
             int votosA = scan.nextInt();
             int votosB = scan.nextInt();
             if (listDistritos[distrito - 1] == null) {
                 listDistritos[distrito - 1] = new Distrito(votosA, votosB);
             } else {
                 listDistritos[distrito - 1].votosA += votosA;
                 listDistritos[distrito - 1].votosB += votosB;
             }
             totalVotos += votosA + votosB;
         }

         //Analizar los distritos
         int totalWasteA = 0;
         int totalWasteB = 0;

         for (int i = 0; i < distritos; i++) {
             int votosA = listDistritos[i].votosA;
             int votosB = listDistritos[i].votosB;
             int totalVotosDistrito = votosA + votosB;
             int wasteA = 0;
             int wasteB = 0;
             if (votosA > votosB) {
                 wasteB = votosB;
                 wasteA = votosA - (totalVotosDistrito / 2 + 1);
             } else {
                 wasteA = votosA;
                 wasteB = votosB - (totalVotosDistrito / 2 + 1);
             }
             totalWasteA += wasteA;
             totalWasteB += wasteB;
             System.out.println(listDistritos[i].winner() + " " + wasteA + " " + wasteB);
         }

         //Calcular el porcentaje de desperdicio
         double porcentaje = (double) Math.abs(totalWasteA - totalWasteB) / totalVotos;
         System.out.printf("%.10f\n", porcentaje);

     }


}


