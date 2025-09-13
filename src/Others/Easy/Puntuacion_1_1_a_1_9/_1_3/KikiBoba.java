package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Contar las k y las b en la entrada y si hay más k imprimir kiki, si hay más b imprimir boba, si hay igual número imprimir boki
// Pero si no hay ni k ni b imprimir none

import java.util.Scanner;

public class KikiBoba {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        String a = scan.nextLine();
        //Contar las k y las b
        int kCount = 0;
        int bCount = 0;
        for (char c : a.toCharArray()) {
            if (c == 'k' || c == 'K') {
                kCount++;
            } else if (c == 'b' || c == 'B') {
                bCount++;
            }
        }
        //Mostrar el resultado
        if (kCount > bCount) {
            System.out.println("kiki");
        } else if (bCount > kCount) {
            System.out.println("boba");
        } else if (kCount == 0 && bCount == 0) {
            System.out.println("none");
        } else {
            System.out.println("boki");
        }

    }
}