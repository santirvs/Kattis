package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer dos enteros de la entrada y multiplicarlos.
// No hay peligro de desbordamiento, ya que el resultado cabe en un int

import java.util.Scanner;

public class ClassPhoto {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Leer los datos
        int a = scan.nextInt();
        int b = scan.nextInt();
        //Calcular el resultado
        int result = a * b;
        //Mostrar el resultado
        System.out.println(result);

    }
}