package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la longitud (se puede ignorar)
// Leer el primer nombre
// Leer el segundo nombre
// Comparar la distancia letra por letra. Si la distancia > 13, es más corta en sentido contrario.  (26-distancia)
// Ir acumulando las distancias

import java.util.Scanner;


public class JustAJoystick {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Ignorar la longitud
        sc.nextLine();
        //Leer los nombres
        String nom1 = sc.nextLine();
        String nom2 = sc.nextLine();

        int movimientos = 0;
        for (int i=0; i<nom1.length(); i++) {
            char c1 = nom1.charAt(i);
            char c2 = nom2.charAt(i);

            int distancia = Math.abs( c1 - c2);
            if (distancia > 13 ) distancia = 26 - distancia;

            movimientos += distancia;

        }

        System.out.println(movimientos);

        sc.close();
    }
}

