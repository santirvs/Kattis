package Others.Easy.Puntuacion_1_1_a_1_9;

// Leer el nombre y la cantidad de ingredientes
// Si sólo hay 1 ingrediente, imprimirlo. Si hay más de 1, imprimir "blandad best"

import java.util.Scanner;

public class BlandadBest {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numIngredientes = scan.nextInt();
        scan.nextLine();

        if (numIngredientes == 1) {
            String ingrediente = scan.nextLine();
            System.out.println(ingrediente);
        } else {
            System.out.println("blandad best");
        }


    }
}