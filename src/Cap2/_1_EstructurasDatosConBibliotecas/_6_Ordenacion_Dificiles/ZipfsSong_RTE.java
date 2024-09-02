package Cap2._1_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.*;

public class ZipfsSong_RTE {

    public static class Song implements Comparable<Song> {
        int posicion;
        long calidad;
        String nombre;

        public Song(String nombre, int numReproducciones, int pos) {
            this.nombre = nombre;
            this.posicion = pos;
            this.calidad = numReproducciones * pos;
        }

        @Override
        public int compareTo(Song o) {
            if (this.calidad == o.calidad) {
                return this.posicion - o.posicion;
            } else {
                return (int) (o.calidad - this.calidad);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCanciones = scan.nextInt();
        int numPrint = scan.nextInt();

        //Leer las canciones
        Song[] canciones = new Song[numCanciones];
        for (int i = 0; i < numCanciones; i++) {
            int numReproducciones = scan.nextInt();
            String nombre = scan.next();
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



/*   No probado!!!


import java.io.*;
import java.util.*;

public class zipfslaw {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String line = "";
        TreeMap<String, Integer> freq = new TreeMap<String, Integer>();
        int n = 0;
        String res = "";
        boolean nextInt = true;
        while((line = in.readLine()) != null) {
            line = line.toLowerCase();
            if(line.equals("")) continue;
            if(nextInt) {
                n = Integer.parseInt(line);
                nextInt = false;
            }
            else if(line.equals("endoftext")) {
                if(n != 0) {
                    if(freq.values().contains(n)) {
                        res += "\n";
                        for(String s : freq.keySet()) {
                            if(freq.get(s) == n) {
                                res += s + "\n";
                            }
                        }
                    }
                    else {
                        res += "\nThere is no such word.\n";
                    }
                    freq = new TreeMap<String, Integer>();
                }
                nextInt = true;
            }
            else {
                String[] st = line.split("[^a-zA-Z0-9]");
                for(String s : st) {
                    if(freq.get(s) == null)
                        freq.put(s, 1);
                    else
                        freq.put(s, freq.get(s) + 1);
                }
            }
        }
        out.println(res.trim());
        out.close();
    }
}


 */