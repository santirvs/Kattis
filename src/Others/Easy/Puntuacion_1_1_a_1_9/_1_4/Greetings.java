package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el saludo (en la forma heee...eeey"
// Calcular su longitud
// Doblar el número de e's

import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el saludo
        String saludo = sc.nextLine();

        //Calcular el número de e
        int numEs = saludo.length()-2;

        // Devolver el saludo doblando el número de e
        System.out.println("h" + new String("e").repeat(2*numEs) + "y");

        sc.close();
    }
}

