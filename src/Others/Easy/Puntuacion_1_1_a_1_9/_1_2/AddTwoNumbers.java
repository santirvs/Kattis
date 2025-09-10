package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer los dos números y sumarlos
import java.util.Scanner;

public class AddTwoNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();

        //Comparar y mostrar el resultado
        System.out.println(num1 + num2);

    }
}