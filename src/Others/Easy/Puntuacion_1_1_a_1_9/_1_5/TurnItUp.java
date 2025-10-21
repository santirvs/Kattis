package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Empezamos en un nivel 7
// Leer la cantidad de órdenes
// Por cada Skru op! subimos un nivel, sin pasarnos de 10
// Por cada Skru ned! bajamos un nivel, sin pasarnos de 0
// Al final, mostramos el nivel final

import java.util.Scanner;


public class TurnItUp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de órdenes
        int numOrdenes = sc.nextInt();
        sc.nextLine();
        int nivel = 7;
        // Procesar las órdenes
        for (int i = 0; i < numOrdenes; i++) {
            String orden = sc.nextLine();
            if (orden.equals("Skru op!")) {
                // Subir nivel
                if (nivel < 10) {
                    nivel++;
                }
            }
            else if (orden.equals("Skru ned!")) {
                // Bajar nivel
                if (nivel > 0) {
                    nivel--;
                }
            }
        }
        // Mostrar el nivel final
        System.out.println(nivel);

        sc.close();
    }
}

