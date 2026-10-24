package Others.Easy.Puntuacion_2_0_a_2_9._2_2;


//Contar los problemas que será capaz de resolver
//Para poderlo resolver, el caso de pruebas no debe
// contener ninguna mayúscula a partir de la 2a posición

import java.util.Scanner;

public class ToLower {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numProblemas = 0;
        int numCasos = sc.nextInt();
        int numTests = sc.nextInt();

        while (numCasos-- > 0) {
            boolean correcto = true;

            for (int i=0; i<numTests; i++) {
                String palabra = sc.next();
                String palabra1 = palabra.substring(1);

                if (!palabra1.toLowerCase().equals(palabra1)) {
                    correcto = false;
                }
            }

            if (correcto) numProblemas++;
        }

        System.out.println(numProblemas);

    }
}
