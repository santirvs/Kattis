package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Buscar la máxima fuerza con la que se puede cerrar la puerta sin que caiga la chimenea
// Leer el registro de la fuerza con la que se cierra la puerta
// Si cayó la chimenea, ignorarla
// Si no cayó, guardar el registro mayor

import java.util.Scanner;

public class FallenChimney {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int maxForce = -1;
        for (int i = 0; i < n; i++) {
            int force = scan.nextInt();
            String result = scan.next();
            if (result.equals("nej")) {
                if (force > maxForce) {
                    maxForce = force;
                }
            }
        }

        //Mostrar el resultado
        System.out.println(maxForce);

    }
}