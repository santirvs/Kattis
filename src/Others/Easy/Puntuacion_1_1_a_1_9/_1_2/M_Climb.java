package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer los dos primeros números e ignorar el tercero
// Multiplicar los dos primeros números
// Imprimir el resultado

import java.util.Scanner;

public class M_Climb {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.nextInt(); // Ignorar el tercer número
        int product = a * b;
        System.out.println(product);
    }
}