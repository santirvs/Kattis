package Cap1._2_ProblemasAdHoc._7_VidaReal_Dificiles;


import java.util.*;

public class TouchScreenKeyboard {

       static public class Propuesta implements Comparable<Propuesta> {
           String palabra;
           int distancia;

           public Propuesta(String palabra, int distancia) {
               this.palabra = palabra;
               this.distancia = distancia;
           }

           @Override
           public int compareTo(Propuesta o) {
               int distancia = this.distancia - o.distancia;
               if (distancia == 0) {
                   return this.palabra.compareTo(o.palabra);
               } else {
                   return distancia;
               }
           }
       }

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            scan.useLocale(Locale.ENGLISH);

            String teclado = "qwertyuiopasdfghjkl zxcvbnm";

            int numCasos = scan.nextInt();
            for (int i = 0; i < numCasos; i++) {
                String input = scan.next();
                int numPalabras = scan.nextInt();
                ArrayList<Propuesta> propuestas = new ArrayList<Propuesta>();
                for (int j = 0; j < numPalabras; j++) {
                    String palabra = scan.next();
                    int suma=0;
                    for (int k=0; k < palabra.length(); k++) {
                        int pos1 = teclado.indexOf(input.charAt(k));
                        int pos2 = teclado.indexOf(palabra.charAt(k));
                        int x1 = pos1 / 10;
                        int y1 = pos1 % 10;
                        int x2 = pos2 / 10;
                        int y2 = pos2 % 10;
                        suma += Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    }
                    Propuesta p = new Propuesta(palabra, suma);
                    propuestas.add(p);
                }

                Collections.sort(propuestas);

                for (Propuesta p : propuestas) {
                    System.out.println(p.palabra + " " + p.distancia);
                }
            }

     }

}
