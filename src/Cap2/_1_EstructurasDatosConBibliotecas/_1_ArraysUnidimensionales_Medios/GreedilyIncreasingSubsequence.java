package Cap2._1_EstructurasDatosConBibliotecas._1_ArraysUnidimensionales_Medios;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GreedilyIncreasingSubsequence {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

       //Leer la entrada
        int n = scan.nextInt();
        ArrayList<Integer> subsecuencia = new ArrayList<>();

        subsecuencia.add(scan.nextInt());
        int ultimoNumero = subsecuencia.get(0);
        for (int i=1; i<n; i++) {
            int numero = scan.nextInt();
            if (numero > ultimoNumero) {
                subsecuencia.add(numero);
                ultimoNumero = numero;
            }
        }

        //Mostrar la subsecuencia
        boolean primero = true;
        System.out.println(subsecuencia.size());
        for (Integer c :subsecuencia) {
            if (!primero) System.out.print(" " + c);
            else {
                primero = false;
                System.out.print(c);
            }
        }
        System.out.println();
    }
}
