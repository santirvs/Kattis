package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Leer los datos de los tres casos
// y aplicar la fórmula

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HydroPotential {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i=0; i<3 ; i++) {
            int masa = sc.nextInt();
            int altura = sc.nextInt();

            int energia = masa * 10 * altura;
            System.out.println(energia);
        }
    }
}

