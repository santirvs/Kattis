package Cap1._1_ParaEmpezar._8_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class Ptice {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       scan.nextInt();  //Ignorar
       String respuestas = scan.next();

       //Patrones de respuesta de cada uno
       char[] adrian ={'A', 'B', 'C'};
       char[] bruno = {'B', 'A', 'B', 'C'};
       char[] goran = {'C', 'C', 'A', 'A', 'B', 'B'};

       //Contadores de respuestas correctas
       int a = 0;
       int b = 0;
       int g = 0;

       //Analizar las respuestas
       for (int i=0; i<respuestas.length(); i++) {
           if (respuestas.charAt(i) == adrian[i%3]) a++;
           if (respuestas.charAt(i) == bruno[i%4]) b++;
           if (respuestas.charAt(i) == goran[i%6]) g++;
       }

       //Mostrar la respuesta más alta
       int max = Math.max(a, Math.max(b, g));
       System.out.println(max);

        //Mostrar los nombres de los que han obtenido la respuesta más alta
        if (a == max) System.out.println("Adrian");
        if (b == max) System.out.println("Bruno");
        if (g == max) System.out.println("Goran");

    }
}
