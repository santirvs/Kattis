package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Eliminar repetidos apoyándose en un Set

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bidrod {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cantidad = sc.nextInt();
        Set<Integer> set = new HashSet<>() ;
        boolean primero = true;
        while (cantidad-- > 0) {
            int numero = sc.nextInt();

            if (! set.contains(numero)) {
                set.add(numero);
                if (!primero) System.out.print(" ");
                System.out.print(numero);
                primero = false;
            }

        }
        System.out.println();

    }
}
