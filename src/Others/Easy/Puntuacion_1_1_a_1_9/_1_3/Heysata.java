package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer el string que hace de pajar y el string que hace de aguja
// Buscar si la aguja está en el pajar (la segunda cadena está en la primera)
// Mostrar "Unnar fann hana!" si está y "Unnar fann hana ekki!" si no lo está

import java.util.Scanner;

public class Heysata {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int n = scan.nextInt();
        scan.nextLine(); // Consumir el salto de línea después del entero
        String aguja = scan.nextLine();
        String pajar = scan.nextLine();

        //Buscar si la aguja está en el pajar y mostrar el resultado
        if (pajar.contains(aguja)) {
            System.out.println("Unnar fann hana!");
        } else {
            System.out.println("Unnar fann hana ekki!");
        }


    }
}