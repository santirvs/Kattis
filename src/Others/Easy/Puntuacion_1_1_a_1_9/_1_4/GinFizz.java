package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de cocktails a preparar
// Listar los ingredientes necesarios (multiplicados por la cantidad a preparar)
// Vigilar las "slices" cuando es 1 cocktail

import java.util.Scanner;

public class GinFizz {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el número de cocktails
        int numCocktails = sc.nextInt();

        //Mostrar los ingredientes
        System.out.println((45*numCocktails) + " ml gin");
        System.out.println((30*numCocktails) + " ml fresh lemon juice");
        System.out.println((10*numCocktails) + " ml simple syrup");
        //Ojo al plural slice/slices
        if (numCocktails==1) System.out.println("1 slice of lemon");
        else System.out.println(numCocktails + " slices of lemon");

        sc.close();
    }
}

