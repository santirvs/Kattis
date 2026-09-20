package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Leer las notas y añadirlas a un Set, ordenarlo y recorrerlo
 * haciendo grupos que respeten la máxima diferencia
 */


import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class ACapellaRecording {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        TreeSet<Integer> lista = new TreeSet<>();

        int numNotas = sc.nextInt();
        int distanciaMax = sc.nextInt();

        while (numNotas-- >0) {
            lista.add(sc.nextInt());
        }

        int minimo = lista.pollFirst();
        int grabaciones = 1;

        while (!lista.isEmpty()) {
            int num = lista.pollFirst();
            if (num - minimo > distanciaMax ) {
                minimo = num;
                grabaciones++;
            }
        }

        System.out.println(grabaciones);

        sc.close();
    }
}