package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHashSet;

import java.util.HashSet;
import java.util.Scanner;

// Si el equipo no existe, se premia y se añade al conjunto
// Si el equipo ya ha sido premiado, no se premia
// Se acaba cuando se llega a 12 premios

public class ICPCAwards {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        HashSet<String> lista = new HashSet<String>();
        scan.nextLine();

        while (lista.size() < 12) {

            String[] equipo = scan.nextLine().split(" ");
            if (!lista.contains(equipo[0])) {
                System.out.println(equipo[0] + " " + equipo[1]);
                lista.add(equipo[0]);
            }

        }
    }

}

