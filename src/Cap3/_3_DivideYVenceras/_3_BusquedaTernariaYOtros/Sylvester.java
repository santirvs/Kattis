package Cap3._3_DivideYVenceras._3_BusquedaTernariaYOtros;

// Estrategia de D&C. Búsqueda ternaria y otros
/** Kattis - sylvester
 *
 * Original de: https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_3_Problem_Solving_Paradigms/Divide_and_Conquer/kattis_sylvester.cpp
 *
 * Observa que, dada la representación binaria de las coordenadas x e y de la celda,
 * podemos determinar el valor contando el número de posiciones binarias en las que
 * ambos dígitos de x e y son 1. Este número corresponde al número de inversiones de la celda.
 *
 * Tiempo: O(h*w), Espacio: O(1)
 */
import java.util.Scanner;

public class Sylvester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_tc = sc.nextInt();

        while (num_tc-- > 0) {
            long n = sc.nextLong();  // no se usa, pero se lee para mantener consistencia
            long x = sc.nextLong();
            long y = sc.nextLong();
            long w = sc.nextLong();
            long h = sc.nextLong();

            for (long yi = y; yi < y + h; yi++) {
                for (long xi = x; xi < x + w; xi++) {
                    // contamos los bits a 1 en (xi & yi)
                    int count = Long.bitCount(xi & yi);
                    System.out.print((count % 2 == 0 ? 1 : -1) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        sc.close();
    }
}
