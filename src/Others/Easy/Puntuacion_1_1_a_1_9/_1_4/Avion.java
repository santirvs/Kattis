package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Hay exactamente 5 entradas
// Leer cada entrada
// Si la cadena contiene el texto "FBI" mostrar el indice de entrada
// Si no hay entradas, mostrar "HE GOT AWAY!"

import java.util.Scanner;

public class Avion {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Hay exactamente 5 entradas
        boolean primera = true;
        for (int i=1; i<=5; i++) {
            // Leer cada entrada
            String identificacion = sc.nextLine();
            // Si la cadena contiene el texto "FBI" mostrar el indice de entrada
            if (identificacion.contains("FBI")) {
                if (primera) {
                    primera = false;
                }
                else {
                    System.out.print(" ");  // Separador de casos
                }
                System.out.print(i);
            }
        }
        // Si no hay entradas, mostrar "HE GOT AWAY!"
        if (primera) {
            System.out.println("HE GOT AWAY!");
        } else {
            System.out.println();
        }


        sc.close();
    }
}

