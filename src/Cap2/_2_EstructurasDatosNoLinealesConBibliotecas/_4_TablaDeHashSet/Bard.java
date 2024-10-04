package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

// Cada habitante conoce una lista de canciones que ha aprendido a lo largo de su vida
// cuando ha coincidido con el bard o con otros habitantes.

public class Bard {


       public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in);

        int numHabitantes = scan.nextInt();
        int numNoches = scan.nextInt();
        HashSet<Integer>[] cantantes = new HashSet[numHabitantes+1];
        for (int i=0; i < cantantes.length; i++) {
            cantantes[i] = new HashSet<>();
        }

        for (int i=0; i<numNoches; i++) {
            int numInvitados = scan.nextInt();
            int[] invitados = new int[numInvitados];

            boolean bardPresente = false;
            for (int j=0; j<numInvitados; j++) {
                invitados[j] = scan.nextInt();
                if (invitados[j] == 1) {
                    bardPresente = true;
                }
            }

            //Si está presente el bard, todos los habitantes aprenden la canción del bard (la de la noche i-ésima)
            if (bardPresente) {
                for (int j=0; j<numInvitados; j++) {
                    cantantes[invitados[j]].add(i);
                }
            }

            //Si no está presente el bard, todos los cantantes comparten todas sus canciones
            if (!bardPresente) {
                //para cada invitado
                for (int j=0; j<numInvitados; j++) {
                    //Para cada canción que conoce el invitado j
                    for (int k : cantantes[invitados[j]]) {
                        //Compartir la canción con el resto de invitados
                        for (int l=0; l<numInvitados; l++) {
                            cantantes[invitados[l]].add(k);
                        }
                    }
                }
            }
        }

        //Quien és el invitado que conoce más canciones?
        int maxCanciones = 0;
        for (int i=0; i<numHabitantes; i++) {
            maxCanciones = Math.max(maxCanciones, cantantes[i].size());
        }

        //Guardar en una lista los invitados que conocen maxCanciones
        for (int i=0; i<cantantes.length; i++) {
            if (cantantes[i].size() == maxCanciones) {
                System.out.println(i);
            }
        }




    }
}
