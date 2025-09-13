package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer la entrada y eliminar los espacios en blanco

import java.util.Scanner;

public class Leynibjonusta {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        String a = scan.nextLine();
        //Eliminar los espacios en blanco
        System.out.println(a.replace(" ", ""));

    }
}