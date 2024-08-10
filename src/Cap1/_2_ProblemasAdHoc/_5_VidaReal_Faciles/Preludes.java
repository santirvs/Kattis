package Cap1._2_ProblemasAdHoc._5_VidaReal_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class Preludes {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         int caso = 0;
         while (scan.hasNext()) {
             caso++;
             String[] linea = scan.nextLine().split(" ");
             String nota = linea[0];
             String escala = linea[1];

             if (nota.length()==1) {
                 System.out.println("Case " + caso + ": UNIQUE");
             } else {
                 char variacion = nota.charAt(1);
                 if (variacion=='#') {
                     //Sostenido: nota siguiente en bemol
                     if (nota.equals("G#")) {
                         nota = "Ab";
                     } else {
                         nota = "" + (char)(nota.charAt(0)+1) + "b";
                     }
                 } else {
                     //Bemol: nota anterior en sostenido
                     if (nota.equals("Ab")) {
                         nota = "G#";
                     } else {
                         nota = (char)(nota.charAt(0)-1) + "#";
                     }
                 }
                 System.out.println("Case " + caso + ": " + nota + " " + escala);
             }

         }
     }

}
