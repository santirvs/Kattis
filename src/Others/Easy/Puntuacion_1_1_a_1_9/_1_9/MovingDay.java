package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Calcular el tamaño de las cajas, seleccionar la mayor y restarla del volumen necesario
 */


import java.util.Scanner;

public class MovingDay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCajas = sc.nextInt();
        long volumenNecesario = sc.nextLong();
        long maxVolumen = 0;

        for (int i=0; i<numCajas; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long volumen = a*b*c;

            maxVolumen = Math.max(volumen, maxVolumen);
        }

        //Mostrar el resultado
        System.out.println(maxVolumen-volumenNecesario);

    }
}