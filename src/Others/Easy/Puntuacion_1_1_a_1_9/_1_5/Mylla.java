package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Dadas tres cadenas que representan el tablero de un 3 en raya,
// determinar si el jugador con O ha ganado o no
// Si ha ganado, mostrar "Jebb", si no ha ganado mostrar "Neibb"

import java.util.Scanner;


public class Mylla {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fila1 = sc.nextLine();
        String fila2 = sc.nextLine();
        String fila3 = sc.nextLine();
        sc.close();
        boolean haGanado = false;
        // Comprobar filas
        if (fila1.equals("OOO") || fila2.equals("OOO") || fila3.equals("OOO")) {
            haGanado = true;
        }
        // Comprobar columnas
        for (int i = 0; i < 3; i++) {
            if (fila1.charAt(i) == 'O' && fila2.charAt(i) == 'O' && fila3.charAt(i) == 'O') {
                haGanado = true;
            }
        }
        // Comprobar diagonales
        if ((fila1.charAt(0) == 'O' && fila2.charAt(1) == 'O' && fila3.charAt(2) == 'O') ||
            (fila1.charAt(2) == 'O' && fila2.charAt(1) == 'O' && fila3.charAt(0) == 'O')) {
            haGanado = true;
        }

        //Mostrar resultado
        if (haGanado) {
            System.out.println("Jebb");
        } else {
            System.out.println("Neibb");
        }
    }
}

