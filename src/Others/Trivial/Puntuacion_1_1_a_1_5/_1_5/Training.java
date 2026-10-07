package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Leer cada caso
// Si el nivel se encuentra dentro del rango, se incrementa
// el nivel en 1

import java.util.Scanner;

public class Training {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el número de casos
        int numCasos = sc.nextInt();
        int nivel = sc.nextInt();

        //Tratar los casos
        while (numCasos-- >0) {
            int rangoInferior = sc.nextInt();
            int rangoSuperior = sc.nextInt();

            if (nivel>=rangoInferior && nivel<=rangoSuperior) {
                nivel++;
            }

        }

        System.out.println(nivel);

        sc.close();
    }
}

