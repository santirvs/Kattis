package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Hay dos formas:
//  1.- leer todos los precios, ordenarlos y coger el segundo
//  2.- leer los precios y quedarnos con los dos más altos <- óptimo


import java.util.Scanner;


public class PenultimateIceCream {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer la cantidade de precios (no lo usaremos)
        sc.nextLine();

        int primeroMasAlto = Integer.MIN_VALUE;
        int segundoMasAlto = Integer.MIN_VALUE;

        while (sc.hasNext()) {
            int precio = sc.nextInt();

            if (precio >= primeroMasAlto) {
                segundoMasAlto = primeroMasAlto;
                primeroMasAlto = precio;
            } else if (precio > segundoMasAlto) {
                segundoMasAlto = precio;
            }
        }

        System.out.println(segundoMasAlto);

        sc.close();
    }
}

