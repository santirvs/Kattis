package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Determinar la longitud del arco entre caracteres.
 * Se empieza en la primera letra.
 * Calcular la distancia más corta entre dos letras consecutivas.
 * Acumular las distancias
 * Calcular el tiempo (según la velocidad del jugador)
 * Añadir 1seg por cada letra
 */

import java.io.IOException;
import java.util.Scanner;


public class RacingAroundTheAlphabet {

    static final String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ '";
    static final double DIST_LETRAS = Math.PI * 60 / 28;  //Longitud de la circunferencia (28 letras)

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();
        sc.nextLine();

        while (numCasos-- > 0) {

            //Leer el mensaje
            String mensaje = sc.nextLine();
            double distancia = 0;

            //Calcular la distancia entre dos letras consecutivas
            int pos = 1;
            while (pos < mensaje.length()) {
                char car1 = mensaje.charAt(pos-1);
                char car2 = mensaje.charAt(pos);

                distancia += distanciaCaracteres(car1, car2);
                pos++;
            }

            //Calcular el tiempo en recorrer la distancia
            double tiempo = distancia / 15;

            //Sumar 1 segundo por cada letra que hay que recoger
            tiempo += mensaje.length();

            //Imprimir el resultado
            System.out.println(tiempo);


        }

        sc.close();
    }

    private static double distanciaCaracteres(char car1, char car2) {
        int pos1 = letras.indexOf(car1);
        int pos2 = letras.indexOf(car2);

        int distancia = Math.abs(pos1 - pos2);

        if (distancia > 14) distancia = 28-distancia;

        return distancia * DIST_LETRAS;

    }
}

