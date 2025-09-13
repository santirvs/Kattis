package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer una cadena
// Buscar la primera aparición de la letra 'a' (minúscula)
// Imprimir la subcadena desde la primera 'a' hasta el final de la cadena


import java.util.Scanner;

public class FindingAnA {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Leer una cadena
        String input = scan.nextLine();

        //Buscar la posición donde se encuentra la primera 'a'
        int position = input.indexOf('a');

        // Imprimir la subcadena desde la primera 'a' hasta el final de la cadena
        String result = input.substring(position);
        System.out.println(result);

    }
}