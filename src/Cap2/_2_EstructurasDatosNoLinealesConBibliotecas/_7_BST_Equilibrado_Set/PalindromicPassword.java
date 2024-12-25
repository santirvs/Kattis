package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;


public class PalindromicPassword {

    public static int BuscarPalindromo(int numOriginal, int offset) {
        int result = numOriginal / 1000 + offset;

        result = result * 1000 + (result % 10) * 100 + (result / 10 % 10) * 10 + (result / 100);

        return result;

    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();

        while (numCasos > 0 ) {

            int n = scan.nextInt();

            //Buscar el número palíndromo a partir de n
            int n0 = BuscarPalindromo(n,-1);
            int n1 = BuscarPalindromo(n,0);
            int n2 = BuscarPalindromo(n,1);

            int minDistance = Math.abs(n-n0);
            int result = n0;
            if (Math.abs(n-n1) < minDistance) {
                minDistance = Math.abs(n-n1);
                result = n1;
            }
            if (Math.abs(n-n2) < minDistance) {
                minDistance = Math.abs(n-n2);
                result = n2;
            }

            System.out.println(result);

            numCasos--;
        }
    }
}