package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHashSet;

import java.util.HashSet;
import java.util.Scanner;

// LLevar un set con las palabras usadas

public class Shiritori {


      public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in);

        HashSet<String> lista = new HashSet<String>();


        int numPalabras = scan.nextInt();
        scan.nextLine();
        String palabra = scan.nextLine();
        lista.add(palabra);
        char ultimoCaracter = palabra.charAt(palabra.length()-1);
        boolean turnoJugador1 = false;
        boolean correcto = true;
        for (int i = 1; i< numPalabras && correcto; i++) {
            palabra = scan.nextLine();
            if (palabra.charAt(0) == ultimoCaracter && !lista.contains(palabra)) {
                lista.add(palabra);
                turnoJugador1 = !turnoJugador1;
                ultimoCaracter = palabra.charAt(palabra.length()-1);
            }
            else {
                correcto = false;
            }
        }

        if (correcto)
            System.out.println("Fair Game");
        else if (turnoJugador1) {
            System.out.println("Player 1 lost");
                }
        else
            System.out.println("Player 2 lost");
            }
}
