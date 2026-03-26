package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Descartar la primera línea
// Leer a
// Leer b
// Leer el resultado
// hacer a - b
// Si el resultado es negativo -> JEDI
// Si a - b es negativo pero el resultado es positivo -> SITH
// Si a - b es positivo -> VEIT EKKI

import java.util.Scanner;

public class Sith {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer los datos
        sc.nextLine();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int res = sc.nextInt();

        int my_res = a-b;

        if (res < 0) System.out.println("JEDI");
        else if ( my_res < 0 ) System.out.println("SITH");
        else System.out.println("VEIT EKKI");

        sc.close();
    }
}

