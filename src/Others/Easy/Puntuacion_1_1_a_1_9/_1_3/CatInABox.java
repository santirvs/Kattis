package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer las dimensiones de una caja y el tamaño de un gato
// Si el gato cabe en la caja justo, imprimir "COZY"
// Si el gato cabe en la caja con espacio de sobra, imprimir "SO MUCH SPACE"
// Si el gato no cabe en la caja, imprimir "TOO TIGHT"


import java.util.Scanner;

public class CatInABox {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int boxLength = scan.nextInt();
        int boxWidth = scan.nextInt();
        int boxHeight = scan.nextInt();
        int boxSize = boxLength * boxWidth * boxHeight;
        int catSize = scan.nextInt();

        //Determinar si el gato cabe en la caja y mostrar el resultado
        if (catSize == boxSize) {
            System.out.println("COZY");
        } else if (catSize < boxSize) {
            System.out.println("SO MUCH SPACE");
        } else {
            System.out.println("TOO TIGHT");
        }

    }
}