package Cap2._2_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.*;

public class Dyslectionary {

    private static int maxLenght = 0;

    public static class Palabra implements Comparable<Palabra> {
        String txt;
        private String txt_reverse;

        public Palabra(String txt) {
            this.txt = txt;
            this.txt_reverse = new StringBuilder(txt).reverse().toString();
        }

        @Override
        public int compareTo(Palabra o) {
            return this.txt_reverse.compareTo(o.txt_reverse);
        }

    }

    public static void tratarPalabra(String palabra, ArrayList<Palabra> listaPalabras, boolean ultimo) {
        if (palabra.equals("")) {
            //Ordenar las palabras
            Collections.sort(listaPalabras);

            //Mostrar el resultado
            for (Palabra p : listaPalabras) {
                //Imprimir espacios en blanco
                if (p.txt.length() < maxLenght) {
                    for (int i = 0; i < maxLenght - p.txt.length(); i++) {
                        System.out.print(" ");
                    }
                }
                //Imprimir la palabra
                System.out.println(p.txt);
            }
            //Salto de línea entre casos
            if (!ultimo) System.out.println();
            //Reiniciar casos
            listaPalabras.clear();
            maxLenght = 0;
        } else {
            listaPalabras.add(new Palabra(palabra));
            maxLenght = Math.max(palabra.length(), maxLenght);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        ArrayList<Palabra> listaPalabras = new ArrayList<>();

        //Lectura de datos
        while (scan.hasNext()) {
            String palabra = scan.nextLine();
            tratarPalabra(palabra, listaPalabras, false);
        }
        tratarPalabra("", listaPalabras, true);
    }


}