package Cap2._2_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import Utils.Kattio;

import java.util.*;

/*
   1-> RTE -->TestCase#3: La lectura del número de reproducciones ya es un long!
   2-> TLE -->TestCase#4: Uso la librería Kattio
   3-> WA  -->TestCase#5: En la comparación, la resta de longs convertida a int no es correcta.
 */
public class ZipfsSong {

    public static class Song implements Comparable<Song> {
        int posicion;
        long calidad;
        String nombre;

        public Song(String nombre, long numReproducciones, int pos) {
            this.nombre = nombre;
            this.posicion = pos;
            this.calidad = numReproducciones * pos;
        }

        @Override
        public int compareTo(Song o) {
            if (this.calidad == o.calidad) {
                return this.posicion - o.posicion;
            } else {
                //return (int) (o.calidad - this.calidad);
                //TestCase#5: la resta de longs convertida a Int no es correcta
                if (o.calidad > this.calidad) return 1;
                else return -1;
            }
        }
    }

    public static void main(String[] args) {

        //Scanner scan = new Scanner(System.in);
        //scan.useLocale(Locale.ENGLISH);
        Kattio scan = new Kattio(System.in);


        //Lectura de datos
        //int numCanciones = scan.nextInt();
        //int numPrint = scan.nextInt();
        int numCanciones = scan.getInt();
        int numPrint = scan.getInt();


        //Leer las canciones
        Song[] canciones = new Song[numCanciones];
        for (int i = 0; i < numCanciones; i++) {
            //long numReproducciones = scan.nextLong();
            //String nombre = scan.next();

            long numReproducciones = scan.getLong();
            String nombre = scan.getWord();

            canciones[i] = new Song(nombre, numReproducciones, i+1);
        }

        //Ordenar las canciones
        Arrays.sort(canciones);

        //Mostrar las canciones
        for (int i = 0; i < numPrint; i++) {
            System.out.println(canciones[i].nombre);
        }

    }
}
