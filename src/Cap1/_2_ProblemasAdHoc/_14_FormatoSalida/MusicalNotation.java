package Cap1._2_ProblemasAdHoc._14_FormatoSalida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MusicalNotation {

    public static char[][] pentagramaNuevo() {
        char[][] pentagrama = {
                "G: ".toCharArray(),
                "F: ".toCharArray(),
                "E: ".toCharArray(),
                "D: ".toCharArray(),
                "C: ".toCharArray(),
                "B: ".toCharArray(),
                "A: ".toCharArray(),
                "g: ".toCharArray(),
                "f: ".toCharArray(),
                "e: ".toCharArray(),
                "d: ".toCharArray(),
                "c: ".toCharArray(),
                "b: ".toCharArray(),
                "a: ".toCharArray()
        };
        return pentagrama;
    }

    public static ArrayList<Character>  notas = new ArrayList<>(Arrays.asList('G', 'F', 'E', 'D', 'C', 'B', 'A', 'g', 'f', 'e', 'd', 'c', 'b', 'a'));


    public static void extender(char[][] pentagrama, int longitud) {
        ArrayList<Integer> filasLineas = new ArrayList<>(Arrays.asList( 1, 3, 5, 7, 9, 13));
        for (int i = 0; i < pentagrama.length; i++) {
            char[] fila = pentagrama[i];
            char[] nuevaFila = new char[fila.length + longitud];
            char nuevoCaracter = ' ';
            if (filasLineas.contains(i)) {
                nuevoCaracter = '-';
            }
            for (int j = 0; j < fila.length; j++) {
                nuevaFila[j] = fila[j];
            }
            for (int j = fila.length; j < nuevaFila.length; j++) {
                nuevaFila[j] = nuevoCaracter;
            }
            pentagrama[i] = nuevaFila;
        }
    }

    public static void anyadirNota(char[][] pentagrama, String nota) {
        char pitch = nota.charAt(0);
        int duracion = 1;
        if (nota.length()>1) {
            duracion = Integer.parseInt(nota.substring(1));
        }

        //Separación entre notas
        int separacion = pentagrama[0].length > 3 ? 1 : 0;
        int posicionInicial = pentagrama[0].length+separacion;

        //Extender el pentagrama
        extender(pentagrama, duracion+separacion);

        //Dibujar la nota
        for (int i = posicionInicial; i < posicionInicial+duracion; i++) {
            pentagrama[notas.indexOf(pitch)][i] = '*';
        }
    }

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        scan.nextLine();  //Ignorar la longitud de la canción
        String cancion = scan.nextLine();

        //Crear el pentagrama
        char[][] pentagrama = pentagramaNuevo();

        //Añadir las notas
        String[] notas = cancion.split(" ");
        for (String nota : notas) {
            anyadirNota(pentagrama, nota);
        }

        //Imprimir el pentagrama
        for (int i = 0; i < pentagrama.length; i++) {
            System.out.println(pentagrama[i]);
        }

    }
}


