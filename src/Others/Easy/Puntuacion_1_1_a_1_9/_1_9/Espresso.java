package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Ir decrementando el agua disponible en función del agua necesaria para cada café
 * Si no hay suficiente para el próximo café, recargar la máquina
 */


import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Espresso {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCafes = sc.nextInt();
        int capacidad = sc.nextInt();
        int recarga = capacidad;
        int numRecargas = 0;

        while (numCafes-- > 0) {
            String pedido = sc.next();
            int consumo = 0;
            if (pedido.charAt(pedido.length()-1) == 'L') {
                consumo++;
                pedido = pedido.substring(0, pedido.length()-1);
            }
            consumo += Integer.parseInt(pedido);

            if (consumo > capacidad) {
                capacidad =recarga;
                numRecargas++;
            }
            capacidad -= consumo;

        }

        System.out.println(numRecargas);

        sc.close();
    }
}