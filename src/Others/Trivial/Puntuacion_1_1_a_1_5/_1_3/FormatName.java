package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Leer la línea, splitar por ", "
// Tomar la inicial del nombre, añadir un punto y el apellido con la inicial en mayúscula


import java.util.Scanner;

public class FormatName {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] partes = scan.nextLine().split(", ");

        System.out.println(Character.toUpperCase(partes[1].charAt(0)) + ". " +
                Character.toUpperCase(partes[0].charAt(0)) + partes[0].substring(1) );

    }
}