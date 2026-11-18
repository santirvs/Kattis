package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.util.HashSet;
import java.util.Scanner;

public class Division2Problems {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numProblemas = sc.nextInt();
        int numJuecesProblematicos = sc.nextInt();

        //Leer y guardar los jueces problemáticos
        HashSet<String> jp = new HashSet<>();
        for (int i=0; i<numJuecesProblematicos; i++) {
            String nom = sc.next();
            jp.add(nom);
        }

        //Leer los problemas y comprobar si contienen algun juez problemático
        boolean primero = true;
        for (int problema=1; problema<= numProblemas; problema++) {

            int numJueces = sc.nextInt();
            sc.nextLine();
            String[] jueces = sc.nextLine().split(" ");
            boolean problematico = false;
            for (int i=0; i<numJueces && !problematico; i++) {
                problematico = jp.contains(jueces[i]);
            }

            if (!problematico) {
                if (!primero) System.out.print(" ");
                else primero = false;
                System.out.print(problema);
            }
        }
        System.out.println();
    }
}
