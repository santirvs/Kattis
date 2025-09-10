package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer el nombre y el nivel de diversion.
// Si el nivel de diversión supera el mayor actual, guardarme el nivel y el nombre.
// Finalmente, imprimir el nombre de quien trajo el regalo más divertido.

import java.util.Scanner;

public class BestaGjofin {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int numAmigos = scan.nextInt();
        String nombreMejorAmigo = "";
        int nivelDiversionMaximo = -1;

        for (int i = 0; i < numAmigos; i++) {
            String nombreAmigo = scan.next();
            int nivelDiversion = scan.nextInt();

            //Comprobar si es el mejor regalo
            if (nivelDiversion > nivelDiversionMaximo) {
                nivelDiversionMaximo = nivelDiversion;
                nombreMejorAmigo = nombreAmigo;
            }
        }

        //Imprimir el resultado
        System.out.println(nombreMejorAmigo);

    }
}