package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Leer los valores de multiples paginas y paginas selladas
// Dividir las paginas selladas entre las múltiples y al resultado, sumarle el resto

import java.util.Scanner;

public class MemoriesOfPassportControl {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();

        System.out.println(b/a + b%a);

    }
}