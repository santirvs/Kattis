package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHashSet;

import java.util.HashSet;
import java.util.Scanner;

// Apuntar las ciudades visitadas en un HashSet y mostrar el tamaño del conjunto

public class IveBeenEverywhereMan {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();

        while (numCasos > 0) {

            int numViajes = scan.nextInt();
            scan.nextLine();
            HashSet<String> lista = new HashSet<String>();
            while (numViajes > 0) {
                lista.add(scan.nextLine());
                numViajes--;
            }
            System.out.println(lista.size());

            numCasos--;
        }
    }

}

