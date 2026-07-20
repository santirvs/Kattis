package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Leer cada ingrediente. Si tengo menos de lo que necesito, calcular la diferencia
// y multiplicar por el precio.
// Acumular el total de costes

import java.util.Scanner;

public class TheRecipe {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numIngredientes = scan.nextInt();
        int totalCoste = 0;

        while (numIngredientes-- > 0) {
            int cantidadTengo = scan.nextInt();
            int cantidadNecesito = scan.nextInt();
            int precio = scan.nextInt();

            int cantidadFaltante = Math.max(0, cantidadNecesito - cantidadTengo);
            int costeIngrediente = cantidadFaltante * precio;

            totalCoste += costeIngrediente;
        }

        System.out.println(totalCoste);

    }
}