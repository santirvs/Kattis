package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

/**
 * A partir de la posición inicial, ir aplicando las operaciones
 * y mostrar el resultado final
 */

import java.util.Scanner;

public class Drip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numAcciones = sc.nextInt();
        int cantidadDinero = sc.nextInt();
        int numTransacciones = sc.nextInt();

        for (int i=0; i<numTransacciones; i++) {
            String operacion = sc.next();
            boolean esDrip = operacion.equals("DRIP");
            int dividendo = 0;
            if (esDrip) dividendo = sc.nextInt();
            int precio = sc.nextInt();

            if (esDrip) {
                int importe = dividendo * numAcciones;
                int nuevasAcciones = importe / precio;
                int sobrante = importe % precio;
                numAcciones +=nuevasAcciones;
                cantidadDinero += sobrante;
            } else {
                int nuevasAcciones = cantidadDinero / precio;
                numAcciones += nuevasAcciones;
                cantidadDinero = cantidadDinero % precio;
            }
        }
        System.out.println(numAcciones);
        System.out.println(cantidadDinero);
    }
}
