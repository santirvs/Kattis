package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * El marcador y la temperatura no hay que tenerlos en cuenta
 * Hay que ir a la yarda Y y 20 yardas más y esto 2 veces
 */


import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class BlastersDash {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        sc.nextLine();  //Ignorar el marcador

        //Leer la yarda a la que hay que ir
        int y = sc.nextInt();

        //Calcular la cantidad de yardas a recorrer
        int total = 2 * (y + 20);

        //Mostrar el resultado
        System.out.println(total);


        sc.close();
    }
}

