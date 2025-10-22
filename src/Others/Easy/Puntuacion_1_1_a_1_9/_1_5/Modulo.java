package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer 10 números de la entrada y calcular su módulo 42
// Leer los 10 números
// Usar un HashSet para almacenar los números resultantes de hacer módulo 42
// Finalmente, mostrar el tamaño del HashSet

import java.util.Scanner;


public class Modulo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Usar un HashSet para almacenar números únicos menores de 42
        java.util.HashSet<Integer> modulos42 = new java.util.HashSet<>();
        // Leer 10 números
        for (int i = 0; i < 10; i++) {
            int numero = sc.nextInt();
            modulos42.add(numero%42);
        }
        // Mostrar el tamaño del HashSet
        System.out.println(modulos42.size());

        sc.close();
    }
}

