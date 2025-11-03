package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer L y R
// Determinar si un cuadrado de lado L puede pasar por un agujero de radio R
// Calcular la hipotenusa de un cuadrado de lado L y determinar si es inferior a un 2*R
// O dicho de otra forma, si la diagonal del cuadrado es inferior al diámetro del agujero
// Para no usar raíces cuadradas, haremos que h^2 < d^2
// Si cabe, mostrar "fits", en caso contrario mostrar "nope"

import java.util.Scanner;


public class SquarePeg {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer L y R
        int lado = sc.nextInt();
        int radio = sc.nextInt();
        // Determinar si un cuadrado de lado L puede pasar por un agujero de radio R
        // Calcular la hipotenusa de un cuadrado de lado L y determinar si es inferior a un 2*R
        // O dicho de otra forma, si la diagonal del cuadrado es inferior al diámetro del agujero
        // Para no usar raíces cuadradas, haremos que h^2 < d^2
        // Si cabe, mostrar "fits", en caso contrario mostrar "nope"
        if (2*lado*lado < (4*radio*radio) ) {
            System.out.println("fits");
        } else {
            System.out.println("nope");
        }

        sc.close();
    }
}

