package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Quedarnos con la coordenada más alta, más baja, más a la derecha y más a la izquierda
 * Restar las posiciones y obtener la altura y anchura
 * Añadir 40 a cada dimensión por los márgenes de seguridad
 */


import java.io.IOException;
import java.util.Scanner;

public class Router {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numMovs = sc.nextInt();

        //Posiciones iniciales
        int arriba = 0;
        int abajo = 0;
        int izquierda = 0;
        int derecha = 0;
        int x = 0;
        int y = 0;

        //Leer los movimientos
        for (int i=0; i<numMovs; i++) {
            String mov = sc.next();
            int distancia = sc.nextInt();

            if (mov.equals("U")) {
                y += distancia;
            } else if (mov.equals("D")) {
                y -= distancia;
            } else if (mov.equals("L")) {
                x -= distancia;
            } else if (mov.equals("R")) {
                x += distancia;
            }

            arriba = Math.max(arriba,y);
            abajo = Math.min(abajo, y);
            izquierda = Math.min(izquierda, x);
            derecha = Math.max(derecha, x);

        }

        //Calcular las dimensiones
        int ancho = derecha-izquierda + 40;
        int alto = arriba-abajo+40;

        System.out.println(ancho + " " + alto);

        sc.close();
    }
}