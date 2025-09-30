package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la palabra
// Comprobar si contiene el substring "kth"
// Responder yes o no

import java.util.Scanner;

public class Blackthorn {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer la palabra
        String palabra = sc.next();

        // Comprobar si contiene "kth"
        if (palabra.contains("kth")) System.out.println("yes");
        else System.out.println("no");


        sc.close();
    }
}

