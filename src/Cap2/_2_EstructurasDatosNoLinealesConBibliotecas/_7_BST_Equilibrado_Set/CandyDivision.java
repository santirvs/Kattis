package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// Dividir e ir insertando en un Set desde 1 hasta raiz de N
// Ojo que N es 2 * 10^12 --> Long


public class CandyDivision {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        Set<Long> numeros = new TreeSet<Long>();


        long N = scan.nextLong();
        long raiz = (long) Math.sqrt(N);

        for (Long i=1L; i<=raiz; i++) {
            if (N % i == 0) {
                Long result = N / i;

                numeros.add(i-1);   //-1 porque él mismo se incluye en el grupo de amigos
                numeros.add(result-1);

                }
            }

                for (int num = 0; num < numeros.size(); num++) {
            if (num!=0) System.out.print(" ");
            System.out.print(numeros.toArray()[num]);
        }
    }
}
