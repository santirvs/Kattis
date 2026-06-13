package Others.Medium.Puntuacion_3_0_a_3_9._3_3;

/*
    Suponemos que empezamos en la tecla 1 y vamos subiendo
    y bajando tonos en cada una de las notas.
    Nos guardamos el máximo y el mínimo que habremos inicializado a 1.
    Al final, hay que desplazar el teclado para que el mínimo sea 1.
    Si el máximo excede la cantidad de teclas del teclado -> finns ingen
 */

import java.util.Scanner;

public class PlayingPiano {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int numTeclas = sc.nextInt();
        int numNotas = sc.nextInt();

        int posicion = 1;
        int minimo = 1;
        int maximo = 1;

        numNotas--;  //La primera nota siempre es la 1
        while (numNotas-- > 0) {
            int diff = sc.nextInt();
            posicion +=diff;
            minimo = Math.min(minimo, posicion);
            maximo = Math.max(maximo, posicion);
        }

        int inicio = 1 + (1-minimo);
        int ultima = maximo + (1-minimo);

        if (ultima > numTeclas) {
            System.out.println("finns ingen");
        } else {
            System.out.println(inicio);
        }

    }
}