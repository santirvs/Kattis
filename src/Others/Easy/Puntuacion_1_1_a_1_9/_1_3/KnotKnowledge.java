package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer la cantidad de nudos a aprender
// Leer los nudos a aprender y guardar en un Set
// Leer los nudos aprendidos y eliminar en el Set
// Mostrar los nudos que faltan por aprender

import java.util.Scanner;

public class KnotKnowledge {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de nudos a aprender
        int n = sc.nextInt();
        // Leer los nudos a aprender y guardar en un Set
        java.util.Set<String> knotsToLearn = new java.util.HashSet<>();
        for (int i = 0; i < n; i++) {
            knotsToLearn.add(sc.next());
        }
        // Leer los nudos aprendidos y eliminar en el Set
        for (int i = 0; i < n-1; i++) {
            knotsToLearn.remove(sc.next());
        }
        // Mostrar los nudos que faltan por aprender
        for (String knot : knotsToLearn) {
            System.out.println(knot);
        }
    }
}

