package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Esto es calcular el lado del cuadrado inscrito dentro de un círculo  l = r * sqrt(2)

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Skalagerd {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de concursantes
        int radio = sc.nextInt();


        System.out.println(radio * Math.sqrt(2));
    }
}

