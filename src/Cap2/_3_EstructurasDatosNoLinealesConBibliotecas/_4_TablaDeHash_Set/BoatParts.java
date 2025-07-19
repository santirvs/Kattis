package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHash_Set;

import java.util.HashSet;
import java.util.Scanner;

// Apuntar en un HashSet las partes reemplazadas.
// Si el tamaño del HastSet llega a ser el tamaño de las partes, se ha cambiado todas las piezas el dia X
// Sino, se ha cambiado todas las piezas en toda la sesión

public class BoatParts {


       public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in);

        int numPartes = scan.nextInt();
        int diasSesion = scan.nextInt();
        scan.nextLine();
        HashSet<String> partesCambiadas = new HashSet<>();
        boolean completo = false;
        for (int i=0; i<diasSesion && !completo; i++) {
            partesCambiadas.add(scan.nextLine());
            if (partesCambiadas.size() == numPartes) {
                System.out.println(i+1);
                completo = true;
            }
        }

        if (!completo) {
            System.out.println("paradox avoided");
        }

    }
}
