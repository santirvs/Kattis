package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHash_Set;


import java.util.HashSet;
import java.util.Scanner;

// Si el equipo no existe, se añade al conjunto
// Si el equipo ya ha existe, se elimina del conjunto
// Al final, el que quede en el conjunto es el que no tiene pareja


public class OddManOut {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();

        for (int i=0; i<numCasos; i++) {
            HashSet<String> invitados = new HashSet<String>();

            int numInvitados = scan.nextInt();

            for (int j=0; j<numInvitados; j++) {
                String invitado = scan.next();
                if (invitados.contains(invitado)) {
                    invitados.remove(invitado);
                } else {
                    invitados.add(invitado);
                }
            }

            System.out.println("Case #" + (i+1) + ": " + invitados.iterator().next());

        }


    }

}

