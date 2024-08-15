package Cap1._2_ProblemasAdHoc._6_VidaReal_Medios;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MusicalScales {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Construir las escalas
         String[] escala = new String[]{"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
         int[] variaciones = new int[]{2, 2, 1, 2, 2, 2, 1, 2};
         ArrayList<ArrayList<String>>escalas = new ArrayList<ArrayList<String>>();
         boolean[] escalasValidas = new boolean[12];
         for (int i= 0; i < 12; i++) {
             escalasValidas[i] = true;
         }

         for (int i = 0; i < 12; i++) {
             int indice = i;
             ArrayList<String> nuevaEscala = new ArrayList<String>();
             for (int j = 0; j < 8; j++) {
                 nuevaEscala.add(escala[indice]);
                 indice = (indice + variaciones[j]) % 12;
             }
             escalas.add(nuevaEscala);
         }

         //Leer los datos del caso
         int numNotas = scan.nextInt();
         scan.nextLine();
         String[] notas = scan.nextLine().split(" ");

         //Procesar el caso
         for (int i=0; i<numNotas;i++) {
             for (int nota=0; nota<12; nota++) {
                 boolean esValida = true;
                 if (!escalas.get(nota).contains(notas[i])) {
                     esValida = false;
                 }
                 escalasValidas[nota] = escalasValidas[nota] && esValida;
             }
         }

         //Mostrar resultado
         int numValidas = 0;
         for (int i=0; i<12; i++) {
             if (escalasValidas[i]) {
                 if (numValidas> 0)
                     System.out.print(" ");
                 System.out.print(escala[i]);
                 numValidas++;
             }
         }
         if (numValidas== 0)
             System.out.println("none");
         else
             System.out.println();


     }

}
