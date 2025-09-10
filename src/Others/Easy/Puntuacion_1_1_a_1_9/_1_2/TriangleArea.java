package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer la base y la altura y calcular b*a/2
// Mostrar el resultado con 7 decimales
import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int base = scan.nextInt();
        int altura = scan.nextInt();

        //Comparar y mostrar el resultado con 7 decimales
        double area = (base * altura) / 2.0;
        System.out.printf("%.7f\n", area);
    }
}