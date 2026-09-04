package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Leer el dato y comprobar con el anterior para ver si está repetido
 */


import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;


public class DuplicateRemoval {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int cantidad = sc.nextInt();
        while (cantidad > 0) {
            HashSet<Integer> set = new HashSet<>();
            int anterior = sc.nextInt();
            System.out.print(anterior + " ");
            while (cantidad-- > 1) {
                int numero = sc.nextInt();
                if (numero != anterior) {
                    System.out.print(numero + " ");
                }
                anterior = numero;
            }
            System.out.println("$");

            //Siguiente caso
            cantidad = sc.nextInt();
        }
    }
}

