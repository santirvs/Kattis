package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la entrada
// Imprimir cualquier cosa que no sea la entrada
// Comparar la entrada con "a" y, si es igual, imprimir "b", sino "a"

import java.util.Scanner;

public class Contrarianism {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la entrada
        String entrada = sc.nextLine();
        // Imprimir cualquier cosa que no sea la entrada
        if (entrada.equals("a")) {
            System.out.println("b");
        } else {
            System.out.println("a");
        }

        sc.close();
    }
}

