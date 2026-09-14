package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Leer la línea,
// Recorrer el String imprimiendo los caracteres pares

//OJO TLE!  Usar String Builder!


import java.util.Scanner;

public class EveryOtherLetter {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StringBuilder salida = new StringBuilder();

        String linea = scan.nextLine();

        for (int i=0; i<linea.length(); i++) {
            if (i%2 ==0 ) {
                salida.append(linea.charAt(i));
            }
        }

        System.out.println(salida.toString());



    }
}