package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;

// Buscar por fuerza bruta
// Dado un número n, encontrar dos números tales que a^2 - b^2 = n
// Límites:
// Como b es mayor que 0, el límite inferior de a es raiz de n
// Como a es mayor que b, el límite superior de b es a-1
// Y por lo tanto, el límite superior de a es (n+1)/2   [a^2 - (a-1)^2 <= n]

import java.util.Scanner;

public class FallingMugs {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        long d = scan.nextLong();

        // Para cada uno de los valores posibles de a, mirar si b es un número entero
        // N = a^2 - b^2
        // b^2 = a^2 - N
        // b = sqrt(a^2-N)
        long a, b;
        for (a = (long) Math.sqrt(d); a <= (d+1)/2; a++) {
            b = (long) Math.sqrt(a*a-d);
            if (d == a*a - b*b) {
                System.out.println(b + " " + a);
                return; // Solo necesitamos una solución
            }
        }

        // Si no se ha encontrado ninguna solución, se imprime "impossible"
        System.out.println("impossible");

    }
}
