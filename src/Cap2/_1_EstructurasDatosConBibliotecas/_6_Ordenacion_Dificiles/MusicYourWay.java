package Cap2._1_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.*;

public class MusicYourWay {

    private static int orden = 0;

    public static class Song implements Comparable<Song> {
        String[] atributos;

        public Song(String txt) {
            this.atributos = txt.split(" ");
        }

        @Override
        public int compareTo(Song o) {
            return this.atributos[orden].compareTo(o.atributos[orden]);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (String s : atributos) {
                sb.append(s);
                sb.append(" ");
            }
            return sb.toString();
        }

    }

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Lectura de atributos
         ArrayList<String> atributos = new ArrayList<>();
         atributos = new ArrayList<String>(Arrays.asList(scan.nextLine().split(" ")));

         //Lectura de canciones
         int numCanciones = scan.nextInt();
         scan.nextLine();
         Song[] listaCanciones = new Song[numCanciones];
         for (int i = 0; i < numCanciones; i++) {
             String cancion = scan.nextLine();
             Song s = new Song(cancion);
             listaCanciones[i] = s;
         }

         //Ordenar las canciones
         int numOrdenaciones = scan.nextInt();
         scan.nextLine();

         //Mostrar las canciones ordenadas


         for (int i = numOrdenaciones - 1; i >= 0; i--) {
             //Mostrar la lista de atributos
             for (int j=0; j<atributos.size(); j++) {
                 System.out.print(atributos.get(j));
                 if (j != atributos.size()-1) System.out.print(" ");
             }
             System.out.println();

             String ordenacion = scan.nextLine();
             orden = atributos.indexOf(ordenacion);
             Arrays.sort(listaCanciones);
             //Mostrar el resultado
             for (Song s : listaCanciones) {
                 System.out.println(s);
             }
             if (i != 0) System.out.println();
         }

    }


}