package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de casos
// Leer cada caso
// Comprobar si contiene "CD"
// Contar los que no lo contienen
// Imprimir el total

import java.util.Scanner;


public class DeathKnightHero {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de casos
        int numCasos = sc.nextInt();
        int contador = 0;
        // Leer cada caso
        for (int i=0; i<numCasos; i++) {
            // Comprobar si contiene "CD"
            String caso = sc.next();
            // Contar los que no lo contienen
            if (!caso.contains("CD") ) {
                contador++;
            }
        }
        // Imprimir el total
        System.out.println(contador);


        sc.close();
    }
}

