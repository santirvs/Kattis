package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;

// Búsqueda completa
// Hay dos símbolos a colocar y uno de ellos es un =. El otro es un +, -, * o /.
// Por lo tanto, hay 8 combinaciones posibles. Probar cada una de ellas



import java.util.Scanner;

public class Tri {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer los datos
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        // Comprobar cada combinación
        if (num1 + num2 == num3) {
            System.out.println(num1 + "+" + num2 + "=" + num3);
        } else if (num1 - num2 == num3) {
            System.out.println(num1 + "-" + num2 + "=" + num3);
        } else if (num1 * num2 == num3) {
            System.out.println(num1 + "*" + num2 + "=" + num3);
        } else if (num1 / num2 == num3 && num2 != 0) {
            System.out.println(num1 + "/" + num2 + "=" + num3);
        } else if (num2 + num3 == num1) {
            System.out.println(num1 + "=" + num2 + "+" + num3);
        } else if (num2 - num3 == num1) {
            System.out.println(num1 + "=" + num2 + "-" + num3);
        } else if (num2 * num3 == num1) {
            System.out.println(num1 + "=" + num2 + "+" + num3);
        } else if (num2 / num3 == num1 && num3 != 0) {
            System.out.println(num1 + "=" + num2 + "/" + num3);
        } else {
            System.out.println("No solution");
        }
    }
}


